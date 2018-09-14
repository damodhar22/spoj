package zero;

import java.util.Scanner;

public class BobAndForest {
    static long count[] = new long[1001];
        static void subMatrix(int a[][])
        {
            //int i,j;
            int R = a.length;
            int C = a[0].length;
            int b[][] = new int[R][C];

            int max_of_s, max_i, max_j;

            for(int i = 0; i < R; i++)
                b[i][0] = a[i][0];

            for(int j = 0; j < C; j++)
                b[0][j] = a[0][j];

            for(int i = 1; i < R; i++)
            {
                for(int j = 1; j < C; j++)
                {
                    if(a[i][j] == 1)
                        b[i][j] = Math.min(b[i][j-1],Math.min(b[i-1][j], b[i-1][j-1])) + 1;
                    else
                        b[i][j] = 0;
                }
            }

            for(int i = 0; i < R; i++)
            {
                for(int j = 0; j < C; j++) {
                    count[b[i][j]] += 1;
                }
                }

                for (int i=999;i>0;i--){
                count[i] += count[i+1];
                }

                for(int i=2;i<=1000;i++){
                    count[i] += count[i-1];
                }
        }

        public static void main(String[] args)
        {

            Scanner s = new Scanner(System.in);
            String str = s.nextLine();
            String[] str2 = str.split(" ");
            int N = Integer.parseInt(str2[0]);
            int M = Integer.parseInt(str2[1]);
            int a[][] = new int[N][M];
            for(int i=0;i<N;i++){
                str = s.nextLine();
                char [] c= str.toCharArray();
                for(int j=0;j<c.length;j++){
                    if(c[j]=='*'){
                        a[i][j] = 1;
                    }else{
                        a[i][j] = 0;
                    }
                }

            }

            subMatrix(a);
             str = s.nextLine();
            int q = Integer.parseInt(str);

            while(q>0){
                q--;
                str = s.nextLine();
                System.out.println(count[Integer.parseInt(str)]);
            }

        }

    }
