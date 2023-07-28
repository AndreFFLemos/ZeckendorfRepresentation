package org.example;

import java.math.BigInteger;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class main {


    public static void main(String[] args) {
        Generate generate= new Generate();
        long a=0;
        long b=0;
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Please, enter a number between 0 and 2147483647 (Max: 10 decimal numbers): ");
            a = scanner.nextLong();
            if (a < 0) {
                System.out.println("Number cannot be negative. Please enter it again.");
                continue;
            }
            while (true) {
                System.out.println("Please, enter a number between the previous number and 2147483647 (Max: 10 decimal numbers):");
                b = scanner.nextLong();
                if (b < 0) {
                    System.out.println("Number cannot be negative. Please enter the number again.");
                    continue;
                }
                if (a >= b) {
                    System.out.println("The first number cannot be equal or higher than the second. Please enter the numbers again.");
                    break;
                }
                break;
            }
            if ((a >= b || a < 0 || b < 0)) {
                continue;
            }
            break;
        }

        generate.getTheZeckendorfSumForAllNumbers(a,b);

        scanner.close();
    }

}
