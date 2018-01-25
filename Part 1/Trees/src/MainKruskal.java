import java.util.*;
import java.util.HashSet;
import java.util.Map.Entry;

public class MainKruskal {
	public static void main(String[] args)
	{
		kruskal();
	}
	
	public static void kruskal()
	{
		int edgesAccepted = 0;
		final int NUM_VERTICES = 2;
		DisjSets ds = new DisjSets(NUM_VERTICES);
		BinomialQueue<Edge> pq = new BinomialQueue<Edge>();
		Edge ed = new Edge("Dallas", "Abilene", 4);
		Edge dd = new Edge("Dallas", "Chicago", 6);
		Edge de = new Edge("Abilene", "Dallas", 4);
		pq.insert(ed);
		Map<String,Integer> map = new HashMap<>();
		map.put("Dallas", 0);
		map.put("Abilene", 1);
		List<Edge> vs = new LinkedList<Edge>();
		vs.add(0, ed);
		vs.add(0, dd);
		System.out.println(vs.get(0).u);
		Set< Map.Entry< String,Integer> > st = map.entrySet();
       for (Map.Entry< String,Integer> me:st)
       {
           System.out.print(me.getKey()+"-->");
           System.out.println(me.getValue());
       }
	}
}
