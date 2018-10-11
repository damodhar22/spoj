package zero;

import java.util.Arrays;
import java.util.Scanner;

public class AIBOHP_Aibohphobia {

    static int dp[][];

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        int T = Integer.parseInt(s);
        while(T>0){
            T--;
            s = sc.nextLine().trim();
            dp = new int[s.length()][s.length()];

            for(int i=0;i<s.length();i++){
                Arrays.fill(dp[i],-1);
            }

            System.out.println(rec(s,0,s.length()-1));
        }

    }

    static int dpRec(String s){
        int[][] dp = new int[s.length()][s.length()];

        return 0;
    }

    static int rec(String s,int i,int j){
        if(i>=j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s.charAt(i) == s.charAt(j)){
            dp[i][j] = rec(s,i+1,j-1);
            return dp[i][j];
        }
        else{
            dp[i][j] = 1+ Math.min(rec(s,i,j-1),rec(s,i+1,j));
            return dp[i][j];
        }
    }

}
