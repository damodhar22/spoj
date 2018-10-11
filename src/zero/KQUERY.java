package zero;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KQUERY {

    static int n;
    static int[] s;
    public static void main(String args[]){

        FastIO fs = new FastIO();

        n = fs.readInt();
        s = new int[n+1];
        List<T> li = new ArrayList<>();

        for(int i=1;i<=n;i++){
            int val = fs.readInt();
            li.add(new T(i,val,0,0));
        }

        int q = fs.readInt();

        int[] res = new int[q];
        int count = 0;
        while(count < q){
            int l = fs.readInt();
            int r = fs.readInt();
            int k = fs.readInt();
            li.add(new T(count++,k,l,r));
        }

        Collections.sort(li,Collections.reverseOrder());

        int size = li.size();
        for(int i=0;i<size;i++){
            T t = li.get(i);
            if(t.l == 0){
                update(t.order,1);
            }else{
                res[t.order]= query(t.r) - query(t.l-1);
            }
        }

        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
        }

    static void update(int idx,int val){
        for (int i=idx;i<=n;i+=i&(-i)){
            s[i]+=val;
        }
    }

    static int query(int idx){
        int sum = 0;
        for(int i=idx;i>0;i-=i&-i){
            sum += s[i];
        }
        return sum;
    }


    static class T implements Comparable<T>{
        int order;
        int val;
        int l;
        int r;

        T(int order,int val,int l,int r){
            this.order = order;
            this.val = val;
            this.l = l;
            this.r =r;
        }
        @Override
        public int compareTo(T o) {
            if(this.val == o.val){
                return this.l - o.l;
            }else{
                return this.val - o.val;
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

