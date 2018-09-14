package zero;

public class DeadLockExample implements Runnable {

    private static DeadLockExample friend1;
    static DeadLockExample friend2;
    String name;

    DeadLockExample(String name) {
        this.name = name;
    }

    public static void main(String args[]) {
        friend1 = new DeadLockExample("f1");
        friend2 = new DeadLockExample("f2");
        Thread t1 = new Thread(friend1);
        Thread t2 = new Thread(friend2);
        t1.start();
        t2.start();
    }

    synchronized void bow(DeadLockExample friend) {
        System.out.println(this.name+" bows to"+friend.name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        friend.bowBack(this);
    }

    synchronized void bowBack(DeadLockExample friend){
        System.out.println(this.name+" bows back to"+friend.name);
    }

    @Override
    public void run() {
        friend1.bow(friend2);
        friend2.bow(friend1);
    }
}
