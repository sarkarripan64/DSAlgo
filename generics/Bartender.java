package generics;

/**
 * Created by sarkarri on 11/25/16.
 */
public class Bartender {
    public static void main(String[] args) {
        Color<Red, Green, Blue> color = new Color(new Red(), new Green(), new Blue());
        Bartender bartender = new Bartender();
        Cocktail<Water, Juice> cocktail = bartender.<Water,Juice>mix(new Water(), new Juice());

        Cocktail<LemonSoda, Juice> cocktail1 = bartender.mix(new LemonSoda(), new Wine());
    }

    public <W, J> Cocktail mix(W water, J juice) {
        return new Cocktail(water, juice);
    }

}

class Cocktail<W, J> {
    W w;
    J j;

    Cocktail(W water, J juice) {
        this.j = juice;
        this.w = water;
    }
}