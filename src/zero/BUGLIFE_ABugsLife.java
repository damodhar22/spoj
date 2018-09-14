package zero;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BUGLIFE_ABugsLife {

    public static void main(String args[]){

        FastIO sc = new FastIO();

        int T = sc.readInt();
        int scen = 0;
        while(T-->0){
            scen++;
            int n = sc.readInt();
            int a[] = new int[n+1];
            int noEdge = sc.readInt();

            Map<Integer,List<Integer>> map = new HashMap<>();

            for(int i=1;i<=n;i++){
                map.put(i,new ArrayList<Integer>());
            }

            while(noEdge-->0){
                int i = sc.readInt();
                int j = sc.readInt();
                List<Integer> list = map.get(i);
                list.add(j);
                List<Integer> list2 = map.get(j);
                list2.add(i);
            }
            boolean flag = true;
            for(int i=1;i<=n;i++){
                if(a[i]==0) {
                    if (!BFS(i, map, 0, a)) {
                        flag = false;
                        break;
                    }
                }
            }

            if(flag){
                System.out.println("Scenario #"+scen+":");
                System.out.println("No suspicious bugs found!");
            }else{
                System.out.println("Scenario #"+scen+":");
                System.out.println("Suspicious bugs found!");
            }

        }
    }

    static boolean BFS(int i,Map<Integer,List<Integer>> map,int col,int[] a){

        if(col==2 || col==0){
            a[i] = 1;
        }else{
            a[i] = 2;
        }

        List<Integer> l = map.get(i);

        for(int j=0;j<l.size();j++){
            int k = l.get(j);
            if(a[k]==0){
                if(!BFS(k,map,a[i],a)){
                    return false;
                }
            }else if(a[i]==a[k]){
                return false;
            }
        }
        return true;
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
