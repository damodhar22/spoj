package zero;

import java.util.Arrays;
import java.util.Scanner;

public class Maximum_Weight_Difference {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T =  sc.nextInt();
        int N = sc.nextInt();
        int K = sc.nextInt();
        int a[] = new int[N];
        int sum = 0;
        for(int i=0;i<N;i++){
            a[i] = sc.nextInt();
            sum += a[i];
        }
        Arrays.sort(a);
        int firstK = 0;
        for(int i=0;i<K;i++){
            firstK += a[i];
        }

        int lastK = 0;
        for(int i=N-1;i>=N-K;i++){
            lastK += a[i];
        }
    }

}
