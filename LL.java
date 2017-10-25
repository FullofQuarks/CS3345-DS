import java.util.NoSuchElementException;

public class LL
{
	private int size;

	public LL()
	{
		size = 0;
		Node n = new Node();
	}

	private static class Node
	{
		Node head;
		Node tail;
		public Node()
		{

		}
	}

	public void removeFront()
	{
		if (head == null)
			//throw new NoSuchElementException;
		else if (head == tail)
			head = tail = null;
		else
		{
			head = head.next;
		}
		size--;
	}

	public void removeBack()
	{
		if (head == null || head == tail)
			removeFront();
		else
		{
			Node p = head;
			while (p.next != tail)
				p = p.next;
			tail = p;
			tail.next = null;
			size--;
		}
	}

	public static void main(String args[]){
		
	}
}