package zero;

import java.util.Scanner;

public class EvenLengthPalindrome {
    public  static void main(String args[]){

        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int T = Integer.parseInt(str);
        while(T > 0){
            T--;
            str = s.nextLine();
            long N = Long.parseLong(str);
            long[] a =  new long[10];
            long count = 0;
            int no = 10;
            int length = new String(N+"").length();
            length = length/2;
            while(N>0){
                int t = (int)(N%10);
                N = N/10;

                a[t] += 1;

                if(count < a[t]){
                    count = a[t];
                    no = t;
                }else if( count == a[t] && t < no){
                    no = t;
                }
                if(count > length){
                    break;
                }
            }
        System.out.println(no);

        }

    }
}
