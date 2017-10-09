
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
		double p = probability(freq);
		return -(p*log2(p));
	}
	
	
	public double log2(double x){ return Math.log(x)/Math.log(2.0);	}
	
	//Pr(Income| Q = X(?))
	public double probability(int frequency) 
	{
		double f = frequency;
		
		return 1/f; 
	}
}
