
public class Edge implements Comparable<Edge>
	{
		int weight;
		String u;
		String v;
		
		public Edge(String vertexU, String vertexV, int w)
		{
			u = vertexU;
			v = vertexV;
			weight = w;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return (Integer.compare(weight, o.weight));
		}
	}