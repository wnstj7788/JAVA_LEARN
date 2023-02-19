import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_1228 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			ArrayList mylist = new ArrayList();
			StringTokenizer st;
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				mylist.add(Integer.parseInt(st.nextToken()));

			}
			int k = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < k; i++) {
				String temp = st.nextToken();
				int position = Integer.parseInt(st.nextToken());
				int loop = Integer.parseInt(st.nextToken());
				for (int j = position; j < position + loop; j++) {
					mylist.add(j, Integer.parseInt(st.nextToken()));
					
				}
				
			}
			System.out.print("#" + tc +" ");
			for (int i = 0; i < 10; i++) {
				System.out.print(mylist.get(i) + " ");
		}
		
		}
	}
}
