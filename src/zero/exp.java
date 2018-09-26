package zero;

import oracle.jrockit.jfr.StringConstantPool;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.*;
import java.util.regex.Pattern;

public class exp {

   static int count =0;
   public static void main(String args[]){
      Scanner sc = new Scanner(System.in);
      int T = sc.nextInt();
      while(T>0){
         T--;
         int N = sc.nextInt();
         int K = sc.nextInt();
         int a[]=new int[N];
         int max = 0;
         for(int i=0;i<N;i++){
            a[i] = sc.nextInt();
         }
         System.out.println(rec(a,0, 0, K));
         System.out.println(count);
      }
   }

   static int rec(int a[],int i,int xor,int k){
      count++;
      if(i>=a.length){
         return k^xor;
      }
      return Math.max(rec(a,i+1,xor,k),rec(a,i+1,xor^a[i],k));
   }

}
