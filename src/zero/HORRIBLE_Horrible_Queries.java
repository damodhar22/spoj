package zero;

import java.util.Scanner;

public class HORRIBLE_Horrible_Queries {

    static int a[];
    static long s[];
    static long lazy[];

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T-->0){
            int n = sc.nextInt();
            int c = sc.nextInt();

            a = new int[n+1];
            s = new long[4*n+1];
            lazy = new long[4*n+1];

            StringBuilder sb = new StringBuilder();
            while(c-->0){
                int q = sc.nextInt();
                if(q==0){
                    int l = sc.nextInt();
                    int r = sc.nextInt();
                    long val = sc.nextInt();
                    update(1,1,n,l,r,val);
                }else{
                    int l = sc.nextInt();
                    int r = sc.nextInt();
                    sb.append(query(1,1,n,l,r)+"\n");
                }
            }
            System.out.println(sb.toString());
        }
    }

    public static void update(int node,int start,int end,int l,int r,long value){


        if(lazy[node]!=0){
            s[node] += (end-start+1)*lazy[node];
            if(start!=end){
                lazy[2*node] += lazy[node];
                lazy[2*node+1] += lazy[node];
            }
            lazy[node] = 0;
        }

        if(end<start || start >r || end < l){
            return;
        }

        if(l <= start && r >= end){
                s[node] += (end - start + 1) * value;
                if (start != end) {
                    lazy[2 * node] += value;
                    lazy[2 * node + 1] += value;
                }
             return;
        }

        int mid = (start+end)/2;

            update(2*node,start,mid,l,r,value);
            update(2*node+1,mid+1,end,l,r,value);
        s[node] = s[2*node] + s[2*node+1];
    }

    public static long query(int node,int start,int end,int l,int r){

        if(end<start || start >r || end < l){
            return 0;
        }
            if(lazy[node]!=0){
                s[node] += (end-start+1)*lazy[node];
                if(start!=end) {
                    lazy[2 * node] += lazy[node];
                    lazy[2 * node + 1] += lazy[node];
                }
                lazy[node] = 0;
            }
        if(l <= start && r >= end){
            return s[node];
        }
        int mid = (start+end)/2;
//        if(r<=mid){
//           return query(2*node,start,mid,l,r);
//        }else if(l>mid){
//           return query(2*node+1,mid+1,end,l,r);
//        }else{
           return query(2*node,start,mid,l,r) + query(2*node+1,mid+1,end,l,r);
       // }
    }

}
