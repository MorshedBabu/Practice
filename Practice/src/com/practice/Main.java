package com.practice;

import com.Passenger;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Flight flight1 = new Flight(0, 150 );
        Flight flight2 = new Flight(0, 140);
        Flight dhaka1 = new Flight(0, 100);
        Flight dhaka2 = new Flight(0, 80);
        Flight dhaka3 = null;

        Passenger Eva = new Passenger();
        Passenger Babu = new Passenger(2);



        flight1.add1passenger();
        //flight1.add1passenger();

        if (dhaka1.hasRoom(dhaka2)) {
            dhaka3 = dhaka1.combineTwoFlight(dhaka2);
            //System.out.println(dhaka3.numOfSeats);
        }
        if (dhaka3 != null)
            System.out.println("Flights Combined");

        System.out.println(dhaka1.getSeats());
        System.out.println(dhaka1.getPassengers());


        //System.out.println(flight2.hasRoom(flight1));
        //System.out.println(dhaka3.numOfSeats);
        //flight1- refers to the number of passengers on the flight that was passed in as a parameter
    }
}
