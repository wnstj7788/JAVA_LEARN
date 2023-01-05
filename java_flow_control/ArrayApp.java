
public class ArrayApp {

	public static void main(String[] args) {
		
		//egoing, jinhuck, youbin 
		
		String[] users = new String[3];
		users[0] = "egoing";
		users[1] = "jinhuck";
		users[2] = "youbin";
		
		System.out.println(users[1]);
		System.out.println(users.length);
		
		int[] scores1 = new int[3]; // 빈 배열 만들기 
		int[] scores = {10,100,100}; //만들면서 값 넣어주기 
		System.out.println(scores[1]);
		System.out.println(scores.length);
	}

}
