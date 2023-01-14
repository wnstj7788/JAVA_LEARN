import java.util.Stack;// 라이브러 불러

public class Stack_tesst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<>(); // int형 스택 선언
		Stack<String> stack1 = new Stack<>(); // String형 스택 선언

		// 5 2 3 7 (7삭제) 1 4 (4삭제)
		stack.push(5); // 스택에 5값 추가
		stack.push(2); // 스택에 2값 추가
		stack.push(3); // 스택에 3값 추가
		stack.push(7); // 스택에 7값 추가
		stack.pop();
		stack.push(1); // 스택에 1값 추가
		stack.push(4); // 스택에 4값 추가
		stack.pop();
		
		stack1.push("banana");
		stack1.push("apple");
		stack1.push("orange");
		stack1.pop();

		System.out.println(stack);
		System.out.println(stack1);
	}
}
