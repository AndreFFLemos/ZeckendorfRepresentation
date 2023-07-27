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

        //so if a is 0, then add it
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
            //and the higher number receives the sum value because it is the next Fibonnaci number
            higherNumber = sum;
        }

        return fibonacciNumbers;
    }

    //this method finds the list of non-sequential Fibonacci's numbers which their sum is a particular number
    public List<Long> zeckendorfsRepresentation (long number) {

        //invoke the method to get all the fibonacci's numbers until a particular number
        List<Long> fibonaccis = findFibonnaciNumbers(0, number);

        List<Long> fibonnacisInTheRepresentation = new ArrayList<>();

        //if the number is 0, add it to the Representation and return
        if (number== 0) {
            fibonnacisInTheRepresentation.add(0L);
            return fibonnacisInTheRepresentation;
        }

        //now to check if the numbers aren't sequential we have to run through each in the fibonacci's list
        for (int i = fibonaccis.size()-1; i > 0; i--) {
            //the last added Fibonacci number is the highest one so that is the first to be used
            long currentFibonacciNumber = fibonaccis.get(i);
            //then we compare the Fibonacci's number in the current iteration to an integer,
            // if it's smaller add it in the representation and we update the integer value to find the next.
            // So if the Number is 71, then 71-55=16. In the second iteration we compare 34<16, in the third 21<16, in the 4th 13<16...
            if (currentFibonacciNumber <= number) {
                fibonnacisInTheRepresentation.add(currentFibonacciNumber);
                number = number - currentFibonacciNumber;
            }
        }

        return fibonnacisInTheRepresentation;

    }

    //this method gets the Zeckendorf sum for all numbers in a range
    public List <StringBuilder> getTheZeckendorfSumForAllNumbers(Long lowerRange, Long upperRange ){

        List<StringBuilder> listOfZeckendorfSumForAllNumbers= new ArrayList<>();

        for (long i= lowerRange; i<=upperRange;i++){
            listOfZeckendorfSumForAllNumbers.add(convertToStringBuilder(zeckendorfsRepresentation(i)));
        }

        return listOfZeckendorfSumForAllNumbers;
    }


    //this method converts the Zeckendorf's representation to a StringBuilder in order to show each number in the sum
    public StringBuilder convertToStringBuilder (List <Long> fibonnacisInTheRepresentation ){

        StringBuilder fibonnacisInTheRepresentationAsAString= new StringBuilder();

        //run through each number in the list and add it to the StringBuilder instance and after add a + sign

        for (int i=0;i<fibonnacisInTheRepresentation.size();i++){
            fibonnacisInTheRepresentationAsAString.append(fibonnacisInTheRepresentation.get(i));
            fibonnacisInTheRepresentationAsAString.append("+");
        }

        //because the last char added is a +, we have to remove it.
        fibonnacisInTheRepresentationAsAString.deleteCharAt(fibonnacisInTheRepresentationAsAString.length()-1);

        return fibonnacisInTheRepresentationAsAString;
    }
}
