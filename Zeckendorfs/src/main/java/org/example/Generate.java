package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generate {


    public List<Long> findFibonnaciNumbers (long a, long b){

        List<Long> fibonacciNumbers= new ArrayList<>();
        //The first two int in a Fibonacci list are
        long lowerNumber = 0;
        long higherNumber = 1;

        //so if the generated random number a is 0, then add it
        if(a == 0) {
            fibonacciNumbers.add(0L);
        }

        //let's enter the loop and run it until higherNumber reaches the value inside b
        while(higherNumber <= b){
            //If the fibonacci number is between a and b add it to the list
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


    //now that i have the list of fibonacci numbers i can check what Fib. numbers are in the sum of the representation
    public String zeckendorfsRepresentation (long number){

        List <Long> fibonaccis= new ArrayList<>();
        fibonaccis= findFibonnaciNumbers(0,number);





        
    }
}
