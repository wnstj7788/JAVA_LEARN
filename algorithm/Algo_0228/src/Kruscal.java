
import java.util.Arrays;
import java.util.Scanner;

public class Kruscal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		V = sc.nextInt();
		E = sc.nextInt();
		edgeList = new Edge[E];

		for (int i = 0; i < E; i++) {
			edgeList[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}

		Arrays.sort(edgeList);

		makeSet();
		int result = 0, count = 0;

		for (Edge edge : edgeList) {
			if (union(edge.fromV, edge.toV)) {
				result += edge.weight;
				if (++count == V - 1)
					break;

			}
		}
		System.out.println(result);

	}

	static class Edge implements Comparable<Edge> {
		int fromV, toV, weight;

		public Edge(int fromV, int toV, int weight) {
			super();
			this.fromV = fromV;
			this.toV = toV;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);

		}

	}

	static int V, E;
	static Edge[] edgeList;
	static int[] parents;

	static void makeSet() {
		parents = new int[V];
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}

	static int findSet(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = findSet(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);

		if (aRoot == bRoot)
			return false; 
		parents[bRoot] = aRoot;
		return true;
	}

}