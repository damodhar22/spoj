package zero;

import java.util.Arrays;
import java.util.Scanner;

public class SnakeEating {

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while(T>0){
            T--;
            int n = sc.nextInt();
            int q = sc.nextInt();
            int a[] = new int[n];
            for(int i=0;i<n;i++){
                a[i] = sc.nextInt();
            }
            Arrays.sort(a);

            while(q>0){
                q--;
                int length = sc.nextInt();

                int rem = n-1;
                int count = 0;
                for(int i=n-1;i>0;i--){
                    if(a[i] >= length){
                        count++;
                        rem--;
                    }else{
                        break;
                    }
                }

                int left = rem;

                while(true && left > 0 && rem >= 0){
                    if((length - a[rem]) <= left){
                        left = length - a[rem] - 1;
                        rem--;
                        count++;
                    }else{
                        break;
                    }
                }

                System.out.println(count);

            }
        }

    }

}
