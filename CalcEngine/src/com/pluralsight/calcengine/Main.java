package com.pluralsight.calcengine;

public class Main {
	public static void main(String[] args) {
		performCalculations();
	}

	static void performCalculations() {
		/** create a new MathEquation array of size four. We're creating an array of MathEquation
		 * references. so we are not creating four instances of the MathEquation class.
		 * Instead, we're creating four references of type MathEquation. each of the elements within
		 * this array will need to explicitly create an instance of the MathEquation class.
		 * so starting out by setting the 0th element to a new instance of the MathEquation class.  */
		MathEquation[] equations = new MathEquation[4];
		equations[0] = equation(100.0d, 50.0d, 'd');
		equations[1] = equation(50.0, 25.0, 's');
		equations[2] = equation(30.0, 35.0, 'm');
		equations[3] = equation(427.0d, 45.0d, 'a');
		/*we have equations array set up. Each of the elements in the array are referencing new
		instance of the math equation class. And each of the fields within those instances we have
		the values to be used to perform the calculations.
		 */
		for (MathEquation equation : equations) {
			equation.execute();
			System.out.println("Result = " + equation.results);
		}
	}

	private static MathEquation equation(double leftVal, double rightVal, char opCode) {
		MathEquation equation =new MathEquation();
		equation.leftVal = leftVal;
		equation.rightVal = rightVal;
		equation.opCode = opCode;
		return equation;
	}
}
