package com.pluralsight;

public class Method {
    public static void main (String[] args) {
        double[] value1 = {100.0, 222.0, 303.0, 427.0};
        double[] value2 = {15.0, 25.0, 35.0, 45.0};
        char[] opCode = {'a', 's', 'm', 'd'};
        double[] results = new double[opCode.length];

        if (args.length == 0) { //If No command line argument is provided
            for (int i = 0; i < opCode.length; i++)
                results[i] = switchCalc(opCode[i], value1[i], value2[i]);

            for (double currentValue : results) {
               // String s1 = String.format("The operation: %c of %f and %f makes %.2f",
                        //opCode, value1, value2, currentValue);
                System.out.println(currentValue);}
        } else if (args.length == 3) {
            handleCommandline(args); //If arguments are passed
        }
        else
            System.out.println("Please provide an operation code and 2 numbers");
    }

    private static void handleCommandline(String[] args) {
        /** Java is strongly typed language, the arguments would coming in as string type,
        each individual string would be considered as sequence of characters even there is
        only one character. So they need to be converted into each of the arguments needed
        in switchCalc method */
        char opCode = args[0].charAt(0); //The whole line just convert String to char, args[0] would be the first argument,
                                        // to extract first character from string used charAt(int ) method of string
        double value1 = Double.parseDouble(args[1]); //converting String type argument to double type
        double value2 = Double.parseDouble(args[2]);
        double result = switchCalc(opCode, value1, value2); //passing the arguments to method
        System.out.println(result);
    }

    static double switchCalc (char opCode, double value1, double value2) {
        double result;
        switch(opCode) {
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
                result = value1 != 0 & value2 != 0 ? value1/value2: 0.0;
                break;
            default:
                System.out.println("Invalid Input :" + opCode);
                result = 0.0;
                break;
        }
        return result;
    }
}
