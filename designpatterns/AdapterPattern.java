package designpatterns;

/**
 * Created by sarkarri on 5/16/17.
 */
public class AdapterPattern {

}

class Volt {
    int volt;

    public Volt(int volt) {
        this.volt = volt;
    }

    public int getVolt() {
        return volt;
    }
}

class Socket {

    public Volt getVolt() {
        return new Volt(120);
    }
}

interface SocketAdapter {
    Volt get120Volt();

    Volt get12Volt();

    Volt get3Volt();
}

class SocketClassAdapterImpl extends Socket implements SocketAdapter {

    @Override
    public Volt get120Volt() {
        return getVolt();
    }

    @Override
    public Volt get12Volt() {
        return converter(getVolt(), 10);
    }

    @Override
    public Volt get3Volt() {
        return converter(getVolt(), 40);
    }

    private Volt converter(Volt volt, int divider) {
        return new Volt(volt.getVolt() / divider);
    }
}

class SocketAdapterImpl implements SocketAdapter {
    Socket socket = new Socket();

    @Override
    public Volt get120Volt() {
        return socket.getVolt();
    }

    @Override
    public Volt get12Volt() {
        return converter(socket.getVolt(), 10);
    }

    @Override
    public Volt get3Volt() {
        return converter(socket.getVolt(), 40);
    }

    private Volt converter(Volt volt, int divider) {
        return new Volt(volt.getVolt() / divider);
    }
}
