import java.util.InputMismatchException; //Used in case the user enters anything besides an int
import java.util.Scanner; // Used to get input from the user

public class Main {

    public static void main(String[] args) throws InputMismatchException {
        Scanner sc = new Scanner(System.in); //creates scanner object

        int number = 0;
        boolean loop = true;
        do {
            try {
                System.out.print("Please enter positive integer: ");
                number = sc.nextInt();

                if(number >0 )
                {
                    loop = false;
                }
                // Just in case the user entered a negative integral value
                else
                {
                    System.out.println("You didn't enter a positive integer...");
                }
            } catch (InputMismatchException e) {
                System.out.println("Hey, you didn't enter an integer!");
                sc.nextLine(); //effectively gets rid of bad input
            }
        } while (loop);

        //Create the array to track primes, fill with numbers
        int [] array;
        array = new int[number];
        for(int i = 0; i < number; ++i)
        {
            array[i] = i+1;
        }

        //Condition for the assignment: stop once index has reached sqrt(number)
        int stopPoint = (int)Math.ceil(Math.sqrt(number));

        //Sieve of Eratosthenes algorithm
        // 0's will be the crossed out numbers
        for (int ix = 2; ix < stopPoint; ++ix)
        {
            for ( int iy = 0; iy < number; ++iy)
            {
                //Start at i^2, then move to i^2+2i, i^2+3i, etc
                if(((ix*ix)+(iy*ix)) < number) {
                    array[((ix * ix) + (iy * ix))-1] = 0;
                }
            }
        }

        //Print array, except for 0s as those are not prime
        for(int ix = 1; ix < number-1; ++ix)
        {
            if(array[ix] != 0)
            System.out.print(array[ix] + " ");
        }
    }
}
