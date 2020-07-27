package com.pluralsight;
/*Commandline */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class interactiveCalc {
    public static void main (String[] args){
        double[] value1 = {100.0, 222.0, 303.0, 427.0};
        double[] value2 = {15.0, 25.0, 35.0, 45.0};
        char[] opCode = {'a', 's', 'm', 'd'};
        double[] results = new double[opCode.length];

        if (args.length == 0) {
            for (int i = 0; i < opCode.length; i++)
                results[i] = switchCalc(opCode[i], value1[i], value2[i]);
            for (double currentValue: results) {
                //String s1 = String.format("The operation: %s %.1f and %.1f results %.2f", parts[0], value1, value2, currentValue);
                System.out.println(currentValue);
            }

        } else if (args.length == 1 && args[0].equals("interactive")) {
            executeInteractively();

        } else if (args.length == 3) {
             String result = handleCommandline(args);
             System.out.println(result);
        } else
            System.out.println("Argument must be three, Please provide one operator and two numbers (eg. 1, 435, -345)");
    }

    private static void executeInteractively() {
        /*This portion will implement user input and calculate*/
        System.out.println("Please provide operation and two numbers(in words, eg. zero to nine)");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] parts = userInput.split(" ");
        performOperationInput(parts);//Take userInput and perform calculation
    }

    private static void performOperationInput(String[] parts) {
        char opCode = opCodeExtractor(parts[0]);
        if (opCode == 'w')
            handleWhen(parts);
        else {
            double value1 = valueFromWord(parts[1]);
            double value2 = valueFromWord(parts[2]);
            double results = switchCalc(opCode, value1, value2);
            displayResult(opCode, value1, value2, results);
            //String s1 = String.format("The operation: %s %.1f and %.1f results %.2f", parts[0], value1, value2, results);
            //System.out.println(s1);
            //String s2 = String.format("Equation: %.1f %c %.1f = %.2f", value1, sym, value2, results);
            //System.out.println(s2);
        }
    }

    private static void handleWhen(String[] parts) {
        LocalDate startDate = LocalDate.parse(parts[1]);
        long daysToAdd = (long) valueFromWord(parts[2]);
        LocalDate newDate = startDate.plusDays(daysToAdd);
        String output = String.format("%s plus %d days makes %s", startDate, daysToAdd, newDate);
        System.out.println(output);
    }

    private static void displayResult(char opCode, double value1, double value2, double results) {
        char sym = symbolFromOpcode (opCode);
//        StringBuilder builder = new StringBuilder(20);
//        builder.append(value1);
//        builder.append(" ");
//        builder.append(sym);
//        builder.append(" ");
//        builder.append(value2);
//        builder.append(" = ");
//        builder.append(results);
//        String output = builder.toString();
//        System.out.println(output);
        String output = String.format("Equation: %.1f %c %.1f = %.2f", value1, sym, value2, results);
        System.out.println(output);
    }

    private static char symbolFromOpcode (char code) {
        char[] opCodes = {'a', 's', 'm', 'd'};
        char[] symbols = {'+', '-', '*', '/'};
        char operator = ' ';
        /*for (char c : opCode) char operator = symbol[c];*/
        for (int i = 0; i < opCodes.length; i++) {
            if (code == opCodes[i]) {
                operator = symbols[i];
                break;
            }
        }
        return operator;
    }

    private static String handleCommandline(String[] args) {
       char opCode = opCodeExtractor(args[0]);
        double value1 = Double.parseDouble(args[1]); //method() to convert a String to double value
        double value2 = Double.parseDouble(args[2]);
        double results = switchCalc(opCode, value1, value2);
        String display = String.format("The operation: %s %.1f and %.1f results %.2f",
                args[0], value1, value2, results);
        return display;
    }

    private static char opCodeExtractor(String part) {
       char opCode = part.charAt(0);/*charAt(int index) method returns the character at
                                            the specified index in a string*/
        return opCode;

    }

    private static double valueFromWord (String arguments) {
        String[] numWord = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        double value = 0;
        for (int index = 0; index < numWord.length; index++) {
            if (arguments.equals(numWord[index])) {
                value = index;
                break;
            } /* braces are important here after if condition otherwise
            only the first line would execute, break would be ignored */
        }
        return value;
    }

    static double switchCalc(char opCode, double value1, double value2) {
        double result;
        switch (opCode) {
            case 'a':
                result = value1 + value2;
                break;
            case 's':
                result = value1 - value2;
                break;
            case 'm':
                result = value1 * value2;
                break;
            case 'd':
                result = ((value1 != 0) & (value2 != 0)) ? (value1 / value2) : 0.0;
                break;
            default:
                System.out.println ("invalid input: " + opCode);
                result = 0.0;
        }
        return result;
    }
}


