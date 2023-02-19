import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_12891{
	static int S, P;
	static int ans;
	static String DNA;
	static HashMap<Character,int[]> hmap = new HashMap<Character, int[]>();
	static char[] dnas = {'A','C','G','T'};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		DNA = br.readLine();
		st = new StringTokenizer(br.readLine());
        
        
     
		for (char c : dnas) { // 순서대로 A의 현재 사용 횟수 , 최소로 사용되는 조건 입력 
			hmap.put(c, new int[] {0, Integer.parseInt(st.nextToken())});
		}
            
		for (int i = 0; i < P; i++) { //P의 길이만큼 
			hmap.get(DNA.charAt(i))[0]++; // 첫번째 뺀거부터 해쉬맵에 해당하는 key가 있다면 카운트 증ㄱ가
		}
		if(isFull()) ans ++;		
        
        // 인덱스를 1씩 증가시켜가며 가장 왼쪽 문자 삭제 ,가장 오른쪽 문자 추가
        // 카운트를 모두 새로 하는것이 아닌 왼쪽 끝은 -1 오른쪽 끝은 +1한다.
		for (int i = 0; i < S-P; i++) { // 4-2 
			hmap.get(DNA.charAt(i))[0] -= 1;// ex) S 4 P 2 라면 위에 포문에서 이미 첫 2개는 확인
			hmap.get(DNA.charAt(i + P))[0] += 1; // 추가로 더해지는 것을 막기 위해 -- 그 후 진핸되는 3-4번 인덱스는 ++ 
			if(isFull()) ans ++; 
		}
		System.out.println(ans);
		
	}
	public static boolean isFull() {
		for (char c : dnas) {
			if (hmap.get(c)[0] < hmap.get(c)[1]) return false;// 목적 값보다 작다면 실패
		}
		return true; // 목표치까지 사용했다면 ++

	}
}