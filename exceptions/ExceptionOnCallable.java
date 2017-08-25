package exceptions;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by sarkarri on 7/13/17.
 */
public class ExceptionOnCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService ex = Executors.newFixedThreadPool(2);

        Future f = ex.submit(new Callable<Runnable>() {
            @Override
            public Runnable call() throws Exception {
                throw new RDFileConversionException("Snowbound decompress operation failed!!");
                //return null;
            }
        });
        try {
            System.out.println(f.get());
        } catch (InterruptedException | ExecutionException e) {
            // This will never happen as Callable has a top level try catch! #badCode
            System.out.println("Exception occurred" + e.getMessage());
        }


        ex.shutdownNow();
    }
}

class RDFileConversionException extends RuntimeException{

    private String message;

    private Throwable cause;

    public RDFileConversionException() { super(); }

    public RDFileConversionException(String message) {
        super(message);
        this.message = message;
    }

    public RDFileConversionException(Throwable cause) {
        super(cause);
        this.cause = cause;
    }

    public RDFileConversionException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
        this.cause = cause;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public Throwable getCause() {
        return cause;
    }

    public void setCause(Throwable cause) {
        this.cause = cause;
    }
}
