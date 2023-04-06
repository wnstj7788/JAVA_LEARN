

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_bj_1753_최단경로_dij {

	static int [] distance;
	static int V, E, K;
	
	static class Edge{
		int v;
		int w;
		public Edge(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}
	}
	static List<Edge>[] adj;
	static int MM=Integer.MAX_VALUE/1000;
	static boolean [] checked;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		K=Integer.parseInt(st.nextToken());
		adj=new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adj[i]=new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			adj[s-1].add(new Edge(e-1, w));
		}
		distance=new int[V];
		Arrays.fill(distance, MM);
		checked=new boolean[V];
		distance[K-1]=0;
		for (int i = 0; i <V-1; i++) {
			int minV=MM;
			int w=-1;
			for (int j = 0; j <V; j++) {
				if(!checked[j] && minV>distance[j]) {
					minV=distance[j];
					w=j;
				}
			}
			if(w==-1) break; // 끊어짐
			checked[w]=true;
			for (Edge next:adj[w]) {
				if(!checked[next.v] && distance[next.v]>distance[w]+next.w) {
					distance[next.v]=distance[w]+next.w;
				}
			}
		}
		// 시작 k-> i 최소 거리합 distance[i]
		for (int i = 0; i < V; i++) {
			if(distance[i]==MM) {
				System.out.println("INF");
			}else {
				System.out.println(distance[i]);
			}
		}
	}

}
