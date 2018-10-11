package zero;

import java.util.Arrays;
import java.util.Scanner;

public class EDIST_EditDistance {

    static String a;
    static String b;
    static int dp[][];

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        int T = Integer.parseInt(sc.nextLine().trim());

        while(T-->0) {
            a = sc.nextLine();
            b = sc.nextLine();
            dp = new int[a.length()+1][b.length()+1];

            for(int i=0;i<=a.length();i++){
                Arrays.fill(dp[i],-1);
            }

           System.out.println(recFun(0,0));
        }
    }

    static int recFun(int i,int j){
        if(i>= a.length() && j>= b.length())
            return 0;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        if(i>=a.length()){
            dp[i][j] =  b.length() - j;
            return dp[i][j];
        }

        if(j>=a.length()){
            dp[i][j] = a.length() - i;
            return dp[i][j];
        }

        int count = 0;

        if(a.charAt(i) == b.charAt(j)){
            dp[i][j] = recFun(i+1,j+1);
            return dp[i][j];
        }

        dp[i][j] = Math.min(1+recFun(i+1,j+1),Math.min(1+recFun(i+1,j),1+recFun(i,j+1)));
        return dp[i][j];

    }

}
