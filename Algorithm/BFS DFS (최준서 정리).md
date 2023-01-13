# BFS / DFS (최준서 정리)

# 1. 자료구조 기초

### 1. 탐색(Search)

- 많은 양의 데이터 중(그래프,트리 등의 자료구조)에서 원하는 데이터를 찾는 과정 의미
→ 대표적인 탐색 알고리즘으로  DFS/BFS가 있다.
→ DFS/BFS는 기본 자료구조인 스택과 큐를 사용한다.

### 2. 자료구조(Data Structure)

- 데이터를 표현하고 관리하고 처리하기 위한 구조를 의미 
→ Pop(데이터 삭제)
→ Push(데이터 삽입)
- 실제 개발에서는 오버플로우(데이터 크기가 가득 찬 상태에서), 언더플로우(아무것도 없는데 삭제)를 생각해야하는 개념이다

### 2-1. 스택

- 아래에서부터 위로 차곡차곡 쌓아올리는 방식 (선입후출, 후입선출) → FILO → LIFO
    
    ![Untitled](BFS%20DFS%20(%E1%84%8E%E1%85%AC%E1%84%8C%E1%85%AE%E1%86%AB%E1%84%89%E1%85%A5%20%E1%84%8C%E1%85%A5%E1%86%BC%E1%84%85%E1%85%B5)%209bf349a7159f48b78292b49b4621ca8f/Untitled.png)
    
    ![Untitled](BFS%20DFS%20(%E1%84%8E%E1%85%AC%E1%84%8C%E1%85%AE%E1%86%AB%E1%84%89%E1%85%A5%20%E1%84%8C%E1%85%A5%E1%86%BC%E1%84%85%E1%85%B5)%209bf349a7159f48b78292b49b4621ca8f/Untitled%201.png)
    
    ### Stack 예시코드
    
    ```java
    import java.util.Stack;
    
    public class Stack_tesst {
    
    	public static void main(String[] args) {
    		// TODO Auto-generated method stub
    		Stack<Integer> stack = new Stack<>(); // int형 스택 선언
    		Stack<String> stack1 = new Stack<>(); // String형 스택 선언
    
    		// 5 2 3 7 (7삭제) 1 4 (4삭제)
    		stack.push(5); // 스택에 5값 추가
    		stack.push(2); // 스택에 2값 추가
    		stack.push(3); // 스택에 3값 추가
    		stack.push(7); // 스택에 7값 추가
    		stack.pop();
    		stack.push(1); // 스택에 1값 추가
    		stack.push(4); // 스택에 4값 추가
    		stack.pop();
    		
    		stack1.push("banana");
    		stack1.push("apple");
    		stack1.push("orange");
    		stack1.pop();
    
    		System.out.println(stack);
    		System.out.println(stack1);
    	}
    }
    
    결과 : [5,2,3,1]
    			[banana,apple]
    ```
    

### 2-2 큐

- 공정한 자료구조 → 대기줄과 비슷함
- 먼저 들어온 사람이 먼저 나가는구조를 가짐 → 선입선출 → FIFO

![Untitled](BFS%20DFS%20(%E1%84%8E%E1%85%AC%E1%84%8C%E1%85%AE%E1%86%AB%E1%84%89%E1%85%A5%20%E1%84%8C%E1%85%A5%E1%86%BC%E1%84%85%E1%85%B5)%209bf349a7159f48b78292b49b4621ca8f/Untitled%202.png)

## Queue 명령어

- Queue값 삽입
    
    **1. add()**
    
    - **해당 큐 맨 뒤에 값 삽입**
    - **값 추가 성공 시 true 반환**
    - **큐가 꽉 찬 경우 IllegalStateException 에러 발생**
    
    **2. offer()**
    
    - **해당 큐 맨 뒤에 값 삽입**
    - **값 추가 성공 시 true 반환**
    - **값 추가 실패 시 false 반환**

