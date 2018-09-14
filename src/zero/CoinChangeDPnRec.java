package zero;

import java.util.Arrays;

public class CoinChangeDPnRec {

    // Complete the ways function below.
    static int ways(int n, int[] coins) {

        return rec(n,coins,0);

    }


    static int rec(int n,int[] coins,int j){

        if( n < 0 ){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        int sum = 0;
        for(int i=j;i < coins.length;i++){
            sum += rec(n-coins[i],coins,i+1);
        }

        return sum;
    }

    long dynamic2(int n,int[] coins){
        long[] table = new long[n+1];

        // Initialize all table values as 0
        Arrays.fill(table, 0);   //O(n)

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
        for (int i=0; i<coins.length; i++)
            for (int j=coins[i]; j<=n; j++)
                table[j] += table[j-coins[i]];

        return table[n];
    }
    int dynamic(int n,int[] coins){
            int[][] dp = new int[n+1][coins.length];

            Arrays.fill(dp[0],0);
            for (int i=1;i<=n;i++){
                for(int j=0;j<coins.length;j++){
                    int x = coins[j] > i ? 0 : dp[i-coins[j]][j];
                    int y = j==0 ? 0 : dp[i][j-1];
                    dp[i][j] = x + y;
                }
            }

            return dp[n][coins.length-1];
    }
}
