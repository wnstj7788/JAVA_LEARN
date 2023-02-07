
public class anonymousCalss {
	//문법은 new 조상 클래스 이름(){} or new 구현 인터페이스 이름(){}
	Object iv = new Object() {
		void method() {}
	};
	
	static Object cv = new Object() {
		void method() {}
	};
	
	void myMethod() {
		Object lv = new Object() {
			void method() {}
		};
	}
	
}
