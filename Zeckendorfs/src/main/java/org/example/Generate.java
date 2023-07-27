package org.example;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generate {


    public List<Long> findFibonnaciNumbers (Long a, Long b){

        List<Long> fibonacciNumbers= new ArrayList<>();
        //The first two int in a Fibonacci list are
        long lowerNumber = 0;
        long higherNumber = 1;

        //so if a is 0, then add it
        if(a==0){
            fibonacciNumbers.add(a);
        }

        //let's enter the loop and run it until higherNumber reaches the value inside b
        while(higherNumber<b) {
            //If the fibonacci number is between a and b add it to the list
            if(higherNumber>a){
                fibonacciNumbers.add(higherNumber);
            }
            //since a Fibonnaci number is the result of the sum of the two previous Fibonacci numbers
            long sum = lowerNumber +higherNumber;
            //then the lower Fibonacci Number receives the higher Fibonnaci Number
            lowerNumber = higherNumber;
            //and the higher number receives the sum value because it is the next Fibonnaci number
            higherNumber = sum;
        }

        return fibonacciNumbers;
    }

    //this method finds and prints the list of non-sequential Fibonacci's numbers which their sum is a particular number
    public void zeckendorfsRepresentationForANumber (long number, List<Long> fibonacciNumbers) {

        //now to check if the numbers aren't sequential we have to run through each in the fibonacci's list
        for (int i = fibonacciNumbers.size()-1; i > 0; i--) {
            //the last added Fibonacci number is the highest one so that is the first to be used
            //then we compare the Fibonacci's number in the current iteration to an integer,
            // if it's smaller add it in the representation and we update the integer value to find the next.
            // So if the Number is 71, then 71-55=16. In the second iteration we compare 34<16, in the third 21<16, in the 4th 13<16...
            if (fibonacciNumbers.get(i)<=number) {
                System.out.println(fibonacciNumbers.get(i));
                number = number-fibonacciNumbers.get(i);
            }
            //if number reached 0, no more fibonacci numbers are needed for the representation
            if(number == 0){
                break;
            }
        }
        System.out.println();
    }

    //this method gets the Zeckendorf sum for all numbers in a range
    public void getTheZeckendorfSumForAllNumbers(long lowerRange, long upperRange ){

        List<Long> fibonacciNumbers= findFibonnaciNumbers(lowerRange,upperRange);

        for (long i= lowerRange; i<=upperRange; i++){
            System.out.print(i + ": ");
            zeckendorfsRepresentationForANumber(i,fibonacciNumbers);
        }
    }
}
