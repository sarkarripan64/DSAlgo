package designpatterns;

/**
 * Created by sarkarri on 5/20/17.
 */
public class StrategyPattern {
    public static void main(String[] args) {
        Context context = new Context(new AddOperation());
        context.executeStrategy(5, 4);
    }
}


interface Strategy {
    int doOperation(int a, int b);
}

class AddOperation implements Strategy {

    @Override
    public int doOperation(int a, int b) {
        return a + b;
    }
}

class SubtractOperation implements Strategy {

    @Override
    public int doOperation(int a, int b) {
        return a - b;
    }
}

class MultiPlyOperation implements Strategy {

    @Override
    public int doOperation(int a, int b) {
        return a * b;
    }
}

class Context {
    Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(int a, int b) {
        strategy.doOperation(a, b);
    }
}