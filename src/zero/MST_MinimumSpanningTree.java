package zero;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MST_MinimumSpanningTree {

    public static void main(String args[]){

        FastIO fs = new FastIO();
        int n = fs.readInt();
        boolean[] vis = new boolean[n+1];
        int ec = fs.readInt();
        List<Edge>[] a= new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            a[i] = new ArrayList<>();
        }
        PriorityQueue<Edge> q = new PriorityQueue<>();
        for(int i=1;i<=ec;i++){
             int v = fs.readInt();
             int u = fs.readInt();
             int w = fs.readInt();
             a[v].add(new Edge(u,w));
             a[u].add(new Edge(v,w));
        }
        long w = 0;
        vis[1] = true;
        for(int i=0;i<a[1].size();i++){
         q.add(a[1].get(i));
        }
        while(!q.isEmpty()){
            Edge e = q.poll();
            if(!vis[e.u]){
                w += e.w;
                vis[e.u] = true;
                for(int i=0;i<a[e.u].size();i++){
                    q.add(a[e.u].get(i));
                }
            }
        }
       System.out.println(w);
    }

    static class Edge implements Comparable<Edge>{

        int u,w;

        Edge(int u,int w){
            this.u = u;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w-o.w;
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
