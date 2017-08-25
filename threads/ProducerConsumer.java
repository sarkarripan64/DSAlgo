package threads;

/**
 * Created by sarkarri on 2/4/17.
 */
public class ProducerConsumer {
    public static void main(String[] args) {
        ShareResource sr = new ShareResource();
        new Producer(sr);
        new Consumer(sr);
    }
}


class Producer implements Runnable {
    ShareResource sr;

    Producer(ShareResource sr) {
        this.sr = sr;
        Thread p = new Thread(this, "producer");
        p.start();
    }


    @Override
    public void run() {
        int i = 0;
        while (i < 100) {
            sr.produce(++i);
        }
    }

}

class Consumer implements Runnable {
    ShareResource sr;

    Consumer(ShareResource sr) {
        this.sr = sr;
        Thread c = new Thread(this, "Consumer");
        c.start();
    }


    @Override
    public void run() {
        while (true) {
            sr.consume();
        }
    }
}

class ShareResource {
    int data;
    volatile boolean available;

    public synchronized void produce(int data) {
        try {
            if (available) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.data = data;
        System.out.println(Thread.currentThread().getName() + " producing " + this.data);
        available = true;
        notify();
    }

    public synchronized void consume() {
        try {
            if (!available) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " Consuming " + this.data);
        available = false;
        notify();
    }
}