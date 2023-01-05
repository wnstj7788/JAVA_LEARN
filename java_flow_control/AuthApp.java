
public class AuthApp {

	public static void main(String[] args) {
		
		System.out.println(args[0]);
		String id = "egoing";
		String inputId = args[0];
		
		String pass = "1111";
		String inputPass = args[1];
		
		
		//if (id == inputId) {
		if(inputId.equals(id)) {
			System.out.println("Hi Master");
		} else {
			System.out.println("Who are you?");
		}
		
		

	}

}
