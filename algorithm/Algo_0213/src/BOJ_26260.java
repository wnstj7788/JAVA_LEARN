import java.util.Arrays;
import java.util.Scanner;

class Tree{
	class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
		}
	}
	Node root;
	public void makeTree(int[] a) {
		root = makeTreeR(a,0,a.length -1);
	}
	public Node makeTreeR(int[]a , int start, int end) {
		if(start > end) return null;
		int mid = (start + end) /2;
		Node node  = new Node(a[mid]);
		node.left= makeTreeR(a,start,mid -1);
		node.right = makeTreeR(a, mid+1,end );
		return node;
	}
	
	public void postorder(Node node) {
		if(node != null) {
			postorder(node.left);
			postorder(node.right);
			System.out.print(node.data + " ");
		}
	}
	
//	public void searchBTree(Node n, int find) {
//		if(find < n.data) {
//			System.out.println("data is smaller than" + n.data);
//			searchBTree(n.left,find);
//		}else if (find >n.data) {
//			System.out.println("data is bigger than" + n.data);
//			searchBTree(n.right, find);
//		}else
//			System.out.println("data found");
//	}
}


public class BOJ_26260 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int arr[] = new int[N];
		
		int X = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			if(arr[i] == -1) arr[i] = X;			
		}
		
		
		
		Arrays.sort(arr);
		Tree t = new Tree();
		
		t.makeTree(arr);
		t.postorder(t.root);
		
		
//		System.out.println(Arrays.toString(arr));
	}
}

