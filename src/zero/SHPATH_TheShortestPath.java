package zero;

import sun.misc.Queue;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.*;

public class SHPATH_TheShortestPath {

    static Map<Integer, List<Edge>> map;
    static int n;
    public static void main(String args[]){
        FastIO fs = new FastIO();
        int T = fs.readInt();
        while(T-->0){
            n = fs.readInt();
            map = new HashMap<>();
            for(int i=1;i<=n;i++){
                map.put(i,new ArrayList<Edge>());
            }
            int count = 0;
            Map<String, Integer> mapCity = new HashMap<>();
            while(count<n) {
                count++;
                String city = fs.read();
                mapCity.put(city,count);
                int ed = fs.readInt();
                List<Edge> li = map.get(count);
                while(ed-->0){
                   int j = fs.readInt();
                   int w = fs.readInt();
                   li.add(new Edge(j,w));
                }
            }
            int k = fs.readInt();
            while(k-->0){
                String s = fs.read();
                String t = fs.read();
                System.out.println(dijiktra(mapCity.get(s),mapCity.get(t)));
            }
        }
    }

    static int dijiktra(int s,int t){
        int d[] = new int[n+1];
        Arrays.fill(d,Integer.MAX_VALUE);
        boolean v[] = new boolean[n+1];
        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.add(new Edge(s,0));
        d[s] = 0;
        while(!q.isEmpty()){
            Edge e = q.poll();
            if(e.v == t){
                break;
            }
            if(!v[e.v]){
                v[e.v] = true;
                List<Edge> li = map.get(e.v);
                for(int i=0;i<li.size();i++){
                    Edge ed = li.get(i);
                    if(!v[ed.v]&&d[ed.v]>d[e.v]+ed.w){
                        d[ed.v] = d[e.v]+ed.w;
                        q.add(new Edge(ed.v,d[ed.v]));
                    }
                }
            }
        }
        return d[t];
    }


    static class Edge implements Comparable<Edge> {
        int v;
        int w;
        Edge(int v, int w)
        {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
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
