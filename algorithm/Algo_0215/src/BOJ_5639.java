import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
이진 검색 트리 
노드 왼쪽의 서브트리에 있는 모든 노드의 키는 노드이 키 보다 작다 
노드의 오른쪽 서브트리에 있는 모든 노드의 키는 노드의 키 보다 크다 

접근방법 : 전위 순회결과 : 처음 값이 root 값이라는 특징 있다.
입력을 받는 동시에 루트값과 비교 후 작다면 왼쪽 노드 크다면 오른쪽 노드로 만든다.

*/

public class BOJ_5639 {
	public static class Node {
		int num;
		Node left, right;

		Node(int num) {
			this.num = num;
		}

		Node(int num, Node left, Node right) { // 트리 생성을 위한 기본 생성자
			this.num = num;
			this.left = left;
			this.right = right;
		}

		// 위의 접근 방법과 같이 입력을 받으면서 바로바로 비교를 위해 삽입 시에 동작할 행동을 정의
		void input(int n) {
			if (n < this.num) { // 입력 값이 현재 값보다 작다면 왼쪽 노드로 들어가야함
				if (this.left == null)
					this.left = new Node(n); // 왼쪽 요소가 비어있다면 왼쪽에 노드 생
				else
					this.left.input(n); // 비어 있지 않다면 재귀적 탐색 

			} else { // 입력 값이 현재 값보다 크다면 오른쪽노드로 들어가야함
				if (this.right == null)
					this.right = new Node(n); // 오른쪽 노드가 비어있다면 오른쪽에 노드 생성
				else
					this.right.input(n); //비어 있지 않다면 재귀 탐색 

			}

		}

	}
	
	static void postOrder(Node node) {
		if(node == null) return;
		
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.num);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		//Scanner sc = new Scanner(System.in);
		// 첫번째 값이 루트라는 특성을 이용
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int root_value =Integer.parseInt(br.readLine());
		Node root = new Node(root_value);
		
		
		String temp;
		
		//why Scanner hasNext 안멈추냠.......
		//while(sc.hasNext()) {
		while (true) {
			temp = br.readLine();
			//Short-circuit??
			if(temp == null || temp.equals("") )
				break;
			root.input(Integer.parseInt(temp));
			
		}
		
		postOrder(root);

	}
}
