package zero;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayAndMagicValue {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int size = Integer.parseInt(str);
        int []a= new int[size];
        str = s.nextLine();
        String[] strs = str.trim().split("\\s+");

        for (int i = 0; i < strs.length; i++) {
            a[i] = Integer.parseInt(strs[i]);
        }
        int b[] = a.clone();

        Arrays.sort(b);
        long gSum = 0;
        long bSum = 0;

        for(int i=0;i<size;i++){

            if(a[i] == b[i]){
              gSum+=a[i];
            }else{
                bSum+=a[i];
            }
        }
       System.out.println(gSum-bSum);
    }
}
