public class OutsidePrintJob extends PrintJob {

	private float cost;
	private char dollar = 36;
	
	public OutsidePrintJob(String u, int num, int pri) {
		super(u, num, pri);
		cost = (float) .1 * num;
	}
	
	public float getCost()
	{
		return cost;
	}
	
	public String toString()
	{
		return String.format("%10s%10d%10d%6.2f", userName, numPages, ultPriority, cost);
	}

}
