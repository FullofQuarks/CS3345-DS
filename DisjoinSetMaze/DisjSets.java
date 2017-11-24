// DisjSets class
//
// CONSTRUCTION: with int representing initial number of sets
//
// ******************PUBLIC OPERATIONS*********************
// void union( root1, root2 ) --> Merge two sets
// int find( x )              --> Return set containing x
// ******************ERRORS********************************
// No error checking is performed

/**
 * Disjoint set class, using union by rank and path compression.
 * Elements in the set are numbered starting at 0.
 * @author Mark Allen Weiss
 */
public class DisjSets
{
    /**
     * Construct the disjoint sets object.
     * @param numElements the initial number of disjoint sets.
     */
    public DisjSets( int numElements )
    {
        s = new Cell [ numElements ];
        counter = 1;
        //s[0].root = -1;
        for( int i = 0; i < s.length; i++ )
        	s[i] = new Cell(-1);
    }
    
    public static class Cell
    {
    	Cell(int theElement)
    	{
    		this( theElement, true, true);
    	}
    	
    	Cell(int r, boolean leftWall, boolean bottomWall)
    	{
    		root = r;
    		left = leftWall;
    		bottom = bottomWall;
    	}
    	int root;
    	boolean left;
    	boolean bottom;
    }

    /**
     * Union two disjoint sets using the height heuristic.
     * For simplicity, we assume root1 and root2 are distinct
     * and represent set names.
     * @param root1 the root of set 1.
     * @param root2 the root of set 2.
     */
    public void union( int root1, int root2 )
    {
        if( s[ root2 ].root < s[ root1 ].root )  // root2 is deeper
            s[ root1 ].root = root2;        // Make root2 new root
        else
        {
            if( s[ root1 ].root == s[ root2 ].root )
                s[ root1 ].root--;          // Update height if same
            s[ root2 ].root = root1;        // Make root1 new root
        }
        counter++;
    }

    /**
     * Perform a find with path compression.
     * Error checks omitted again for simplicity.
     * @param x the element being searched for.
     * @return the set containing x.
     */
    public int find( int x )
    {
        if( s[ x ].root < 0 )
            return x;
        else
            return s[ x ].root = find( s[ x ].root );
        
    }
    
    public void printAll()
    {
    	for(int ix = 0; ix < s.length; ++ix)
    	{
    		//System.out.print(ix + ": ");
    		System.out.print(s[ix].root);
    		System.out.print(" ");
    	}
    	System.out.print("\nThere are " + counter + " elements in the Disjointed Sets.");
    }
    
    public boolean isOne()
    {
    	boolean one = true;
    	for(int ix = 0; ix < s.length; ++ix)
    	{
    		if(s[ix].root == -1)
    		{
    			one = false;
    		}
    	}
    	return one;
    }

    private Cell [ ] s;
    private int counter;


    // Test main; all finds on same output line should be identical
    /*public static void main( String [ ] args )
    {
        int NumElements = 128;
        int NumInSameSet = 16;

        DisjSets ds = new DisjSets( NumElements );
        int set1, set2;

        for( int k = 1; k < NumInSameSet; k *= 2 )
        {
            for( int j = 0; j + k < NumElements; j += 2 * k )
            {
                set1 = ds.find( j );
                set2 = ds.find( j + k );
                ds.union( set1, set2 );
            }
        }

        for( int i = 0; i < NumElements; i++ )
        {
            System.out.print( ds.find( i )+ "*" );
            if( i % NumInSameSet == NumInSameSet - 1 )
                System.out.println( );
        }
        System.out.println( );
    }*/
}
