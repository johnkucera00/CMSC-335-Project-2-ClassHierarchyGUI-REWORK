/*
* File: Shape.java
* Author: John Kucera
* Date: November 21, 2020
* Purpose: This Java program is meant to accompany MenuGUI.java and is dedicated
* to being the grandparent superclass of all shapes listed in the main menu.
* Shape holds attributes name and numberOfDimensions, which all shapes 
* always have. Shape Class has children TwoDimensionalShape and 
* ThreeDimensionalShape which inherits this class's attributes.
* Shape also overrides the toString() method of Object.
* Shape is a child of java.lang.Object class.
*/

// Shape class, parent class. Child of java.lang.Object
public class Shape {
    
    // Variable initialization
    protected String name;
    protected int numberOfDimensions;
    
    // No-argument constructor
    public Shape() {
        name = "Shape";
        numberOfDimensions = 1;
    } // end of method
    
    // Constructor
    public Shape(String name, int numberOfDimensions) {
        this.name = name;
        this.numberOfDimensions = numberOfDimensions;
    } // end of method  
    
    // toString() override
    @Override
    public String toString () {
        return "name = " + name + ", numberOfDimensions = " + numberOfDimensions;
    } // end of method
} // end of class
