package ds.stack;

import util.ArrayUtil;

/**
 * Created by sarkarri on 4/5/17.
 */
public class StockSpan {
    public static void main(String[] args) {
        int price[] = {10, 4, 5, 90, 120, 80};
        maxSpan(price);
    }

    static void maxSpan(int ar[]) {
        int n = ar.length;
        int stock[] = new int[n];
        stock[0] = 1;
        for (int i = 1; i < n; i++) {
            stock[i] = 1;
            for (int j = i - 1; j >= 0 && ar[i] > ar[j]; j--) {
                stock[i]++;
            }
        }

        ArrayUtil.printArray(stock);

    }
}
