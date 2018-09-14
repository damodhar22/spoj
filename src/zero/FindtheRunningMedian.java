package zero;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class FindtheRunningMedian {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int al = a.length();
        int bl = b.length();

        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        Arrays.sort(ac);
        Arrays.sort(bc);
        int count = 0;
        int i=0,j=0;
        for(i=0,j=0;i<al&&j<bl;){
          if(ac[i]>bc[j]){
                j++;
                count++;
            }else if(ac[i]<bc[j]){
                i++;
                count++;
            }else{
                i++;
                j++;
            }
        }

        if(i<al){
            count+=(al-i);
        }else{
            count+=(bl-j);
        }
        System.out.println(count);
    }
}
