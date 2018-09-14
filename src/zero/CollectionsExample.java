package zero;

import java.util.*;
import java.util.concurrent.*;

public class CollectionsExample {

    public static  void main(String args[]){

        Hashtable htab = new Hashtable();

        htab.put(1,"a");

        htab.entrySet();

        htab.remove(1);

        Vector v = new Vector();
        v.add("A");

        TreeSet tset = new TreeSet();

        tset.add(1);

        //red black tree implementation
        TreeMap tmap = new TreeMap();
        tmap.put(1,"A");

        ConcurrentSkipListSet conset = new ConcurrentSkipListSet();

        conset.add("A");

        ConcurrentSkipListMap conmap = new ConcurrentSkipListMap();

        conmap.put(1,"aa");

        //uses hash table internally
        HashSet hset = new HashSet();

        hset.add("a");

        //uses copyonwritearraylis internally
        CopyOnWriteArraySet cset = new CopyOnWriteArraySet();

        cset.add("A");

        ConcurrentHashMap conMap = new ConcurrentHashMap();

        conMap.put(1,"a");

        HashMap hmap = new HashMap();

        hmap.put(1,"a");

        LinkedHashMap lmap = new LinkedHashMap();

        lmap.put(1,"a");

        lmap.entrySet();

        //this uses vector below
        Stack s = new Stack();

        s.push("a");

        ArrayList al = new ArrayList();

        //default capacity 10 grows 50% size
        al.add("A");
        al.get(0);

        //get firt and get last are extra methods
        LinkedList ll = new LinkedList();
        ll.add("aa");
        ll.get(0);
        ll.peek();
        ll.poll();
        ll.push("bb");
        ll.pop();
        ll.iterator();
        ll.listIterator();

        CopyOnWriteArrayList cl = new CopyOnWriteArrayList();

        cl.add("Aa");
        cl.remove(1);

        Iterator it = cl.iterator();

        it.remove();

    }

}
