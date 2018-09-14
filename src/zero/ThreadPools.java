package zero;

import java.util.Comparator;
import java.util.concurrent.*;

class Task implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            System.out.println(i);
        }
    }
}



public class ThreadPools {

    public static void main(String args[]){

        Callable c= ()->{
            return null;
        };

        ScheduledExecutorService executorService = Executors
                .newSingleThreadScheduledExecutor();

        Future<String> resultFuture =
                executorService.schedule(c, 1, TimeUnit.SECONDS);

        Task t = new Task();
        new Thread(t).start();
        new Thread(t).start();

    }

}
