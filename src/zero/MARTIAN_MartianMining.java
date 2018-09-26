package zero;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Arrays;

public class MARTIAN_MartianMining {

    static int dp[][];
    static int row[][];
    static int col[][];

    public static void main(String args[]){

        FastIO fs = new FastIO();

        while(true) {
            int m = fs.readInt();
            int n = fs.readInt();
           if(m==0 && n==0)break;

           dp = new int[m][n];

           for (int i=0;i<m;i++){
               Arrays.fill(dp[i],-1);
           }

           row = new int[m][n];
           col = new int[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    row[i][j] = fs.readInt();
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    col[i][j] = fs.readInt();
                }
            }

            System.out.println(rec(m-1,n-1));
        }

    }

    static int rec(int m,int n){

        if(m<0 || n<0)
           return 0;

        if(dp[m][n] != -1){
            return dp[m][n];
        }

        int rowSum = 0;
        for(int i=n;i>=0;i--){
            rowSum += row[m][i];
        }
        int colSum = 0;
        for(int i=m;i>=0;i--){
            colSum += col[i][n];
        }

        dp[m][n] = Math.max(rec(m,n-1) + colSum,rec(m-1,n)+rowSum);

        return dp[m][n];
    }


    static class FastIO
    {
        static BufferedInputStream in = new BufferedInputStream(System.in);
        static int readInt() {
            int no = 0;
            boolean minus = false;
            try {
                int a = in.read();
                while (a == 32 || a == 10) //10 is newline & 32 is ASCII for space
                    a = in.read();
                if (a == '-') {
                    minus = true;
                    a = in.read();
                }
                while (a != 10 && a != 32 && a != -1) {
                    no = no * 10 + (a - '0');
                    a = in.read();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
            return minus ? -no: no;
        }
        static String read() {
            StringBuilder str = new StringBuilder();
            try {
                int a = in.read();
                while (a == 32)
                    a = in.read();
                while (a != 10 && a != 32 && a != -1) {
                    str.append((char)a);
                    a = in.read();
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
            return str.toString();
        }
    }

}
