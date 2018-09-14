package zero;

import java.util.Scanner;
import java.util.Stack;

class MyQueue<T>{

    Stack<T> stack1 = new Stack<T>();
    Stack<T> stack2 = new Stack<T>();

    public void enqueue(T t){
        stack1.push(t);
    }

    public T dequeue(){
        if(stack2.isEmpty()){
            copyToStack2();
        }
        if(!stack2.isEmpty()){
            return stack2.pop();
        }
        return null;
    }

    public T peek(){
        if(stack2.isEmpty()){
            copyToStack2();
        }
        if(!stack2.isEmpty()){
            return stack2.peek();
        }
        return null;
    }

    private void copyToStack2(){
       while(!stack1.isEmpty()){
           stack2.push(stack1.pop());
       }
    }
}

public class QueueUsingTwoStacks {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
