package PriorityQueue;

import java.util.PriorityQueue;

public class compare_priority implements Comparable<compare_priority>{
	
	private int writeRowNumber;
	private String content;
	
	public compare_priority(int writeRowNumber, String content) {
		this.writeRowNumber = writeRowNumber;
		this.content = content;
	}
	
	
	
	

	public int getWriteRowNumber() {
		return this.writeRowNumber;
	}




	public String getContent() {
		return this.content;
	}




	@Override
	public int compareTo(compare_priority o) {
		// TODO Auto-generated method stub
		if(this.writeRowNumber > o.getWriteRowNumber())
			return 1;
		else if (this.writeRowNumber < o.getWriteRowNumber())
			return -1;
		return 0;
	}
	
	
	public static void main(String[] args) {
		PriorityQueue<compare_priority>  priorityQueue = new PriorityQueue<>();
		
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
