package designpatterns;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by sarkarri on 2/7/17.
 */
public class ObserverPatternDemo {
}

class Subject {
    int state;
    List<Observer> list = new LinkedList<>();

    public void attach(Observer o) {
        list.add(o);
    }

    public void setState(int s) {
        state = s;
    }

    void notiFy(){
        for (Observer o:list){
            o.update();
        }
    }
}

abstract class Observer {
    Subject s;

    abstract void update();
}

class Binary extends Observer{
    Subject s;

    public Binary(Subject s) {
        this.s = s;
        this.s.attach(this);
    }

    @Override
    void update() {
        System.out.println("updaed");
    }
}
