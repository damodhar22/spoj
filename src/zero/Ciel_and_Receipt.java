package zero;

import java.util.Scanner;

public class Ciel_and_Receipt {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] a = {1,2,4,8,16,32,64,128,256,512,1024,2048};
        while(T>0){
            T--;
            int count = 0;
            int P = sc.nextInt();
            for(int i=a.length-1;i>=0;){
                if(P == 0){
                  break;
                }else if(P >= a[i]){
                    P -= a[i];
                    count++;
                }else{
                    i--;
                }
            }
            System.out.println(count);
        }
    }

}
