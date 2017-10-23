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
		List<PrintJob> jobs = new ArrayList<PrintJob>();
		List<OutsidePrintJob> outJobs = new ArrayList<>();
		int iJobs = 0, oJobs = 0;
		
		BinaryHeap<Integer> bh = new BinaryHeap<>();
		BinaryHeap<PrintJob> otherJobs = new BinaryHeap<>();
		
		OutsidePrintJob temp = new OutsidePrintJob("Nick", 1, 5);
		OutsidePrintJob temp2 = new OutsidePrintJob("Bob", 1, 3);
		otherJobs.insert(temp);
		otherJobs.insert(temp2);
		
		bh.insert(45);
		bh.insert(23);
		
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
						tempPriority = tempPriority * tempNumPages;
						jobs.add(newJob);
						
						bh.insert(tempPriority);
						iJobs++;
					}
					else
					{
						OutsidePrintJob newJob = new OutsidePrintJob(tempUserName, tempPriority, tempNumPages);
						outJobs.add(newJob);
						oJobs++;
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
		int min;
		
		while(!bh.isEmpty())
		{
			min = bh.findMin();
			System.out.println(otherJobs.findMin());
			bh.deleteMin();
		}
		
		System.out.println(temp.compareTo(temp2));
		
	}

}
