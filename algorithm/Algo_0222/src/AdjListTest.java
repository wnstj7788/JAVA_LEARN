import java.util.Arrays;
import java.util.Scanner;

public class AdjListTest {
	
	static class Node{
		int vertex;
		Node link;
		
		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}
		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}
		
	}
	

	static Node[] adjList;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt();
		int E = sc.nextInt();

		adjList = new Node[V]; // head가ㅣ 모두 null인 상태 

		int from, to;
		for (int i = 0; i < E; i++) {
			from = sc.nextInt();
			to = sc.nextInt();
			
			
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
		}
		print();

	}
	
	
	static void print() {
		for(Node node : adjList) { // node 각 인접 리스트의 해드 
			System.out.println(node);
		}
	}
	

}
