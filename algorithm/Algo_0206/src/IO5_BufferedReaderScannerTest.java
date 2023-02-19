
import java.io.*;
import java.util.*;

/**
 * 
 * @author THKim
 *
 */
public class IO5_BufferedReaderScannerTest {

	static String path = "C:\\Users\\SSAFY\\Desktop\\ssafy_java\\Algo_0206\\src\\input.txt";
	public static void main2(String[] args) throws IOException {

		System.setIn(new FileInputStream(path));
		Scanner sc = new Scanner(System.in);

		long start = System.nanoTime();
		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			int N = sc.nextInt();
			int sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sum += sc.nextInt();
				}
			}
			System.out.println("#" + tc + " " + sum);
		}
		long end = System.nanoTime();
		System.out.println((end - start) / 1_000_000_000.0 + "s");
	} 
	
	
	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream(path));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long start = System.nanoTime();
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			int sum = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					
					
					sum += Integer.parseInt(st.nextToken());
				}
			}
			System.out.println("#" + tc + " " + sum);
		}
		long end = System.nanoTime();
		System.out.println((end - start) / 1_000_000_000.0 + "s");
	} 


	
}
