package zero;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GSS1_Can_you_answer_these_queriesI {

    static int a[];
    static int s[];

    public static void main(String args[]) throws IOException {

        Reader fr = new Reader();

        int n = fr.nextInt();
        a = new int[50005];
        s = new int[200005];
        Arrays.fill(s,Integer.MIN_VALUE);
        for(int i=1;i<=n;i++){
            a[i] = fr.nextInt();
        }

        construct(1,1,n);
        int q = fr.nextInt();
        StringBuilder sb = new StringBuilder();
        while(q-->0){
            int i = fr.nextInt();
            int j = fr.nextInt();
            sb.append(query(1,n,i,j,1)+"\n");
        }

        System.out.print(sb.toString());
    }

    static void construct(int node,int start,int end){
        if(start == end){
            s[node] = a[start];
        }else {
            int mid = (start + end) / 2;
            construct(2 * node, start, mid);
            construct(2 * node + 1, mid + 1, end);
            s[node] = Math.max(s[2 * node] + s[2 * node + 1],Math.max(s[2 * node], s[2 * node + 1]));
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
        s[node] = Math.max(s[2 * node] + s[2 * node + 1],Math.max(s[2 * node], s[2 * node + 1]));
    }

    static int query(int start,int end,int l,int r,int node){


        if(start > end || start > r || end < l){
                 return Integer.MIN_VALUE;
        }

        if(start>=l && end <= r){
            return s[node];
        }
        int mid = (start+end)/2;
        if(r<=mid){
            return query(start,mid,l,r,2*node);
        }else if(l>mid){
            return query(mid+1,end,l,r,2*node+1);
        }else {
            int left = query(start, mid, l, r, 2 * node);
            int right = query(mid + 1, end, l, r, 2 * node + 1);
            return Math.max(left+right,Math.max(left,right));
        }
    }

    static /** Faster input **/
    class Reader {
        final private int BUFFER_SIZE = 1 << 16;private DataInputStream din;private byte[] buffer;private int bufferPointer, bytesRead;
        public Reader(){din=new DataInputStream(System.in);buffer=new byte[BUFFER_SIZE];bufferPointer=bytesRead=0;
        }public Reader(String file_name) throws IOException{din=new DataInputStream(new FileInputStream(file_name));buffer=new byte[BUFFER_SIZE];bufferPointer=bytesRead=0;
        }public String readLine() throws IOException{byte[] buf=new byte[64];int cnt=0,c;while((c=read())!=-1){if(c=='\n')break;buf[cnt++]=(byte)c;}return new String(buf,0,cnt);
        }public int nextInt() throws IOException{int ret=0;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');if(neg)c=read();do{ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');if(neg)return -ret;return ret;
        }public long nextLong() throws IOException{long ret=0;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');if(neg)c=read();do{ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');if(neg)return -ret;return ret;
        }public double nextDouble() throws IOException{double ret=0,div=1;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');if(neg)c = read();do {ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');if(c=='.')while((c=read())>='0'&&c<='9')ret+=(c-'0')/(div*=10);if(neg)return -ret;return ret;
        }private void fillBuffer() throws IOException{bytesRead=din.read(buffer,bufferPointer=0,BUFFER_SIZE);if(bytesRead==-1)buffer[0]=-1;
        }private byte read() throws IOException{if(bufferPointer==bytesRead)fillBuffer();return buffer[bufferPointer++];
        }public void close() throws IOException{if(din==null) return;din.close();}
    }
}
