
import java.util.*;

public class SWEA_1218 {
	public static void main(String[] ags) {
		Scanner sc = new Scanner(System.in);
		for(int t = 1; t <= 10; t++) {
			int tc = sc.nextInt();
			String s = sc.next();
			Stack <Character> st = new Stack();
			int r = 0;
			for(int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				
				if(c == ')' && st.peek() == '(') st.pop();
				else if(c == ']' && st.peek() == '[') st.pop();
				else if(c == '}' && st.peek() == '{') st.pop();
				else if(c == '>' && st.peek() == '<') st.pop();
				else {
					st.push(c);
				}
			}
			if(st.isEmpty()) r = 1;
			else r = 0;
			System.out.println("#" + t + " " + r);
		}
	}
}