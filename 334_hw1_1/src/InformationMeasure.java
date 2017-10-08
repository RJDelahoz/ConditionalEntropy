
public class InformationMeasure 
{
	private int sum;
	private int freq;
	private int total;
	
	public InformationMeasure()
	{	}
	public InformationMeasure (int sum, int freq, int total) {
		setSum(sum);
		setFrequency(freq);
		setTotal(total);
	}
	//setter methods
	public void setSum(int s) 	{ this.sum = s;	}
	public void setFrequency(int f) { this.freq = f;	}
	public void setTotal(int t) { this.total = t; }
	
	//getters Methods
	public int getSum() { return sum; }
	public int getFrequency() { return freq; }
	public int getTotal() { return total; }
	
	public double I () {
		double  result = 0; 
		for(int i = 0; i < this.getSum(); i++)
		{
		
		}
		return result;
	}
	
	public double I_total(){
		return 0;
	}
	/*
	public double log2(double x)
	{
		
		TODO - write log2 
	}
	**/
}
