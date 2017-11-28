
public class MainMaze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DisjSets cells = new DisjSets( 1000,1000 );
		System.out.println("Begin.");
		cells.generateMaze();
		System.out.println();
		cells.printMaze();
	}

}
