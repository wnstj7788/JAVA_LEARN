package LIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_14003_가장긴증가하는부분수열 {

    static int N;
    static int[] A;
    static int[] dp;
    static ArrayList<Integer> listForSize;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        dp = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken()); // 배열에 넣어주기
        }

        listForSize = new ArrayList<>();
        listForSize.add(Integer.MIN_VALUE); // 첫 칸에 가장 작은 값을 넣어줌

        for(int i = 0; i< N; i++){
            if(listForSize.get(listForSize.size() -1) < A[i]){
                //현재 리스트 사이즈 -1한 값이 A 의 값보다 작다면?
                listForSize.add(A[i]);
                // 현재 A 값을 배열에 넣어줌
                dp[i] = listForSize.size() -1;
                // dp 배열에 현재 인덱스를 삽입
            }else{
                // 현재 리스트 사이즈 -1한 값이 같거나 크다면?
                int index = binarySearch(1,listForSize.size()-1,A[i]);
                // 내가 들어갈 부분 확인해버려
                listForSize.set(index,A[i]);
                // 현재 인덱스의 값을 변경해
                dp[i] = index; // 값을 삽입한 부분의 값을 넣어줌
            }
        }

        int LISLength = listForSize.size() -1;
        //LIS 의 사이즈
        System.out.println(LISLength);
        result(LISLength);
        System.out.println(sb);


    }

    private static int binarySearch(int left, int right, int target){
        while(left < right){
            int mid = (left + right) /2;
            if(target > listForSize.get(mid)){
                left = mid +1;
            }else right = mid;
        }
        return left; // 2진 탐색의 low값을 던저줌
    }

    private static void result(int size){
        Stack<Integer> stack = new Stack<>();
        int index = size;

        for(int i = N -1; i >= 0 ; i--){
            if(dp[i] == index){
                stack.push(A[i]);
                index--;
            }
        }
       sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop() + " ");
        }


    }


}
