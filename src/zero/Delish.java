package zero;

import java.util.Arrays;
import java.util.Scanner;

public class Delish {

    static int n;
    static int[] a;
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        int T =  sc.nextInt();
        while(T-->0){
            n = sc.nextInt();
            a = new int[n];

            for(int i=0;i<n;i++){
              a[i] = sc.nextInt();
            }


            /* Brute force solution
            int max = Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                int lSum = Integer.MIN_VALUE;
                for(int j=i;j<n;j++){
                    lSum += a[j];
                    for(int k=j+1;k<n;k++){
                        int rSum = Integer.MIN_VALUE;
                        for(int l=k;l<n;l++){
                            rSum += a[l];
                            max = Math.max(max,Math.abs(lSum-rSum));
                        }
                    }
                }
            }
            System.out.println(max);
            */

            // dynamic programming solution
            long[] lMax = new long[n];
            Arrays.fill(lMax,Integer.MIN_VALUE);
            lMax[0] = a[0];
            long sumPrev = a[0];
            for(int i=1;i<n;i++){
                sumPrev = Math.max(sumPrev+a[i],a[i]);
                lMax[i] = Math.max(lMax[i-1]+a[i],sumPrev);
            }

            long[] lMin = new long[n];
            Arrays.fill(lMin,Integer.MAX_VALUE);
            lMin[0] = a[0];
            sumPrev = a[0];
            for(int i=1;i<n;i++){
                sumPrev = Math.min(sumPrev+a[i],a[i]);
                lMin[i] = Math.min(lMin[i-1]+a[i],sumPrev);
            }


            long[] rMax = new long[n];
            Arrays.fill(rMax,Integer.MIN_VALUE);
            rMax[n-1] = a[n-1];
            sumPrev = a[n-1];
            for(int i=n-2;i>=0;i--){
                sumPrev = Math.max(sumPrev+a[i],a[i]);
                rMax[i] = Math.max(rMax[i+1]+a[i],sumPrev);
            }

            long[] rMin = new long[n];
            Arrays.fill(rMin,Integer.MAX_VALUE);
            rMin[n-1] = a[n-1];
            sumPrev = a[n-1];
            for(int i=n-2;i>=0;i--){
                sumPrev = Math.min(sumPrev+a[i],a[i]);
                rMin[i] = Math.min(rMin[i+1]+a[i],sumPrev);
            }

            long max = Long.MIN_VALUE;
            for(int i=0;i<n-1;i++){
                long s1 = Math.abs(lMax[i] - rMin[i+1]);
                long s2 = Math.abs(lMin[i] - rMax[i+1]);
                max = Math.max(max,Math.max(s1,s2));
            }

            System.out.println(max);

        }

    }




}
