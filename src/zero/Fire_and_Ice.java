package zero;

import java.util.Scanner;

class Main {

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        int T = Integer.parseInt(s);

        while(T > 0){
            T--;
            s = sc.nextLine().trim();
            String[] str = s.split(" ");
            int N = Integer.parseInt(str[0]);
            System.out.println(2*army(N));
        }
    }

    static int army(int sum){

        if(sum == 0){
            return 1;
        }else if(sum < 0){
            return 0;
        }else{
            int count = 0;
            for(int i=1;i<= sum;i+=2){
                count += army(sum-i);
            }
            return count;
        }
    }

}
