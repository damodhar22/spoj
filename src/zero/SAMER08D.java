package zero;

import java.util.Arrays;
import java.util.Scanner;

public class SAMER08D {

    static String a;
    static String b;
    static int k;
    static int dp[][];

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            k = Integer.parseInt(sc.nextLine().trim());
            if(k==0) break;
            a = sc.nextLine().trim();
            b = sc.nextLine().trim();
            dp = new int[a.length()][b.length()];
            for (int i=0;i<a.length();i++)
            Arrays.fill(dp[i],-1);
            System.out.println(rec(0,0));
        }
    }

    static int rec(int i,int j){
        if(i>=a.length() || j>= b.length()){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int count = 0;
        int iT = i;
        int jT = j;
        while(iT<a.length() && jT<b.length() && a.charAt(iT) == b.charAt(jT)){
            iT++;
            jT++;
            count++;
        }
        if(count < k) {
            count = 0;
        }
            else{
             count = count + rec(iT,jT);
            }

            dp[i][j] = Math.max(count ,Math.max(rec(i,j+1),rec(i+1,j)));
        return dp[i][j];

    }


}
