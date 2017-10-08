import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import java.lang.Math;

public class database_Main {
	//total participants
	static int total;
	
	//frequencies
	static int[] count_Edu  = new int[6];
	static int[] count_Gen = new int[4];
	static int[] count_Hel = new int[5];
	static int[] count_Sty = new int[4];
	static int[] count_Inc = new int[6];
	
	static InformationMeasure InfoM = new InformationMeasure();
	 
	static double EntropyOfEdu;
	
	public static void main(String args[]) throws FileNotFoundException
	{
		File input = new File("info.txt");
		People[] newPerson = new People[291];
		Scanner scn = new Scanner(input);

		int count = 0;

		while(scn.hasNext())
			newPerson[count++] = new People(scn.nextInt(), scn.nextInt(), scn.nextInt(), scn.nextInt(), scn.nextInt());

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
					if(Integer.toString(newPerson[i].getGender()).equals(a)) count++;
				
				count_Gen[count_Gen_Count++] = count;
				gen.add(a);
				System.out.println(a + " - " + count);
			}//if gen

			if(!hel.contains(b)){
				count = 0;
				for(int i = 0;i<291;i++){
					if(Integer.toString(newPerson[i].getOverallHealth()).equals(b)) count++;
				}
				count_Hel[count_Hel_Count++] = count;
				hel.add(b);
			//	System.out.println(b + " - " + count);

			}//if hel

			if(!sty.contains(c)){
				count = 0;
				for(int i = 0;i<291;i++){
					if(Integer.toString(newPerson[i].gethoursStudy()).equals(c)) count++;
				}
				count_Sty[count_Sty_Count++] = count;
				sty.add(c);
				//System.out.println(c + " - " + count);

			}//if sty
		}//end for loop
		for(int i = 0; i < count_Edu.length; i++)
			total += count_Edu[i];
			
		//Sigma
		for(int i = 0; i < count_Gen.length; i++)
			InfoMeasure(count_Inc.length, count_Gen[i], total);
		
		scn.close();
	}
	
	//probability 
	public static double probability(int x, int tot)
	{
		double f = x;
		double t = tot;
		
		return f/t;
	}
	
	//Log base 2 function
	public static double log2(double p) { return Math.log10(p)/Math.log10(2); }
	
	public static void InfoMeasure(int s, int f, int t) {
		InfoM.setSum(s);
		InfoM.setFrequency(f);
		InfoM.setTotal(t);
	}
	
}
