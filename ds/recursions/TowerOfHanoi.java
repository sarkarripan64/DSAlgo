package ds.recursions;

/**
 * Created by sarkarri on 11/24/16.
 */
public class TowerOfHanoi {
    public static void main(String[] args) {

    }

    static void move(int noOfDisc, char src, char aux, char dest) {
        if (noOfDisc >= 1) {
            move(noOfDisc - 1, src, dest, aux);
            System.out.println("src "+src+" dest "+dest);
            //move();
            move(noOfDisc-1,aux,src,dest);
        }
    }
}
