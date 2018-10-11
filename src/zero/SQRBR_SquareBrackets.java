package zero;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class SQRBR_SquareBrackets {

    static int n;
    static boolean[] a;
    static int[][] dp;
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T-->0){
            n = sc.nextInt();
            int k = sc.nextInt();
            a = new boolean[2*n+1];
            dp = new int[2*n+1][2*n+1];

            for(int i=0;i<=2*n;i++){
                Arrays.fill(dp[i],-1);
            }

            for(int i=0;i<k;i++){
                int j = sc.nextInt();
                a[j] = true;
            }
            System.out.println(dpFun(1,0));
        }
    }

    static int dpFun(int i,int openBrackets){
        if(i>2*n){
            if(openBrackets == 0){
                return 1;
            }else{
                return 0;
            }
        }

        if(dp[i][openBrackets] != -1){
          return dp[i][openBrackets];
        }

        if(a[i] || openBrackets == 0){
            dp[i][openBrackets] = dpFun(i+1, openBrackets+1);
            return dp[i][openBrackets];
        }else{
            dp[i][openBrackets] = dpFun(i+1, openBrackets+1) + dpFun(i+1, openBrackets-1);
            return dp[i][openBrackets];
        }

    }

}
