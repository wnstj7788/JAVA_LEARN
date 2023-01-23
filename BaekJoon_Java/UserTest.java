class User {
	//접근제한자를 이용하여 접근을 막음 
	private String name = "공돌이";
	private int money = 10000;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}	
}

public class UserTest {
	public static void main(String[] args) {
		User u = new User();
//		System.out.println(u.name);
//		System.out.println(u.money);
		//getter를 통해서만 User 클래스의 요소 접근 가능 
		System.out.println(u.getName());
		System.out.println(u.getMoney());
		
//		u.name = "문돌이로 바꿔야지";
//		u.money = 300;
		
		//setter를 통해 값을 변경  
		u.setMoney(300);
		System.out.println(u.getMoney());
		
//		
//		System.out.println(u.name);
//		System.out.println(u.money);
	}

}
