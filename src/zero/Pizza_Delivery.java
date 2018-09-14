package zero;

import java.util.Arrays;
import java.util.Scanner;

public class Pizza_Delivery {

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0){
            T--;
            int  N = sc.nextInt();
            int a[] = new int[N+1];
            int b[] = new int[N+1];
            int max = Integer.MIN_VALUE;

            for(int i=1;i<=N;i++){
                a[i]=sc.nextInt();
                max = Math.max(max,a[i]);
            }

            for(int i=1;i<=N;i++){
                b[i]=sc.nextInt();
            }

            int dp[][] = new int[N+1][2*max+1];

            Arrays.fill(dp[0],Integer.MAX_VALUE);
            dp[0][0] = 0;

            for(int i=1;i<=N;i++){
                for(int j=0;j<=2*max;j++){
                    dp[i][j] = dp[i-1][j];
                    if(j>=b[i]) {
                        dp[i][j] = Math.min(dp[i][j], 1 + dp[i][j - b[i]]);
                    }
                }
            }

            int sum = 0;
            for(int i=1;i<=N;i++){
            sum += dp[N][2*a[i]];
            }
            System.out.println(sum);
        }

    }

}
