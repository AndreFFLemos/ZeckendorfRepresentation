package org.example;

import java.util.Random;

public class main {


    public static void main(String[] args) {
        Generate generate= new Generate();

        Random random= new Random();
        long a= random.nextLong(0L,2147483647L);
        long b= random.nextLong(a,2147483647L);

        System.out.println("A is " + a);
        System.out.println("B is " + b);
        generate.getTheZeckendorfSumForAllNumbers(0L,71L);
    }

}
