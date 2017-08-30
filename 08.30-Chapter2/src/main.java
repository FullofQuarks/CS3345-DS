/*
 * What is the best way to find the largest subsequence sum?
 */
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a = {1,2,3,4,5};
		System.out.println(maxSubSum1(a));
		System.out.println(maxSubSum2(a));
	}

	//N^3 Solution
	public static int maxSubSum1(int [] a)
	{
		int maxSum = 0;
		for(int i = 0; i < a.length; i++) {
			for(int j = i; j < a.length; j++)
			{
				int thisSum = 0;
				for (int k = i; k <= j; k++)
				{
					thisSum += a[k];
				}
				
				if(thisSum > maxSum)
				{
					maxSum = thisSum;
				}
			}
		}
		return maxSum;
	}
	//N^2 solution
	public static int maxSubSum2(int [] a)
	{
		int maxSum = 0;
		for(int i=0; i<a.length; i++)
		{
			int thisSum = 0;
			for(int j=i;j<a.length;j++)
			{
				thisSum += a[j];
				if(thisSum > maxSum)
				{
					maxSum = thisSum;
				}
			}
		}
		return maxSum;
	}
}
