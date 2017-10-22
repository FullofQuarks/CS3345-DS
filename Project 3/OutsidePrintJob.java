
public class OutsidePrintJob extends PrintJob {

	private float cost;
	
	public OutsidePrintJob(String u, int num, int pri) {
		super(u, num, pri);
		cost = (float) .1 * num;
	}
	
	public float getCost()
	{
		return cost;
	}

}
