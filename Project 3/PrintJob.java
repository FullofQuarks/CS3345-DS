import java.util.*;

public class PrintJob implements Comparable<PrintJob> {
	private String userName;
	protected int numPages;
	private int priority;
	private int ultPriority;
	
	public PrintJob()
	{
		userName = null;
		numPages = 0;
		priority = 0;
		ultPriority = priority * numPages;
	}
	
	public PrintJob(String u, int num, int pri)
	{
		userName = u;
		numPages = num;
		priority = pri;
		ultPriority = priority * numPages;
	}
	
	public String getUserName()
	{
		return userName;
	}
	
	public int getNumPages()
	{
		return numPages;
	}
	
	public int getPriority()
	{
		return priority;
	}

	@Override
	public int compareTo(PrintJob o) {
		// TODO Auto-generated method stub
		int otherPriority = o.ultPriority;
		if(otherPriority < 0)
		{
			return otherPriority;
		}
		else
			return ultPriority;
	}
}
