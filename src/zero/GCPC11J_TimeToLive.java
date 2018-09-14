package zero;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.*;

public class GCPC11J_TimeToLive {

    public static void main(String args[]){

        FastIO fs = new FastIO();
        int T = fs.readInt();

        while(T-->0){
            int c = fs.readInt();

            Map<Integer,List<Integer>> map = new HashMap<>();
            for(int i=1;i<=c;i++){
                map.put(i,new ArrayList<>());
            }

            long dp[] = new long[c+1];

            Arrays.fill(dp,-1);

            int B = fs.readInt();
            int s = fs.readInt();
            int t = fs.readInt();

            for(int i=1;i<=B;i++){
                int a = fs.readInt();
                int b = fs.readInt();
                List<Integer> li = map.get(a);
                li.add(b);
            }

                System.out.println(dfs(s, map, t, dp));
        }
    }

    static long dfs(int v,Map<Integer,List<Integer>> map,int T,long[] dp){

        if(v==T){
            return 1;
        }
        if(dp[v]!=-1){
            return dp[v];
        }
        List<Integer> li = map.get(v);
        long count = 0;
        for (int i: li) {
            count = count + dfs(i,map,T,dp);
        }
        dp[v] = count%1000000007;
        return dp[v];
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
