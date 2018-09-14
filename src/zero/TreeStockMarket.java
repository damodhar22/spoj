package zero;

import com.sun.imageio.plugins.common.I18N;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Node{
    int no;
    Map<Integer,Integer> map;
    int weight;
}

public class TreeStockMarket {

    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        String[] strs = str.trim().split("\\s+");
        int N = Integer.parseInt(strs[0]);
        int Q = Integer.parseInt(strs[1]);
        Map<Integer,List<Node>> map = new HashMap<Integer, List<Node>>();
        Node n = new Node();
        while(N>0){
            N--;
            str = s.nextLine();
            strs = str.trim().split("\\s+");
            int a = Integer.parseInt(strs[0]);
            int b = Integer.parseInt(strs[1]);
            if(map.containsKey(a)){
                List<Node> l = map.get(a);
               // n = new Node;
            }

        }

    }

}

