package zero;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class TDPRIMES_PrintingSomePrimes {

    public static void main(String args[]){

        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = 100000000;

        boolean[] a = new boolean[n];

        a[0] = true;
        a[1] = true;
        int sqrt = (int)Math.sqrt(n);

        for(int i=3;i<=sqrt;i+=2){
            if(!a[i]){
                for(int j=i*i;j<n;j+=2*i){
                    a[j] = true;
                }
            }
        }

        int count = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(2+"\n");
        for (int i=3;i<n;i+=2){
            if(!a[i]){
                count++;
                if (count%100 == 1)
                    sb.append(i+"\n");
            }
        }
        System.out.println(sb.toString());
    }

}
