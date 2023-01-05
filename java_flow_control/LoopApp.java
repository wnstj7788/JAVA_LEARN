public class LoopApp {

	public static void main(String[] args) {
		System.out.println(1);
		System.out.println("====while=========");
		int i = 0; 
		
		while(i < 3) {
			System.out.println(2);
			System.out.println(3);
			i += 1;
			// i = i + 1;
			//i++;
		}
		System.out.println("=======for ======");
		// 초기값, 조건값, 변화 j 제일 먼저 딱 1번 실행 j확인, j ++ 확인 ->j -> j++ 
		for(int j = 0; j < 3; j ++) {
			System.out.println(2);
			System.out.println(3);
		}
		System.out.println(4);
		

	}

}
