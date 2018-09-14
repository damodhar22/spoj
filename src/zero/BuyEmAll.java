package zero;

import java.util.Scanner;

public class BuyEmAll {

    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        String[] str2 = str.split(" ");
        int n = Integer.parseInt(str2[0]);
        long k = Long.parseLong(str2[1]);
        int[] a = new int[n];
        str = s.nextLine();
        str2 = str.split(" ");
        for(int i=0;i<n;i++){
            a[i] = Integer.parseInt(str2[i]);
        }

        int count = 0;

         for(int i=0;i<n;i++){
             int cost = a[i]*1;
             if(cost <= k){
                 count++;
             }
             long sum = 0;
            for(int j=i+1;j<n;j++){
                int d = j-i;
                if((d & 1) ==0 ){
                    sum = sum + (a[j-1]*a[j]);
                    if(sum <= k){
                        count++;
                    }
                }else{
                    long tsum = sum + a[j];
                    if(tsum <= k){
                        count++;
                    }
                }

            }
         }
         System.out.println(count);
    }

}