- Queue값 제거
    1. **remove()**
        - **큐 맨 앞에 있는 값 반환 후 삭제**
        - **큐가 비어 있는 경우 NoSuchElementException 에러 발생**
    
    **2. poll()**
    
    - **큐 맨 앞에 있는 값 반환 후 삭제**
    - **큐가 비어있을 경우 null 반환**
    
    **3. clear()**
    
    - **큐 비우기**

- Queue값  맨 앞 값 확인

**1. element()**

- **큐의 맨 앞에 있는 값 반환**
- **큐가 비어 있는 경우 NoSuchElementException 에러 발생**

**2. peek()**

- **큐의 맨 앞에 있는 값 반환**
- **비어있을 경우 null 반환**

```java
import java.util.LinkedList; //두가지 인포트 되어있어야 사용가
import java.util.Queue;

public class Queue_test {
	public static void main(String[] args) {
		
		Queue<Integer> queue = new LinkedList<>(); //int형 배열 선언 
		Queue<String> queue1 = new LinkedList<>(); //String형 배열 선언 
		
		queue.offer(5);
		queue.add(2);
		queue.offer(3);
		queue.offer(7);
		queue.remove();
		queue.offer(1);
		queue.offer(4);
		queue.remove();
		System.out.println(queue);
	}
}
결과: [3, 7, 1, 4]
```

### 3. 재귀함수

- DFS/BFS 구현을 위해 이해하고 있어야한다 → 자기 자신을 다시 호출하는 함수
- 대표적인 예시로 프랙털 구조, 피보나치, 팩토리얼이 존재
- 재귀 함수를 사용하기 위해서는 반드시 종료조건을 명시해야한다!
- 재귀 함수는 내부적으로 스택 자료구조를 이용한다 ( 가장 마지막에 호출한 함수가 먼저 수행을 끝내야 앞의 함수 호출이 종료되기 때문) DFS에서 많이 활용된다.
    - 코드가 간결해진다는 장점이 있음 (수학의 재귀식{점화식}을 그대로 소스코드로 옮기기 떄문)
- 피보나치 :

![Untitled](BFS%20DFS%20(%E1%84%8E%E1%85%AC%E1%84%8C%E1%85%AE%E1%86%AB%E1%84%89%E1%85%A5%20%E1%84%8C%E1%85%A5%E1%86%BC%E1%84%85%E1%85%B5)%209bf349a7159f48b78292b49b4621ca8f/Untitled%203.png)

```jsx

public class Fibonacci {

	

	public static void main(String[] args) {

		int input = 8; // 8개 출력

		

		for (int i = 1; i <= input; i++) {

			System.out.println(fibo(i));

		}

	}

	public static int fibo(int n) {

		if (n <= 1) //종료조건 명시 

			return n;

		else 

                        return fibo(n-2) + fibo(n-1);

	}

}
```

# 2. 탐색 알고리즘 DFS / BFS

## 2-1.  DFS ( Depth-First Seach) = 깊이 우선 탐색

- 그래프에서 깊은 부분을 우선적으로 탐색하는 알고리즘
- 그래프의 핵심은 노드와 간선을 이해하는 것 
→ 두 노드가 간선으로 연결되어 있다. = 두 노드는 인접하다

![Untitled](BFS%20DFS%20(%E1%84%8E%E1%85%AC%E1%84%8C%E1%85%AE%E1%86%AB%E1%84%89%E1%85%A5%20%E1%84%8C%E1%85%A5%E1%86%BC%E1%84%85%E1%85%B5)%209bf349a7159f48b78292b49b4621ca8f/Untitled%204.png)

### 프로그래밍에서 그래프는 크게 2가지 방식으로 표현

