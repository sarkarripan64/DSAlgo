package threads;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarkarri on 5/10/17.
 */
public class PCSharedQueue {
    public static void main(String[] args) {
        List<Integer> q = new ArrayList<>();
        ProducerQ pr = new ProducerQ(q);
        ConsumerQ cr = new ConsumerQ(q);

        Thread p = new Thread(pr);
        Thread c = new Thread(cr);
        p.start();
        c.start();
    }
}

class ProducerQ implements Runnable {
    List<Integer> sharedQ;

    ProducerQ(List<Integer> sharedQ) {
        this.sharedQ = sharedQ;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            produce(i);
        }
    }

    public void produce(int i) {
        synchronized (sharedQ) {
            if (sharedQ.size() == 2) {
                try {
                    System.out.println("Queue is full, producerThread is waiting for "
                            + "consumerThread to consume, sharedQueue's size= ");
                    sharedQ.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        synchronized (sharedQ) {
            sharedQ.add(i);
            System.out.println("produced " + i);
            sharedQ.notify();
        }
    }
}

class ConsumerQ implements Runnable {
    List<Integer> sharedQ;

    ConsumerQ(List<Integer> sharedQ) {
        this.sharedQ = sharedQ;
    }

    @Override
    public void run() {
        while (true) {
            consume();
        }
    }

    public void consume() {
        synchronized (sharedQ) {
            if (sharedQ.isEmpty()) {
                try {
                    System.out.println("queue is empty");
                    sharedQ.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        synchronized (sharedQ) {
            System.out.println("consumed " + sharedQ.remove(0));
            sharedQ.notify();
        }
    }
}
