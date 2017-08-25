package designpatterns;

/**
 * Created by sarkarri on 5/15/17.
 */
public class FactoryPatternDemo {
    public static void main(String[] args) {

    }


}

interface Shapes {
    void draw(String s);
}


class CircleF implements Shapes {

    @Override
    public void draw(String s) {

    }
}

class SquireF implements Shapes {

    @Override
    public void draw(String s) {

    }
}

class RectangleF implements Shapes {

    @Override
    public void draw(String s) {

    }
}

class ShapeFactory {
    public Shapes getShape(String s) {
        switch (s) {
            case "C":
                return new CircleF();
            case "S":
                return new SquireF();
            default:
                return null;
        }
    }
}