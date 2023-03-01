

import java.io.*;
import java.util.*;



public class SWEA_3124_최소스패닝트리{

	static int[] parents;
	static int V,E;
	static Edge[] edgeList;
	
	static class Edge implements Comparable<Edge>{
		int start,end,weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
		
	
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st;
		
		int TC=Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=TC;tc++) {
			st=new StringTokenizer(br.readLine()," ");
			V=Integer.parseInt(st.nextToken());
			E=Integer.parseInt(st.nextToken());
			
			edgeList=new Edge[E];
			
			for(int i=0;i<E;i++) {
				st=new StringTokenizer(br.readLine()," ");
				int start=Integer.parseInt(st.nextToken())-1;
				int end=Integer.parseInt(st.nextToken())-1;
				int weight=Integer.parseInt(st.nextToken());
				edgeList[i]=new Edge(start, end, weight);
			}
			Arrays.sort(edgeList);
			
			makeset();
			
			int cnt=0 ;
			long result=0;
			for(Edge edge: edgeList) {
				if(union(edge.start, edge.end)) {
					result+=edge.weight;
					if(++cnt==V-1) break;
				}
			}
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

	private static boolean union(int a, int b) {
		// TODO Auto-generated method stub
		int aRoot=findSet(a);
		int bRoot=findSet(b);
		if(aRoot==bRoot)return false;
		
		parents[bRoot]=aRoot;
		return true;
	}

	private static int findSet(int a) {
		// TODO Auto-generated method stub
		if(a==parents[a]) return a;
		
		return parents[a]=findSet(parents[a]);
	}

	private static void makeset() {
		// TODO Auto-generated method stub
		parents=new int[V];
		
		for(int i=0; i<V;i++) {
			parents[i]=i;
		}
	}
	
}
