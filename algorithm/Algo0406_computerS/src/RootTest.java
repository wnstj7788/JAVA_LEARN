
public class RootTest {

	public static void main(String[] args) {
		double a=5;
		while(true) {
			if(Math.abs(a-5.0/a)>10E-15) {
				a=(a+5.0/a)/2.0;
			}else {
				break;
			}
		}
		System.out.println(a);
		System.out.println(Math.sqrt(5));
	}

}
