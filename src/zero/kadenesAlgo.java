package zero;

public class kadenesAlgo {

    public static void main(String args[]){

        int[] a = {-220,143,23,-231,123,33};

        int maxSoFar = a[0];
        int maxPrev = a[0];

        for(int i=1;i<a.length;i++){
            maxPrev = Math.max(maxPrev+a[i],a[i]);
            maxSoFar = Math.max(maxSoFar,maxPrev);
        }

        System.out.println(maxSoFar);
    }
}
