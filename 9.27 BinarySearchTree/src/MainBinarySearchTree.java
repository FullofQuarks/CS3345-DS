
public class MainBinarySearchTree {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree b = new BinarySearchTree<Integer>();
		b.insert(6);
		b.insert(4);
		b.insert(8);
		b.insert(5);
		b.insert(3);
		b.insert(7);
		b.insert(9);
		
		BinarySearchTree a = new BinarySearchTree<Integer>();
		a.insert(6);
		a.insert(4);
		a.insert(3);
		a.insert(5);
		a.insert(3);
		a.insert(7); 
		a.insert(9);
		
		b.equals(a);
		
		System.exit(0);
	}

}
