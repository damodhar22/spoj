package zero;

import java.util.Scanner;

public class SherlockAndTheGrid {

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int T = Integer.parseInt(s);

        while(T-->0){
            int n = Integer.parseInt(sc.nextLine());
            boolean[][] a = new boolean[n][n];

            for(int i=0;i<n;i++){
                s = sc.nextLine().trim();
                String[] str = s.split("");
                for(int j=0;j<str.length;j++){
                    if(".".equals(str[j])){
                        a[i][j] = true;
                    }
                }
            }

            boolean[][] dpR = new boolean[n][n];
            boolean[][] dpC =  new boolean[n][n];

            for(int i=0;i<n;i++){
                if(a[i][n-1])
                    dpR[i][n-1] = true;
            }

            for(int i=0;i<n;i++){
                if(a[n-1][i])
                    dpC[n-1][i] = true;
            }

            for(int i=0;i<n;i++){
                for(int j=n-2;j>=0;j--){
                    dpR[i][j] = dpR[i][j+1] && a[i][j];
                    if (!dpR[i][j]) {
                        break;
                    }
                }
            }

            for(int i=0;i<n;i++){
                for(int j=n-2;j>=0;j--){
                    dpC[j][i] = dpC[j+1][i] && a[j][i];
                    if (!dpC[j][i]) {
                        break;
                    }
                }
            }

            int count = 0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if (dpR[i][j] && dpC[i][j]) {
                        count++;
                    }
                }
            }

            System.out.println(count);
        }

    }

}
