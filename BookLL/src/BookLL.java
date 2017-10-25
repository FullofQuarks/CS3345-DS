import java.util.*;
public class BookLL {

	private String name;
	private BookLL [] books;
	private int size;
	private int top;
	
	public BookLL(String n)
	{
		name = n;
	}
	
	public BookLL(int s)
	{
		top = 0;
		size = s;
		books = new BookLL[size];
	}
	
	public void setName(String n)
	{ 
		name = n;
	}
	
	public String getName()
	{
		return name; 
	}
	
	private BookLL deepCopy(BookLL b)
	{
		BookLL clone;
		clone = new BookLL(b.getName());
		return clone;
	}
	
	public String toString()
	{
		return "The Book name is " + name + ".";
	}
	
	public boolean push(BookLL b)
	{

		/*if(top == size)
		{
			System.out.println("You've reached the top of the stack.");
			System.exit(1);
		}*/
		books[top].deepCopy(b);
		return true;
	}
	
	private static class Node<AnyType>
	{
	   private AnyType data;
	   private Node<AnyType> next;

	   public Node(AnyType data, Node<AnyType> next)
	   {
	      this.data = data;
	      this.next = next;
	   }
	}
}
