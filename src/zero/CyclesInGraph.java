package zero;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class CyclesInGraph {

    static boolean visited[];
    //static boolean exited[];
    static boolean stopRecursion = false;
    static String result;
    static Map<Integer,Set<Integer>> map;
    static int[] parseArray(String line) {
        StringTokenizer st = new StringTokenizer(line);
        int[] rv = new int[st.countTokens()];
        for (int i = 0; i < rv.length; ++i) {
            rv[i] = Integer.parseInt(st.nextToken());
        }
        return rv;
    }

    static void dfs(String s, int vertex){
        visited[vertex] = true;
        Set<Integer> set = map.get(vertex);
        if(set!=null) {
            for (Integer i: set) {
                if (visited[i] && s.contains("-"+i+"-")) {
                    result = s;
                    int j = result.indexOf("-"+i+"-");
                    result= result.substring(j);
                    result=result.replace("-"," ");
                    result = result.trim();
                    stopRecursion = true;
                    break;
                }
                dfs(s + i + "-", i);
                if (stopRecursion) {
                    break;
                }
            }
        }
    }

    public static void main(String args[]) throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader("input.txt"));
             PrintWriter out = new PrintWriter("output.txt")) {
            String line = in.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            visited = new boolean[n+1];
            map = new HashMap<Integer, Set<Integer>>();

            while(m>0) {
            m--;
                 line = in.readLine();
                 st = new StringTokenizer(line);
                 int srcV = Integer.parseInt(st.nextToken());
                 int destV = Integer.parseInt(st.nextToken());
            if(map.containsKey(srcV)){
                Set<Integer> set = map.get(srcV);
                set.add(destV);
            }else{
                Set<Integer> l = new HashSet<>();
                l.add(destV);
                map.put(srcV,l);
            }
            }


            for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet())
            {
                int i = entry.getKey();
                if(!visited[i]){
                    dfs("-"+i+"-",i);

                }
                if(stopRecursion){
                    break;
                }
            }
            if(stopRecursion){
                out.println("YES");
                out.println(result);
            }else{
                out.println("NO");
            }



        }
    }

}
