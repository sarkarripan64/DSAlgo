package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by sarkarri on 2/4/17.
 */
public class AccessPrivateMethod {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class c = Class.forName("reflection.A");
        Method[] m = c.getDeclaredMethods();
        Object obj = c.newInstance();
        Method p = c.getDeclaredMethod("printArray", Integer.TYPE,Boolean.TYPE);
        for (Method mt : m) {
            System.out.println(mt);
        }
        p.setAccessible(true);
        p.invoke(obj, 5,true);
    }
}


class A {
    private void print(int a,boolean f) {
        System.out.println(a * a);
    }
}