package zero;

import oracle.jrockit.jfr.StringConstantPool;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.*;
import java.util.regex.Pattern;

public class exp {

   public static void main(String args[]) {

      long i = (1<<31)-1;
      int j = (1<<31)-1;
      double k = Math.pow(2,30);
      float f = Math.max(2,30);

      int m = (int)Math.pow(2,30);
      System.out.println(i+"\n"+j+"\n"+k+"\n"+f+"\n"+m);
   }
}
