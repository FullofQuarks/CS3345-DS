import java.util.*;

public class MyLinkedList<AnyType> implements Iterable<AnyType>
{
	private static class Node<AnyType>
	{
		
	}
	
	public MyLinkedList()
	{
		doClear();
	}
	
	public void clear()
	{
		
	}
	
	public int size()
	{
		return theSize;
	}
	
	public boolean isEmpty()
	{
		return size() == 0;
	}
	
	public boolean add(AnyType x)
	{
		add(size(), x);
		return true;
	}
	public void add(int idx, AnyType x)
	{
		addBefore(getNode(idx, 0, size() ), x);
	}
	public AnyType get(int idx)
	{
		return getNode(idx).data;
	}
	public AnyType set(int idx, AnyType newVal)
	{
		Node<AnyType> = getNode(idx);
		AnyType oldVal = p.data;
		p.data = newVal;
		return oldVal;
	}
	public AnyType remove(int idx)
	{
		return remove(getNode(idx));
	}
	private void addBefore(Node<AnyType> p, AnyType x)
	{
		
	}
	private AnyType remove(Node<AnyType> p)
	{
		
	}
	private Node<AnyType> getNode(int idx)
	{
		
	}
	private Node<AnyType> getNode(int idx, int lower, int upper)
	{
		
	}
	
	public java.util.Iterator<AnyType> iterator()
	{
		return new LinkedListIterator();
	}
	private class LinkedListIterator implements java.util.Iterator<AnyType>{
		
	}
	
	private int theSize;
	private int modCount = 0;
	private Node<AnyType> beginMarker;
	private Node<AnyType> endMarker;
	
	private static class Node<AnyType>
	{
		public Node(AnyType d, Node<AnyType> p, Node<AnyType> n)
		{
			data = d;
			prev = p;
			next = n;
		}
		
		public AnyType data;
		public Node<AnyType> prev;
		public Node<AnyType> next;
	}
}