
public class Casting {

	public static void main(String[] args) {
		
		double a = 1.1;
		int b = 1;
		double c = 1;
		System.out.println(c); // 1.0 인트형 -> 버블형으로 바뀜 손실 없음 손실이 없기에 자동 캐스팅 
		
		//int d = 1.1 //  오류 더블형에서 -> 인트형 불가 =>  손실이 존재 
		double d = 1.1;
		int e = (int) 1.1; // 1
		System.out.println(e); //1.1 을 강제로 인트형으로 변경 -> 손실 발생 -> 손실이 발생할 때는 명시적 캐스팅 
		
		//1 to String 
		//String f = 1;
		String f = Integer.toString(1); // int to String 
		System.out.println(f.getClass()); // 데터 타입 확인 
	}

}
