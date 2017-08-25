package designpatterns;

/**
 * Created by sarkarri on 5/19/17.
 */
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        AbstractFactory absf = FactoryProducer.createFactory("S");
        ShapeA s = absf.getShape("S");
        s.draw();
    }
}

interface ShapeA {
    void draw();
}

class SquareA implements ShapeA {

    @Override
    public void draw() {
        System.out.println("Square");
    }
}

class CircleA implements ShapeA {

    @Override
    public void draw() {
        System.out.println("circle");
    }
}

interface ColorA {
    void fill();
}

class Red implements ColorA {

    @Override
    public void fill() {
        System.out.println("Red");
    }
}

class Blue implements ColorA {

    @Override
    public void fill() {
        System.out.println("blue");
    }
}

abstract class AbstractFactory {
    public abstract ColorA getColor(String cCode);

    public abstract ShapeA getShape(String sCode);
}

class ShapeFactoryA extends AbstractFactory {

    @Override
    public ColorA getColor(String cCode) {
        return null;
    }

    @Override
    public ShapeA getShape(String sCode) {
        if (sCode == "S")
            return new SquareA();
        else if (sCode == "C")
            return new CircleA();
        return null;
    }
}

class ColorFactory extends AbstractFactory {

    @Override
    public ColorA getColor(String cCode) {
        //return shapes based on ccode;
        return null;
    }

    @Override
    public ShapeA getShape(String sCode) {
        return null;
    }
}


class FactoryProducer extends ShapeFactoryA {
    public static AbstractFactory createFactory(String fCode) {
        if (fCode == "S") {
            return new ShapeFactoryA();
        } else if (fCode == "C") {
            return new ColorFactory();
        }

        return null;
    }
}
