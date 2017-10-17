
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
		b.nodeCount();
		b.nodeCount();
		System.out.print("\n");
		b.isFull();
		System.out.print("\n");
		b.printTree();
		
		b.makeEmpty();
		b.printTree();
		
		System.exit(0);
	}

}
