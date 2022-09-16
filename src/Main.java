import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
public class Main {
    private static BlockingQueue queuefirst;
    private static  BlockingQueue queuesecond;

    public static void main(String[] args) {
        Main main = new Main();
        main.queuefirst = new ArrayBlockingQueue(1);
        main.queuesecond = new ArrayBlockingQueue(1);
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        Ivanov ivanov = new Ivanov(queuefirst, arr);
        Thread t1 = new Thread(ivanov);
        Petrov petrov = new Petrov(queuefirst, queuesecond);
        Thread t2 = new Thread(petrov);
        Nechiporuk nechiporuk = new Nechiporuk(queuesecond);
        Thread t3 = new Thread(nechiporuk);
        t1.start();
        t2.start();
        t3.start();
    }
}
