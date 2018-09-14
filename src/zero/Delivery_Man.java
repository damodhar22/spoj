package zero;

import java.util.Scanner;

public class Delivery_Man {

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        int a[] = new int[N];
        int b[] = new int[N];

        for(int i=0;i<N;i++){
           a[i]= sc.nextInt();
        }

        for(int i=0;i<N;i++){
            b[i]= sc.nextInt();
        }

        System.out.println(rec(a,b,0,0));
    }

    static int rec(int[] a,int[] b,int i,int count){
        if(i>=a.length){
            return count;
        }
        return Math.max(rec(a,b,i+1,count+a[i]),rec(a,b,i+1,count+b[i]));
    }

}
