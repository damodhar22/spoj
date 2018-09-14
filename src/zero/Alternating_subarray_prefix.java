package zero;

import java.util.Scanner;

class Alternating_subarray_prefix {

    public static void  main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0){
            T--;
            int N = sc.nextInt();
            int a[] = new int[N];
            for(int i=0;i<N;i++){
                a[i] = sc.nextInt();
            }
            int dp[] = new int[N];

            dp[N-1] = 1;
            for(int i=N-2;i>=0;i--){
                if((a[i] >= 0 && a[i+1] < 0) || (a[i] < 0 && a[i+1] >= 0)){
                    dp[i] = dp[i+1] + 1;
                }else{
                    dp[i] = 1;
                }
            }

            for(int i=0;i<N;i++){
                System.out.print(dp[i]+" ");
            }
            System.out.println();
        }
    }

}
