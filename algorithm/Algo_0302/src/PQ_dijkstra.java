import java.util.PriorityQueue;

//프림과 다익스트라의 차이
// 네 영역에 있는 애들이 인접한 애들을 가져올 때 가장 적은 비용으로 가져올 수 있는 것 프림

// 무조건 내가  -> 누적해서 


public class PQ_dijkstra {
	static int N;
	static int [][] adjArr;
	public static void main(String[] args) {
		
	}
	
	static int dijkstra(int start, int end) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N]; //어떤 정점까지의 최소비용이 나왔는지 기록하는 배열 
		
		pq.add(new Edge(0,start)); // 출발점 영입하는데 드는 비용은 0원
		
		while(!pq.isEmpty()) {
			Edge minEdge = pq.poll(); // 현재 확보한 간선중에 가장 짧은 간선이 나옴 (끝에 정점 매달려 있음)
			
			if(visited[minEdge.num]) continue; // 애는 최소 비용 이미 기록되었던 애야(새로운 정점이 아냐)
			//오 내가 현재 새로 영입할 수 있는 애들 중에 가장 저렴하네? 
			visited[minEdge.num] = true; 
			
			if(minEdge.num == end) {// 내 타겟이 발견됐다> 이제 pq 에는 이것보다 비용 비싼것들만 있을 테니!
				return minEdge.weight;
			}
			
			for(int i = 0; i < N; i++) {
				if(!visited[i] && adjArr[minEdge.num][i] > 0) {
					// 내가 A를 영입하는 거 + A한테 연결된 친구들을 영입하는 비용 
					pq.add(new Edge(minEdge.weight+ adjArr[minEdge.num][i],i));
				}
			}
			
		}
		return -1; // 타켓이 없냐? 그럼 -1 
		
	}
	
	
	static class Edge implements Comparable<Edge>{
		int weight, num;
		Edge(int w, int n){
			weight = w;
			num  = n;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
	}
}
