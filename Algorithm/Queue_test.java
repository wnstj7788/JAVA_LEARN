import java.util.LinkedList; //두가지 인포트 되어있어야 사용가
import java.util.Queue;

public class Queue_test {
	public static void main(String[] args) {
		
		Queue<Integer> queue = new LinkedList<>(); //int형 배열 선언 
		Queue<String> queue1 = new LinkedList<>(); //String형 배열 선언 
		
		queue.offer(5);
		queue.add(2);
		queue.offer(3);
		queue.offer(7);
		queue.remove();
		queue.offer(1);
		queue.offer(4);
		queue.remove();
		System.out.println(queue);
	} 
}
