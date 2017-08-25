package designpatterns;

/**
 * Created by sarkarri on 5/22/17.
 */
public class StatePattern {
    public static void main(String[] args) {

    }
}

interface State{
    void doAction(ContextS contextS);
}

class StartState implements State{

    @Override
    public void doAction(ContextS contextS) {
        System.out.println("start");
        contextS.setState(this);
    }
}

class StopState implements State{

    @Override
    public void doAction(ContextS contextS) {
        System.out.println("stop");
        contextS.setState(this);
    }
}


class ContextS {
    State state;
    public ContextS(){

    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}