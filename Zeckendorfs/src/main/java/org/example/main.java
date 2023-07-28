package org.example;

import java.math.BigInteger;
import java.util.List;
import java.util.Random;

public class main {


    public static void main(String[] args) {
        Generate generate= new Generate();

        Random random= new Random();
        long a = random.nextLong(0,2147483647);
        long b = random.nextLong(a,2147483647);

        generate.getTheZeckendorfSumForAllNumbers(a,b);

    }

}
