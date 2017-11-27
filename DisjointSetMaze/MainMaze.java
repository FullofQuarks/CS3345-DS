
public class MainMaze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DisjSets cells = new DisjSets( 4,4 );
		System.out.println(cells.find(3) == cells.find(0));
		cells.union(0, 1);
		cells.union(2, 3);
		cells.union(0, 2);
		System.out.println(cells.find(3) == cells.find(0));
		//cells.union(0, 2);
		cells.printAll();
		//System.out.println(cells.find(0) == cells.find(3));
		System.out.println();
		System.out.println(cells.isOne());
		System.out.println();
		cells.generateMaze();
		cells.printAll();
		System.out.println();
		cells.printMaze();
	}

}
