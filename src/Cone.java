/*
* File: Cone.java
* Author: John Kucera
* Date: November 21, 2020
* Purpose: This Java program is meant to accompany MenuGUI.java and is dedicated
* to constructing Cone objects. Cone inherits attributes from 
* ThreeDimensionalShape (parent) and Shape (grandparent) and has unique attributes
* int coneRadius, int coneHeight, and double slantHeight.
* Cone(int coneRadius, int coneHeight) constructor uses the arguments to
* determine volume and slant height. calculateConeVolume contains the formula to
* calculate volume and calculateSlantHeight contains the formula to calculate
* slant height. toString method overrides that of ThreeDimensionalShape.
*/

// Cone class, ThreeDimensionalShape is parent
public class Cone extends ThreeDimensionalShape {
    
    // Variable initialization
    final int coneRadius, coneHeight;
    final double slantHeight;
    
    // No-argument constructor
    public Cone () {
        name = "Cone";
        numberOfDimensions = 3;
        coneRadius = 0;
        coneHeight = 0;
        volume = 0.0;
        slantHeight = 0.0;
    } // end of method
    
    // Constructor
    public Cone (int coneRadius, int coneHeight) {
        name = "Cone";
        numberOfDimensions = 3;
        this.coneRadius = coneRadius;
        this.coneHeight = coneHeight;
        volume = calculateConeVolume(coneRadius, coneHeight);
        slantHeight = calculateSlantHeight(coneRadius, coneHeight);
    } // end of method
    
    // Method to calculate cone volume
    private double calculateConeVolume (int coneRadius, int coneHeight) {
        volume = Math.PI * Math.pow(coneRadius, 2.0) * coneHeight / 3.0;
        return volume;
    } // end of method
    
    // Method to calculate slant height
    private double calculateSlantHeight (int coneRadius, int coneHeight) {
        double slantH = Math.sqrt(Math.pow(coneRadius, 2.0) + Math.pow(coneHeight, 2.0));
        return slantH;
    } // end of method
    
    // toString() override
    @Override
    public String toString () {
        return "name = " + name + ", numberOfDimensions = " + numberOfDimensions 
                + ", volume = "  + volume + ", coneRadius = " + coneRadius + 
                ", coneHeight = " + coneHeight + ", slantHeight = " + slantHeight;
    } // end of method
} // end of class
