import java.util.*;

public class GenLinkedList<AnyType> {
    private Node h; // list header
    private int size;
    
    public GenLinkedList()
    {
    		h = new Node();;
    		//h.l = null;
    		h.next = null;
    		size = 0;
    }
    
    public boolean addFront(AnyType newNode)
    {
    		Node n = new Node();
    		n = (Node) newNode;
    		if(n == null) //out of memory
    		{
    			return false;
    		}
    		else
    		{
    			n.next = h;
    			size++;
    			return true; 
    		}
    }
    
	@SuppressWarnings("unused")
	public void addEnd(AnyType newNode)
    {
    		Node p = h.next;
    		//O(N) as it needs to traverse the list
    		while(p != null)
    		{
    			p = p.next;
    		}
    		if(p!=null)
    		{
    			Node n = new Node();
    			n = newNode;
    			p.next = n;
    			size++;
    		}
    }
	
	public void removeFront()
	{
		h.next = h;
		size--;
	}
	
	public void removeEnd()
	{
		Node p = h.next;
		int it = 0;
		while(p != null && it < size)
		{
			p = p.next;
		}
		p.next = null;
		
	}
	
	private int getSize()
	{
		return size;
	}
	
	public void set(int idx, AnyType newNode)
	{
		int it = 0;
		Node p = h.next;
		Node n = deepCopy();
		while(it < idx)
		{
			p = p.next;
		}
		
	}
	
	public Node deepCopy()
	{
		Node clone = new Node<AnyType>();
		return clone;
	}
    
    private class Node<AnyType>
    {
        public Node<AnyType> next;
        public Node(Node<AnyType> n )
        {
            next = n;
        }
        
        public Node() {}

    }
}
