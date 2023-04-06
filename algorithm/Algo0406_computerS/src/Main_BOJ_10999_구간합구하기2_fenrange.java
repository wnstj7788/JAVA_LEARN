import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_10999_구간합구하기2_fenrange {
	static long[] atree, btree;
    static int N;
    static int M,K;
    static void update(int type, int i, long diff) {
        long[] tree = type==1 ? atree : btree;
        while (i <= N) {
            tree[i] += diff;
            i += i&-i;
        }
    }

    static void rangeUpdate(int l, int r, long x) {
        update(1, l, x);
        update(1, r+1, -x);
        update(2, l, x * (l-1));
        update(2, r+1, -x * r);
    }

    static long getValue(int type, int i) {
    	long[] tree = type==1 ? atree : btree;
        long answer = 0;
        while (i > 0) {
            answer += tree[i];
            i -= i&-i;
        }
        return answer;
    }

    static long prefixSum(int x) {
        return getValue(1, x) * x - getValue(2, x);
    }

    static long rangeSum(int a, int b) {
        return prefixSum(b) - prefixSum(a-1);
    }

  public static void main(String[] args) throws Exception {
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      atree = new long[N+1];
      btree = new long[N+1];
      int M = Integer.parseInt(st.nextToken()) ;
      int K= Integer.parseInt(st.nextToken());

      for (int i = 1; i <= N; i++) {
          rangeUpdate(i, i, Long.parseLong(br.readLine()));
      }

      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < M+K; i++) {
		  st=new StringTokenizer(br.readLine());
		  int a=Integer.parseInt(st.nextToken());
		  if(a==1) {
			  int b=Integer.parseInt(st.nextToken());
			  int c=Integer.parseInt(st.nextToken());
			  long d=Long.parseLong(st.nextToken());
			  rangeUpdate(b,c,d);
		  }else if(a==2) {
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			long s=rangeSum(b,c);
			sb.append(s).append("\n");
		  }
      }
      System.out.print(sb);
  }
}
