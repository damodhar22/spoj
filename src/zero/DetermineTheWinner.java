package zero;

import java.util.Scanner;

public class DetermineTheWinner {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int t =Integer.parseInt(str);
        while(t>0) {
            t--;
            str = s.nextLine();
            String str2[] = str.split(" ");
            int s_p = Integer.parseInt(str2[0]);
            int s_q = Integer.parseInt(str2[1]);
            int s_r = Integer.parseInt(str2[2]);
            int s_s = Integer.parseInt(str2[3]);
            str = s.nextLine();
            str2 = str.split(" ");
            int d_p = Integer.parseInt(str2[0]);
            int d_q = Integer.parseInt(str2[1]);
            int d_r = Integer.parseInt(str2[2]);
            int d_s = Integer.parseInt(str2[3]);
            str = s.nextLine();
            str2 = str.split(" ");
            int f_p = Integer.parseInt(str2[0]);
            int f_q = Integer.parseInt(str2[1]);
            int f_r = Integer.parseInt(str2[2]);
            int f_s = Integer.parseInt(str2[3]);
            int f_max = Math.max(f_p, Math.max(f_q, Math.max(f_r, f_s)));
            str = s.nextLine();
            str2 = str.split(" ");
            int c_p = Integer.parseInt(str2[0]);
            int c_q = Integer.parseInt(str2[1]);
            int c_r = Integer.parseInt(str2[2]);
            int c_s = Integer.parseInt(str2[3]);
            int c_max = Math.max(c_p, Math.max(c_q, Math.max(c_r, c_s)));

            long f_score = 0;
            f_score = f_score + ((s_p - (long)f_p * d_p)<s_p/2 ? s_p/2:(s_p - (long)f_p * d_p));
            f_score = f_score + ((s_q - (long)f_q * d_q)<s_q/2 ? s_q/2:(s_q - (long)f_q * d_q));
            f_score = f_score + ((s_r - (long)f_r * d_r)<s_r/2 ? s_r/2:(s_r - (long)f_r * d_r));
            f_score = f_score + ((s_s - (long)f_s * d_s)<s_s/2 ? s_s/2:(s_s - (long)f_s * d_s));

            long c_score = 0;
            c_score = c_score + ((s_p - (long)c_p * d_p)<s_p/2 ? s_p/2:(s_p - (long)c_p * d_p));
            c_score = c_score + ((s_q - (long)c_q * d_q)<s_q/2 ? s_q/2:(s_q - (long)c_q * d_q));
            c_score = c_score + ((s_r - (long)c_r * d_r)<s_r/2 ? s_r/2:(s_r - (long)c_r * d_r));
            c_score = c_score + ((s_s - (long)c_s * d_s)<s_s/2 ? s_s/2:(s_s - (long)c_s * d_s));

//            System.out.println("f_score"+f_score);
//            System.out.println("f_max"+f_max);
//            System.out.println("c_score"+c_score);
//            System.out.println("c_max"+c_max);

            if (f_score > c_score) {
                System.out.println("Flash");
            } else if (c_score > f_score) {
                System.out.println("Cisco");
            } else if (f_max > c_max) {
                System.out.println("Cisco");
            } else if (c_max > f_max) {
                System.out.println("Flash");
            } else {
                System.out.println("Tie");
            }
        }

    }

}
