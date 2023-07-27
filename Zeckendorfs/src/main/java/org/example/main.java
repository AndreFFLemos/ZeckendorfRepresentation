package org.example;

import java.math.BigInteger;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class main {


    public static void main(String[] args) {
        Generate generate= new Generate();

        Random random= new Random();
        BigInteger a = BigInteger.valueOf(random.nextInt(2147483647));
        BigInteger b = new BigInteger(2147483647 - a.intValue(), random).add(a);

        generate.getTheZeckendorfSumForAllNumbers(a,b);

    }

}
