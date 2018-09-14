package zero;

import java.util.*;

public class PS {

    static class Edge
    {
        int v;
        int w;
        Edge(int v, int w)
        {
            this.v = v;
            this.w = w;
        }
    }

    static class PQEdgeComparator implements Comparator<Edge> {

        public int compare(Edge one, Edge two) {
            return (int)(one.w - two.w);
        }
    }

    static void parkingFee(int N,Map<Integer, ArrayList<Edge>> g, int s,int c[],int K,int F)
    {
        int []d = new int[N+1];
        Arrays.fill(d,Integer.MAX_VALUE);
        boolean []v = new boolean[N+1];
        PQEdgeComparator comp = new PQEdgeComparator();
        PriorityQueue<Edge> q = new PriorityQueue<Edge>(comp);
        q.add(new Edge(s,0));
        d[s] = 0;

      //  ArrayList<Integer> distOrderList = new ArrayList<Integer>();
        int K2 = 0;
        while(!q.isEmpty()){
            Edge eu = q.poll();
            if(!v[eu.v]) {
                v[eu.v] = true;
                //distOrderList.add(eu.v);
                for(int j=0;j<c[eu.v];j++) {
                    if (K == 0) {
                        break;
                    }
                    System.out.print((F + d[eu.v]) + " ");
                    --K;
                }
               // K2 = K2 + c[eu.v];
                if(K==0){
                break;
                }
                ArrayList<Edge> adjacentEdgeList = g.get(eu.v);
                if(adjacentEdgeList != null) {
                    for (int i = 0; i < adjacentEdgeList.size(); i++) {
                        Edge ev = adjacentEdgeList.get(i);
                        int weight = d[eu.v] + ev.w;
                        if (d[ev.v] > weight) {
                            d[ev.v] = weight;
                            q.add(new Edge(ev.v, d[ev.v]));
                        }
                    }
                }
            }
        }

//        for (Integer i: distOrderList) {
//            if(K==0){
//                break;
//            }
//            for(int j=0;j<c[i];j++) {
//                if (K == 0) {
//                    break;
//                }
//                System.out.print((F + d[i]) + " ");
//                K--;
//            }
//        }
        if(K>0) {
            for (int i = 0; i < K; i++) {
                System.out.print(-1 + " ");
            }
        }
    }

    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        String[] str2 = str.split(" ");
        int N = Integer.parseInt(str2[0]);
        int M = Integer.parseInt(str2[1]);
        int F = Integer.parseInt(str2[2]);

        int c[] = new int[N+1];

        str =s.nextLine();
        str2 = str.split(" ");

        Map<Integer,ArrayList<Edge>> g = new HashMap<Integer,ArrayList<Edge>>();

        for(int i=1;i<= N;i++){
        c[i] =  Integer.parseInt(str2[i-1]);
            ArrayList<Edge> li = new ArrayList<Edge>();
            g.put(i,li);
        }



        for (int i = 0; i < M; i++){
            str = s.nextLine();
            str2 = str.trim().split("\\s+");
            int u = Integer.parseInt(str2[0]);
            int v = Integer.parseInt(str2[1]);
            int w = Integer.parseInt(str2[2]);
          //  if(g.containsKey(u)){
                ArrayList<Edge> l1 = g.get(u);
                l1.add(new Edge(v,w));

            ArrayList<Edge> l2 = g.get(v);
            l2.add(new Edge(u,w));

        }

        str = s.nextLine();
        int K = Integer.parseInt(str);

        //parkingFee(Map<Integer, ArrayList<Edge>> g, int s,int c[],int K,int F)
        parkingFee(N,g,1,c,K,F);

    }

}
