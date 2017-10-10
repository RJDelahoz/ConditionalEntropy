import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class database_Main {
	//total participants
	static int total;

	//frequencies
	static int[] count_Edu  = new int[6];
	static int[] count_Gen = new int[4];
	static int[] count_Hel = new int[5];
	static int[] count_Sty = new int[4];
	static int[] count_Inc = new int[6];
	static int[] count_Min_Gen = new int[16];
	static int[] count_Min_Sty = new int[23];
	static int[] count_Min_Hel = new int[27];

	static InformationMeasure InfoM = new InformationMeasure();

	static double EntropyOfGen;
	static double EntropyOfEdu;
	static double EntropyOfHel;
	static double EntropyOfSty;

	public static void main(String args[]) throws FileNotFoundException
	{
		File input = new File("info.txt");
		People[] newPerson = new People[291];
		Scanner scn = new Scanner(input);

		int count = 0;

		while(scn.hasNext())
			newPerson[count++] = new People(scn.nextInt(), scn.nextInt(), scn.nextInt(), scn.nextInt(), scn.nextInt());

		scn.close();

		ArrayList<String> edu = new ArrayList<String>();
		ArrayList<String> gen = new ArrayList<String>();
		ArrayList<String> hel = new ArrayList<String>();
		ArrayList<String> sty = new ArrayList<String>();
		ArrayList<String> inc = new ArrayList<String>();

		int count_Edu_Count = 0, count_Inc_Count = 0, count_Gen_Count = 0, count_Hel_Count = 0, count_Sty_Count = 0;

		for (int counter = 0; counter < 291; counter++)
		{
			//initialize varibles gets the first element and so on
			String n = Integer.toString(newPerson[counter].getEducation());
			String a = Integer.toString(newPerson[counter].getGender());
			String b = Integer.toString(newPerson[counter].getOverallHealth());
			String c = Integer.toString(newPerson[counter].gethoursStudy());
			String in = Integer.toString(newPerson[counter].getIncome());

			//if the element is not in the arylist
			if(!edu.contains(n))
			{
				count = 0;
				//traverse through the list 
				for (int i = 0; i < 291; i++)
					if (Integer.toString(newPerson[i].getEducation()).equals(n)) 
						count++;

				count_Edu[count_Edu_Count++] = count;
				edu.add(n);
				//System.out.println(n + " - " + count);
			}//if edu

			if(!inc.contains(in))
			{
				count = 0;
				//traverse through the list 
				for (int i = 0; i < 291; i++)
					if (Integer.toString(newPerson[i].getIncome()).equals(in)) 
						count++;

				count_Inc[count_Inc_Count++] = count;
				inc.add(in);
				//System.out.println(in + " - " + count);
			}//if inc

			if(!gen.contains(a))
			{
				count = 0;
				for(int i = 0;i<291;i++)
					if(Integer.toString(newPerson[i].getGender()).equals(a))
						count++;

				count_Gen[count_Gen_Count++] = count;
				gen.add(a);
				//	System.out.println(a + " - " + count);
			}//if gen

			if(!hel.contains(b)){
				count = 0;
				for(int i = 0;i<291;i++)
					if(Integer.toString(newPerson[i].getOverallHealth()).equals(b)) 
						count++;

				count_Hel[count_Hel_Count++] = count;
				hel.add(b);
				//	System.out.println(b + " - " + count);

			}//if hel

			if(!sty.contains(c)){
				count = 0;
				for(int i = 0;i<291;i++)
					if(Integer.toString(newPerson[i].gethoursStudy()).equals(c)) 
						count++;

				count_Sty[count_Sty_Count++] = count;
				sty.add(c);
				//System.out.println(c + " - " + count);

			}//if sty

		}//end for loop
		for(int i = 0; i < count_Edu.length; i++)
			total += count_Edu[i];

		//Entropy for gender
		for(int i = 0; i < count_Gen.length; i++)
			EntropyOfGen += (InfoMeasure( count_Gen[i], total) * probability(count_Gen[i], total));
		System.out.println("Conditional Entropy for gender: "+ EntropyOfGen  + "\n--------------------");

		//Entropy for Education
		for(int i = 0; i < count_Edu.length; i++)
			EntropyOfEdu += (InfoMeasure( count_Edu[i], total) * probability(count_Edu[i], total));
		System.out.println("Conditional Entropy for education: "+ EntropyOfEdu + "\n--------------------");

		//Entropy for Overall health
		for(int i = 0; i < count_Hel.length; i++)
			EntropyOfHel += (InfoMeasure( count_Hel[i], total) * probability(count_Hel[i], total));
		System.out.println("Conditional Entropy for overall health: "+ EntropyOfHel + "\n--------------------");

		//Entropy for Work/Study hours
		for(int i = 0; i < count_Sty.length; i++)
			EntropyOfSty += (InfoMeasure( count_Sty[i], total) * probability(count_Sty[i], total));
		System.out.println("Conditional Entropy for work/study hours: "+ EntropyOfSty + "\n" + "------------------" );
		
		System.out.println("the min is:"+findMin(EntropyOfSty,EntropyOfEdu,EntropyOfHel,EntropyOfGen));
		System.out.println("----------------");

		//calc row 2 of I
		ArrayList<String> min_Gen = new ArrayList<>();
		ArrayList<String> min_Sty = new ArrayList<>();
		ArrayList<String> min_Hel = new ArrayList<>();

		int count_min_Gen = 0,count_min_Hel=0,count_min_Sty = 0;

		for (int counter = 0; counter < 291; counter++){
			String n = newPerson[counter].getEducation() + " " + newPerson[counter].getGender();
			String a = newPerson[counter].getEducation() + " " + newPerson[counter].gethoursStudy();
			String b = newPerson[counter].getEducation() + " " + newPerson[counter].getOverallHealth();

			if(!min_Gen.contains(n)){
				int count1 = 0;
				for (int i = 0; i < 291; i++){
					String z = newPerson[counter].getEducation() + " " + newPerson[counter].getGender();
					if (z.equals(n))
						count1++;

				}
				count_Min_Gen[count_min_Gen++] = count1;
				min_Gen.add(n);
				//System.out.println(n + " - " + count1);

			}


			if(!min_Hel.contains(b)){
				int count1 = 0;
				for (int i = 0; i < 291; i++){
					String z = newPerson[counter].getEducation() + " " + newPerson[counter].getOverallHealth();
					if (z.equals(b))
						count1++;
				}
				count_Min_Hel[count_min_Hel++] = count1;
				min_Hel.add(b);
			//	System.out.println(b + " - " + count1);

			}

			if(!min_Sty.contains(a)){
				int count1 = 0;
				for (int i = 0; i < 291; i++){
					String z = newPerson[counter].getEducation() + " " + newPerson[counter].gethoursStudy();
					if (z.equals(a))
						count1++;

				}
				count_Min_Sty[count_min_Sty++] = count1;
				min_Sty.add(a);
				//System.out.println(a + " - " + count1);

			}
		}//for
		//System.out.println(min_Sty.size());
		
		
		
		
		/**
		double EntropyOfMinGen = 0 ;
		for(int i = 0; i < count_Gen.length;i++){
			for(int j = 0; i < count_Min_Edu.length; i++)
				EntropyOfMinGen += (InfoMeasure(count_Min_Edu[i], count_Gen[j]) * probability(count_Min_Edu[i], total));
			System.out.println("Conditional Entropy for Gen_Edu: "+ EntropyOfMinGen  + "\n--------------------");

		}
		 **/
	}

	//Pr(Q)
	public static double probability(int frequency, int tot)
	{
		double f = frequency;
		double t = tot;

		return f/t;
	}

	public static double InfoMeasure( int f, int t) 
	{

		InfoM.setFrequency(f);
		InfoM.setTotal(t);

		System.out.println(f + "\t--\t" + InfoM.I());

		return InfoM.I();
	}

	//finds minimum returns value
	public static double findMin(double... vals) {
		double min = Double.POSITIVE_INFINITY;

		for (double d : vals) 
			if (d < min) min = d;

		return min;
	}
}
