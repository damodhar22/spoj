package zero;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Scanner;

public class KGSS_MaximumSum {

    static class T{
        int max1;
        int max2;
    }

    static T s[];
    static int a[];
    public static void main(String args[]){

        FastIO sc = new FastIO();

        int n = sc.readInt();
        a = new int[n+1];
        s = new T[4*n+1];
        for (int i=1;i<=n;i++){
            a[i] = sc.readInt();
        }
        construct(1,1,n);
        int q = sc.readInt();
        while(q-->0){
            String s = sc.read();
            if("Q".equals(s)){
                int l = sc.readInt();
                int r = sc.readInt();
                T t = query(1,n,l,r,1);
                System.out.println(t.max1 + t.max2);
            }else{
                int idx = sc.readInt();
                int val = sc.readInt();
                update(1,1,n,idx,val);
            }
        }
    }

    static void construct(int node,int start,int end){
        if(start == end){
            T t = new T();
            t.max1 = a[start];
            t.max2 = 0;
            s[node] = t;
            return;
        }
        int mid = (start + end)/2;
        construct(2*node,start,mid);
        construct(2*node+1,mid+1,end);
        s[node] = join(s[2*node],s[2*node+1]);
    }

    static void update(int node,int start,int end,int idx,int val){

        if(start == end){
            a[idx] = val;
            T t = new T();
            t.max1 = a[idx];
            t.max2 = 0;
            s[node] = t;
            return;
        }

        int mid = (start + end) /2;
        if(idx <= mid){
            update(2*node,start,mid,idx,val);
        }else{
            update(2*node+1,mid+1,end,idx,val);
        }
        s[node] = join(s[2*node],s[2*node+1]);
    }

    static T query(int start,int end,int l,int r,int node){
        if(l<=start && r>= end){
            return s[node];
        }
        int mid = (start + end )/2;
        if(r<=mid){
            return query(start,mid,l,r,2*node);
        }else if(l>mid){
            return query(mid+1,end,l,r,2*node+1);
        }else{
            T lT = query(start,mid,l,r,2*node);
            T rT = query(mid+1,end,l,r,2*node+1);
            return join(lT,rT);
        }
    }

    static T join(T l,T r){
        T t = new T();
        if(l.max1>=r.max1){
            t.max1 = l.max1;
            t.max2 = Math.max(r.max1,l.max2);
        }else{
            t.max1 = r.max1;
            t.max2 = Math.max(l.max1,r.max2);
        }
        return t;
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
