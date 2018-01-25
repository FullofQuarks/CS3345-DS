/*
 * @author Nicholas Smith
 * Project 3
 * Reads in a file, adds each line to a Binary Heap, outputs min until empty
 * Simulation of a printer
 */


import java.io.File; //File IO
import java.io.FileNotFoundException; //Using this for the Scanner object
import java.util.Scanner;
import java.util.NoSuchElementException; //Using this for the Scanner object

public class Printer {

	public static void main(String[] args) {
		
		//Basic attributes
		String fileName = "input.txt";
		String tempUserName = null;
		int tempPriority = 0;
		int tempNumPages = 0;
		String tempIO = null;
		
		//Create Binary Heap object
		BinaryHeap<PrintJob> jobs = new BinaryHeap<>();
		
		//Open file
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
					}
					else
					{
						OutsidePrintJob newJob = new OutsidePrintJob(tempUserName, tempPriority, tempNumPages);
						jobs.insert(newJob);
					}
				}
				catch (NoSuchElementException e) {}
			}
			sc.close(); //close the file to prevent memory leaks
		} catch (FileNotFoundException e) { //file not found
			System.out.println("Cannot find file named " + fileName + ".");
			System.out.println("Please check spelling or file existence, and try again.");
		}
		//Create table header using String.format() 
		System.out.format("%10s%10s%10s%6s", "NAME", "NUMPAGES", "PRIORITY", "COST");
		System.out.println();
		//Loop while there are still elements in the Binary Heap
		while(!jobs.isEmpty())
		{
			//Delete min and print at the same time
			System.out.println(jobs.deleteMin().toString());
		}
	}
}
