import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Printer {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		String fileName = "input.txt";
		String tempUserName = null;
		int tempPriority = 0;
		int tempNumPages = 0;
		String tempIO = null;

		int iJobs = 0, oJobs = 0;
		
		BinaryHeap<PrintJob> jobs = new BinaryHeap<>();
		BinaryHeap<PrintJob> otherJobs = new BinaryHeap<>(); 
		
		File file = new File(fileName);
		try { 
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine())
			{
				try {
					tempUserName = sc.next();
					tempPriority = sc.nextInt();
					tempNumPages = sc.nextInt();
					tempIO = sc.next();
					if(tempIO.equals("I"))
					{
						PrintJob newJob = new PrintJob(tempUserName, tempPriority, tempNumPages);
						jobs.insert(newJob);
						iJobs++;
					}
					else
					{
						OutsidePrintJob newJob = new OutsidePrintJob(tempUserName, tempPriority, tempNumPages);
						jobs.insert(newJob);
						iJobs++;
					}
				}
				catch (NoSuchElementException e)
				{
					
				}
			}
			
			sc.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Cannot find file named " + fileName + ".");
			System.out.println("Please check spelling or file existence, and try again.");
		}
		System.out.format("%10s%10s%10s%6s", "NAME", "NUMPAGES", "PRIORITY", "COST");
		System.out.println();
		for(int ix = iJobs; iJobs > 0; iJobs--)
		{
			System.out.println(jobs.findMin().toString());
			jobs.deleteMin();
		}
		
		
	}

}
