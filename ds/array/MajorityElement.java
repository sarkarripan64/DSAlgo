package ds.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sarkarri on 1/5/17.
 */
public class MajorityElement {
    public static void main(String[] args) {
        //int ar[] = {1, 7, 1, 7, 7, 7, 4};
        int ar[] = {3, 4, 4, 2, 4, 4, 2, 4, 4};
        //System.out.println(majorityElement(ar));
        findMejority(ar);
    }

    static int majorityElement(int[] ar) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : ar) {
            if (map.containsKey(x)) {
                int count = map.get(x);
                if (++count > ar.length / 2)
                    return x;

                map.put(x, count);
            } else {
                map.put(x, 1);
            }
        }
        return 0;
    }

    static void findMejority(int[] ar) {
        int cand = findCandidate(ar);
        ifMajority(ar, cand);
    }

    //{3, 4, 4, 2, 4, 4, 2, 4, 4}
    static int findCandidate(int[] ar) {
        int c = 0;
        int majIndex = 0;
        for (int i = 1; i < ar.length; i++) {
            if (ar[majIndex] == ar[i]) {
                c++;
            } else {
                c--;
            }

            if (c == 0) {
                majIndex = i;
                c = 1;
            }
        }
        return ar[majIndex];
    }

    static void ifMajority(int ar[], int majEle) {
        int c = 0;
        for (int i = 0; i < ar.length; i++) {
            if (majEle == ar[i])
                c++;
        }
        if (c > (ar.length / 2)) {
            System.out.println(majEle + " is major element");
        } else {
            System.out.println("no major element");
        }
    }
}
