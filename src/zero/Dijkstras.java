package zero;

import java.lang.reflect.Array;
import java.util.*;

public  class Dijkstras {

    class Edge
    {
        int v;
        int w;
        Edge(int v, int w)
        {
            this.v = v;
            this.w = w;
        }
    }

    class PQEdgeComparator implements Comparator<Edge> {

        // return -ve to put first before second, +ve otherwise
        public int compare(Edge one, Edge two) {
            return one.w - two.w;  // This will make it MIN_PQ
        }
    }

    void printSingleSourceShortestDistance(Map<Integer, ArrayList<Edge>> g, int s)
    {
        // TODO: Print space separated Min Distance from s to all vertices.
        // Do not give any newline at end.

        int []d = new int[g.size()];
        Arrays.fill(d,Integer.MAX_VALUE);
        boolean []v = new boolean[g.size()];
        PQEdgeComparator comp = new PQEdgeComparator();
        PriorityQueue<Edge> q = new PriorityQueue<Edge>(comp);
        q.add(new Edge(s,0));
        d[s] = 0;

   while(!q.isEmpty()){
       Edge eu = q.remove();
       if(!v[eu.v]) {
           v[eu.v] = true;
           ArrayList<Edge> adjacentEdgeList = g.get(eu.v);
           for (int i = 0; i < adjacentEdgeList.size(); i++) {
               Edge ev = adjacentEdgeList.get(i);
               if (d[ev.v] > (d[eu.v] + ev.w)) {
                   d[ev.v] = d[eu.v] + ev.w;
                   q.add(new Edge(ev.v, d[ev.v]));
               }
           }
       }
   }

   for(int i=s;i<d.length;i++){
       System.out.print(d[i]+" ");
   }

    }


}