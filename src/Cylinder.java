/*
* File: Cylinder.java
* Author: John Kucera
* Date: November 21, 2020
* Purpose: This Java program is meant to accompany MenuGUI.java and is dedicated
* to constructing Cylinder objects. Cylinder inherits attributes from 
* ThreeDimensionalShape (parent) and Shape (grandparent) and has unique attributes
* int cylinderRadius, int cylinderHeight, and double cylinderLongestDiagonal.
* Constructor Cylinder(int cylinderRadius, int cylinderHeight) uses arguments
* to determine the volume and longest diagonal. calculateCylinderVolume contains
* the formula to calculate volume and calculateCylinderLongestDiagonal contains 
* the formula to calculate the cylinder's longest diagonal. toString method
* overrides that of ThreeDimensionalShape.
*/

// Cylinder class, ThreeDimensionalShape is parent
public class Cylinder extends ThreeDimensionalShape {
    
    // Variable initialization
    final int cylinderRadius, cylinderHeight;
    final double cylinderLongestDiagonal;
    
    // No-argument constructor
    public Cylinder () {
        name = "Cylinder";
        numberOfDimensions = 3;
        cylinderRadius = 0;
        cylinderHeight = 0;
        volume = 0.0;
        cylinderLongestDiagonal = 0.0;
    } // end of method
    
    // Constructor
    public Cylinder (int cylinderRadius, int cylinderHeight) {
        name = "Cylinder";
        numberOfDimensions = 3;
        this.cylinderRadius = cylinderRadius;
        this.cylinderHeight = cylinderHeight;
        volume = calculateCylinderVolume(cylinderRadius, cylinderHeight);
        cylinderLongestDiagonal = calculateCylinderLongestDiagonal(cylinderRadius, 
                                                                   cylinderHeight);
    } // end of method
    
    // Method to calculate cylinder volume
    private double calculateCylinderVolume (int cylinderRadius, 
                                            int cylinderHeight) {
        volume = Math.PI * Math.pow(cylinderRadius, 2.0) * cylinderHeight;
        return volume;
    } // end of method
    
    // Method to calculate longest diagonal
    private double calculateCylinderLongestDiagonal (int cylinderRadius, 
                                                     int cylinderHeight) {
        double longestDiagonal = Math.sqrt(4.0 * Math.pow(cylinderRadius, 2.0) 
                                 + Math.pow(cylinderHeight, 2.0));
        return longestDiagonal;
    } // end of method
    
    // toString() override
    @Override
    public String toString () {
        return "name = " + name + ", numberOfDimensions = " + numberOfDimensions 
                + ", volume = "  + volume + ", cylinderRadius = " + cylinderRadius + 
                ", cylinderHeight = " + cylinderHeight + 
                ", cylinderLongestDiagonal = " + cylinderLongestDiagonal;
    } // end of method
} // end of class
