package zero;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IncreasingSubsequence {


    // Complete the longestIncreasingSubsequence function below.
    static int longestIncreasingSubsequence(int[] a) {

        return dpFun(a);
          //return rec(1,a,0);
    }


    // works only with all subsets time complexity exponential
    static int brute(int[] a){

        int max = Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++){
            int count = 1;
            int no = a[i];
            for (int j=i+1;j<a.length;j++){
                if(a[j]>=no){
                    no = a[j];
                    count++;
                }
            }
            max = Math.max(max,count);
        }
        return max;
    }

     // stack overflow
    // recursion memoization
    static int rec(int i,int[] nums, int prev){
        if(i>=nums.length){
            return 0;
        }
        if(dp[i][prev] != -1){
            return dp[i][prev];
        }
        int max = rec(i+1,nums,prev);
        if(nums[prev] <= nums[i]){
            max = Math.max(max,1 + rec(i+1,nums,i));
        }
        dp[i][prev] = max;
        return dp[i][prev];
    }

    //dp iterative

    static int dpFun(int[] a){

        int n = a.length;
        int dp[][] = new int[n][n];

        for(int i=n-1;i>0;i--){
            for(int j=i-1;j>=0;j--){
                if(i == n-1){
                    if(( j==0 || a[j] < a[i]))
                    dp[i][j] = 1;
                }else{
                  dp[i][j] = j == 0 || a[i] > a[j] ? Math.max(1+dp[i+1][i],dp[i+1][j]): dp[i+1][j];
                }
            }
        }

        return dp[1][0];
    }

    private static final Scanner scanner = new Scanner(System.in);

    static int dp[][];

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n+1];
        dp = new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }

        arr[0] = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        int result = longestIncreasingSubsequence(arr);

        System.out.println(result);
        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

       // bufferedWriter.close();

        scanner.close();
    }


}
