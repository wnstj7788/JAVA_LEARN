import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5639_re {
	static class Node{
		int num;
		Node left, right;
		
		Node(int num){
			this.num = num;
		}
		
		public Node(int num, BOJ_5639_re.Node left, BOJ_5639_re.Node right) {
			this.num = num;
			this.left = left;
			this.right = right;
		}
		
		
		 void input(int n) {
			if( n < this.num) {
				if(this.left == null) {
					this.left = new Node(n);
				}else
					this.left.input(n);
				
			}else {
				if(this.right == null) {
					this.right = new Node(n);
					
				}else
					this.right.input(n);
			}
				
		}
		
	}
	
	static void postOrder(Node node) {
		if(node == null)
			return;
		
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.num);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Node root = new Node(Integer.parseInt(br.readLine()));
		
		String temp;
		while(true) {
			temp = br.readLine();
			if(temp == null || temp.equals(""))
				break;
			
			root.input(Integer.parseInt(temp));
			
		}
		
		postOrder(root);
		
	}

}
