package zero;

import com.sun.java.swing.plaf.windows.WindowsInternalFrameTitlePane;

import java.util.Scanner;

public class StringOccursAsSubstring {

    static String a;
    static String b;

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        int T = Integer.parseInt(sc.nextLine().trim());

        while(T-->0){
            String line = sc.nextLine();
            String[] s = sc.nextLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            line = sc.nextLine();
            String[] s2 = sc.nextLine().trim().split(" ");
            a = s2[0];
            b = s2[1];
            System.out.println(recFun(0,0));
        }

    }

    static int recFun(int i,int j){

        if(i >= a.length() && j < b.length()){
                return 0;
        }

        if(j>=b.length())
            return 1;
        int count = 0;
        if(a.charAt(i) == b.charAt(j))
        count += recFun(i+1,j+1);

        count += recFun(i+1,j);

        return count;
    }


}
