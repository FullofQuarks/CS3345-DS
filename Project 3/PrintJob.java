import java.util.*;
public class PrintJob implements Comparable {
	private String userName;
	protected int numPages;
	private int priority;
	
	public PrintJob()
	{
		userName = null;
		numPages = 0;
		priority = 0;
	}
	
	public PrintJob(String u, int num, int pri)
	{
		userName = u;
		numPages = num;
		priority = pri;
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

	public int compareTo(Object arg0) {
		return 0;
	}
}
