package threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sarkarri on 6/1/17.
 */
public class ReenrantLockExample {
    public static void main(String[] args) {
        LockingClass lc = new LockingClass(new SharedResource());
        new Thread(lc).start();
    }
}


class LockingClass implements Runnable {
    SharedResource sharedResource;
    Lock lock;

    LockingClass(SharedResource sr) {
        sharedResource = sr;
        lock = new ReentrantLock();
    }

    @Override
    public void run() {
        try {
            lock.tryLock(10, TimeUnit.SECONDS);
            sharedResource.doOperation();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        sharedResource.logging();

    }
}

class SharedResource {
    public void doOperation() {
        System.out.println("sensitive operation");
    }

    public void logging() {
        System.out.println("logging operation");
    }
}