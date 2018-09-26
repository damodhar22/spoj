package zero;

import java.util.Scanner;

public class HIST2_Histogram {
    static int heights[];
    static int dp[][];
    static int combs[][];

    //dp[comb][height[j], j in combi] = (max over all k){dp[comb - j][height[k] for k in combi-j] + 2+2*height[j]-height[k]}
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            heights = new int[n];
            if (n == 0) break;
            for (int i = 0; i < n; i++) {
                heights[i] = sc.nextInt();
            }

            int allpresent = (int) Math.pow(2, n) - 1;
            dp = new int[allpresent][n];
            combs = new int[allpresent][n];
            for (int i = 0; i < allpresent + 1; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = 0;
                    combs[i][j] = 0;
                }
            }

            for (int i = 0; i < n; i++) {
                dp[1 << i][heights[i]] = 2 + 2 * heights[i];
                combs[1 << i][heights[i]] = 1;
            }

            int val;
            for (int i = 0; i < allpresent + 1; i++) {
                for (int k = 0; k < n; k++) {
                    if ((i >> k & 1) > 0) {
                        for (int r = 0; r < n; r++) {
                            if (r != k && ((i >> r & 1) > 0)) {
                                int comb = combs[i][heights[k]];
                                int maxi = dp[i][heights[k]];
                                val = dp[(i & ~(1 << k))][heights[r]] + 2 + 2 * heights[k] - 2 * Math.min(heights[r], heights[k]);
                                if (val > maxi) {
                                    dp[i][heights[k]] = val;
                                    comb = 0;
                                }
                                if (val == maxi) {
                                    comb += combs[(i & ~(1 << k))][heights[r]];
                                }
                            }
                        }
                    }
                }
            }


            int max_ = 0;
            long combinations = 0;
            for (int i = 0; i < n; i++) {
                max_ = Math.max(max_, dp[allpresent][heights[i]]);
            }
            for (int i = 0; i < n; i++) {
                if (max_ == dp[allpresent][heights[i]]) {
                    combinations += combs[allpresent][heights[i]];
                }
            }
            System.out.println(max_ + " " + combinations);
        }
    }
}