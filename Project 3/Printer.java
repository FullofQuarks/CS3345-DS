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
		
		File file = new File(fileName);
		try { 
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine())
			{
				tempUserName = sc.next();
				tempPriority = sc.nextInt();
				tempNumPages = sc.nextInt();
				tempIO = sc.next();
				if(tempIO.equals("I"))
				{
					PrintJob newJob = new PrintJob(tempUserName, tempPriority, tempNumPages);
					jobs.add(newJob);
					iJobs++;
				}
				else
				{
					OutsidePrintJob newJob = new OutsidePrintJob(tempUserName, tempPriority, tempNumPages);
					outJobs.add(newJob);
					oJobs++;
				}
			}
			
			sc.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Cannot find file named " + fileName + ".");
			System.out.println("Please check spelling or file existence, and try again.");
		}
	}

}
