package threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by sarkarri on 6/1/17.
 */
public class CyclicBarrierExample {
    public static void main(String[] args) {
        Runnable r1 = () -> System.out.println("running BarrierAction1");
        Runnable r2 = () -> System.out.println("running BarrierAction2");
        CyclicBarrier cb1 = new CyclicBarrier(2, r1);
        CyclicBarrier cb2 = new CyclicBarrier(2, r2);
        CyclicBarrierRunner cbr1 = new CyclicBarrierRunner(cb1, cb2);
        CyclicBarrierRunner cbr2 = new CyclicBarrierRunner(cb1, cb2);
        new Thread(cbr1).start();
        new Thread(cbr2).start();
    }
}


class CyclicBarrierRunner implements Runnable {

    CyclicBarrier cb1;
    CyclicBarrier cb2;

    public CyclicBarrierRunner(CyclicBarrier cb1, CyclicBarrier cb2) {
        this.cb1 = cb1;
        this.cb2 = cb2;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() +
                    " waiting at barrier 1");
            this.cb1.await();

            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() +
                    " waiting at barrier 2");
            this.cb2.await();

            System.out.println(Thread.currentThread().getName() +
                    " done!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

