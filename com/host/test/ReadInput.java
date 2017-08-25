package com.host.test;

import java.util.Scanner;

/**
 * Created by sarkarri on 1/12/17.
 */
public class ReadInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int ar[][] = new int[6][6];

        for (int i = 0; i < ar.length; i++) {
            Scanner colReader = new Scanner(input.nextLine());
            for (int j = 0; j < ar.length; j++) {
                int a = colReader.nextInt();
                ar[i][j] = a;
            }
            colReader.close();
        }


        int max = Integer.MIN_VALUE;
        for (int i = 0; i < ar.length - 2; i++) {
            for (int j = 0; j < ar.length - 2; j++) {
                int sum = ar[i][j] + ar[i][j + 1] + ar[i][j + 2] + ar[i + 1][j + 1]
                        + ar[i + 2][j] + ar[i + 2][j + 1] + ar[i + 2][j + 2];
                if (sum > max) {
                    max = sum;
                }
            }
        }

        System.out.println(max);

        input.close();

    }
}
