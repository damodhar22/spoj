package zero;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.*;

public class TOPOSORT_TopologicalSorting {

    public static void main(String args[]){

        FastIO fs = new FastIO();
        int n = fs.readInt();
        int m = fs.readInt();
        TreeSet<Integer>[] adj = new TreeSet[n+1];
        int[] in_index = new int[n+1];
        int[] res = new int[n+1];
        boolean[] vis = new boolean[n+1];
        for(int i=1;i<=n;i++){
           adj[i] = new TreeSet<Integer>();
        }

        for(int i=0;i<m;i++){
          int u = fs.readInt();
          int v = fs.readInt();
          adj[u].add(v);
        }

        for(int i=1;i<=n;i++){
            TreeSet<Integer> li = adj[i];
            Iterator<Integer> it = li.iterator();
            while(it.hasNext()){
                int k = it.next();
                in_index[k]++;
            }
        }
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int idx = 0;
        for(int i=1;i<=n;i++){
            if(in_index[i] == 0){
               q.offer(i);
               vis[i] = true;
            }
        }

        if(q.isEmpty()){
            System.out.println("Sandro fails.");
        }else{
            while(!q.isEmpty()){
                int v = q.poll();
                res[++idx] = v;
                TreeSet<Integer> li = adj[v];
                Iterator<Integer> it = li.iterator();
                while(it.hasNext()){
                        int k = it.next();
                      if(!vis[k]) {
                        in_index[k]--;
                        if (in_index[k] == 0) {
                            q.offer(k);
                            vis[k] = true;
                        }
                    }
                }
            }
            if(idx == n){
                for(int i=1;i<=n;i++){
                    System.out.print(res[i]+" ");
                }
            }else{
                System.out.println("Sandro fails.");
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
