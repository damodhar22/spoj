package zero;

import javafx.scene.layout.Priority;

import java.util.*;

/*
*
* */

public class EXPEDI_Expedition {

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T>0){
            T--;
            int n = sc.nextInt();
            Station a[] = new Station[n];
            for(int i=0;i<n;i++){
                a[i] = new Station(sc.nextInt(),sc.nextInt());
            }

            // NlogN
            Arrays.sort(a, new Comparator<Station>() {
                @Override
                public int compare(Station o1, Station o2) {
                    return (o1.dist-o2.dist)*-1;
                }
            });

            int p = sc.nextInt();
            int l = sc.nextInt();
            PriorityQueue<Station> q = new PriorityQueue<>(Collections.reverseOrder());
            int i = 0;
            int count = 0;
            while (true){
            if((l-p)>=0){
                break;
            }

           while(i<n){
                if((p - a[i].dist) <= l ){
                    q.offer(a[i]);
                    i++;
                }else{
                    break;
                }
           }
           if(q.isEmpty()){
                break;
           }else{
               Station s = q.poll();
               l -= (p - s.dist);
               l += s.litr;
               p = s.dist;
               count++;
           }
        }

        if((l-p)>=0){
              System.out.println(count);
        }else{
                System.out.println(-1);
        }
        }
    }
}


 class Station implements Comparable<Station>{
    int dist;
    int litr;

    Station(int dist,int litr){
        this.dist = dist;
        this.litr = litr;
    }

    @Override
    public int compareTo(Station o) {
        return this.litr-o.litr;
    }
}

