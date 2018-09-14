package zero;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KthSmallestNo {

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T>0){
            T--;
            int k = sc.nextInt();
            PriorityQueue<Integer> q = new PriorityQueue<>();

            int n = sc.nextInt();

            while(n>0){
                n--;
                int no = sc.nextInt();
                if(q.isEmpty() || q.size() < k ){
                    q.offer(no);
                }else if(q.peek() < no){
                    q.poll();
                    q.offer(no);
                }

                if(q.size()<k){
                    System.out.print(-1+" ");
                }else{
                    System.out.print(q.peek()+" ");
                }
            }
System.out.println();
        }

    }

}
