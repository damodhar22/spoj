package zero;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;

public class NITTROAD_RoadsOfNITT {

    static class Edge{
        int a;
        int b;
        boolean mark;

        Edge(int a,int b){
        this.a = a;
        this.b = b;
        }
    }

    static int set[];
    static long size[];
    public static void main(String args[]){

        FastIO fs = new FastIO();

        int T = fs.readInt();

        while(T-->0) {
            int n = fs.readInt();
            set = new int[n + 1];
            size = new long[n + 1];
            Arrays.fill(size, 1);
            for(int i=1;i<=n;i++){
                set[i] = i;
            }
            Edge edges[] = new Edge[n];
            for (int i = 1; i < n; i++) {
                int a = fs.readInt();
                int b = fs.readInt();
                edges[i] = new Edge(a, b);
            }
            int q = fs.readInt();

            Stack<Integer> stack = new Stack<>();

            while (q-- > 0) {
                String s = fs.read();
                if ("Q".equals(s)) {
                    stack.push(0);
                } else {
                    int i = fs.readInt();
                    edges[i].mark = true;
                    stack.push(i);
                }
            }

            long disConnectedCount = (n * (n - 1)) / 2;

            for (int i = 1; i < n; i++) {
                if (!edges[i].mark) {
                    int a = find(edges[i].a);
                    int b = find(edges[i].b);
                    disConnectedCount -= size[a] * size[b];
                    union(a, b);
                }
            }
            Stack<Long> resultStack = new Stack();

            while (!stack.isEmpty()) {
                int k = stack.pop();
                if (k == 0) {
                    resultStack.push(disConnectedCount);
                } else {
                    int a = find(edges[k].a);
                    int b = find(edges[k].b);
                    disConnectedCount -= size[a] * size[b];
                    union(a, b);
                }
            }
            while (!resultStack.isEmpty()) {
                System.out.println(resultStack.pop());
            }
            if(T>0){
                System.out.println();
            }
        }
    }

    static int find(int x){
        while (set[x] != x)
        {
            set[x] = set[set[x]];
            x = set[x];
        }
        return x;
    }

    static void union(int pX,int pY){
        if(pX==pY){
            return;
        }
        if(size[pX]>=size[pY]) {
            set[pY] = pX;
            size[pX] += size[pY];
        }
        else {
            set[pX] = pY;
            size[pY] += size[pX];
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
