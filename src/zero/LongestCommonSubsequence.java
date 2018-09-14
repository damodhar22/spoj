package zero;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LongestCommonSubsequence {

    // Complete the longestCommonSubsequence function below.
    static int[] longestCommonSubsequence(int[] a, int[] b) {
          int[][] dp= new int[a.length][b.length];
          StringBuilder sb = rec(0,0,a,b,dp);
          int c[] = new int[sb.length()];
          String s = sb.toString();
          String str[] = s.split("");
          for(int i=0;i<c.length;i++){
              c[i] = Integer.parseInt(str[i]);
          }
          return a;
    }

    static StringBuilder rec(int i,int j,int[] a,int[] b,int[][] dp){
        if(i>=a.length || j>=b.length){
            return new StringBuilder();
        }

        if(a[i] == b[j]){
            return rec(i+1,j+1,a,b,dp).insert(0, a[i]);
        }else{
            StringBuilder s1 = rec(i+1,j,a,b,dp);
            StringBuilder s2 = rec(i,j+1,a,b,dp);
            return s1.length() >= s2.length()? s1 : s2;
        }
    }



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] b = new int[m];

        String[] bItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int bItem = Integer.parseInt(bItems[i]);
            b[i] = bItem;
        }

        int[] result = longestCommonSubsequence(a, b);

        for (int i = 0; i < result.length; i++) {
          //  bufferedWriter.write(String.valueOf(result[i]));

            System.out.print(result[i]+" ");
        }

      //  bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}