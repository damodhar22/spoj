package zero;

import java.util.Arrays;
import java.util.Scanner;

public class Delivery_Man {


    static int A;
    static int B;
    static int dp[][];
    static int memo[][];
    static int N;
    static int a[];
    static int b[];

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = sc.nextInt();
        B = sc.nextInt();
        a = new int[N];
        b = new int[N];
        dp = new int[N][N];
        memo = new int[N+1][N+1];

        for(int i=0;i<N;i++) {
            Arrays.fill(dp[i],-1);
        }

        for(int i=0;i<N;i++) {
            Arrays.fill(memo[i],-1);
        }

        for(int i=0;i<N;i++){
           a[i]= sc.nextInt();
        }

        for(int i=0;i<N;i++){
            b[i]= sc.nextInt();
        }

        System.out.println(rec(0,0,0,""));
       // System.out.println(dpFun(0,0));
    }

    static int rec(int idx,int i,int j,String s){
        if(idx>=a.length){
            System.out.println(s+":"+idx+"-"+i+"-"+j+":::");
            return 0;
        }
        if(dp[idx][i] != -1){
            return dp[idx][i];
        }
        if(i>=A){
          dp[idx][i]  =  b[idx] + rec(idx+1,i,j+1,s+":"+idx+"-"+i+"-"+j);
        }
        else if(j>=B){
            dp[idx][i]  = a[idx] + rec(idx+1,i+1,j,s+":"+idx+"-"+i+"-"+j);
        }else {
            dp[idx][i] = Math.max(a[idx] + rec( idx + 1, i + 1, j, s + ":" + idx + "-" + i + "-" + j),
                    b[idx] + rec( idx + 1,  i, j + 1, s + ":" + idx + "-" + i + "-" + j));
        }
        return dp[idx][i];
    }

    static int dpFun(int i, int j) {
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int res = 0;
        if (i == N) {
            // all orders are processed.
            res = 0;
        } else {
            // Decide for order i.
            // If can give to Andy, try giving it.
            int AndyOrders = j;
            if (AndyOrders + 1 <= A) {
                res = Math.max(res, a[i] + dpFun(i + 1, j + 1));
            }
            // If can give to Bob, try giving it.
            int BobOrders = i - j;
            if (BobOrders + 1 <= B) {
                res = Math.max(res, b[i] + dpFun(i + 1, j));
            }
        }
        memo[i][j] = res;
        return res;
    }

}
