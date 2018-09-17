package zero;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TarjansAlgorithm_AurticulationPoints {

    /*intput
    6 7
    1 2
    2 3
    2 4
    3 4
    3 5
    4 5
    1 6
    */

    static int time = 0;
    public static void main(String args[]){

        FastIO fs = new FastIO();

        while(true) {
            int n = fs.readInt();
            int m = fs.readInt();

            if(n==0&&m==0){
                break;
            }
            boolean[] visited = new boolean[n + 1];
            int[] disc = new int[n + 1];
            int[] low = new int[n + 1];
            Arrays.fill(low, Integer.MAX_VALUE);
            int[] parent = new int[n + 1];
            boolean[] AP = new boolean[n + 1];
            List<Integer>[] adj = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                adj[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                int v = fs.readInt();
                int u = fs.readInt();
                adj[v].add(u);
                adj[u].add(v);
            }

            DFS(adj, disc, low, visited, parent, AP, 1);
            int res = 0;
            for (int i = 1; i <= n; i++) {
                if (AP[i]) {
                    res++;
                }
            }
            System.out.println(res);
        }
    }

    static void DFS(List<Integer>[] adj,int[] disc,int[] low,boolean[] visited,int parent[],boolean[] AP,int vertex){
        visited[vertex] = true;
        disc[vertex] = low[vertex] = ++time;
        int child = 0;
        List<Integer> li = adj[vertex];
        for(int k = 0;k<li.size();k++) {
            int i = li.get(k);
            if (visited[i] == false) {
                child++;
                parent[i] = vertex;
                DFS(adj, disc, low, visited, parent, AP, i);
                low[vertex] = Math.min(low[vertex], low[i]);
                if (parent[vertex] == 0 && child >1) {
                    AP[vertex] = true;
                }
                if(parent[vertex] != 0 && low[ i] >=disc[vertex])
                AP[vertex] = true;
            } else if (parent[vertex] != i) {
                low[vertex] = Math.min(low[vertex], disc[i]);
            }
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
