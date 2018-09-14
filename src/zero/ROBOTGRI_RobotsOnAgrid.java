package zero;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class ROBOTGRI_RobotsOnAgrid {

    public static void main(String args[]){

        FastIO fs = new FastIO();
        int n = fs.readInt();
        boolean[][] a = new boolean[n][n];
        for(int i=0;i<n;i++){
                String s = fs.read();
                for(int j=0;j<s.length();j++){
                    char c = s.charAt(j);
                if('.'==c){
                    a[i][j] = true;
                }
            }
        }

        long mod = (1<<31)-1;
        long[][] dp = new long[n][n];
        dp[n-1][n-1] = 1;
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){

                if(i-1>=0 && a[i-1][j]){
                    dp[i-1][j] += dp[i][j]%mod;
                }
                if(j-1>=0 && a[i][j-1]){
                    dp[i][j-1] += dp[i][j]%mod;
                }
            }
        }

        if(dp[0][0] == 0){
            Queue<Pair<Integer,Integer>> q = new LinkedList<>();
            boolean v[][] = new boolean[n][n];
            q.offer(new Pair<>(0,0));
            boolean f = false;
            while(!q.isEmpty()){
                Pair<Integer,Integer> p = q.poll();
                int i = p.getKey();
                int j = p.getValue();
                if(v[i][j]){
                    continue;
                }
                v[i][j] = true;
                if(i==n-1 && j == n-1)
                {
                    f =true;
                    break;
                }
                if(i+1<n && a[i+1][j]){
                    q.offer(new Pair<>(i+1,j));
                }
                if(j+1<n && a[i][j+1]){
                    q.offer(new Pair<>(i,j+1));
                }
                if(i-1>=0 && a[i-1][j]){
                    q.offer(new Pair(i-1,j));
                }
                if(j-1>=0 && a[i][j-1]){
                    q.offer(new Pair<>(i,j-1));
                }
            }
            if(f){
                System.out.println("THE GAME IS A LIE");
            }else{
                System.out.println("INCONCEIVABLE");
            }
        }else {
            System.out.println(dp[0][0]%mod);
        }

    }

   static class Pair<T,G>{

        T key;
        G value;
        Pair(T key,G value){
            this.key = key;
            this.value = value;
        }

       public T getKey() {
           return key;
       }

       public G getValue() {
           return value;
       }
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
