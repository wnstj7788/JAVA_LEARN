import java.util.Scanner;

public class BOJ_1517 {
	static long cnt = 0;
    static int[] arr;
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	int n = sc.nextInt();

        arr = new int[n];
        for(int i =0; i < n ; i++) {
        	arr[i] = sc.nextInt();
        }
        sort(0, n-1);
        System.out.println(cnt);
    }
    	

    private static void sort( int low, int high) {

        if (high - low < 1) //나눠진 부분집합의 크기가 1보다 작으면 리턴
            return;

        int mid = (low + high) / 2;

        //데이터를 2개로 분할
        sort(low, mid);
        sort(mid+1, high);

        //분할된 데이터 합병
        merge(low, mid, high);
    }

    private static void merge( int low, int mid, int high) {

        int[] temp = new int[high - low+1]; //정렬된 데이터를 담아둘 임시 배열
        int t = 0, l = low, h = mid+1;

        //두 그룹을 병합
        while (l <= mid && h <= high) {
            if (arr[l] <= arr[h]) {
                temp[t++] = arr[l++];
               
            } else {
                temp[t++] = arr[h++];
                cnt += (mid - l) + 1;
            }
        }

        //한쪽 그룹이 모두 선택된 후 남아 있는 값 정리
        while (l <= mid) {
            temp[t++] = arr[l++];
        }

        while (h <= high) {
            temp[t++] = arr[h++];
        }

        //임시 배열을 원배열에 복사
        for (int i = low; i <= high; i++) {
            arr[i] = temp[i-low];
        }
    }


}