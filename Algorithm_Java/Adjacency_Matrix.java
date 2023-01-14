import java.util.*;

public class Adjacency_Matrix {

    public static final int INF = 999999999;
    //final 이 변수는 수정할 수 없음을 의미한다. 
    
    // 2차원 리스트를 이용해 인접 행렬 표현
    public static int[][] graph = {
        {0, 7, 5},
        {7, 0, INF},
        {5, INF, 0}
    };

    public static void main(String[] args) {
        // 그래프 출력
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

}