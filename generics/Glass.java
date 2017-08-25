package generics;

/**
 * Created by sarkarri on 11/25/16.
 */
public class Glass<T extends Liquid> {
    private T liquid;

    public T getLiquid() {
        return liquid;
    }

    public void setLiquid(T liquid) {
        this.liquid = liquid;
    }

    <U extends Juice> String getLiquidTaste(U juice) {
        return juice.taste();
    }

}

class Water implements Liquid {

    @Override
    public String taste() {
        return null;
    }
}

class Juice extends Water implements Liquid {

    @Override
    public String taste() {
        System.out.println("sweet");
        return "sweet";
    }
}

class LemonSoda implements Liquid {

    @Override
    public String taste() {
        System.out.println("chh");
        return "ch";
    }
}

class Wine extends Water implements Liquid {

    @Override
    public String taste() {
        System.out.println("sweet");
        return "sweet";
    }
}

class Cake {

}

class Fruit {

}

interface Liquid {
    String taste();
}


class WineGlass<T extends Liquid> extends Glass<T> {

}

class Coke implements Liquid{

    @Override
    public String taste() {
        return "Strong";
    }
}

class DietCoke extends Coke {

}

class CokeZero extends DietCoke {

}

class CokeGreen extends Coke{

}