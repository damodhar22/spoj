package zero;

import java.util.Arrays;
import java.util.Scanner;

public class BeautyOfArray {

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

        Arrays.sort(a);
        long sum = 0;
        for(int i=0;i<size-1;i++){
            for(int j=i+1;j<size;j++){
            sum+=(Math.pow(2,j-i-1)*(a[i]|a[j]));
            }
        }
        System.out.println(sum%1000000007);
    }


}
