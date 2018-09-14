package zero;

import java.util.Scanner;

public class KSpecialCells {

    public static void main(String args[]){

        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int T = Integer.parseInt(str);

        while(T>0){
            T--;
            str = s.nextLine();
            String[] str2 = str.split(" ");
            int m = Integer.parseInt(str2[0]);
            int n = Integer.parseInt(str2[1]);
            int k = Integer.parseInt(str2[2]);
            int a[][] = new int[m+1][n+1];
            int c[][] = new int[m+1][n+1];
            c[1][1] = a[1][1];

            for(int i=0;i<k;i++){
                str = s.nextLine();
                str2 = str.split(" ");
                a[Integer.parseInt(str2[0])][Integer.parseInt(str2[1])] = Integer.parseInt(str2[2]);
            }

            for(int i=2;i<=m;i++){
                c[i][1] = a[i][1] + c[i-1][1];
            }

            for(int i=2;i<=n;i++){
                 c[1][i] = a[1][i] + c[1][i-1];
            }

            for(int i=2;i<=m;i++){
                for(int j=2;j<=n;j++){
                    c[i][j] = a[i][j] + c[i-1][j] + c[i][j-1];
                }
            }

            System.out.println(c[m][n]);

        }

    }

}
