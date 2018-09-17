package zero;

import java.util.*;

public class ChefandDigitJumps {

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int[] d = new int[s.length()];
        boolean[] v = new boolean[s.length()];
        Map<Integer,List<Integer>> map = new HashMap<>();

        for(int i=0;i<=9;i++){
            map.put(i,new ArrayList<>());
        }

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            List<Integer> li = map.get(Character.getNumericValue(c));
            li.add(i);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        v[0]=true;
        d[0]=0;
        while(!q.isEmpty()){
            int i = q.poll();
            if(i==s.length()-1){
                break;
            }
            char c = s.charAt(i);
            List<Integer> li = map.get(Character.getNumericValue(c));
            if(li!=null) {
                for (int j = 0; j < li.size(); j++) {
                    int idx = li.get(j);
                    if (!v[idx]) {
                        v[idx] = true;
                        q.offer(idx);
                        d[idx] = d[i] + 1;
                    }
                }
            }
            map.remove(Character.getNumericValue(c));
            if(i-1>=0 && !v[i-1]){
                q.offer(i-1);
                v[i-1] = true;
                d[i-1] = d[i] + 1;
            }

            if(i+1<s.length()&&!v[i+1]){
                q.offer(i+1);
                v[i+1] = true;
                d[i+1] = d[i] + 1;
            }
        }
       System.out.println(d[s.length()-1]);
    }

}
