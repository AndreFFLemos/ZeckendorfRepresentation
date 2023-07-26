package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generate {
    private Random random= new Random();
    private long a= random.nextLong(0,2147483647);
    private long b= random.nextLong(a, 2147483647);
    List<Long> fibonacciNumbers= new ArrayList<>();

    public List<Long> findFibonnaciNumbers (long a, long b){

        //The first two int in a Fibonacci list are
        long lowerNumber = 0;
        long higherNumber = 1;

        //so if the generated random number a is 0, then add it
        if(a == 0) {
            fibonacciNumbers.add(0L);
        }

        //let's enter the loop and run it until higherNumber reaches the value inside b
        while(higherNumber <= b){
            //If the fibonacci number is bigger than a then add it to the list
            if(higherNumber >= a){
                fibonacciNumbers.add(higherNumber);
            }
            //since a Fibonnaci number is the result of the sum of the two previous Fibonacci numbers
            long sum = lowerNumber + higherNumber;
            //then the lower Fibonacci Number receives the higher Fibonnaci Number
            lowerNumber = higherNumber;
            //and the posterior number receives the number of the sum that is the next Fibonnaci number
            higherNumber = sum;
        }

        return fibonacciNumbers;
    }
}
