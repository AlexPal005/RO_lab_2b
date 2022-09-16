import java.util.concurrent.BlockingQueue;
public class Nechiporuk implements Runnable  {
    private int sum;
    private BlockingQueue queue_second;
    public Nechiporuk(BlockingQueue queue_second){
        this.queue_second = queue_second;
    }
    public synchronized void run() {
        int i = 0;
        try{
            Thread.sleep(1000);
            while(i < 10) {
                if (!queue_second.isEmpty()) {
                    System.out.println(Thread.currentThread().getName()+ " " +queue_second.poll() + " on");
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
