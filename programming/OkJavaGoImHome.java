import org.opentutorials.iot.Elevator;
import org.opentutorials.iot.Lighting;
import org.opentutorials.iot.Security;
//아래 모듈을 불러오기 위해 임포트 

public class OkJavaGoImHome{

	public static void main(String[] args) {
		
		String id = "JAVA APT 507";
		//Elevator call
		Elevator myElevator = new Elevator(id);  // Elevator -> 데이터 타입, myElvator -> 변수명, 
		myElevator.callForUp(1);
		
		//Security off
		Security mySecurity = new Security(id);
		mySecurity.off(); // 괄호로 시작해서 괄호로 끝나느 명령  -> 메소드 
		
		
		// Light On
		Lighting hallLamp = new Lighting(id + "/ Hall Lamp");
		hallLamp.on();
		
		Lighting floorLamp = new Lighting(id + " / floor Lamp");
		floorLamp.on();
		

	}

}
