package inheritance;

public class Test3 {
	public static void main(String[] args) {
		
//		child2 c = new child2("child");
		
		child3 c= new child3();
			
		c.setName("child");
		
		c.m();
		
	}
}



class Parent3{
	//부모에서 setter이용 
	String name = "parent";
	void setName(String name) {
		this.name = name;
	}
	
	Parent3(){} // 명시적 작성 
	Parent3(String name){
		this.name = name; //아래  child(){} 생성자에 오류 발생 Implicit super constructor Parent3() is undefined. Must explicitly invoke another constructor
		//
	}
}
// 컴파일러가 자동으로 처리해주는 것들 
//1. java.lang package 를 자동 import 
//2. 기본 생성자가 없다면 자동으로 만들어줌 
//3. 어떤 클래스가 부모 클래스를 상속 받지 않으면 extends Object를 넣어준다 
//4. 어떤 클래스가 생성자안에서 부모 클래스의 생성자를 명시적으로 호출하지 않으면 자동으로 부모 클래스의 기본 생성자를 호출한다.

class child3 extends Parent3{ 
	// 상속 받은 멤버에 대해서 변경은 가능하지만(달리 없으면)  
	// 더  바람직한 방법은 멤버를 가지고 있는 부모에서 setter 나, 생성자를 이용하고
	//자식은 그것을 이용하는 것 
	String name = "child";
	// 생성자를 통해 바꾸기 
	child3(){
		super(); //자동으로 만들어주는데 부모한테 없으니까 문제가 생기는거임 이를 해결하기 위해서는  부모클래스에 Parent3(){} 디폴트 생성자를 넣어주면 해결 
	}
	child3(String name){
		super(name);
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



//super (객체의 부모)  this ( 객체 자신 )