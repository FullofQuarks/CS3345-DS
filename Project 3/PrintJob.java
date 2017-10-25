import java.util.*;

public class PrintJob implements Comparable<PrintJob> {
	protected String userName;
	protected int numPages;
	private int priority;
	protected int ultPriority;
	
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
		return ultPriority;
	} 
	 
	public String toString()
	{
		return String.format("%10s%10d%10d", userName, numPages, ultPriority); 
	}

	@Override
	public int compareTo(PrintJob o) {
		return Integer.compare(ultPriority, o.ultPriority);
	}
}
