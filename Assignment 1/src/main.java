import java.lang.Math;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Question 1
		//Give the log base 2 of 2048 using only log base 10
		double log10 = 0.0F;
		log10 = Math.log10(2048)/Math.log10(2);
		System.out.println("The log base 2 of 2048 is: " + log10);
		rec(4);
		int [] arr = {1,2,3,4,5,6,7,8,9};
		System.out.println();
		System.out.println("There are " + recArr(arr, 0) + " odd numbers.");
		
	}

	//Question 6 Method
	public static void rec(int a)
	{
			
			if (a == 0)
			{
				System.out.print(" " + 0 + " ");
				return;
			}
			else
			{
				System.out.print(" " + a + " ");
				rec(a-1);
				System.out.print(" " + a + " ");
				return;
			}
			
	}
	
public static int recArr(int []arr, int pos) {
	int count = 0;
	if((arr[pos] % 2) == 1) {
		count++;
	}
	if(pos < arr.length-1) {
		count+=recArr(arr,pos+1);
	}
	return count;
}
}
