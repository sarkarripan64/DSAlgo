package ds.array;

/**
 * Created by sarkarri on 2/16/17.
 */
public class StockBuySell {
    public static void main(String[] args) {
        //int arr[] = {100, 180, 260, 310, 40, 535, 695};
        //int arr[] = {100, 180, 90, 310, 40, 535, 695};
        int arr[] = {14, 12, 70, 15, 99, 65, 21, 90};
        maxProfit(arr);
        System.out.println("==================");
        maxProfit2(arr);
        System.out.println("================");
        System.out.println("max profit in single transaction " + maxProfitOneTransaction(arr));
    }

    static void maxProfit(int[] ar) {
        int n = ar.length;
        if (ar == null || n < 2) {
            return;
        }

        int bi = 0, si = 0;
        for (int i = 1; i < n; i++) {
            if (ar[i] > ar[si]) {
                si++;
            } else {
                if (si > bi) {
                    System.out.println(bi + "-" + si);
                }
                bi = si = i;
            }
        }

        if (si > bi) {
            System.out.println(bi + "-" + si);
        }
    }

    static int maxProfitOneTransaction(int[] ar) {
        int maxProfit = -1;
        int min_val = ar[0];
        for (int i = 1; i < ar.length; i++) {
            maxProfit = Math.max(maxProfit, ar[i] - min_val);
            min_val = Math.min(min_val, ar[i]);
        }
        return maxProfit;
    }

    static void maxProfit2(int ar[]) {
        int n = ar.length;
        if (ar == null || n < 2) {
            return;
        }

        int i = 0;
        while (i < n - 1) {
            //{14, 12, 70, 15, 99, 65, 21, 90}
            while ((i < n - 1) && ar[i + 1] < ar[i]) {
                i++;
            }
            if (i == n - 1)
                break;
            StockBuyingDate e = new StockBuyingDate();
            e.buyDate = i++;
            while ((i < n) && ar[i - 1] < ar[i]) {
                i++;
            }
            e.sellingDate = i - 1;

            System.out.println(e.buyDate + "-" + e.sellingDate);
        }
    }

}

class StockBuyingDate {
    int buyDate;
    int sellingDate;

    public int getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(int buyDate) {
        this.buyDate = buyDate;
    }

    public int getSellingDate() {
        return sellingDate;
    }

    public void setSellingDate(int sellingDate) {
        this.sellingDate = sellingDate;
    }
}