1. 인접 행렬(Adiacency Matrix) : 2차원 배열로 그래프의 연결관계를 표현하는 방식 
-  노드가 연결된 형채를 기록하는 방식
-  연결이 되어 있지 않은 노드끼리는 무한의 비용이라 작성 ( 아래와 같이 0으로 표현하지 않음)
- 인접하다면 데이터를 초기화 
    
    ![Untitled](BFS%20DFS%20(%E1%84%8E%E1%85%AC%E1%84%8C%E1%85%AE%E1%86%AB%E1%84%89%E1%85%A5%20%E1%84%8C%E1%85%A5%E1%86%BC%E1%84%85%E1%85%B5)%209bf349a7159f48b78292b49b4621ca8f/Untitled%205.png)
    

```java
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

실행결과 : 0 7 5 
				7 0 999999999 
				5 999999999 0
```

1. 인접 리스트(Adiacency List) : 리스트로 그래프의 연결관계를 표현하는 방식  
- 모든 노드에 연결된 노드에 대한 정보를 차례대로 연결하여 저장 

```java
import java.util.*;

class Node {
//this 쓰는 이유는 메소드와 필드 사이에 같은 이름의 변수가 존재하더라도 구분할 수 있어 사용 
    private int index; //필드의 index
    private int distance; 

    public Node(int index, int distance) {
        this.index = index; //메소드 속의 index
        this.distance = distance;
    }

    public void show() {
        System.out.print("(" + this.index + "," + this.distance + ") ");
    }
}

public class Adjacency_List {

    // 행(Row)이 3개인 인접 리스트 표현
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

    public static void main(String[] args) {
        // 그래프 초기화
        for (int i = 0; i < 3; i++) {
            graph.add(new ArrayList<Node>());
        }

        // 노드 0에 연결된 노드 정보 저장 (노드, 거리)
        graph.get(0).add(new Node(1, 7));
        graph.get(0).add(new Node(2, 5));

        // 노드 1에 연결된 노드 정보 저장 (노드, 거리)
        graph.get(1).add(new Node(0, 7));

        // 노드 2에 연결된 노드 정보 저장 (노드, 거리)
        graph.get(2).add(new Node(0, 5));

        // 그래프 출력
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                graph.get(i).get(j).show();
            }
            System.out.println();
        }
    }

}

결과:  (1,7) (2,5) 
			(0,7) 
			(0,5)
```

### 두 방식의 차이점

- 메모리 측면에서 본다면 인접 행렬 방식은 모든 관계를 표시해야기 때문에 불필요한 메모리를 소비한다.
- 인접 리스트 방식은 연결된 정보만 저장하기 때문에 메모리 측면에서는 유리하게 사용할 수 있다.
→ 하지만, 특정 노드끼리 연결되어 있는지 확인해야할 때는 연산이 필요하여 오래걸린다.
- 특정 노드와 연결된 모든 인접 노드를 순회해야하는 경우 인접리스트 방식이 유리함

### 언제 사용하나요?
⇒ 특정한 경로를 탐색하다가 특정한 상황에서 최대한 깊숙이 들어가서 노드를 방문한 후, 다시 돌아가 다른 경로를 탐색해야할 때

동작 과정

1. 탐색 시작 노드를 스택에 삽입하고 방문처리 (스택에 한 번 삽입되어 처리도니 노드가 다시 삽입되지 않게 체크하는 것)
2. 스택의 최상단 노드에 방문하지 않은 인접 노드가 있으면 그 인접 노드를 스택에 넣고 방문처리, 인접 노드가 없다면 스택에서 최상단 노드 꺼냄
3. 2번 과정 수행할 수 없을 때까지 무한반복 
    - 데이터의 개수가 N인 경우 O(N) 시간 소요
