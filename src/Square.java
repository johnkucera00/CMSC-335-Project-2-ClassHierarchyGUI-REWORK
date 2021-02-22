/*
* File: Square.java
* Author: John Kucera
* Date: November 21, 2020
* Purpose: This Java program is meant to accompany MenuGUI.java and is dedicated
* to constructing Square objects. Square inherits attributes from 
* TwoDimensionalShape (parent) and Shape (grandparent) and has unique attributes
* int squareLength and double squareDiagonal. Constructor Square(int
* squareLength) uses arguments to determine the area and diagonal. 
* calculateSquareArea contains the formula to calculate area and
* calculateSquareDiagonal contains the formula to calculate the square's diagonal.
* toString method overrides that of TwoDimensionalShape.
*/

// Square class, TwoDimensionalShape is parent
public class Square extends TwoDimensionalShape {
    
    // Variable initialization
    final int squareLength;
    final double squareDiagonal;
    
    // No-argument constructor
    public Square () {
        name = "Square";
        numberOfDimensions = 2;
        squareLength = 0;
        area = 0.0;
        squareDiagonal = 0.0;
    } // end of method
    
    // Constructor
    public Square (int squareLength) {
        name = "Square";
        numberOfDimensions = 2;
        this.squareLength = squareLength;
        area = calculateSquareArea(squareLength);
        squareDiagonal = calculateSquareDiagonal(squareLength);
    } // end of method
    
    // Method to calculate square area
    private double calculateSquareArea (int squareLength) {
        area = Math.pow(squareLength, 2.0);
        return area;
    } // end of method
    
    // Method to calculate square Diagonal
    private double calculateSquareDiagonal (int squareLength) {
        double squareDiag = squareLength * Math.sqrt(2.0);
        return squareDiag;
    } // end of method
    
    // toString() override
    @Override
    public String toString () {
        return "name = " + name + ", numberOfDimensions = " + numberOfDimensions 
                + ", area = "  + area + ", squareLength = " + squareLength + 
                ", squareDiagonal = " + squareDiagonal;
    } // end of method
} // end of class
