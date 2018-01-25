
public class BookLLMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BookLL b = new BookLL("Test");
		BookLL books = new BookLL(100);
		
		System.out.println(b.getName());
		//for( int ix = 0; ix < 50; ++ix)
			System.out.println(books.push(b));
		

		System.exit(0);
		
	}

}
