import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ_1541_괄호 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int result = Integer.MAX_VALUE;

        String[] temp = sc.nextLine().split("-");

        for (int i = 0; i <temp.length; i++) {
            int sum = 0;

            String[] add = temp[i].split("\\+");

            for (int j = 0; j < add.length; j++) {
                sum += Integer.parseInt(add[j]);
            }
                if(result == Integer.MAX_VALUE){
                    result= sum;
                }else{
                    result -= sum;
                }


        }
        System.out.println(result);

    }
}
