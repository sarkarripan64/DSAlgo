package com.host.test;

import java.util.Scanner;

/**
 * Created by sarkarri on 1/12/17.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int d = in.nextInt();
        int ar[] = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }

        reverse(ar, 0, d - 1);
        reverse(ar, d, ar.length - 1);
        reverse(ar, 0, ar.length - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(ar[i] + " ");
        }
    }

    static void reverse(int ar[], int l, int r) {
        while (l < r) {
            int temp = ar[l];
            ar[l] = ar[r];
            ar[r] = temp;
            l++;
            r--;
        }
    }
}
