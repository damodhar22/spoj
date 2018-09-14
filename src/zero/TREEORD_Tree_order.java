package zero;

import java.util.Scanner;

public class TREEORD_Tree_order {

    static int Cek(int[] pre, int[] post, int[] in, int n,int preIdx,int postIdx,int inIdx)
    {    if(pre[0] != post[n - 1]) return 0;

        if(n == 1)
            if(pre[0] == post[0] && post[0] == in[0]) return 1;
            else return 0;

        int i;
        for(i = 0; i < n; i++)
            if(in[i] == pre[0]) break;

        if(i == n) return 0;

        int j, result = 1, post_r = post[n - 2], leftn = 0;

        for(j = 0; j < n; j++)
            if(pre[j] == post_r)
            {    if((result *= Cek(pre , post , in, n - j,j,j-1,i+1)) == 0) return 0;
                leftn = j - 1;
                break;
            }

        if(i != 0) result *= Cek(pre, post, in, leftn,1,0,1);

        return result;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int pre[] = new int[n];
        int post[] = new int[n];
        int in[] = new int[n];

        for(int i = 0; i < n; i++) pre[i] = sc.nextInt();
        for(int i = 0; i < n; i++) post[i] = sc.nextInt();
        for(int i = 0; i < n; i++) in[i] = sc.nextInt();

        if(Cek(pre, post, in, n,0,0,0)==1)
            System.out.println("yes");
        else
            System.out.println("no");
    }
}