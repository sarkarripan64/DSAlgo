package designpatterns;

/**
 * Created by sarkarri on 2/7/17.
 */
public class DecoratorPattern {
}


interface Shape {
    void draw();
}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("drawing circle");
    }
}

class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("retangle");
    }
}

abstract class ShapeDecorator implements Shape {

    Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
    }
}

class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedColoured();
    }

    public void setRedColoured() {
        System.out.println("red decorated");
    }
}