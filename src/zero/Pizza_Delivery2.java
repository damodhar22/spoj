package zero;

import java.util.Arrays;
import java.util.Scanner;

public class Pizza_Delivery2 {

    static int n;
    static int a[];
    static int b[];
    static int dp[];
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            T--;
            n = sc.nextInt();
            a = new int[n];
            b = new int[n];
            int max = Integer.MIN_VALUE;
            for (int i=0;i<n;i++){
                a[i] = sc.nextInt();
                max = Math.max(max,2*a[i]);
            }
            dp = new int[max+1];
            Arrays.fill(dp,Integer.MAX_VALUE-1);
            for (int j=0;j<n;j++){
                b[j] = sc.nextInt();
            }
            dp[0] = 0;
            for(int j=0;j<n;j++) {
                for (int i = b[j]; i <= max; i++) {
                    dp[i] = Math.min(dp[i],1+dp[i-b[j]]);
                }
            }

            int sum =0 ;
            for(int i=0;i<n;i++){
            sum += dp[2*a[i]];
            }

            System.out.println(sum);
        }
    }
}
