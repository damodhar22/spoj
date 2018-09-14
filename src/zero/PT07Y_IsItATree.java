package zero;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PT07Y_IsItATree {

    public static void main(String args[]){

        FastIO fs = new FastIO();

        int n = fs.readInt();
        int m = fs.readInt();

        if(m!=n-1){
            System.out.println("NO");
        }
        else {

            boolean a[] = new boolean[n+1];

            Map<Integer, List<Integer>> map = new HashMap<>();

            for (int i = 1; i <= n; i++) {
                map.put(i, new ArrayList<Integer>());
            }

            while (m-- > 0) {
                int i = fs.readInt();
                int j = fs.readInt();
                List<Integer> list = map.get(i);
                list.add(j);
                List<Integer> list2 = map.get(j);
                list2.add(i);
            }
            dfs(1,a,map);
            boolean f = true;
            for (int i=1;i<a.length;i++){
                if(!a[i]){
                    f= false;
                    break;
                }
            }
            if(f)
            System.out.println("YES");
            else
                System.out.println("NO");
        }

    }

    static void dfs(int v,boolean[] a,Map<Integer,List<Integer>> map){
        a[v] = true;
        List<Integer> li = map.get(v);
        for (int i = 0; i <li.size() ; i++) {
            int k = li.get(i);
            if(!a[k]){
                dfs(k,a,map);
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
