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
 * Modified by Nicholas Smith
 * @author Nicholas Smith 
 */
public class DisjSets
{
    /**
     * Construct the disjoint sets object.
     * @param numElements the initial number of disjoint sets.
     */
    public DisjSets( int r, int c )
    {
    	rows = r;
    	columns = c;
    	numCells = r * c;
        s = new Cell [ numCells ];
        counter = 1;
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
    
    //Method added to DisjSets by Nicholas
    public void generateMaze()
    {
    	System.out.println(numCells);
	        //Begin at top left of maze
    		union(find(0),find(1));
    		s[1].left = false;
    		s[0].bottom = true;
    		union(find(numCells-2), find(numCells-1));
    		s[numCells-1].left = false;
		setCounter = 2;
		int randomCell;
		while(setCounter < numCells-1)
		{
			randomCell = (int)(Math.random() * numCells);
			int possCells[] = {-1,-1,-1,-1};
			int possCellChoice;
			
			//Checks to see if there is a possible cell above the random value
			if(randomCell - columns > -1)
			{
				possCells[0] = randomCell - columns;
			}
			//Checks if there's a cell below
			if(randomCell + columns < numCells)
			{
				possCells[1] = randomCell + columns;
			}
			//Checks if there's a cell to the left
			if(randomCell % columns != 0)
			{
				possCells[2] = randomCell - 1;
			}
			//Checks if there's a cell to the right
			if(randomCell % columns != (columns - 1))
			{
				possCells[3] = randomCell + 1;
			}
			do
			{
				possCellChoice = (int)(Math.random() * 3);
			} while(possCells[possCellChoice] == -1);
			//if(find(randomCell) != find(possCells[possCellChoice]))
			{
				switch (possCellChoice)
				{
					//If we've chosen the top cell/wall
					case 0:
					{
						if(find(possCells[0]) != find(randomCell))
						{
							s[possCells[0]].bottom = false;
							union(find(randomCell), find(possCells[0]));
							setCounter++;
						}
					}
				break;
					//If we've chosen the bottom cell/wall
					case 1:
					{
						if(find(possCells[1]) != find(randomCell))
						{
							s[randomCell].bottom = false;
							union(find(randomCell), find(possCells[1]));
							setCounter++;
						}
					}
				break;
					//If we've chosen the left cell/wall
					case 2:
					{
						if(find(possCells[2]) != find(randomCell))
						{
							s[randomCell].left = false;
							union(find(randomCell), find(possCells[2]));
							setCounter++;
						}
					}
				break;
					//If we've chosen the right cell/wall
					case 3:
					{
						if(find(possCells[3]) != find(randomCell))
						{
							s[possCells[3]].left = false;
							union(find(randomCell), find(possCells[3]));
							setCounter++;
						}
					}
				}
			}
		}
    }
    
    //Print the maze using the 
    public void printMaze()
    {
	    	System.out.print("_");
	    	for(int ix = 0; ix < columns; ++ix)
	    	{
	    		System.out.print("__");
	    	}
	    	System.out.println();
	    	for(int ix = 0; ix < numCells; )
	    	{
	    		for(int iy = 0; iy < columns; ++iy)
	    		{
		    		if(s[ix+iy].left == true)
		    		{
		    			System.out.print("|");
		    		}
		    		if(s[ix+iy].left == false)
		    		{
		    			System.out.print(" ");
		    		}
		    		if(s[ix+iy].bottom == true)
		    		{
		    			System.out.print("_");
		    		}
		    		if (s[ix+iy].bottom == false)
		    		{
		    			System.out.print(" ");
		    		}
	    		}
	    		System.out.print("|");
	    		System.out.println();
	    		ix += columns;
	    	}
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
	    		System.out.print(find(ix));
	    		System.out.print(" ");
	    	}
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
    private int setCounter;
    private int rows;
    private int columns;
    private int numCells;


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
