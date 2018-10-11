package zero;

import java.util.Scanner;

public class DIV_Divisors {

    public static void main(String args[]){

        int[] a = new int[1000000+1];
        int[] b = new int[1000000+1];

        // no distinct prime factors
        for (int i=1;i<=1000000;i++){
            int res = 1;
            int n = i;
            int c = 0;
            for (int j=2;j*j<=n;j++){
                int count = 0;
                if(n%j==0){
                    c++;
                    while(n%j==0){
                        count++;
                        n = n/j;
                    }
                    res *= (count+1);
                }
            }
            if(n>1){
                c++;
                res *= 2;
            }
            if(c==2)
            a[i] = res-2;
        }

        // no of divisors
        for(int i=1;i<=1000000;i++){
            for(int j=i;j<=1000000;j+=i){
             b[j]++;
            }
        }

        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=1000000;i++){
            if(a[b[i]] == 2){
                count++;
                if(count%9 == 0)
                    sb.append(i+"\n");
            }
        }
    }

}
