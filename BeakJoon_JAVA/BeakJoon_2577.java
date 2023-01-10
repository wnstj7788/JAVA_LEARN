import java.util.Scanner;

public class BeakJoon_2577 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int abc = a*b*c; // 값 곱하기 

        String str = Integer.toString(abc); // int 형을 String형으로 변환 
        for(int i = 0; i < 10; i++) { // 0~9까지 반
            int cnt = 0;
            for(int j = 0; j < str.length(); j++) {
                if((str.charAt(j) - '0') == i) { // 요소를 아스키 값으로 변경하고 숫자 0에 해당하는 값을 빼주어 인트형으로 바꾸고 해당 수가 j와 같다면 카운
                    cnt++;
                }
            }
            System.out.println(cnt); 
        }

    }
}