package zero;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.*;

public class Paradox {

    public static void main(String args[]){

        FastIO fs = new FastIO();

        while(true){
            int n = fs.readInt();
            if(n==0){
                break;
            }

            int[][] a = new int[n+1][2];
            int[] b = new int[n+1];
            int[] c = new int[n+1];
             Arrays.fill(b,-1);
            Arrays.fill(c,-1);
            for(int i=1;i<=n;i++) {
                a[i][0] = fs.readInt();
                String l = fs.read().trim();
                if("true".equals(l)){
                    a[i][1] = 1;
                }else{
                    a[i][1] = 0;
                }
            }

            boolean flag = true;

            for(int i=1;i<=n;i++) {
                if(b[i]==-1) {
                    b[i] = 1;
                    if (!dfs(a[i][0], a, b, a[i][1])) {
                        c[i] = 0;
                        int col = 0;
                        if (a[i][1] == 0) {
                            col = 1;
                        }
                        if (!dfs(a[i][0], a, c, col)) {
                            flag = false;
                            break;
                        }
                    }
                }
            }

            if(flag){
                System.out.println("NOT PARADOX");
            }else{
                System.out.println("PARADOX");
            }
        }
    }

    static boolean dfs(int v,int[][] a,int[] b,int col){
        if(b[v]!=-1 && b[v]!=col){
            return false;
        }else if(b[v]!=-1 && b[v]==col){
            return true;
        }
        b[v] = col;
        if(col==0){
            if(a[v][1]==0){
                col = 1;
            }else{
                col = 0;
            }
        }else{
            col = a[v][1];
        }
        return dfs(a[v][0],a,b,col);
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
