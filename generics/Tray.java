package generics;


/**
 * Created by sarkarri on 11/25/16.
 */
public class Tray {
    public static void main(String[] args) {
        Tray tray = new Tray();
        tray.addGlass(new Glass<Wine>());
        tray.removeGlass(new Glass<Coke>());
    }

    public void addGlass(Glass<? extends Water> glass){

    }

    public void removeGlass(Glass<? super CokeZero> glass){

    }
}
