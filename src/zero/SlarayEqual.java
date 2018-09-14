package zero;

import java.util.Scanner;

public class SlarayEqual
{
    public static void main(String args[]){

        Scanner s = new Scanner(System.in);

        String str = s.nextLine();
        int T = Integer.parseInt(str);

        while(T>0){
            T--;
            str = s.nextLine();
            int N = Integer.parseInt(str);
            int a[] = new int[N];
            str = s.nextLine();
            String[] str2=str.split(" ");
            for(int i=0;i<N;i++){
                  a[i] =  Integer.parseInt(str2[i]);
            }
            int ops = 0;
            for(int i=0;i<N;i++){

                if(i-1 >= 0){
                    while(a[i] > a[i-1]){
                        fun(a,i);
                        print(a);
                        ops++;
                    }
                }
                if(i+1<N){
                    while(a[i] > a[i+1]){
                        fun(a,i);
                        print(a);
                        ops++;
                    }
                }
            }
            System.out.println(ops);
        }
    }

    static void fun(int[] a,int j){

        for(int i=0;i<a.length;i++){
            if(i!=j){
                a[i] +=1;
            }
        }

    }

    static void print(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+"---");
        }
        System.out.println("---");
    }
}

