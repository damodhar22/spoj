package zero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BACKPACK_DabOfBackpack {


    static int maxV;
    static Item[] list;
    static boolean vis[];
    static int[][] dp;

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T-->0){
            maxV = sc.nextInt();
            int n =  sc.nextInt();
            list = new Item[n+1];
            vis = new boolean[n+1];
            for(int i=1;i<=n;i++){
                int v = sc.nextInt();
                int c = sc.nextInt();
                int u = sc.nextInt();
                list[i] = new Item(v,c,u);
            }
            dp = new int[n+1][maxV+1];

            for(int i=0;i<=n;i++){
                Arrays.fill(dp[i],-1);
            }

            System.out.println(recFun(1,maxV));
        }
    }

    static int recFun(int i,int sum){

        if(i >= list.length || sum==0){
            return 0;
        }

        if(dp[i][sum] != -1)
            return dp[i][sum];

        Item item = list[i];
        Item item1 = null;
        int count = 0;
        int v = item.v;
        int c = item.v * item.c;
        if(item.u!=0 && !vis[item.u]){
            vis[item.u] = true;
            item1 = list[item.u];
            v +=  item1.v;
            c += item1.v * item1.c;
        }
        if(sum >= v && !vis[i]){
            vis[i] = true;
           count = c + recFun(i+1,sum - v);
            vis[i] = false;
        }

        if(item1!=null){
            vis[item.u] = false;
        }

        dp[i][sum] = Math.max(count,recFun(i+1,sum));
        return dp[i][sum];
    }


    static class Item{
        int v;
        int c;
        int u;

        Item(int v,int c,int u){
            this.v = v;
            this.c = c;
            this.u = u;
        }
    }


}
