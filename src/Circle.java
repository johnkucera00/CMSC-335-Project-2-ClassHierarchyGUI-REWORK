/*
* File: Circle.java
* Author: John Kucera
* Date: November 21, 2020
* Purpose: This Java program is meant to accompany MenuGUI.java and is dedicated
* to constructing Circle objects. Circle inherits attributes from 
* TwoDimensionalShape (parent) and Shape (grandparent) and has unique attributes
* int circleRadius and double circumference. Circle(int circleRadius)
* constructor uses the argument as radius and uses that to determine area and
* circumference. calculateCircleArea(int circleRadius) contains the formula to
* calculate area and calculateCircumference(int circleRadius) contains the
* formula to calculate circumference. toString() method overrides that of
* TwoDimensionalShape.
*/

// Circle class, TwoDimensionalShape is parent
public class Circle extends TwoDimensionalShape {
    
    // Variable initialization
    final int circleRadius; 
    final double circumference;
    
    // No-argument constructor
    public Circle () {
        name = "Circle";
        numberOfDimensions = 2;
        circleRadius = 0;
        area = 0.0;
        circumference = 0.0;
    } // end of method
    
    // Constructor
    public Circle (int circleRadius) {
        name = "Circle";
        numberOfDimensions = 2;
        this.circleRadius = circleRadius;
        area = calculateCircleArea(circleRadius);
        circumference = calculateCircumference(circleRadius);
    } // end of method
    
    // Method to calculate circle area
    private double calculateCircleArea (int circleRadius) {
        area = Math.PI * Math.pow(circleRadius, 2.0);
        return area;
    } // end of method
    
    // Method to calculate circle circumference
    private double calculateCircumference (int circleRadius) {
        double circum = 2.0 * Math.PI * circleRadius;
        return circum;
    } // end of method
    
    // toString() override
    @Override
    public String toString () {
        return "name = " + name + ", numberOfDimensions = " + numberOfDimensions 
                + ", area = "  + area + ", circleRadius = " + circleRadius + 
                ", circumference = " + circumference;
    } // end of method
} // end of class
