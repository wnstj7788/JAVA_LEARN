//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.StringTokenizer;
//
//public class BOJ_12891_DNA비밀번호 {
//	
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		int S = Integer.parseInt(st.nextToken());
//		int P = Integer.parseInt(st.nextToken());
//		int result = 0;
//		
//		
//		char []DNA = new char[S];
//		
//		String temp = br.readLine();
//		
//		DNA = temp.toCharArray();
//		
//		int rotate = S - P; // 슬라이드 할 길이
//		int idx = 0;
//		
//		//맵 채우기 
//		Map<Character, Integer> map = new HashMap<>();
//		st = new StringTokenizer(br.readLine());
//		map.put('A', Integer.parseInt(st.nextToken()));
//		map.put('C', Integer.parseInt(st.nextToken()));
//		map.put('G', Integer.parseInt(st.nextToken()));
//		map.put('T', Integer.parseInt(st.nextToken()));
//		
//		
//		for (int i = 0; i < rotate; i++) {
//			Map<Character, Integer> copymap = new HashMap<>();
//			copymap.putAll(map);
//			for (int j = idx; j <= idx + P; j++) {
////				System.out.println("들어온 문자열 " + DNA[j] );
//				if(DNA[j] == 'A') {
//					copymap.put('A', map.get('A') -1);
//					
//				}else if(DNA[j] == 'C') {
//					copymap.put('C', map.get('C') -1);
//					
//				}else if(DNA[j] == 'G') {
//					copymap.put('G', map.get('G') -1);
//					
//				}else if(DNA[j] == 'T') {
//					copymap.put('T', map.get('T') -1);
//					
//				}else {
//					break;
//				}
//				
//			}
////			for(int value : copymap.values()) {
////				System.out.print(value + "-> ");
////			}
//			idx++;
//			int okay =0;
//			for(int value : copymap.values()) {
//				if(value < 1) {
//					okay ++;
//				}
//			}
//			
//			if(okay ==4) {
//				result++;
//			}
//			
//			
//		}// 모든 로테이트 끝 
//		
//		System.out.println(result);
//	}
//
//}





import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_12891_DNA비밀번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String DNA = br.readLine();
        Map<Character, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        map.put('A', Integer.parseInt(st.nextToken()));
        map.put('C', Integer.parseInt(st.nextToken()));
        map.put('G', Integer.parseInt(st.nextToken()));
        map.put('T', Integer.parseInt(st.nextToken()));

        int count = 0;
        for (int i = 0; i <= S - P; i++) {
            Map<Character, Integer> freq = new HashMap<>();
            for (int j = i; j < i + P; j++) {
                char c = DNA.charAt(j);
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }
            boolean valid = true;
            for (char c : map.keySet()) {
                if (freq.getOrDefault(c, 0) < map.get(c)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                count++;
            }
        }

        System.out.println(count);
    }
}
