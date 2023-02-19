public class ancalss {

	Object iv = new Object() { //조상이름으로 익명 클래스 생성 
		void method() {}//클래스 내용 
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