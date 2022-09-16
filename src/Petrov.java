import java.util.concurrent.BlockingQueue;

public class Petrov implements Runnable {
    private BlockingQueue queue_first;
    private BlockingQueue queue_second;
    public Petrov(BlockingQueue queue, BlockingQueue queue_second){
        this.queue_first = queue;
        this.queue_second = queue_second;
    }
    public synchronized void run() {
        int i = 0;
        try{
            Thread.sleep(2000);
            while(i < 10) {
                if (!queue_first.isEmpty()) {
                    if(queue_second.remainingCapacity() == 0) {
                        wait(50);
                    }
                    else{
                        System.out.println(Thread.currentThread().getName()+ " " + queue_first.element() + " read");
                        queue_second.put(queue_first.poll());
                    }
                    i++;
                } else {
                    wait(50);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
