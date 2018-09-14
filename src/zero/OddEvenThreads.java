package zero;

public class OddEvenThreads implements Runnable{

    int count=0;

    public static void main(String args[]){

        OddEvenThreads task = new OddEvenThreads();

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

    }

    @Override
    public void run() {
       // while(count<=10) {
            print();
       // }
    }

    synchronized void print() {
        if((count & 1) == 0){
            while(count <= 10){
                System.out.println(count+":"+Thread.currentThread());
                count++;
                try {
                    notify();
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }else{
            while(count <= 10){
                System.out.println(count+":"+Thread.currentThread());
                count++;
                try {
                    notify();
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


