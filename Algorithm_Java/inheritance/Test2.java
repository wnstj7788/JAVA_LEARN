package inheritance;

public class Test2 {
	public static void main(String[] args) {
		
//		child2 c = new child2("child");
		
		child2 c= new child2();
			
		c.setName("child");
		
		c.m();
		
	}
}



class Parent2{
	String name = "parent";
}


class child2 extends Parent1{ //상속받아 출력하기 
	//자신만의 이름만들기
	String name = "child"; // 오버라이
	// 생성자를 통해 바꾸기 
	child2(){}
	child2(String name){
		super.name = name;
	}
	
	
	//setter를 통해서 변경하기 
	
	void setName(String name) {
		super.name = name;
	}
	
	void m() {
		System.out.println(name);
	 System.out.println(this.name);
	 System.out.println(super.name);
	}
}



//부모로 부터 상속받은 멤버들은 변경하고할ㄱ 경우 생성자나. setter를 이용하여 변경한다.  

// 이미 부모가 가지고 있는 멤버를 다시 만들지 않는다. 