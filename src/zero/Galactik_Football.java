package zero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Galactik_Football {

    static int cmin[];
    static int parent[];
    static int size[];
    static int ncc;

    public static void main(String args[]){

        FastReader fr = new FastReader();
        int N = fr.nextInt();
        int M = fr.nextInt();
        ncc = N;
        cmin = new int[N+1];
        parent = new int[N+1];
        size = new int[N+1];
        Arrays.fill(cmin,-1);
        Arrays.fill(size,-1);

        for (int k = 1; k <= M; k++) {
            int i = fr.nextInt();
            int j = fr.nextInt();
            Union(i, j);
        }

        if (ncc == 1) {
            System.out.println(0);
        }

        for (int i = 1; i <= N; i++) {
            int C = fr.nextInt();
            if (C < 0)
                continue;
            int j = Find(i);
            if (cmin[j] < 0 || C < cmin[j])
                cmin[j] = C;
        }

        int sum = 0;
        int Cmin = Integer.MAX_VALUE;

        boolean flag = true;

        for (int i = 1; i <= N; i++) {
            if (parent[i] > 0)
                continue;
            if (cmin[i] < 0) {
                flag = false;
                break;
            }
            sum += cmin[i];
            if (cmin[i] < Cmin)
                Cmin = cmin[i];
        }

        if(flag){
        System.out.println(sum + (ncc - 2) * Cmin);
        }else{
            System.out.println("-1");
        }


    }

    static int Find(int x) {
        int tx = x;
        while (parent[tx] > 0)
            tx = parent[tx];

        while (x != tx) {
            int rx = parent[x];
            parent[x] = tx;
            x = rx;
        }

        return tx;
    }

    static void Union(int i, int j) {
        int ti = Find(i), tj = Find(j);
        if (ti == tj)
            return;
        ncc--;
        if (size[ti] >= size[tj]) {
            parent[tj] = ti;
            size[ti] += size[tj];
        } else {
            parent[ti] = tj;
            size[tj] += size[ti];
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
                catch (IOException  e)
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
