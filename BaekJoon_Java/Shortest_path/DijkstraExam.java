package Shortest_path;

import java.util.LinkedList;
import java.util.List;

public class DijkstraExam {
	public static void mian(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> list = new LinkedList<>();
		for(int i = 1; i<= 10 ; i ++) {
			list.add(i);
		}
		
		list.remove(3);
		list.add(3,3);
		list.remove(Integer.valueOf(3));
		
		System.out.println(list.get(3));
	}

}
