package zero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RangeMinimumQuery {

    static int[] a;
    static int[] s;

    public static void main(String args[]){
        FastReader fr = new FastReader();

        int n = fr.nextInt();
        int q = fr.nextInt();
        a = new int[n+1];
        s = new int[4*n+1];

        for(int i=1;i<=n;i++){
            a[i] = fr.nextInt();
        }
        construct(1,1,n);
        while(q-->0){
            if("q".equals(fr.next())){
                int l = Integer.parseInt(fr.next());
                int r = Integer.parseInt(fr.next());
                System.out.println(query(1,n,l,r,1));
            }else{
                int idx = Integer.parseInt(fr.next());
                int val = Integer.parseInt(fr.next());
                update(1,1,n,val,idx);
            }
        }
    }

    static void construct(int node,int start,int end){
        if(start == end){
                s[node] = a[start];
        }else {
            int mid = (start + end) / 2;
            construct(2 * node, start, mid);
            construct(2 * node + 1, mid + 1, end);
            s[node] = Math.min(s[2 * node], s[2 * node + 1]);
        }
    }

    static void update(int node,int start,int end,int value,int idx){
        if(start == end && start == idx){
            a[idx] = value;
            s[node] = value;
            return;
        }
        int mid = (start+end)/2;
        if(idx <= mid){
            update(2*node,start,mid,value,idx);
        }else{
            update(2*node+1,mid+1,end,value,idx);
        }
        s[node] = Math.min(s[2*node],s[2*node+1]);
    }

    static int query(int start,int end,int l,int r,int node){

        if(start>=l && end <= r){
            return s[node];
        }
        int mid = (start+end)/2;
        if(r<=mid){
            return query(start,mid,l,r,2*node);
        }else if(l>mid){
            return query(mid+1,end,l,r,2*node+1);
        }else {
            return Math.min(query(start, mid, l, r, 2 * node), query(mid + 1, end, l, r, 2 * node + 1));
        }
    }

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}
