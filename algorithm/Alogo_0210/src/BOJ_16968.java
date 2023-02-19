import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.zip.InflaterInputStream;

public class BOJ_16968 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char arr[] = br.readLine().toCharArray();
		
		int c = 26;
		int d = 10;
		int sum = 0;
		
		if(arr[0] == 'c') { 
			sum = c;
		}else
			sum = d;
		
		for(int i = 1; i < arr.length; i++ ) { // 1부터 시작하는데 1개 짜리 들어오면 시작도 안함 
			if(arr[i] == 'c') {
				if(arr[i -1] == 'c') {
					sum = sum * (c-1);
				}else {
					sum = sum * c;
				}
			}else {
				if(arr[i -1] == 'd') {
					sum = sum * (d-1);
				}else {
					sum = sum * d;
				}
				
			}
		}
		System.out.println(sum);
	}

}
