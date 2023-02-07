class B extends A {
	public B(String str) {
		System.out.println("B " + str);
	}
}

class A {
	public A() {
		System.out.println("기본생성자");
	}

	public A(String str) {
		System.out.println("A " + str);
	}
}

public class test {
	public static void main(String args[]) {
		B b = new B("hi");
	}
}