package zero;

import java.util.Scanner;

public class ByteToBit {

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T-->0){

            int n = sc.nextInt();

            int type = 1;

            int bitCount = 1;
            int nibbleCount = 0;
            int byteCount = 0;

            while(n>0){
                if(type == 1){
                    if(n-3>=0){
                        n -= 3;
                        nibbleCount = bitCount;
                        bitCount = 0;
                        type = 2;
                    }else{
                        break;
                    }
                }else if(type == 2){
                    if(n-9>=0){
                        n -= 9;
                        byteCount = nibbleCount;
                        nibbleCount = 0;
                        type = 3;
                    }else{
                        break;
                    }
                }else{
                    if(n-17>=0){
                        n -= 17;
                        bitCount = 2*byteCount;
                        byteCount = 0;
                        type = 1;
                    }else{
                        break;
                    }
                }
            }
            System.out.println(bitCount+" "+nibbleCount+" "+byteCount);
        }

    }

}
