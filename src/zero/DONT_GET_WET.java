package zero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DONT_GET_WET {

    public static void main(String args[]) {

        FastReader fr = new FastReader();

        int T = fr.nextInt();

        while (T-- > 0) {
            int n = fr.nextInt();
            int p[] = new int[n + 1];
            int size[] = new int[n + 1];

            int c = fr.nextInt();

            while (c-- > 0) {
                int i = fr.nextInt();
                int j = fr.nextInt();
                union(i, j, p, size);
            }

            int q = fr.nextInt();

            StringBuilder sb = new StringBuilder();
            while (q-- > 0) {
                int i = fr.nextInt();
                int j = fr.nextInt();
                int pi= find(i,p);
                int pj= find(j,p);
                if(pi==pj){
                    sb.append("Yes\n");
                }else{
                    sb.append("No\n");
                }
            }
            System.out.print(sb.toString());
        }
    }

    static void union(int i,int j,int[] parent,int[] size){
        int p1 = find(i,parent);
        int p2 = find(j,parent);
        if(p1 == p2){
            return;
        }else if(size[p1]>= size[p2]){
            size[p1] += size[p2];
            parent[p2] = p1;
        }else{
            size[p2] += size[p1];
            parent[p1] = p2;
        }
    }

    static int find(int i,int[] p){
        if(p[i] == 0){
            return i;
        }else{
            int parent = find(p[i],p);
            p[i] = parent;
        }
       return p[i];
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
