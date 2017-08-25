package designpatterns;

import java.io.Serializable;

/**
 * Created by sarkarri on 5/15/17.
 */
public class BillPughSingleton implements Serializable {
    private BillPughSingleton() {
    }

    private static final long SERIAL_VERSION_UID = -7604766932017737115L;

    private static class SingletonBuilder {
        private static final BillPughSingleton INSTANCEW = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return SingletonBuilder.INSTANCEW;
    }

    protected Object readResolve() {
        return getInstance();
    }
}
