/*
* File: Rectangle.java
* Author: John Kucera
* Date: November 21, 2020
* Purpose: This Java program is meant to accompany MenuGUI.java and is dedicated
* to constructing Rectangle objects. Rectangle inherits attributes from 
* TwoDimensionalShape (parent) and Shape (grandparent) and has unique attributes
* int rectangleLength, int rectangleWidth, and double rectangleDiagonal.
* Constructor Rectangle(int rectangleLength, int rectangleWidth) uses arguments
* to determine the area and diagonal. calculateRectangleArea contains
* the formula to calculate area and calculateRectangleDiagonal contains 
* the formula to calculate the rectangle's diagonal. toString method overrides
* that of TwoDimensionalShape.
*/

// Rectangle class, TwoDimensionalShape is parent
public class Rectangle extends TwoDimensionalShape {
    
    // Variable initialization
    final int rectangleLength, rectangleWidth;
    final double rectangleDiagonal;
    
    // No-argument constructor
    public Rectangle () {
        name = "Rectangle";
        numberOfDimensions = 2;
        rectangleLength = 0;
        rectangleWidth = 0;
        area = 0.0;
        rectangleDiagonal = 0.0;
    } // end of method
    
    // Constructor
    public Rectangle (int rectangleLength, int rectangleWidth) {
        name = "Rectangle";
        numberOfDimensions = 2;
        this.rectangleLength = rectangleLength;
        this.rectangleWidth = rectangleWidth;
        area = calculateRectangleArea(rectangleLength, rectangleWidth);
        rectangleDiagonal = calculateRectangleDiagonal(rectangleLength, 
                                                       rectangleWidth);
    } // end of method
    
    // Method to calculate rectangle area
    private double calculateRectangleArea (int rectangleLength, 
                                           int rectangleWidth) {
        int areaRec = rectangleLength * rectangleWidth;
        return areaRec;
    } // end of method
    
    // Method to calculate rectangle diagonal
    private double calculateRectangleDiagonal (int rectangleLength, 
                                               int rectangleWidth) {
        double rectangleDiag = Math.sqrt(Math.pow(rectangleLength, 2.0) 
                                      + Math.pow(rectangleWidth, 2.0));
        return rectangleDiag;
    } // end of method
    
    // toString() override
    @Override
    public String toString () {
        return "name = " + name + ", numberOfDimensions = " + numberOfDimensions 
                + ", area = "  + area + ", rectangleLength = " + rectangleLength + 
                ", rectangleWidth = " + rectangleWidth + ", rectangleDiagonal = " + 
                rectangleDiagonal;
    } // end of method
} // end of class