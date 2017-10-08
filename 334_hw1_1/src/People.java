
public class People {

	int income,hoursStudy,gender,education,overallHealth;
	int[] people = new int[291];
	
	People(int gender,int income,int education,int hoursStudy,int overallHealth){
		this.income = income;
		this.hoursStudy = hoursStudy;
		this.gender = gender;
		this.education = education;
		this.overallHealth = overallHealth;
		
	}

	public int getGender(){
		return gender;
	}

	public int getEducation(){
		return education;
	}
	
	public int getOverallHealth(){
		return overallHealth;
	}

	public int getIncome(){
		return income;
	}

	public int gethoursStudy(){
		return hoursStudy;
	}
	
	
	
	
	
	
	
	
	
}
