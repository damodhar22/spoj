package zero;

import oracle.jrockit.jfr.StringConstantPool;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.*;
import java.util.regex.Pattern;

public class exp {


   public static void main(String args[]) {

      int[] a = {4,4,4,4};

      System.out.println(lowBound(a,2,0,a.length-1));
      System.out.println(highBound(a,3,0,a.length-1));

   }

   static int lowBound(int l[],int x,int low,int high){

      int i = -1;
      while(low<=high){
         int mid = low + ((high-low)/2);
         if((mid-1 < 0 ||  l[mid-1]< x) && l[mid] >= x) {
            i = mid;
            break;
         }
         if(l[mid]>=x){
            high = mid - 1;
         }else{
            low = mid + 1;
         }

      }
      return i;
   }

   static int highBound(int l[],int x,int low,int high){
      int n = high;
      int i = -1;
      while(low<=high){
         int mid = low + ((high-low)/2);
         if((mid+1 > high ||  l[mid+1]> x) && l[mid] <= x) {
            i = mid;
            break;
         }
         if(l[mid]>x){
            high = mid - 1;
         }else{
            low = mid + 1;
         }

      }
      return i;
   }


}