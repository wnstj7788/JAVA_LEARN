import java.util.Arrays;

public class IndexedTree {

	static int [] tree;
	static int N;
	static int a[] = {2, 21, 12, 31, 22, 33, 40, 15, 60, 17, 18, 19};  
	public static void main(String[] args) {
		N=a.length+1;
		tree=new int[N];
		
		for (int i = 0; i < N-1; i++) {
			update(i+1,a[i]);
			System.out.println(Arrays.toString(tree));
		}
		System.out.println(rangeSum(1, 1));
		System.out.println(rangeSum(1, 2));
		System.out.println(rangeSum(1, 3));
		System.out.println(rangeSum(1, 4));
		System.out.println(rangeSum(1, 5));
	}

	static void update(int i, int diff) {
		while(i<N) {
			tree[i]+=diff;
			i+=( i & -i);
		}
		
	}
	static int sum(int i) {
		int result=0;
		while(i>0) {
			result+=tree[i];
			i-=( i & -i);
			//i &=(i-1);
		}
		return result;
	}
	static int rangeSum(int start, int end) {
		return sum(end)-sum(start-1);
	}
}
