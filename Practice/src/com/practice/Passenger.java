package com.practice;
//Examples- Constructor

public class  Passenger {
    private int checkBags;
    private int freeBags; //Getters and Setters elided
    private double perBagFree;//Amount of money the passengers
                                //has to pay any bags they check beyond the bags they are allowed
    //Constructor#1
    public Passenger() {}
    /*If one constructor is Provided, then the empty constructor can be placed explicitly
    if we want instance with no parameters */
    //Constructor#2
    public Passenger(int freeBags) {
        this(freeBags > 1 ? 25.0d: 50.0d);//Calling the constructor of the 'perBagFee'
        this.freeBags = freeBags;
        /*Based on the assumption of Business Rule that, Elite passengers are
        allowed more than one freeBag and
        * Elite passengers have to pay less perBagFee as general passengers*/
    }
    //Constructor#3
    private Passenger (int freeBags, int checkBags) {
        /*CHAINING CONSTRUCTORS- One constructor can call another constructor.
         * The call to other constructor must be placed on the first line of the new constructor.
         * Use 'this' keyword followed by parameter list as above*/
        this(freeBags); //Calling Passenger(int freeBags) constructor
        this.checkBags = checkBags;
    }
    //Constructor#4
    public Passenger(double perBagFree) {
        this.perBagFree = perBagFree;
    }
}
