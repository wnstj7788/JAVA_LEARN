import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



/*
1. 연속 m개 벌통 선택 (가로) : 두 일꾼 선택이 겹치면 안된다
=> 조합
2. 연속 M개 중에 최대양 c를 넘지 않는 벌통 선택
=> 부분 집합의 합

- 위 두개의 순서르 바꾸고한다면?> 가능한 위치만 비교가 가능함
가능한 위치의 첫번째 자리에  얻을 수 있는 최대의 값을 저장해두는 배열을 만들어둠

시간 복잡도 따지기
부분 집합 만드는 시간
N = 10 , N = 5
M이 줄어들면 : 부분집합 경우의 수 줄어듬
M이 커지면 : 부분집합 경우의 수 늘어남
2^5
조합을 따시지는 시간
M이 줄어들면 : 조합의 경우의 수 늘어남
M이 커지면 : 조합의 경우의 수 줄어듬
60C2


2가지 작업을 나눠서 만들기
일꾼 A가 선택한 행 or 동일행의 경우 뒤쪽에서 부터 확인
다른행의 경우 앞쪽부터 뒤쪽까지 쭉 확인
 */


public class SWEA_2115_벌꿀_교수님버전 {
    static int N,M,C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());



    }
}
