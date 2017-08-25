package generics;

/**
 * Created by sarkarri on 11/25/16.
 */
public class GenericsDemo {
    public static void main(String[] args) {
        Glass<Water> glass = new Glass<Water>();
        Juice juice = new Juice();
        Water water = new Water();

        glass.setLiquid(juice);

        Water o = glass.getLiquid();

        Glass<Water> glass1 = new Glass<>();

        Glass<Wine> wineGlass = new WineGlass<Wine>();

        System.out.println(glass.getLiquidTaste(juice));

    }
}
