package zero;

import java.util.HashMap;
import java.util.Map;

public class IncreasingSubsequence {

    public static void main(String args[]) {

        int a[] = {1,7, 2, 4, 3, 8};
        System.out.println(dynamic(a));


    }

    public int lengthOfLIS(int[] nums) {
        return rec(0, nums, Integer.MIN_VALUE);
    }

    int rec(int i,int[] nums,int prev){
        if(i>=nums.length){
            return 0;
        }
        int max = rec(i+1,nums,prev);
        if(prev < nums[i]){
            max = Math.max(max,1 + rec(i+1,nums,nums[i]));
        }
        return max;
    }

    static int dynamic2(int[] a){

        //a[i] represents length of max subsequence ending at i
        int n = a.length;
        int[] dp = new int[a.length+1];
        dp[0] = 1;
        for(int i=1;i<=n;i++){
            dp[i] = 1;
            for(int j = i-1;j>0;j--){
                if(a[i] > a[j] && 1 + dp[j] > dp[i]){
                    dp[i] = 1 + dp[j];
                }
            }

        }
        return dp[n];
    }


    static int dynamic(int[] a){

         //a[i] represents length of max subsequence starting at i
         int n = a.length;
         int[] dp = new int[a.length+1];
        for(int i=n-1;i>=0;i--){
            dp[i+1] = 1;
            for(int j = i+1;j<n;j++){

                if(a[j] > a[i] && 1 + dp[j] > dp[i+1]){
                  dp[i+1] = 1 + dp[j+1];
                }


            }

        }
for(int i=0;i<n;i++){
            System.out.print(dp[i]+" ");
}
 return dp[0];
    }



}
