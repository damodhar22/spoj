package zero;

import java.util.*;

public class TreeAndSpecialNode {

    static Map<Integer,List<Integer>> g = new HashMap<Integer,List<Integer>>();
    static HashSet<Integer> set = new HashSet<Integer>();
    static int A[];
    static int sum = 0;
    static boolean B[];

    static void dfs(int n){
        if(set.contains(A[n])){
            return;
        }
        List<Integer> li = g.get(n);
        if(li == null){
            sum += 1;
            return;
        }else{
            sum += 1;
            set.add(A[n]);
            for(int i=0;i<li.size();i++){
                dfs(li.get(i));
            }
            set.remove(A[n]);
        }
    }

    static void dfs2(){

        Stack<Integer> s = new Stack<Integer>();
        s.add(1);

        while (!s.isEmpty()){
            int k = s.peek();
            if(B[k]){
                set.remove(A[k]);
                s.pop();
                continue;
            }
            B[k] = true;
            if(set.contains(A[k])){
                s.pop();
            }
            else{
                sum += 1;
                List<Integer> li = g.get(k);
                if(li==null){
                    s.pop();
                }else{
                    set.add(A[k]);
                    for(int i=0;i<li.size();i++){
                        int r = li.get(i);
                        if(!B[r]) {
                            s.add(r);
                        }
                    }
                }
            }

        }

    }




    public static void main(String args[]){

        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int N = Integer.parseInt(str);
        str = s.nextLine();
        String[] strs = str.split(" ");
        A = new int[N+1];
        B = new boolean[N+1];

        for(int i=1;i<=N;i++){
            A[i] = Integer.parseInt(strs[i-1]);
        }

        for (int i = 0; i < N-1; i++){
            str = s.nextLine();
            strs = str.trim().split("\\s+");
            int u = Integer.parseInt(strs[0]);
            int v = Integer.parseInt(strs[1]);
            if(g.containsKey(u)){
                List<Integer> l = g.get(u);
                l.add(v);
            }else{
                List<Integer> li = new ArrayList<Integer>();
                li.add(v);
                g.put(u,li);
            }
            if(g.containsKey(v)){
                List<Integer> l = g.get(v);
                l.add(u);
            }else{
                List<Integer> li = new ArrayList<Integer>();
                li.add(u);
                g.put(v,li);
            }

        }

        //dfs(1);
         dfs2();
        System.out.print(sum);

    }



}
