import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493_탑 {
    static int N;
    static Stack<int[]> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         N =Integer.parseInt(br.readLine());
         stack = new Stack<>();
        StringTokenizer st = new StringTokenizer((br.readLine()));
        for (int i = 1; i <= N; i++) {
            int top = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty()){
                if(stack.peek()[1] >= top){
                    System.out.print(stack.peek()[0] +" ");
                    break;
                }
                stack.pop();

            }
            if(stack.isEmpty()) {
                System.out.print(0 + " ");}

            stack.push(new int[]{i, top});


        }



    }


}





