import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1697_숨바꼭질 {
	//탐색 문제 - 가장 적은 횟수로 돌아갈 수 있는 방법 
	// 출발할 떄 목적지 까지의 길을 모름
	// 가보면서 알아보기
	

    static int N;
    static int K;
    static int visit[] = new int[100001];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();


        bfs();
        if(K == 0) {
        	System.out.println(N);
        }else
        	System.out.println(visit[K]);

    }
    
    private static void bfs(){
    	
    	Queue<Integer> q = new LinkedList<>();
    	q.offer(N);
    	
    	while (!q.isEmpty()){
    		int tmp = q.poll();
    		if(tmp==K){
    			break;
    		}
    		for(int i=0; i<3; i++){
    			int next;
    			
    			if (i == 0) {
    				next = tmp + 1;
    			} else if (i == 1) {
    				next = tmp - 1;
    			} else {
    				next =tmp * 2;
    			}
    			if (next >= 0 && next < visit.length && visit[next] == 0) {
    				q.offer(next);
    				visit[next] = visit[tmp] + 1;
    			}
    		}
    	}
    }
}

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              