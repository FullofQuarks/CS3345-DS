// BinarySearchTree class
//
// CONSTRUCTION: with no initializer
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x
// boolean contains( x )  --> Return true if x is present
// Comparable findMin( )  --> Return smallest item
// Comparable findMax( )  --> Return largest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// void printTree( )      --> Print tree in sorted order
// ******************ERRORS********************************
// Throws UnderflowException as appropriate

/**
 * Implements an unbalanced binary search tree.
 * Note that all "matching" is based on the compareTo method.
 * @author Mark Allen Weiss
 */

import java.util.*;
import java.lang.Object;

public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> implements Cloneable
{ 
    /**
     * Construct the tree.
     */
    public BinarySearchTree( )
    {
        root = null;
    }
    

    /**
     * Insert into the tree; duplicates are ignored.
     * @param x the item to insert.
     */
    public void insert( AnyType x )
    {
        root = insert( x, root );
    }

    /**
     * Remove from the tree. Nothing is done if x is not found.
     * @param x the item to remove.
     */
    public void remove( AnyType x )
    {
        root = remove( x, root );
    }

    /**
     * Find the smallest item in the tree.
     * @return smallest item or null if empty.
     */
    public AnyType findMin( )
    {
        if( isEmpty( ) )
            throw new UnderflowException("empty");
        return findMin( root ).element;
    }

    /**
     * Find the largest item in the tree.
     * @return the largest item of null if empty.
     */
    public AnyType findMax( )
    {
        if( isEmpty( ) )
            throw new UnderflowException( "empty");
        return findMax( root ).element;
    }

    /**
     * Find an item in the tree.
     * @param x the item to search for.
     * @return true if not found.
     */
    public boolean contains( AnyType x )
    {
        return contains( x, root );
    }

    /**
     * Make the tree logically empty.
     */
    public void makeEmpty( )
    {
        root = null;
    }

    /**
     * Test if the tree is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( )
    {
        return root == null;
    }

    /**
     * Print the tree contents in sorted order.
     */
    public void printTree( )
    {
        if( isEmpty( ) )
            System.out.println( "Empty tree" );
        else
            printTree( root );
    }
    
    public void nodeCount()
    {
    		int nodes = 0;
    		nodes = nodeCount(root);
    		System.out.println(nodes);
    }
    
    private int nodeCount(BinaryNode<AnyType> t)
    {
    		if(t == null)
    			return 0;
    		return (1 + nodeCount(t.left) + nodeCount(t.right));
    		
    }
    
    public void isFull()
    {
    		if(isFull(root) == 0)
    		{
    			System.out.println("This tree is a full binary tree.");
    		}
    		else
    		{
    			System.out.println("This tree is NOT a full binary tree.");
    		}
    }
    
    private int isFull(BinaryNode<AnyType> t)
    {

    		boolean full;
    		if(t == null) 
    			return 0;
    		if(numChildren(t) == 1)
    			return 1;
    		return (isFull(t.left) + isFull(t.right));
    }
    
    private int numChildren(BinaryNode<AnyType> t)
    {
		if(t == null) 
			return 0;
		if(t.left != null && t.right == null)
		{
			return 1;
		}
		else if(t.left == null && t.right != null)
		{
			return 1;
		}
		else if(t.left == null && t.right == null)
			return 0;
		else
			return 0;
    }
    
    public void compareStructure(BinarySearchTree<AnyType> t)
    {
    		BinaryNode<AnyType> otherRoot = t.root;
    		if(otherRoot == null || this.root == null)
    		{
    			if(otherRoot == null && this.root == null)
    				System.out.println("The structures are similar.");
    			else
    				System.out.println("The structures are NOT similar.");
    		}
    		else if(compareStructure(root, otherRoot))
    		{
    			System.out.println("The structures are similar.");
    		}
    		else
    		{
    			System.out.println("The structures are not similar.");
    		}
    }
    
    private boolean compareStructure(BinaryNode<AnyType> a, BinaryNode<AnyType> b)
    {
    		if(a.left == null || b.left == null) 
    		{
    			return a.left == b.left;  
    		}
    		if(a.right == null || b.left == null)
    			return a.right == b.right;
    		return (compareStructure(a.left, b.left) && compareStructure(a.right, b.right));
    }
    
    public void equals(BinarySearchTree<AnyType> t)
    {
    		BinaryNode<AnyType> otherRoot = t.root;
    		if(this.root != null && otherRoot != null)
    			System.out.println(equals(this.root, otherRoot));
    		else
    			System.out.println(this.root == otherRoot);
    }
    
    private boolean equals(BinaryNode<AnyType> a, BinaryNode<AnyType> b)
    {
		if(a.left == null || b.left == null)
		{
			return a.element == b.element;  
		}
		if(a.right == null || b.right == null)
			return a.element == b.element;
		return (equals(a.left, b.left) && equals(a.right, b.right));
    }
    
    public BinarySearchTree<AnyType> copy( )
    {
    	BinarySearchTree<AnyType> newBST = new BinarySearchTree<AnyType>();
    	newBST.root = this.root.deepCopy();
    	copy(root, newBST.root);
    	return newBST;
    }
    
    private void copy(BinaryNode<AnyType> x, BinaryNode<AnyType> n)
    {
    	if(x.left != null)
    	{
    		n.left = deepClone(x.left);
    		copy(x.left, n.left);
    	}
    	if(x.right != null)
    	{
    		n.right = deepClone(x.right);
    		copy(x.right, n.right);
    	}
    }
    
    private BinaryNode<AnyType> deepClone(BinaryNode<AnyType> x)
    {
    	return new BinaryNode<AnyType>(x.element, x.left, x.right);
    }
    
    public BinarySearchTree<AnyType> mirror()
    {
    	BinarySearchTree<AnyType> mirrored = new BinarySearchTree<AnyType>();
    	mirrored = this.copy();
    	mirror(mirrored.root);
    	
    	return mirrored; 
    }
    
    private BinaryNode<AnyType> mirror(BinaryNode<AnyType> x)
    {
    	if(x == null)
    		return x;
		BinaryNode<AnyType> left = mirror(x.left);
		BinaryNode<AnyType> right = mirror(x.right);
		x.left = right;
		x.right = left;
		
		return x;
    }
    
    public boolean isMirror(BinarySearchTree<AnyType> n)
    {
    	BinarySearchTree<AnyType> temp = new BinarySearchTree<AnyType>();
    	temp = n.mirror();
    	return equals(this.root, temp.root);
    }

    /**
     * Internal method to insert into a subtree.
     * @param x the item to insert.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private BinaryNode<AnyType> insert( AnyType x, BinaryNode<AnyType> t )
    {
        if( t == null )
            return new BinaryNode<>( x, null, null );
        
        int compareResult = x.compareTo( t.element );
            
        if( compareResult < 0 )
            t.left = insert( x, t.left );
        else if( compareResult > 0 )
            t.right = insert( x, t.right );
        else
            ;  // Duplicate; do nothing
        return t;
    }

    /**
     * Internal method to remove from a subtree.
     * @param x the item to remove.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private BinaryNode<AnyType> remove( AnyType x, BinaryNode<AnyType> t )
    {
        if( t == null )
            return t;   // Item not found; do nothing
            
        int compareResult = x.compareTo( t.element );
            
        if( compareResult < 0 )
            t.left = remove( x, t.left );
        else if( compareResult > 0 )
            t.right = remove( x, t.right );
        else if( t.left != null && t.right != null ) // Two children
        {
            t.element = findMin( t.right ).element;
            t.right = remove( t.element, t.right );
        }
        else
            t = ( t.left != null ) ? t.left : t.right;
        return t;
    }

    /**
     * Internal method to find the smallest item in a subtree.
     * @param t the node that roots the subtree.
     * @return node containing the smallest item.
     */
    private BinaryNode<AnyType> findMin( BinaryNode<AnyType> t )
    {
        if( t == null )
            return null;
        else if( t.left == null )
            return t;
        return findMin( t.left );
    }

    /**
     * Internal method to find the largest item in a subtree.
     * @param t the node that roots the subtree.
     * @return node containing the largest item.
     */
    private BinaryNode<AnyType> findMax( BinaryNode<AnyType> t )
    {
        if( t != null )
            while( t.right != null )
                t = t.right;

        return t;
    }

    /**
     * Internal method to find an item in a subtree.
     * @param x is item to search for.
     * @param t the node that roots the subtree.
     * @return node containing the matched item.
     */
    private boolean contains( AnyType x, BinaryNode<AnyType> t )
    {
        if( t == null )
            return false;
            
        int compareResult = x.compareTo( t.element );
            
        if( compareResult < 0 )
            return contains( x, t.left );
        else if( compareResult > 0 )
            return contains( x, t.right );
        else
            return true;    // Match
    }

    /**
     * Internal method to print a subtree in sorted order.
     * @param t the node that roots the subtree.
     */
    private void printTree( BinaryNode<AnyType> t )
    {
        if( t != null )
        {
            printTree( t.left );
            System.out.println( t.element );
            printTree( t.right );
        }
    }

    /**
     * Internal method to compute height of a subtree.
     * @param t the node that roots the subtree.
     */
    private int height( BinaryNode<AnyType> t )
    {
        if( t == null )
            return -1;
        else
            return 1 + Math.max( height( t.left ), height( t.right ) );    
    }
    
    // Basic node stored in unbalanced binary search trees
    private static class BinaryNode<AnyType>
    {
            // Constructors
        BinaryNode( AnyType theElement )
        {
            this( theElement, null, null );
        }

        BinaryNode( AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt )
        {
            element  = theElement;
            left     = lt;
            right    = rt;
        }
        
        BinaryNode<AnyType> deepCopy()
        {
        	BinaryNode<AnyType> left = null;
        	BinaryNode<AnyType> right = null;
        	if(this.left != null)
        	{
        		left = this.left.deepCopy();
        	}
        	if(this.right != null)
        	{
        		right = this.right.deepCopy();
        	}
        	return new BinaryNode<AnyType>(element, left, right);
        }

        AnyType element;            // The data in the node
        BinaryNode<AnyType> left;   // Left child
        BinaryNode<AnyType> right;  // Right child
    }


      /** The tree root. */
    private BinaryNode<AnyType> root;


        // Test program
    public static void main( String [ ] args )
    {
        BinarySearchTree<Integer> t = new BinarySearchTree<>( );
        final int NUMS = 10000;
        final int GAP  =   37;

        System.out.println( "Checking... (no more output means success)" );

        for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS )
            t.insert( i );

        for( int i = 1; i < NUMS; i+= 2 )
            t.remove( i );

        if( NUMS < 40 )
            t.printTree( );
        if( t.findMin( ) != 2 || t.findMax( ) != NUMS - 2 )
            System.out.println( "FindMin or FindMax error!" );

        for( int i = 2; i < NUMS; i+=2 )
             if( !t.contains( i ) )
                 System.out.println( "Find error1!" );

        for( int i = 1; i < NUMS; i+=2 )
        {
            if( t.contains( i ) )
                System.out.println( "Find error2!" );
        }
    }
}
