package zero;

import java.util.Arrays;
import java.util.Scanner;

public class XOR_with_Subset {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0){
            T--;
            int N = sc.nextInt();
            int K = sc.nextInt();
            int a[]=new int[N];
            int max = 0;
            for(int i=0;i<N;i++){
                a[i] = sc.nextInt();
            }
            int dp[][] = new int[N][1024];

            for(int i =0 ;i<N;i++){
                Arrays.fill(dp[i],-1);
            }
            System.out.println(rec(a,0, 0, K, dp));
        }
    }

    static int rec(int a[],int i,int xor,int k,int[][] dp){
        if(i>=a.length){
            return k^xor;
        }
        if(dp[i][xor] == -1)
            dp[i][xor] = Math.max(rec(a,i+1,xor,k,dp),rec(a,i+1,xor^a[i],k,dp));
        return dp[i][xor];
    }
}
