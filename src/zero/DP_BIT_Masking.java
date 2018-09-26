package zero;

public class DP_BIT_Masking {

    public static void main(String args[]){

        int N = 2;
        int cost[][] = {{2,4},{3,50}};
        int dp[] = new int[4];
        System.out.println(assign(N,cost,dp));
    }

    static int assign(int N,int[][] cost,int dp[]) {
        for (int i = 0; i < Math.pow(2, N); i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int mask = 0; mask < Math.pow(2, N); mask++) {
            int x = count_set_bits(mask);
            for(int j = 0;j< N;j++) {
                if((mask & (1<<j)) == 0){
                dp[mask | (1 << j)] = Math.min(dp[mask | (1 << j)], dp[mask] + cost[x][j]);
                }
            }
        }
        return dp[(int)Math.pow(2, N) - 1];
    }



    static int count_set_bits(int n){
        int count = 0;
           while(n>0){
               count++;
               n = n&(n-1);
           }
            return count;
        }

}
