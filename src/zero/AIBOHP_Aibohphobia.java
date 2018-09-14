package zero;

import java.util.Scanner;

public class AIBOHP_Aibohphobia {

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        int T = Integer.parseInt(s);
        while(T>0){
            T--;
            s = sc.nextLine();
            int dp[][];
            System.out.println(rec(s,0,s.length()-1));
        }

    }

    static int dpRec(String s){
        int[][] dp = new int[s.length()][s.length()];

        return 0;
    }

    static int rec(String s,int i,int j){
        if(i==j){
            return 0;
        }
        if(s.charAt(i) == s.charAt(j)){
            return rec(s,i+1,j-1);
        }
        else{
            return 1+ Math.min(rec(s,i,j-1),rec(s,i+1,j));
        }
    }

}
