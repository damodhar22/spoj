package zero;

import java.util.Scanner;

public class BobCitiesTwoDArray {
    public static  void main(String args[]){
        Scanner s= new Scanner(System.in);
        String str = s.nextLine();
        String[] sA = str.split(" ");
        int n = Integer.parseInt(sA[0]);
        int m = Integer.parseInt(sA[1]);
        char a[][]= new char[n][m];
        for(int i=0;i<n;i++){
                 str = s.nextLine();
                a[i]=str.toCharArray();
        }
        int l = s.nextInt();
        int r = s.nextInt();
        int u = s.nextInt();
        int d = s.nextInt();
        int row = s.nextInt()-1;
        int col = s.nextInt()-1;
        int t = s.nextInt();
        while(t>0){
            t--;
            long cost = s.nextLong();
            long b[][]=new long[n][m];
           System.out.println(sum(row, col, b,cost, l, r, u, d, n, m,a));
            System.out.println();
        }
    }

    static int sum(int row,int col,long[][] b,long cost,int l,int r,int u,int d,int n,int m,char a[][]){
        if(row<0||row>=n||col<0||col>=m){
            return 0;
        }
        int sum=1;
        if(b[row][col]>=1 && cost > b[row][col]){
            sum=0;
            b[row][col]=cost;
        }else if(b[row][col]>=1 && cost <= b[row][col]){
           return 0;
        }else{
            b[row][col]=cost;
        }

        if(col-1>=0 && a[row][col-1] != '#' && cost>=l){
            sum+=sum(row,col-1,b,cost-l,l,r,u,d,n,m,a);
        }
        if(col+1<m && a[row][col+1] != '#' &&cost>=r){
            sum+=sum(row,col+1,b,cost-r,l,r,u,d,n,m,a);
        }
        if(row-1>=0 && a[row-1][col]!='#' && cost>=u){
            sum+=sum(row-1,col,b,cost-u,l,r,u,d,n,m,a);
        }
        if(row+1<n && a[row+1][col]!='#' && cost>=d){
            sum+=sum(row+1,col,b,cost-d,l,r,u,d,n,m,a);
        }
        return sum;
    }
}
