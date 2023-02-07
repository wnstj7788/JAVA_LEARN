/*
 *     (1)
 *     ↙  ↘
 *   (2)  (3)
 *  ↙  ↘
 *(4)  (5)
 * 
 * Inorder (Left, Root, Right) :  4 2 5 1 3 
 * Preorder (Root, Left< Right) : 1 2 4 5 3 
 * Postorder ( Left, Right, Root) : 4 5 2 3 1
 * 
 * 
 */

class Node { // 노드 생성 노드는 데이터와 왼쪽 오른쪽 자식 노드를 가짐
	int data;
	Node left;
	Node right;
}

class Tree {
	public Node root; // root 선언 트리의 시작점

	public void setRoot(Node node) { // get set정의
		this.root = node;
	}

	public Node getRoot() {
		return root;
	}

	public Node makeNode(Node left, int data, Node right) {// 노드를 만드는 함수 정의
		Node node = new Node();
		node.data = data;
		node.left = left;
		node.right = right;
		return node;
	}

	public void inorder(Node node) {
		if (node != null) {
			inorder(node.left);// 왼쪽 재귀 호출
			System.out.println(node.data); // 나 호출
			inorder(node.right); // 오른쪽 재귀

		}
	}

	public void preorder(Node node) {
		if (node != null) {
			System.out.println(node.data); // 나 호출
			preorder(node.left);// 왼쪽 재귀 호출
			preorder(node.right); // 오른쪽 재귀

		}
	}

	public void postorder(Node node) {
		if (node != null) {
			postorder(node.left);// 왼쪽 재귀 호출
			postorder(node.right); // 오른쪽 재귀
			System.out.println(node.data); // 나 호출

		}
	}

}

public class TreeTest {
	public static void main(String[] args) {
		Tree t = new Tree(); // 트리 생성
		// 마지막 노드부터 생성하자
		Node n4 = t.makeNode(null, 4, null);
		Node n5 = t.makeNode(null, 5, null);
		Node n2 = t.makeNode(n4, 2, n5);
		Node n3 = t.makeNode(null, 3, null);
		Node n1 = t.makeNode(n2, 1, n3);
		
		t.setRoot(n1); //1번 노드 루트 노드로 선언 
		t.inorder(t.getRoot());
		t.postorder(t.getRoot());
		t.preorder(t.getRoot());

	}

}
