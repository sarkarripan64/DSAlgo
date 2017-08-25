package threads;

import java.text.SimpleDateFormat;
import java.util.concurrent.*;

/**
 * Created by sarkarri on 3/23/17.
 */
public class InterruptingRunningThread {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");

    public static void main(String[] args) {
        new InterruptingRunningThread().testInterruptThread();
    }

    public void testInterruptThread() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        int i = 0;
        while (i < 10000) {
            Future<String> future = executorService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    //rimRabbitTemplate.convertAndSend(rimQueueName, message);
                    System.out.println("some time intensive task " + Thread.currentThread().getName());
                    Thread.sleep(10_000);
                    return "published successfully";
                }
            });

            try {
                System.out.println("Started..at  " + sdf.format(System.currentTimeMillis()));
                System.out.println(future.get(1, TimeUnit.SECONDS));
                //System.out.println(future.get());
                System.out.println("Finished! " + System.currentTimeMillis());
            } catch (TimeoutException e) {
                future.cancel(true);
                System.out.println("Terminated! " + future.isCancelled() + " time " + sdf.format(System.currentTimeMillis()));
                //e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println("i== " + i);
            i++;
            System.out.println("=================================");
        }

        executorService.shutdownNow();
    }
}
