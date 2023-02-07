package PriorityQueue;

import java.util.PriorityQueue;

public class compare_priority implements Comparable<compare_priority>{
	
	private int writeRowNumber;
	private String content;
	
	
	public compare_priority(int writeRowNumber, String content) {
		this.writeRowNumber = writeRowNumber;
		this.content = content;
	}
	
	
	@Override
	public int compareTo(compare_priority o) {
		// TODO Auto-generated method stub
		if(this.writeRowNumber > o.getWriteRowNumber()) //this의 우선순위가 더 높음 
			return 1;
		else if (this.writeRowNumber < o.getWriteRowNumber()) // o의 우선순위가 더 높음 
			return -1;
		return 0;
	}
	
	
	public int getWriteRowNumber() {
		return this.writeRowNumber;
	}
	
	
	
	
	public String getContent() {
		return this.content;
	}
	
	
	public static void main(String[] args) {
		PriorityQueue<compare_priority>  priorityQueue = new PriorityQueue<>();
		
		
		// writeRowNumber 넘버를 기준으로 정렬을 하고 싶다.
		//compare_priority 을 통해 우선순위 부여 
		priorityQueue.add(new compare_priority(1000, "천이지롱"));
		priorityQueue.add(new compare_priority(10, "십이지롱"));
		priorityQueue.add(new compare_priority(1, "일이지롱"));
		priorityQueue.add(new compare_priority(100, "백지롱"));
		
		while (!priorityQueue.isEmpty()) {
			compare_priority cp = priorityQueue.poll(); // compare_priority객체 cp에 하나 뺴서 넣어두기 
			System.out.println("넘버 :" + cp.getWriteRowNumber() + "이지롱 : " + cp.getContent());
		}
		
	}

}
