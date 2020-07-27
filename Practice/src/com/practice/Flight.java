package com.practice;
import java.time.LocalDateTime;

public class Flight {
    //public static void main(String[] args) {
    private int numOfPassengers;//'this'- is the current object instance
    public int numOfSeats;

    /*Constructor name is the name same as a class and Without return type
    Code within the constructor would run automatically when an object is
    created and normally set initial state*/
    public Flight(int passenger, int seat){
        numOfPassengers = passenger;
        numOfSeats = seat;
        }
    public int getPassengers () {
        return numOfPassengers;
    }
    private void setPassengers(int numOfPassengers) {
        this.numOfPassengers = numOfPassengers;
    }
    public int getSeats() {
        return numOfSeats;
    }
    private void setSeats(int numOfSeats){
        this.numOfSeats = numOfSeats;
    }
    public void add1passenger () {
            if (numOfSeats > numOfPassengers){
                numOfPassengers++;
                //commit
            }
            else
                handleTooMany();
                //return numOfPassengers;
                System.out.println("Number of Passengers as on " + LocalDateTime.now()+ " is " + numOfPassengers);
        }

    private void handleTooMany() {
        System.out.println("No empty seats");
    }

    public Flight combineTwoFlight(Flight flight) {
           int combinedPassengers = this.numOfPassengers + flight.numOfPassengers;
           int combinedSeats = this.numOfSeats + flight.numOfSeats;
           return new Flight (combinedSeats, combinedPassengers);
    }

    public boolean hasRoom (Flight f2) {
    /**  This reference is a reference to the current object instance, What things we often
     * use this for is reducing ambiguity, making it clear they were referring to a member
     * of the current object instance. Also, this is useful for allowing an object to pass
     * a reference to itself as a parameter to a method.  */
        int total = this.numOfPassengers + f2.numOfPassengers;
        /*f2.numOfPassengers this refers to the number of passengers on the flight that was
        passed in as a parameter*/
        /** But our other use of the passenger’s field is unqualified, and in this scenario,
        the passenger’s field not being qualified actually refers to the current object
        instance(line 6). In other words, this code is doing exactly we wanted to do*/
        return total <= numOfSeats;
    }
}

/** Then we have the special reference null. It represents an uncreated object,
 * so allows us to have a reference that rather than referring to an object instance,
 * doesn't refer to any instance at all, and null can be assigned to any reference variable.*/
