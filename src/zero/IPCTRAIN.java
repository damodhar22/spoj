package zero;

import java.util.*;

public class IPCTRAIN {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T>0){
            T--;
            int n = sc.nextInt();
            int d = sc.nextInt();
            Map<Integer,List<Trainer>> map = new HashMap();

            while(n>0){
                n--;
                int k = sc.nextInt();
                int no = sc.nextInt();
                int sad = sc.nextInt();
                if(map.containsKey(k)){
                    List<Trainer> l = map.get(k);
                    l.add(new Trainer(sad,no));
                }else{
                    List<Trainer> l = new ArrayList<>();
                    l.add(new Trainer(sad,no));
                    map.put(k,l);
                }
            }

            PriorityQueue<Trainer> q = new PriorityQueue<>();

            int days = 1;
            while(days<=d){
                List<Trainer> li = map.get(days);
                if(li!=null) {
                    map.remove(days);
                    for (Trainer t : li) {
                        q.offer(t);
                    }
                }
                    if (!q.isEmpty()) {
                        Trainer t = q.peek();
                        t.no -= 1;
                        if(t.no == 0){
                            q.remove();
                        }
                    }
                days++;
            }

            Iterator<Trainer> it = q.iterator();
            Long sadness = 0l;
            while(it.hasNext()){
                Trainer t = it.next();
                sadness += (long)t.no * t.sad;
            }

            for (Map.Entry<Integer, List<Trainer>> e: map.entrySet()) {
                List<Trainer> l = e.getValue();
                for(int i=0;i<l.size();i++){
                    Trainer t = l.get(i);
                    sadness += t.no * t.sad;
                }
            }
            System.out.println(sadness);
        }
    }
}

class Trainer implements Comparable<Trainer>{
    int sad;
    int no;

    Trainer(int sad,int no){
        this.sad = sad;
        this.no = no;
    }

    @Override
    public int compareTo(Trainer o) {
        return (this.sad-o.sad)*-1;
    }
}

