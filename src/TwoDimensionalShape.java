/*
* File: TwoDimensionalShape.java
* Author: John Kucera
* Date: November 21, 2020
* Purpose: This Java program is meant to accompany MenuGUI.java and is dedicated
* to holding attributes for TwoDimensionalShape children. The parent class
* is Shape from which numberOfDimensions is inherited. All children, including
* circle, rectangle, square, and triangle, inherit double area from this class.
* Constructor TwoDimensionalShape(String name, double area) is unused in
* this application but allows a shape name and area to be input, as well as
* automatically assumes numberOfDimensions to be 2 dimensions. toString() method
* overrides that of Shape.
*/

// TwoDimensionalShape class, Shape is parent
public class TwoDimensionalShape extends Shape {
    
    // Variable initialization
    double area;
    
    // No-argument constructor
    public TwoDimensionalShape () {
        name = "Two Dimensional Shape";
        numberOfDimensions = 2;
        area = 0.0;
    } // end of method
    
    // Constructor
    public TwoDimensionalShape (String name, double area) {
        this.name = name;
        numberOfDimensions = 2;
        this.area = area;
    } // end of method
    
    // toString() override
    @Override
    public String toString () {
        return "name = " + name + ", numberOfDimensions = " + numberOfDimensions 
                + ", area = "  + area;
    } // end of method
} // end of class
