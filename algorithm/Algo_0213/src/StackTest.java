
public class StackTest {
	public static void main(String[] args) {
		IStack<String> stack = new LinkedLIstStack<String>();
		
		
		stack.push("강수민0");
		stack.push("강수민1");
		stack.push("강수민2");
		stack.push("강수민3");
		stack.push("강수민4");
		stack.push("강수민5");
		stack.push("강수민6");
		stack.push("강수민7");
		
		System.out.println(stack.size() + "//" + stack.isEmpty());
		System.out.println(stack.peek());
		System.out.println(stack.size() + "//" + stack.isEmpty());
		System.out.println(stack.pop());
		System.out.println(stack.size() + "//" + stack.isEmpty());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		
	}
}