- 동작과정 이미지 및 코드
    - **[Step 0]** 그래프를 준비한다 (**방문 기준: 번호가 낮은 인접 노드 부터**)
        - 시작 노드: 1
    
    ![https://blog.kakaocdn.net/dn/GAxqb/btqJ6dAYOOz/p3ysI6YO2vKBtydazxsHW1/img.png](https://blog.kakaocdn.net/dn/GAxqb/btqJ6dAYOOz/p3ysI6YO2vKBtydazxsHW1/img.png)
    
    - **[Step 1]** 시작 노드인 '1'을 스택에 삽입하고 방문 처리 한다
    
    ![https://blog.kakaocdn.net/dn/VJVxF/btqJ4HCmJ5l/pwWKCcQB3Akn6186o3VWXk/img.png](https://blog.kakaocdn.net/dn/VJVxF/btqJ4HCmJ5l/pwWKCcQB3Akn6186o3VWXk/img.png)
    
    - **[Step 2]** 스택의 최상단 노드인 '1'에 방문하지 않은 인접 노드 '2', '3', '8'이 있다
        - 이 중에서 가장 작은 노드인 '2'를 스택에 넣고 방문 처리를 한다
    
    ![https://blog.kakaocdn.net/dn/oJ4ex/btqJWRNcBZm/mXHsEc5wVRNfbFVIYOMxw1/img.png](https://blog.kakaocdn.net/dn/oJ4ex/btqJWRNcBZm/mXHsEc5wVRNfbFVIYOMxw1/img.png)
    
    - **[Step 3]** 스택의 최상단 노드인 '2'에 방문하지 않은 인접 노드 '7'이 있다
        - 따라서 '7'번 노드를 스택에 넣고 방문 처리를 한다
    
    ![https://blog.kakaocdn.net/dn/mo5iW/btqJWRNcB1w/H1GLVZUl837r4okMVDHZj0/img.png](https://blog.kakaocdn.net/dn/mo5iW/btqJWRNcB1w/H1GLVZUl837r4okMVDHZj0/img.png)
    
    - **[Step 4]** 스택의 최상단 노드인 '7'에 방문하지 않은 인접 노드 '6', '8'이 있다
        - 이 중에서 가장 작은 노드인 '6'을 스택에 넣고 방문 처리를 한다
    
    ![https://blog.kakaocdn.net/dn/cv2RBz/btqJ3hcOqeI/N0RUrpScWG5whJjymGOsL1/img.png](https://blog.kakaocdn.net/dn/cv2RBz/btqJ3hcOqeI/N0RUrpScWG5whJjymGOsL1/img.png)
    
    - **[Step 5]** 스택의 최상단 노드인 '6'에 방문하지 않은 인접 노드가 없다
        - 따라서 스택에서 '6'번 노드를 꺼낸다
    
    ![https://blog.kakaocdn.net/dn/b910J3/btqJ0oQ5VLP/SEHo4XvRsUCzK3oPLkzdlk/img.png](https://blog.kakaocdn.net/dn/b910J3/btqJ0oQ5VLP/SEHo4XvRsUCzK3oPLkzdlk/img.png)
    
    - **[Step 6]** 스택의 최상단 노드인 '7'에 방문하지 않은 인접 노드 '8'이 있다
        - 따라서 '8'번 노드를 스택에 넣고 방문 처리를 한다
    
    ![https://blog.kakaocdn.net/dn/l2ML8/btqJ8gxr1Qe/mgvbwo0GKlAkKGhaeKtxR1/img.png](https://blog.kakaocdn.net/dn/l2ML8/btqJ8gxr1Qe/mgvbwo0GKlAkKGhaeKtxR1/img.png)
    
    - 이러한 과정을 반복하였을 때 전체 노드의 탐색 순서(스택에 들어간 순서)는 다음과 같다
    
    ![https://blog.kakaocdn.net/dn/IWkqk/btqJ8fL8XOw/RxpE0vlH9kU2viCAFOFBQ0/img.png](https://blog.kakaocdn.net/dn/IWkqk/btqJ8fL8XOw/RxpE0vlH9kU2viCAFOFBQ0/img.png)
    
    ```java
    import java.util.*;
    
    public class DFS {
    
        public static boolean[] visited = new boolean[9];
        public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    
        // DFS 함수 정의
        public static void dfs(int x) {
            // 현재 노드를 방문 처리
            visited[x] = true;
            System.out.print(x + " ");
            // 현재 노드와 연결된 다른 노드를 재귀적으로 방문
            for (int i = 0; i < graph.get(x).size(); i++) { //get -> 해당 번지의 값을 가져오는 명령어 
                int y = graph.get(x).get(i);
                if (!visited[y]) dfs(y);
            }
        }
    
        public static void main(String[] args) {
            // 그래프 초기화
            for (int i = 0; i < 9; i++) {
                graph.add(new ArrayList<Integer>());
            }
    
            // 노드 1에 연결된 노드 정보 저장 
            graph.get(1).add(2);
            graph.get(1).add(3);
            graph.get(1).add(8);
            
            // 노드 2에 연결된 노드 정보 저장 
            graph.get(2).add(1);
            graph.get(2).add(7);
            
            // 노드 3에 연결된 노드 정보 저장 
            graph.get(3).add(1);
            graph.get(3).add(4);
            graph.get(3).add(5);
            
            // 노드 4에 연결된 노드 정보 저장 
            graph.get(4).add(3);
            graph.get(4).add(5);
            
            // 노드 5에 연결된 노드 정보 저장 
            graph.get(5).add(3);
            graph.get(5).add(4);
            
            // 노드 6에 연결된 노드 정보 저장 
            graph.get(6).add(7);
            
            // 노드 7에 연결된 노드 정보 저장 
            graph.get(7).add(2);
            graph.get(7).add(6);
            graph.get(7).add(8);
            
            // 노드 8에 연결된 노드 정보 저장 
            graph.get(8).add(1);
            graph.get(8).add(7);
    
            dfs(1);
        }
    
    }
    ```
    

## 2-2.  BFS ( Breadth-First Seach) = 너비 우선 탐색

- 가까운 노드부터 탐색하는 알고리즘
- 선입선출 방식인 큐를 이용하는 것이 정석

동작순서

1. 탐색 시작 노드를 큐에 삽입하고 방문 처리한다
2. 큐에서 노드를 꺼내 해당 노드의 인접 노드 중에서 방문하지 않은 노드를 모두 큐에 삽입하고 방문처리한다.
3. 2번을 수행하지 못 할 때까지 반복 
- 동작과정 이미지 및 코드
    - **[Step 0]** 그래프를 준비한다 (**방문 기준: 번호가 낮은 인접 노드부터**)
        - 시작 노드: 1
    
    ![https://blog.kakaocdn.net/dn/ewCJzd/btqJ8ezDJeh/wwPDjMKuCKVF5vOXU14Ug0/img.png](https://blog.kakaocdn.net/dn/ewCJzd/btqJ8ezDJeh/wwPDjMKuCKVF5vOXU14Ug0/img.png)
    
    - **[Step 1]** 시작 노드인 '1'을 큐에 삽입하고 방문 처리를 한다
    
    ![https://blog.kakaocdn.net/dn/dJ9wO7/btqJ4G4wXZJ/u95m978zQB3D1YE2aQgJ41/img.png](https://blog.kakaocdn.net/dn/dJ9wO7/btqJ4G4wXZJ/u95m978zQB3D1YE2aQgJ41/img.png)
    
    - **[Step 2]** 큐에서 노드 '1'을 꺼내 방문하지 않은 인접 노드 '2', '3', '8'을 큐에 삽입하고 방문 처리한다
    
    ![https://blog.kakaocdn.net/dn/cytDe7/btqJ3gZh3Rk/YO6hSCl4su2924Tp0gUw70/img.png](https://blog.kakaocdn.net/dn/cytDe7/btqJ3gZh3Rk/YO6hSCl4su2924Tp0gUw70/img.png)
    
    - **[Step 3]** 큐에서 노드 '2'를 꺼내 방문하지 않은 인접 노드 '7'을 큐에 삽입하고 방문 처리한다
    
    ![https://blog.kakaocdn.net/dn/Wi8GR/btqJ1MqADVD/SolzlavP0MSmin0Ju9KgF0/img.png](https://blog.kakaocdn.net/dn/Wi8GR/btqJ1MqADVD/SolzlavP0MSmin0Ju9KgF0/img.png)
    
    - **[Step 4]** 큐에서 노드 '3'을 꺼내 방문하지 않은 인접 노드 '4', '5'를 큐에 삽입하고 방문 처리한다
    
    ![https://blog.kakaocdn.net/dn/cTHrgj/btqJ8ezDLeG/uEXzA8kV5BlyZ0JdkUaukk/img.png](https://blog.kakaocdn.net/dn/cTHrgj/btqJ8ezDLeG/uEXzA8kV5BlyZ0JdkUaukk/img.png)
    
    - **[Step 5]** 큐에서 노드 '8'을 꺼내고 방문하지 않은 인접 노드가 없으므로 무시한다
    
    ![https://blog.kakaocdn.net/dn/z1c15/btqJXVu3wKq/EdyutBlPdetiKd8BXc3wFk/img.png](https://blog.kakaocdn.net/dn/z1c15/btqJXVu3wKq/EdyutBlPdetiKd8BXc3wFk/img.png)
    
    - 이러한 과정을 반복하여 전체 노드의 탐색 순서(큐에 들어간 순서)는 다음과 같다
    
    ![https://blog.kakaocdn.net/dn/kJh5f/btqJ3iiySBZ/PlahRHQqbhXD73iGHKXUpk/img.png](https://blog.kakaocdn.net/dn/kJh5f/btqJ3iiySBZ/PlahRHQqbhXD73iGHKXUpk/img.png)
    
    ```java
    import java.util.*;
    
    public class BFS {
    
        public static boolean[] visited = new boolean[9];
        public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    
        // BFS 함수 정의
        public static void bfs(int start) {
            Queue<Integer> q = new LinkedList<>();
            q.offer(start);
            // 현재 노드를 방문 처리
            visited[start] = true;
            // 큐가 빌 때까지 반복
            while(!q.isEmpty()) { //문자열의 길이가 0인경우 , true를 출력 
                // 큐에서 하나의 원소를 뽑아 출력
                int x = q.poll(); // 위에 명령어 참조 (맨 앞 값 삭제 큐 비어있다면 null반환)
                System.out.print(x + " ");
                // 해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
                for(int i = 0; i < graph.get(x).size(); i++) {
                    int y = graph.get(x).get(i);
                    if(!visited[y]) {
                        q.offer(y);
                        visited[y] = true;
                    }
                }
            }
        }
    
        public static void main(String[] args) {
            // 그래프 초기화
            for (int i = 0; i < 9; i++) {
                graph.add(new ArrayList<Integer>());
            }
    
            // 노드 1에 연결된 노드 정보 저장 
            graph.get(1).add(2);
            graph.get(1).add(3);
            graph.get(1).add(8);
            
            // 노드 2에 연결된 노드 정보 저장 
            graph.get(2).add(1);
            graph.get(2).add(7);
            
            // 노드 3에 연결된 노드 정보 저장 
            graph.get(3).add(1);
            graph.get(3).add(4);
            graph.get(3).add(5);
            
            // 노드 4에 연결된 노드 정보 저장 
            graph.get(4).add(3);
            graph.get(4).add(5);
            
            // 노드 5에 연결된 노드 정보 저장 
            graph.get(5).add(3);
            graph.get(5).add(4);
            
            // 노드 6에 연결된 노드 정보 저장 
            graph.get(6).add(7);
            
            // 노드 7에 연결된 노드 정보 저장 
            graph.get(7).add(2);
            graph.get(7).add(6);
            graph.get(7).add(8);
            
            // 노드 8에 연결된 노드 정보 저장 
            graph.get(8).add(1);
            graph.get(8).add(7);
    
            bfs(1);
        }
    }
    ```
    

### 결론

|  | DFS | BFS |
| --- | --- | --- |
| 동작 원리 | 스택 | 큐 |
| 구현 방법 | 재귀함수 | 큐 자료 |