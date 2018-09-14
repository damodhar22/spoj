package zero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Dish_Owner {

    public static void main(String args[]){

        FastReader sc = new FastReader();

        int T = sc.nextInt();
        StringBuilder sb =new StringBuilder();
        while (T>0){
            T--;
            int n = sc.nextInt();
            int a[] = new int[n+1];
            int parent[] = new int[n+1];
            for (int i=1;i<=n;i++){
                a[i] = sc.nextInt();
            }

            int q = sc.nextInt();

            while(q>0){
                q--;
                int type = sc.nextInt();
                if(type == 0){
                  int i = sc.nextInt();
                  int j = sc.nextInt();
                  if(!union(parent,i,j,a)){
                      sb.append("Invalid query!"+'\n');
                  }
                }else{
                    int i = sc.nextInt();
                    sb.append(find(i,parent)+""+'\n');
                }
            }
        }
        System.out.print(sb.toString());
    }

    static boolean union(int[] parent,int i,int j,int a[]){
        int parentI = find(i,parent);
        int parentJ = find(j,parent);

        if(parentI == parentJ){
            return false;
        }
        if(a[parentI] > a[parentJ]){
            parent[parentJ] = parentI;
        }else if(a[parentI] < a[parentJ]){
            parent[parentI] = parentJ;
        }
        return true;
    }

//    static int find(int i,int[] parent){
//        int tempP = i;
//        while(parent[tempP]>0)
//            tempP = parent[tempP];
//
//        if(tempP == i){
//            return tempP;
//        }
//
//        while(parent[i]>0){
//            int currP = parent[i];
//            parent[i] = tempP;
//            i = currP;
//        }
//        return tempP;
//
//    }

    static int find(int x,int[] p)
    {
        if(p[x] == 0)
            return x;
        else{
            int j = find(p[x],p);
            p[x]=j;
            return j;

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
