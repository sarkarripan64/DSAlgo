package designpatterns;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sarkarri on 2/4/17.
 */
public class SingleTonTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, ClassNotFoundException {
        SingletonPattern sp = SingletonPattern.get_instance();
        Class c = Class.forName("designpatterns.SingletonPattern");
        Constructor<?>[] cons = c.getDeclaredConstructors();
        //for (Constructor constructor : cons) {
        Constructor constructor = cons[1];
            System.out.println("constructor "+constructor);
            constructor.setAccessible(true);
            SingletonPattern sp1 = (SingletonPattern) constructor.newInstance();
            System.out.println(sp.hashCode());
            System.out.println(sp1.hashCode());
        //}
        System.out.println("serial ");

        Map map = new HashMap();
        //serialTest();
        SingleTonTest st=null;
        st.serialTest();
    }

    static void serialTest() throws IOException, ClassNotFoundException {
        SingletonPattern sp = SingletonPattern.get_instance();
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("sample.txt"));
        out.writeObject(sp);
        out.flush();
        out.close();

        System.out.println(sp.hashCode());

        ObjectInputStream is = new ObjectInputStream(new FileInputStream("sample.txt"));
        SingletonPattern sp1 = (SingletonPattern) is.readObject();
        is.close();
        System.out.println(sp1.hashCode());
    }
}
