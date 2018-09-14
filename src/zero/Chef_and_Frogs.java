package zero;

import java.util.Scanner;

public class Chef_and_Frogs {

//    Input:
//            5 3 3
//            0 3 8 5 12
//            1 2
//            1 3
//            2 5
//
//    Output:
//    Yes
//    Yes
//    No

    public static void manin(String args[]){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int P = sc.nextInt();

        int a[] = new int[N];

        for(int i=0;i<N;i++){
            a[i] = sc.nextInt();
        }
        int[][] pairs = new int[P][2];
        boolean dp[][] = new boolean[N][N];
        int k = 0;
        while(k<P){
            int i = sc.nextInt();
            int j = sc.nextInt();
            if(i>j){
                pairs[k][0] = j;
                pairs[k][1] = i;
            }else{
                pairs[k][0] = i;
                pairs[k][1] = j;
            }
            k++;
        }
    }

    static void rec(int a[],int start,int end,boolean[][] dp,int k){

        if(Math.abs(a[start]-a[end])<= k ){
            dp[start][end] = true;
            dp[end][start] = true;
        }

        for(int i=start;i<a.length-1;i++){

        }
    }
}
