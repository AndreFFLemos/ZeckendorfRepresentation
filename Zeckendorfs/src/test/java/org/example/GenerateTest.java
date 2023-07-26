package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


class GenerateTest {

    private Generate generate= new Generate();
    private Random random;
    private int a;
    private int b;

    List<Long> fibonacciNumbers;

    @BeforeEach
    void setup(){
        fibonacciNumbers=new ArrayList<>();
        random= new Random();
        a=random.nextInt(0,2147483647);
        b= random.nextInt(a, 2147483647);
    }

    @Test
    void isBHigherThanATest(){
        Assert.assertTrue(a<b);
    }
    @Test
    void checkIfFibonacciNumberIsNotIncludedInTheRange(){
        int x= 100;
        int y=200;

        fibonacciNumbers=generate.findFibonnaciNumbers(x,y);

        assertTrue(!fibonacciNumbers.contains(80));
        assertTrue(!fibonacciNumbers.contains(500));

    }
    @Test
    void checkIfFirstElementIsZero() {
        long x = 0;
        long y=100;

        List<Long> fibonacciNumbers = generate.findFibonnaciNumbers(x,y);

        assertEquals(0, fibonacciNumbers.get(0));
    }
        //the following two methods check if a number is or not a Fibonacci Number
    //algorithm copied from a webpage.
    private boolean isFibonacci(long n) {
        long x = 5 * n * n + 4;
        long y = 5 * n * n - 4;

        return isPerfectSquare(x) || isPerfectSquare(y);
    }

    private boolean isPerfectSquare(long n) {
        long s = (long) Math.sqrt(n);
        return (s * s == n);
    }


    @Test
    void findFibonnaciNumbers() {
        long x= 0;
        long y=1000;
        fibonacciNumbers= generate.findFibonnaciNumbers(x,y);

        assertTrue(!fibonacciNumbers.isEmpty());
        assertTrue(isFibonacci(fibonacciNumbers.get(2)));
        assertTrue(isFibonacci(fibonacciNumbers.get(10)));
        assertTrue(isFibonacci(fibonacciNumbers.get(15)));
    }



}