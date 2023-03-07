import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.interfaces.DSAPublicKey;
import java.sql.SQLOutput;
import java.util.*;

public class SWEA_5658_보물상자비밀번호 {
    static Queue<Character> q;
    static LinkedList<Character> numlist = new LinkedList<>();


    static int N,K, cutSize;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC ; tc++) {
            q = new LinkedList<>();
            set = new HashSet<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            cutSize = N / 4;
            String temp = br.readLine();
            for (int i = 0; i < temp.length(); i++) {
                q.add(temp.charAt(i));
            }

            rotate();

            String result[] = set.toArray(new String[0]);

            Arrays.sort(result, new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    return  Integer.parseInt(s2,16) -  Integer.parseInt(s1,16);
                    //return s1.length() - s2.length();
                }
            });

           // System.out.println(Arrays.toString(result));
            System.out.println("#" + tc + " " + Integer.parseInt(result[K-1], 16));

            //System.out.println(result[K - 1]);
        }

    }

    private static void rotate() {
        int cnt = 0;
       while(true) {
            if(cnt == N ){
                break;
            }

           char temp = q.poll();
            for (int x = 0; x < N -1 ; x++) {
                numlist.add(q.poll());
            }

            numlist.add(temp);



            String a = "";
            for (int i = 0; i < cutSize; i++) {
                a += numlist.get(i);
            }
            set.add(a);

           //System.out.println(numlist.size());
            for (int i = 0; i < numlist.size(); i++) {
                q.add(numlist.get(i));
            }
            numlist.clear();
            cnt ++;

        }
    }

}
