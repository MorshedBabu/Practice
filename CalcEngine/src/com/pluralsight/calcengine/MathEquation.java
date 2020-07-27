package com.pluralsight.calcengine;

public class MathEquation {
    double leftVal;
    double rightVal;
    char opCode;
    double results;

    double execute() {
        /* execute method within our MathEquation class doesn't take
    any parameters, and that's distinctly different from the execute method in
    our main class. That's because here in our math equation class, all the values
    we need are actually part of the class itself */
        switch (opCode) {
            case 'a':
                results = leftVal + rightVal;
                break;
            case 's':
                results = leftVal - rightVal;
                break;
            case 'm':
                results = leftVal * rightVal;
                break;
            case 'd':
                results = leftVal / rightVal;
                break;
            default:
                System.out.println("Invalid Input");
                results = 0.0;
        }
        return results;
    }
}
