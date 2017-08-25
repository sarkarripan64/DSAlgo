package designpatterns;


import net.jcip.annotations.ThreadSafe;

import java.io.Serializable;

/**
 * Created by sarkarri on 2/4/17.
 */
@ThreadSafe
public class SingletonPattern implements Serializable {
    private static  volatile SingletonPattern _instance;

    private SingletonPattern() {
        if (SingletonPattern._instance != null) {
            throw new InstantiationError("Creating of this object is not allowed.");
        }
    }


    public static SingletonPattern get_instance() {
//        if (_instance == null) {
//            synchronized (SingletonPattern.class) {
//                if (_instance == null) {
//                    return new SingletonPattern();
//                }
//            }
//        }

        return SingletonHelper._instance;
    }

    protected Object readResolve() {
        return get_instance();
    }

    private static class SingletonHelper{
        public static final SingletonPattern _instance = new SingletonPattern();
    }

}
