package inheritance;

public class Test1 {
	public static void main(String[] args) {
		
		child1 c = new child1();
		
		c.m();
		
	}
}


class Parent1{
	String name = "parent";
}


class child1 extends Parent1{ //상속받아 출력하기 
	//자신만의 이름만들기
	String name = "child"; // 오버라이딩 이 부분을  주석 처리하면 아래 네임에 전부 Paren출력 
	
	void m() {
		System.out.println(name);
	 System.out.println(this.name);
	 System.out.println(super.name); //부모의 이름을 가져
	}
}



//super (객체의 부모)  this ( 객체 자신 )
//부모로부터 상속받은 것으 ㄴ내것도 되고(단, 같은 내것이 ㅇ벗을 때), 부모것도 되고
// 부모에 없는 내것은 되지만 부모것은 x