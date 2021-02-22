/*
* File: ThreeDimensionalShape.java
* Author: John Kucera
* Date: November 21, 2020
* Purpose: This Java program is meant to accompany MenuGUI.java and is dedicated
* to holding attributes for ThreeDimensionalShape children. The parent class
* is Shape from which numberOfDimensions is inherited. All children, including
* sphere, cube, cone, cylinder, and torus, inherit double volume from this class.
* Constructor ThreeDimensionalShape(String name, double volume) is unused in
* this application but allows a shape name and volume to be input, as well as
* automatically assumes numberOfDimensions to be 3 dimensions. toString() method
* overrides that of Shape.
*/

// ThreeDimensionalShape class, Shape is parent
public class ThreeDimensionalShape extends Shape {
    
    // Variable initialization
    double volume;
    
    // No-argument constructor
    public ThreeDimensionalShape () {
        name = "Three Dimensional Shape";
        numberOfDimensions = 3;
        volume = 0.0;
    } // end of method
    
    // Constructor
    public ThreeDimensionalShape (String name, double volume) {
        this.name = name;
        numberOfDimensions = 3;
        this.volume = volume;
    } // end of method
    
    // toString() override
    @Override
    public String toString () {
        return "name = " + name + ", numberOfDimensions = " + numberOfDimensions 
                + ", volume = "  + volume;
    } // end of method
} // end of class