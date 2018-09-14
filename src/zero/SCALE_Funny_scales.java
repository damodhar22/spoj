package zero;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SCALE_Funny_scales {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine().trim();

        int T = Integer.parseInt(str);

        while(T>0) {
            T--;
            str = sc.nextLine().trim();

            int count = 0;

            if(str.charAt(0)=='1'){
                count++;
            }

            for (int i = 1; i < str.length(); i++) {

                if(str.charAt(i)=='1' && str.charAt(i-1) != '1'){
                   count++;
                }
                if(count>1){
                    break;
                }

            }

            if(count==1){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

}
