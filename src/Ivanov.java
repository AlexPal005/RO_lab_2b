import java.util.concurrent.BlockingQueue;

public class Ivanov implements Runnable {
    private BlockingQueue queue;
    private int[] arr;
    private int i = 0;
    public Ivanov(BlockingQueue queue, int[] arr){
        this.queue = queue;
        this.arr = arr;
    }
    public synchronized void run() {
        try {
            while(i < arr.length) {
                if(queue.remainingCapacity() == 0) {
                    wait(1500);
                }
                else{
                    queue.put(arr[i]);
                    System.out.println(Thread.currentThread().getName()+ " " + arr[i] + "in");
                    i++;
                }
             }
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

    }
    public BlockingQueue curr_queue(){
        return this.queue;
    }
}
