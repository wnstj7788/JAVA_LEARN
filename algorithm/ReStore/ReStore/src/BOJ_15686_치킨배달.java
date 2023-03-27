import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.interfaces.DSAPublicKey;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_15686_치킨배달 {

    static LinkedList<Point> chickenHouse; // 치킨 집 저장 리스트
    static LinkedList<Point> house; // 일반 집 저장 리스트
    static int N, M;
    static Boolean isSelected[];
    static int result[];
    static int min = Integer.MAX_VALUE;
    static int map[][];
    static boolean visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        chickenHouse = new LinkedList<>();
        house = new LinkedList<>();
        result = new int[M];
        int cnt = 1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 2) {
                    chickenHouse.add(new Point(i, j));
                }
                if (temp == 1) {
                    house.add(new Point(i, j));
                }
                map[i][j] = temp;
            }
        }
        isSelected = new Boolean[chickenHouse.size()];
        Arrays.fill(isSelected, false);

        comb(0, 0);
        System.out.println(min);


    }


    private static void comb(int cnt, int idx) {
        if (cnt == M) {
            // 현재 치킨집 목표 수 많큼 들어왔으니까 여기서 최소 값을 구해서 비교
            int total = 0; // 도시의 치킨거리
            for(int i = 0; i < house.size(); i++) {
                int sum = Integer.MAX_VALUE;
                for(int j = 0; j < chickenHouse.size(); j++) {
                    if(isSelected[j] == true) { //i번째 집에서부터 j번짜 치킨집 까지의 거리 중 최소값을 구한다.
                        int dist = Math.abs(house.get(i).x - chickenHouse.get(j).x)
                                + Math.abs(house.get(i).y - chickenHouse.get(j).y);
                        sum = Math.min(sum, dist);
                    }
                }
                total += sum;
            }
            min = Math.min(total, min);




            return;
        }

        for (int i = idx; i < chickenHouse.size(); i++) {
            if (isSelected[i] == false) {
                isSelected[i] = true;
                comb(cnt + 1, i + 1);
                isSelected[i] = false;
            }
        }

    }



}






//import java.awt.*;
//        import java.io.BufferedReader;
//        import java.io.IOException;
//        import java.io.InputStreamReader;
//        import java.util.ArrayList;
//        import java.util.StringTokenizer;
//
//public class BOJ_15686_치킨배달 {
//
//    static ArrayList<Point> chickenHouse = new ArrayList<>();
//    static ArrayList<Point> house = new ArrayList<>();
//    static int N, M;
//    static boolean[] selected;
//    static int result[];
//    static int min = Integer.MAX_VALUE;
//    static int map[][];
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//
//        map = new int[N][N];
//
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < N; j++) {
//                int temp = Integer.parseInt(st.nextToken());
//                if (temp == 2) {
//                    chickenHouse.add(new Point(i, j));
//                }
//                if (temp == 1) {
//                    house.add(new Point(i, j));
//                }
//                map[i][j] = temp;
//            }
//        }
//
//        selected = new boolean[chickenHouse.size()];
//        result = new int[M];
//        combination(0, 0);
//        System.out.println(min);
//    }
//
//    private static void combination(int cnt, int start) {
//        if (cnt == M) {
//            min = Math.min(min, calculateDistance());
//            return;
//        }
//
//        for (int i = start; i < chickenHouse.size(); i++) {
//            selected[i] = true;
//            combination(cnt + 1, i + 1);
//            selected[i] = false;
//        }
//    }
//
//    private static int calculateDistance() {
//        int total = 0;
//
//        for (Point h : house) {
//            int minDist = Integer.MAX_VALUE;
//            for (int i = 0; i < chickenHouse.size(); i++) {
//                if (selected[i]) {
//                    int dist = Math.abs(h.x - chickenHouse.get(i).x) + Math.abs(h.y - chickenHouse.get(i).y);
//                    minDist = Math.min(minDist, dist);
//                }
//            }
//            total += minDist;
//        }
//
//        return total;
//    }
//}