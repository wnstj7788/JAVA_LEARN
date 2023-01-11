import java.util.Scanner;
 
public class BaekJoon_8958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        String arr[] = new String[sc.nextInt()]; //테스트 케이스 만큼 배열 선
 
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.next(); //각 배열에 입력 
        }
        
   
        
        for (int i = 0; i < arr.length; i++) {
            
            int cnt = 0;    // 연속횟수
            int sum = 0;    // 누적 합산 
            
            for (int j = 0; j < arr[i].length(); j++) {
                
                if (arr[i].charAt(j) == 'O') { //i번째 배열의 j번째 요소 O라
                    cnt++; //카운트 
                } 
                else { //X라면 다시 0으로 
                    cnt = 0;
                }
                sum += cnt;
            }
            
            System.out.println(sum);
        }
    }
} 