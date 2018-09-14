package zero;

public class DetectCycleLinkedList {

    class Node {
        int data;
        Node next;
    }

    boolean hasCycle(Node head) {
        boolean flag = false;
        Node tNode = head;
        Node tNode2 = head;
        int count = 1;
        while (true) {
            if (tNode == null || tNode2 == null) {
                break;
            } else {
                if (count % 2 == 0) {
                    tNode2 = tNode2.next;
                }
                tNode = tNode.next;
                if (tNode == tNode2) {
                    flag = true;
                    break;
                }
                ++count;
            }
        }
        return flag;
    }

}
