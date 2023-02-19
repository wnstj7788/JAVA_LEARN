
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * 
 * @author THKim
 *
 */
public class IO4_StringBuilderOutputTest {

	static String path = "C:\\Users\\SSAFY\\Desktop\\ssafy_java\\Algo_0206\\src\\input.txt";

	public static void main2(String[] args) throws IOException {

		int TC = 10;

		FileWriter out = new FileWriter(path);
		long start = System.nanoTime();
		out.write(TC + "\n");

		Random r = new Random();
		for (int tc = 0; tc < TC; tc++) {
			int N = 1000;
			out.write(N + "\n");

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					out.write(r.nextInt(10) + " ");
				}
				out.write("\n");
			}
		}
		out.flush();
		long end = System.nanoTime();
		System.out.println((end - start) / 1_000_000_000.0 + "s!");
		out.close();
	}

	public static void main(String[] args) throws IOException {

		int TC = 10;
		

		FileWriter out = new FileWriter(path);
		StringBuilder sb = new StringBuilder();
		long start = System.nanoTime();
		sb.append(TC + "\n");

		Random r = new Random();
		for (int tc = 0; tc < TC; tc++) {
			int N = 1000;
			sb.append(N + "\n");

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(r.nextInt(10) + " ");
				}
				sb.append("\n");
			}
		}
		out.write(sb.toString());
		long end = System.nanoTime();
		System.out.println((end - start) / 1_000_000_000.0 + "s!");
		out.close();
	}

}
