import javax.swing.JOptionPane;

import org.opentutorials.iot.DimmingLights;
import org.opentutorials.iot.Elevator;
import org.opentutorials.iot.Lighting;
import org.opentutorials.iot.Security;
//아래 모듈을 불러오기 위해 임포트 

public class OkJavaGoImHomeInput {

	public static void main(String[] args) { //args도 변수 -> 사용하는 사람과 프로그램을 매개해줘 매개변수 -> 파라미터 , String으로 이루어진 [] 배열 
		
		String id = args[0];
		String bright = args[1]; // 실행 - ㅡ> 런 속성 -> 아규먼트에 들어가 있는 배열이 args안에 배열로 저장되며 속성을 호출함 
		
		//String id = JOptionPane.showInputDialog("enter a Id"); // 팝업 뛰어서 인풋받기 
		//String bright = JOptionPane.showInputDialog("enter a bright");
		
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
		
		DimmingLights moodLamp = new DimmingLights(id+ " / moodLamp");
		moodLamp.setBright(Double.parseDouble(bright)); // String to Double 
		moodLamp.on();
		

	}

}
