package zero;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Bugs {
    public static void main(String args[]){
    Scanner s = new Scanner(System.in);
    String str = s.nextLine();
    int t =Integer.parseInt(str);
        int size = 0;
        Integer a[] = new Integer[t];
        Arrays.fill(a,0);
        while(t>0){
        t--;
        str = s.nextLine();
        String str2[] = str.split(" ");
            String k = str2[0];
        if("2".equals(k)){
            int bug = size/3;
            if(bug == 0){
                System.out.println("Not enough enemies");
            }else{
                Arrays.sort(a, Collections.reverseOrder());
                System.out.println(a[bug-1]);
            }
        }else{
            a[size] = new Integer(str2[1]);
            size++;
        }
    }
    }
}
