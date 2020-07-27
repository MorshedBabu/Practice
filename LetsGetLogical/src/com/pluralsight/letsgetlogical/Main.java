package com.pluralsight.letsgetlogical;

public class Main {

	public static void main(String[] args) {
		int v1 = 10, v2 = 12;
		final int diff;
		if (v1 > v2) {
			diff = v1 - v2;
			System.out.println ("v1 is bigger than v2 , diff = "  + diff);
		}
		else if (v1 < v2){
			diff = v2 - v1;
			System.out.println ("v2 is greater than v1, diff = " + diff);
		}
	}
}

//	int students = 150;
//	int rooms = 10;
//
//	if (students/rooms > 30 || rooms != 0 )
//	    System.out.println("Crowded");
//		System.out.println("executed");
//
//
//
//
//
//	System.out.println();
//	System.out.println("*** end of programs");

