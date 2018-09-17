package zero;


import java.util.*;
import java.io.*;

class HPair implements Comparable<HPair> {
    int distance;
    int node;

    public HPair() {
        distance = 2000000;
        node = 2000000;
    }

    public HPair(int x, int y) {
        distance = x;
        node = y;
    }

    public int compareTo(HPair hp) {
        return this.distance - hp.distance;
    }
}


public class SHPATH {

    public static void main(String args[]) throws Exception {
        MyScanner5 in = new MyScanner5(System.in);
        int t = in.nextInt();

        while (t != 0) {
            t--;
            HashMap<String, Integer> hm = new HashMap<String, Integer>();
            ArrayList<HPair> graph[];
            int find[];
            int n = in.nextInt();
            graph = new ArrayList[n + 1];
            find = new int[n + 1];
            for (int i = 0; i <= n; ++i) {
                graph[i] = new ArrayList();
            }
            for (int i = 1; i <= n; ++i) {
                String city = in.next();
                int edges = in.nextInt();
                hm.put(city, i);

                for (int j = 1; j <= edges; ++j) {
                    int v = in.nextInt();
                    int dst = in.nextInt();
                    graph[i].add(new HPair(dst, v));
                }
            }

            int q = in.nextInt();
            for (int i = 1; i <= q; ++i) {
                String city = in.next();
                int src = hm.get(city);
                city = in.next();
                int dst = hm.get(city);

                PriorityQueue<HPair> pq = new PriorityQueue();
                pq.add(new HPair(2000000, src));

                int d[] = new int[n + 1];
                for (int j = 0; j <= n; ++j) {
                    d[j] = 2000000;
                    find[j] = 0;
                }

                d[src] = 0;

                while (!pq.isEmpty()) {
                    int tp = pq.peek().node;
                    int dt = pq.peek().distance;
                    pq.remove();

                    if (find[tp] == 1) {
                        continue;
                    }

                    for (int j = 0; j < graph[tp].size(); ++j) {
                        int nd = graph[tp].get(j).node;
                        int edj = graph[tp].get(j).distance;

                        if (find[nd] == 0 && d[tp] + edj < d[nd]) {
                            d[nd] = d[tp] + edj;
                            pq.add(new HPair(d[tp] + edj, nd));
                        }
                    }
                    find[tp] = 1;

                    if (tp == dst) {
                        break;
                    }
                }

                System.out.println(d[dst]);
            }

        }

    }

}


class MyScanner5 {
    final private int BUFFER_SIZE = 1 << 16;

    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public MyScanner5(InputStream in) {
        din = new DataInputStream(in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public long nextLong() throws Exception {
        long ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = c == '-';
        if (neg) c = read();
        do {
            ret = ret * 10 + c - '0';
            c = read();
        } while (c > ' ');
        if (neg) return -ret;
        return ret;
    }

    //reads in the next string
    public String next() throws Exception {
        StringBuilder ret = new StringBuilder();
        byte c = read();
        while (c <= ' ') c = read();
        do {
            ret = ret.append((char) c);
            c = read();
        } while (c > ' ');
        return ret.toString();
    }

    public int nextInt() throws Exception {
        int ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = c == '-';
        if (neg) c = read();
        do {
            ret = ret * 10 + c - '0';
            c = read();
        } while (c > ' ');
        if (neg) return -ret;
        return ret;
    }

    private void fillBuffer() throws Exception {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1) buffer[0] = -1;
    }

    private byte read() throws Exception {
        if (bufferPointer == bytesRead) fillBuffer();
        return buffer[bufferPointer++];
    }
}