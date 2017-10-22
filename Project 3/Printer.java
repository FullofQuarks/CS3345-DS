import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Printer {

	public static void main(String[] args) {
		
		String fileName = "input.txt";
		String line = null;
		String tempUserName = null;
		int tempPriority = 0;
		int tempNumPages = 0;
		String tempIO = null;
		
		File file = new File(fileName);
		try {
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine())
			{
				tempUserName = sc.next();
				tempPriority = sc.nextInt();
				tempNumPages = sc.nextInt();
				tempIO = sc.next();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
