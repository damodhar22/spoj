package zero;

import javafx.util.Pair;

import java.util.*;

public class EulerWalkNewYearTree {
static    int N = 1200300;

 static  int n, m;
  static   int c[];
  static Map<Integer,List<Integer>> g = new HashMap<Integer,List<Integer>>();
  static Pair<Integer,Pair<Integer,Integer>> q[] = new Pair[N];

    public static boolean read() {

        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        String[] strs = str.trim().split("\\s+");
        n = Integer.parseInt(strs[0]);
        m = Integer.parseInt(strs[1]);
        //if (!(cin >> n >> m)) return false;
        c = new int[n];
        str = s.nextLine();
        strs = str.trim().split("\\s+");
        for (int i = 0; i < n; i++){
            c[i] = Integer.parseInt(strs[i]);;
        }
        for (int i = 0; i < n-1; i++){
            str = s.nextLine();
            strs = str.trim().split("\\s+");
            int x = Integer.parseInt(strs[0]);
            int y = Integer.parseInt(strs[1]);
            x--;
            y--;
            if(g.containsKey(x)){
              List<Integer> l = g.get(x);
              l.add(y);
            }else{
                List<Integer> li = new ArrayList<Integer>();
                li.add(y);
                g.put(x,li);

            }
            if(g.containsKey(y)){
                List<Integer> l = g.get(y);
                l.add(x);
            }else{
                List<Integer> li = new ArrayList<Integer>();
                li.add(x);
                g.put(y,li);

            }

        }

        for(int i=0;i<m;i++){
            str = s.nextLine();
            strs = str.trim().split("\\s+");
            int x = Integer.parseInt(strs[0]);
            int y = Integer.parseInt(strs[1]);
            y--;
            if(x == 1){
                int z = Integer.parseInt(strs[2]);
                q[i] = new Pair(x,new Pair(y,z));
            }else{
                q[i] = new Pair(x,new Pair(y,-1));
            }

        }
        return true;
    }

    static int tt;
    static int tin[] = new int[N];
    static int tout[] = new int[N];
    static int vs[] = new int[N];

    static void dfs(int v, int p) {
        vs[tt] = v;
        tin[v] = tt++;
        List<Integer> li = g.get(v);
        if(li != null) {
            for (int i = 0; i < li.size(); i++) {
                if (li.get(i) != p) {
                  dfs(li.get(i),v);
                }
            }
        }
        tout[v] = tt;
    }

    static long []t = new long[4*N];
    static long []add = new long[4*N];

    static void build(int v, int l, int r) {
        add[v] = -1;
        if (l + 1 == r) t[v] = 1 << c[vs[l]];
        else{
            int md = (l + r) >> 1;
            build(2 * v + 1, l, md);
            build(2 * v + 2, md, r);
            t[v] = t[2 * v + 1] | t[2 * v + 2];
        }
    }

    static void push(int v) {
        if (add[v] == -1) return;
        for (int i = 1; i < 3; i++)
        t[2 * v + i] = add[2 * v + i] = add[v];
        add[v] = -1;
    }

    static void paint(int v, int l, int r, int lf, int rg, int c) {
        if (lf >= rg) return;
        if (l == lf && r == rg) {
            t[v] = 1 << c;
            add[v] = 1 << c;
        } else {
            push(v);
            int md = (l + r) >> 1;
            paint(2 * v + 1, l, md, lf, Math.min(md, rg), c);
            paint(2 * v + 2, md, r, Math.max(lf, md), rg, c);
            t[v] = t[2 * v + 1] | t[2 * v + 2];
        }
    }

    static long get(int v, int l, int r, int lf, int rg) {
        if (lf >= rg) return 0;
        if (l == lf && r == rg) return t[v];
        push(v);
        int md = (l + r) >> 1;
        long ans = 0;
        ans |= get(2 * v + 1, l, md, lf, Math.min(md, rg));
        ans |= get(2 * v + 2, md, r, Math.max(lf, md), rg);
        return ans;
    }

    static void solve() {
        tt = 0;
        dfs(0, -1);
        assert (tt == n);
        build(0, 0, n);

            for (int i = 0; i < m; i++){

                int tp = q[i].getKey();
                int v = q[i].getValue().getKey();
            if (tp == 1) {

                int c = q[i].getValue().getValue();
                paint(0, 0, n, tin[v], tout[v], c);
            } else {
                long mask = get(0, 0, n, tin[v], tout[v]);

                int ans = 0;
                for (int j = 0; j < 61; j++)
                ans += (int)(mask >> j) & 1;
                System.out.print(ans+" ");
            }
        }
    }

    public static void main(String args[]) {
        while (read()) {
            solve();
            break;
        }
    }

}