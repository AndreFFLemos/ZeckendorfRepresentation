package org.example;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generate {


    public List<BigInteger> findFibonnaciNumbers (BigInteger a, BigInteger b){

        List<BigInteger> fibonacciNumbers= new ArrayList<>();
        //The first two int in a Fibonacci list are
        BigInteger lowerNumber = BigInteger.ZERO;
        BigInteger higherNumber = BigInteger.ONE;

        //so if a is 0, then add it
        if(a.equals(BigInteger.ZERO)){
            fibonacciNumbers.add(a);
        }

        //let's enter the loop and run it until higherNumber reaches the value inside b
        while(higherNumber.compareTo(b)<=0) {
            //If the fibonacci number is between a and b add it to the list
            if(higherNumber.compareTo(a)>=0){
                fibonacciNumbers.add(higherNumber);
            }
            //since a Fibonnaci number is the result of the sum of the two previous Fibonacci numbers
            BigInteger sum = lowerNumber.add(higherNumber);
            //then the lower Fibonacci Number receives the higher Fibonnaci Number
            lowerNumber = higherNumber;
            //and the higher number receives the sum value because it is the next Fibonnaci number
            higherNumber = sum;
        }

        return fibonacciNumbers;
    }

    //this method finds the list of non-sequential Fibonacci's numbers which their sum is a particular number
    public List<BigInteger> zeckendorfsRepresentation (BigInteger number, List<BigInteger> fibonacciNumbers) {

        List<BigInteger> fibonnacisInTheRepresentation = new ArrayList<>();

        //if the number is 0, add it to the Representation and return
        if (number.equals(BigInteger.ZERO)) {
            fibonnacisInTheRepresentation.add(BigInteger.ZERO);
            return fibonnacisInTheRepresentation;
        }

        //now to check if the numbers aren't sequential we have to run through each in the fibonacci's list
        for (int i = fibonacciNumbers.size()-1; i > 0; i--) {
            //the last added Fibonacci number is the highest one so that is the first to be used
            BigInteger currentFibonacciNumber = fibonacciNumbers.get(i);
            //then we compare the Fibonacci's number in the current iteration to an integer,
            // if it's smaller add it in the representation and we update the integer value to find the next.
            // So if the Number is 71, then 71-55=16. In the second iteration we compare 34<16, in the third 21<16, in the 4th 13<16...
            if (currentFibonacciNumber.compareTo(number)<=0) {
                fibonnacisInTheRepresentation.add(currentFibonacciNumber);
                number = number.subtract(currentFibonacciNumber);
            }
        }

        return fibonnacisInTheRepresentation;

    }
    //this method converts the Zeckendorf's representation to a StringBuilder in order to show each number in the sum
    public StringBuilder convertToStringBuilder (List <BigInteger> fibonnacisInTheRepresentation ){

        StringBuilder fibonnacisInTheRepresentationAsAString= new StringBuilder();

        //run through each number in the list and add it to the StringBuilder instance and after add a + sign
        if (!fibonnacisInTheRepresentation.isEmpty()) {
            for (BigInteger fibonacciNumber: fibonnacisInTheRepresentation){
                fibonnacisInTheRepresentationAsAString.append(fibonacciNumber.toString());
                fibonnacisInTheRepresentationAsAString.append("+");
            }
            //because the last char added is a +, we have to remove it.
            fibonnacisInTheRepresentationAsAString.deleteCharAt(fibonnacisInTheRepresentationAsAString.length() - 1);
        }
        return fibonnacisInTheRepresentationAsAString;
    }

    //this method gets the Zeckendorf sum for all numbers in a range
    public void getTheZeckendorfSumForAllNumbers(BigInteger lowerRange, BigInteger upperRange ){

        List<BigInteger> fibonacciNumbers= findFibonnaciNumbers(BigInteger.ZERO,upperRange);

        for (BigInteger i= lowerRange; i.compareTo(upperRange) <= 0; i = i.add(BigInteger.ONE)){
            List<BigInteger> zeckendorfRepresentation=zeckendorfsRepresentation(i,fibonacciNumbers);
            System.out.println(convertToStringBuilder(zeckendorfRepresentation));
        }
    }

}
