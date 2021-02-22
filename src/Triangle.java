/*
* File: Triangle.java
* Author: John Kucera
* Date: November 21, 2020
* Purpose: This Java program is meant to accompany MenuGUI.java and is dedicated
* to constructing Triangle objects. Triangle inherits attributes from 
* TwoDimensionalShape (parent) and Shape (grandparent) and has unique attributes
* int side1Length, int side2Length, int side3Length, and String triangleType. 
* Constructor Triangle(int side1Length, int side2Length, int side3Length) 
* uses arguments to determine the area and triangle type. 
* calculateTriangleArea uses the 3 side lengths to calculate
* the area with Heron's formula. determineTriangleType compares the 3 side 
* lengths to determine the type of triangle: equilateral, isoceles, or scalene.
* toString method overrides that of TwoDimensionalShape.
*/

// Triangle class, TwoDimensionalShape is parent
public class Triangle extends TwoDimensionalShape {
    
    // Variable initialization
    final int side1Length, side2Length, side3Length;
    final String triangleType;
    
    // No-argument constructor
    public Triangle () {
        name = "Triangle";
        numberOfDimensions = 2;
        side1Length = 0;
        side2Length = 0;
        side3Length = 0;
        area = 0.0;
        triangleType = null;
    } // end of method
    
    // Constructor
    public Triangle (int side1Length, int side2Length, int side3Length) {
        name = "Triangle";
        numberOfDimensions = 2;
        this.side1Length = side1Length;
        this.side2Length = side2Length;
        this.side3Length = side3Length;
        area = calculateTriangleArea(side1Length, side2Length, side3Length);
        triangleType = determineTriangleType(side1Length, side2Length, side3Length);
    } // end of method
    
    // Method to calculate triangle area with Heron's formula
    private double calculateTriangleArea (int side1Length, int side2Length, 
                                           int side3Length) {
        double semiPerimeter = (side1Length + side2Length + side3Length) / 2.0;
        area = Math.sqrt(semiPerimeter * (semiPerimeter - side1Length)
                         * (semiPerimeter - side2Length) * (semiPerimeter - 
                         side3Length));
        return area;
    } // end of method
    
    // Method to determine triangle type
    private String determineTriangleType (int side1Length, int side2Length, 
                                           int side3Length) {
        String type;
        // Equilateral, 3 equal sides
        if (side1Length == side2Length && side2Length == side3Length) {
            type = "Equilateral";
        } // end of if
        
        // Isosceles, 2 equal sides
        else if (side1Length == side2Length || side2Length == side3Length
                 || side1Length == side3Length) {
            type = "Isosceles";
        } // end of else if
        
        // Scalene, no equal sides
        else {
            type = "Scalene";
        } // end of else
        
        return type;
    } // end of method
    
    // toString() override
    @Override
    public String toString () {
        return "name = " + name + ", numberOfDimensions = " + numberOfDimensions 
                + ", area = "  + area + ", side1Length = " + side1Length + 
                ", side2Length = " + side2Length + ", side3Length = " + 
                side3Length + ", triangleType = " + triangleType;
    } // end of method
} // end of class