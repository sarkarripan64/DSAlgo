package lamdas;

/**
 * Created by sarkarri on 5/31/17.
 */
@FunctionalInterface
public interface Converter<T, F> {
    T convert(F from);

    default void defMethod() {
        System.out.println("default method");
    }
}
