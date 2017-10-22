//import java.util.*;
public class PrintJob {
	private String userName;
	protected int numPages;
	private int priority;
	
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
	
	public int compareTo(int arg0) {
		return 0;
	}
}
