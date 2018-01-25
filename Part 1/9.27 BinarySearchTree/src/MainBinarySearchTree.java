
public class MainBinarySearchTree {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree<Integer> b = new BinarySearchTree<>();
		b.insert(6);
		b.insert(4); 
		b.insert(8);
		b.insert(5);
		b.insert(3);
		b.insert(7);
		b.insert(9);
		
		BinarySearchTree<Integer> a = new BinarySearchTree<>();
		a.insert(6);
		a.insert(4);
		a.insert(8);
		a.insert(5);
		a.insert(3);
		a.insert(7); 
		//a.insert(15);
		
		//Mirrored Example
		BinarySearchTree<Integer> c = new BinarySearchTree<>();
		c.insert(100);
		c.insert(50);
		c.insert(40);
		c.insert(45);
		c.insert(150);
		BinarySearchTree<Integer> d = new BinarySearchTree<>();

		//Mirror c into d
		d = c.mirror();
		System.out.println(c.isMirror(d));
		//Test to see if it's mirrored
		for(int ix = 0; ix < 10001; ++ix)
		{
			d = d.mirror();
		}
		System.out.println(c.isMirror(d));
		c.equals(d);
		c.rotateRight(50);
		c.printTree();

		
		System.exit(0);
	}

}
