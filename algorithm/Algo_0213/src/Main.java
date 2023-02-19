import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();

        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=n; i++) q.offer(i);
        sb.append('<');

        while(q.size()!=1){
            for(int i=1; i<k; i++) q.offer(q.poll());
            sb.append(q.poll()).append(", ");
        }
        sb.append(q.poll()).append('>');
        System.out.println(sb);
    }
}