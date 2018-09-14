package zero;

import java.util.Scanner;

public class NextPermutation {

    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int T = Integer.parseInt(str);
        while(T>0) {
            T--;
            str = s.nextLine();
            int N = Integer.parseInt(str);
            str = s.nextLine();
            String[] str2 = str.split(" ");
            int i = N - 1;
            for (; i > 0; i--) {
                if (Integer.parseInt(str2[i]) > Integer.parseInt(str2[i - 1])) {
                    String temp = str2[i];
                    str2[i] = str2[i - 1];
                    str2[i - 1] = temp;
                    break;
                }
            }

            if (i == 0) {
                System.out.println(-1);
            } else {
                for (int j = i; i < N - 1; i++) {
                    if (Integer.parseInt(str2[i]) > Integer.parseInt(str2[i + 1])) {
                        String temp = str2[i];
                        str2[i] = str2[i + 1];
                        str2[i + 1] = temp;
                    }
                }
                for (int j = 0; j < N; j++) {
                    System.out.print(str2[j]);
                }
                System.out.println();
            }
        }
    }
}
