package zero;

import javafx.util.Pair;

import java.util.*;

public class MinimizeTheValue {

    static  int N, X;
    static   int c[];
    static Map<Integer,List<Integer>> g = new HashMap<Integer,List<Integer>>();

    public static boolean read() {

        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        String[] strs = str.trim().split("\\s+");
        N = Integer.parseInt(strs[0]);
        X = Integer.parseInt(strs[1]);

        c = new int[N+1];
        str = s.nextLine();
        strs = str.trim().split("\\s+");
        for (int i = 0; i < N; i++){
            c[i+1] = Integer.parseInt(strs[i]);
        }
        for (int i = 0; i < N-1; i++){
            str = s.nextLine();
            strs = str.trim().split("\\s+");
            int x = Integer.parseInt(strs[0]);
            int y = Integer.parseInt(strs[1]);
                if(g.containsKey(x)){
                List<Integer> l = g.get(x);
                l.add(y);
            }else{
                List<Integer> li = new ArrayList<Integer>();
                li.add(y);
                g.put(x,li);
            }
        }
        return true;
    }

    static long dfs(int v) {
        List<Integer> li = g.get(v);
        if(li != null) {
            long sum = 0;
            for (int i = 0; i < li.size(); i++) {
                    sum += dfs(li.get(i));
            }
            sum *=2 ;
            return sum + c[v];
        }else{
            return c[v];
        }
    }

    static int dfsHeight(int v,int h){
        List<Integer> li = g.get(v);
        if(li != null) {
            int childCount = li.size();
            if(childCount < 2){
                return h;
            }
                return Math.min(dfsHeight(li.get(0),h+1),dfsHeight(li.get(1),h+1));
        }
        return h;
    }


    static void solve() {
        long sum = dfs(1);
        int pow = dfsHeight(1,1);
        sum += Math.pow(2,pow) * X;
       System.out.println(sum);
    }

    public static void main(String args[]) {
        read();
        solve();
    }

}