package threads;

import java.util.concurrent.CountDownLatch;

/**
 * Created by sarkarri on 6/1/17.
 */
public class CowntDownLatchExample {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        new Thread(new Waitor(latch), "watior").start();
        new Thread(new Decrementor(latch), "decrementor").start();
    }
}


class Waitor implements Runnable {

    CountDownLatch latch;

    Waitor(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Decrementor implements Runnable {
    CountDownLatch latch;

    Decrementor(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            System.out.println("count = " + latch.getCount());
            latch.countDown();
            //Thread.sleep(5_000);
            System.out.println("count = " + latch.getCount());
            latch.countDown();
            System.out.println("count = " + latch.getCount());
            latch.countDown();
            System.out.println("count = " + latch.getCount());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}