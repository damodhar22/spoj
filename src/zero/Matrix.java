package zero;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Matrix {

    static int a[];
    static Pair dp[][];
    public static void main(String args[]) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = null;
        while((string = br.readLine())!= null){

            if(string.isEmpty()){
                break;
            }
            int n = Integer.parseInt(string.trim());
            dp = new Pair[n][n];
            a = new int[n];
            String s = br.readLine();
            String str[] = s.trim().split(" ");
            for(int i=0;i<n;i++){
                a[i] = Integer.parseInt(str[i]);
            }

            System.out.println(dpFun(0,n-1).smoke);
        }

    }

    static Pair dpFun(int start, int end){
        if(dp[start][end]!=null){
            return dp[start][end];
        }
        if(start==end){
            dp[start][end] = new Pair(0,a[start]);
            return dp[start][end];
        }

        Pair p = null;
        for(int i=start;i<end;i++){

            Pair p1 = dpFun(start,i);
            Pair p2 = dpFun(i+1,end);

            Pair p3 = new Pair(p1.smoke+p2.smoke+(p1.val*p2.val),(p1.val+p2.val)%100);
            p = p==null || p.smoke > p3.smoke ? p3:p;
        }
         dp[start][end] = p;
        return dp[start][end];
    }

    static class Pair{
        int smoke;
        int val;

        Pair(int smoke, int sum){
        this.smoke = smoke;
        this.val = sum;
        }


    }

}
