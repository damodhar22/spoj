package zero;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class DQUERY {

    static int n;
    static int s[];
    static int a[];
    static int lastOccu[];
    static Pair queries[];
    static int res[];

    public static void main(String args[]){

        FastIO sc = new FastIO();

        n = sc.readInt();
        a = new int[n+1];
        s = new int[n+1];
        int max = Integer.MIN_VALUE;
        for (int i=1;i<=n;i++){
            a[i] = sc.readInt();
            max = Math.max(max,a[i]);
        }
        lastOccu = new int[max+1];
        int q = sc.readInt();
        res = new int[q];
        queries = new Pair[q];

        int count = 0;
        while (count<q){
            int l = sc.readInt();
            int r = sc.readInt();
            queries[count] = new Pair(l,r,count);
            count++;
        }

        Arrays.sort(queries);
        int queC = 0;
        for(int i=1;i<=n;i++){
            if(lastOccu[a[i]] == 0){
                update(i,1);
                lastOccu[a[i]] = i;
            }else{
                update(lastOccu[a[i]],-1);
                update(i,1);
                lastOccu[a[i]] = i;
            }
            while(i==queries[queC].r){
                int total = query(queries[queC].r);
                int dec = query(queries[queC].l-1);
                res[queries[queC].order] = total - dec;
                if(q-1 == queC){
                    break;
                }
                queC++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<q;i++){
            sb.append(res[i]+"\n");
        }
        System.out.print(sb.toString());
    }

    static void update(int idx,int val){
        for(int i=idx;i<=n; i+= i&-i){
            s[i] += val;
        }
    }


    static int query(int idx){
        int sum = 0;
        for(int i = idx;i>0;i-=i&-i){
            sum += s[i];
        }
        return sum;
    }

    static class Pair implements Comparable<Pair>{
        int l;
        int r;
        int order;
        Pair(int l,int r,int order){
            this.l = l;
            this.r = r;
            this.order = order;
        }

        @Override
        public int compareTo(Pair o) {
            return this.r - o.r;
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
