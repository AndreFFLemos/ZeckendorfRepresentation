package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


class GenerateTest {

    private Generate generate= new Generate();
    private Random random;
    private long a;
    private long b;

    List<Long> fibonacciNumbers;

    @BeforeEach
    void setup(){
        fibonacciNumbers=new ArrayList<>();
        random= new Random();
        a=random.nextLong(0L,2147483647L);
        b= random.nextLong(a, 2147483647L);

    }

    @Test
    void isBHigherThanATest(){
        fibonacciNumbers=generate.findFibonnaciNumbers(a,b);
        assertTrue(a<b);
    }
    @Test
    void checkIfFibonacciNumberIsNotIncludedInTheRangeT(){
        long x= 100;
        long y=200;

        fibonacciNumbers=generate.findFibonnaciNumbers(x,y);

        assertTrue(!fibonacciNumbers.contains(80));
        assertTrue(!fibonacciNumbers.contains(500));

    }
    @Test
    void checkIfFirstElementIsZeroTest() {
        long x = 0;
        long y=100;

        fibonacciNumbers = generate.findFibonnaciNumbers(x,y);

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
    void findFibonnaciNumbersTest() {
        long x= 0;
        long y=1000;
        fibonacciNumbers= generate.findFibonnaciNumbers(x,y);

        assertTrue(!fibonacciNumbers.isEmpty());
        assertTrue(isFibonacci(fibonacciNumbers.get(2)));
        assertTrue(isFibonacci(fibonacciNumbers.get(10)));
        assertTrue(isFibonacci(fibonacciNumbers.get(15)));
    }

    @Test
    void zeckendorfsRepresentationForASmallNumberTest(){
        long number=71;
        List<Long> fibonacciNumbers = Arrays.asList(0L,1L,1L,2L,3L,5L,8L,13L,21L, 35L,55L,89L);

        String representation= generate.zeckendorfsRepresentationForANumber(number,fibonacciNumbers);

        assertFalse(representation.isEmpty());
        assertEquals("55+13+3", representation);
    }
    @Test
    void zeckendorfsRepresentationForALargeNumberTest(){
        long number=214748364;
        List<Long> fibonacciNumbers = Arrays.asList(0L,1L,1L,2L,3L,5L,8L,13L,21L,34L,55L,89L,144L,233L,377L,610L,987L,1597L,2584L,4181L,6765L,10946L,17711L,28657L,46368L, 75025L,121393L, 196418L,317811L, 514229L,832040L,1346269L,2178309L, 3524578L,5702887L,9227465L,14930352L,24157817L,39088169L,63245986L,102334155L,165580141L);

        String representation= generate.zeckendorfsRepresentationForANumber(number,fibonacciNumbers);

        assertFalse(representation.isEmpty());
        assertEquals("165580141+39088169+9227465+832040+17711+2584+233+21", representation);
    }

    @Test
    void ifNumberIsZeroTest() {
        long number=0;

        String isZero= generate.zeckendorfsRepresentationForANumber(number,fibonacciNumbers);

        assertTrue(isZero.equals("0"));
    }

    @Test
    void getTheZeckendorfSumForAllNumbersTest(){
        long lower= 100;
        long higher=200;

        generate.getTheZeckendorfSumForAllNumbers(lower,higher);

    }
}