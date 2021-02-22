/*
* File: Torus.java
* Author: John Kucera
* Date: November 21, 2020
* Purpose: This Java program is meant to accompany MenuGUI.java and is dedicated
* to constructing Torus objects. Torus inherits attributes from 
* ThreeDimensionalShape (parent) and Shape (grandparent) and has unique attributes
* int minorRadius, int majorRadius, and String torusType. Constructor 
* Torus(int minorRadius, int majorRadius) uses arguments to determine the
* volume and torus type. determineTorusType is used to compare the minorRadius and
* majorRadius to determine the Torus type (Ring, Horn, or Spindle).
* calculateTorusVolume contains the formula to calculate the volume and accounts
* for the fact that Spindle Torus volume cannot be calculated. toString method
* overrides that of ThreeDimensionalShape.
*/

// Torus class, ThreeDimensionalShape is parent
public class Torus extends ThreeDimensionalShape {
    
    // Variable initialization
    final int minorRadius, majorRadius;
    final String torusType;
    
    // No-argument constructor
    public Torus () {
        name = "Torus";
        numberOfDimensions = 3;
        minorRadius = 0;
        majorRadius = 0;
        volume = 0.0;
        torusType = null;
    } // end of method
    
    // Constructor
    public Torus (int minorRadius, int majorRadius) {
        name = "Torus";
        numberOfDimensions = 3;
        this.minorRadius = minorRadius;
        this.majorRadius = majorRadius;
        torusType = determineTorusType(minorRadius, majorRadius);
        volume = calculateTorusVolume(minorRadius, majorRadius, torusType);
    } // end of method
    
    // Method to determine Torus type
    private String determineTorusType (int minorRadius, int majorRadius) {
        // Ring torus, r < R
        String type;
        if (minorRadius < majorRadius) {
            type = "Ring";
        } // end of if
        
        // Horn torus, r = R
        else if (minorRadius == majorRadius) {
            type = "Horn";
        } // end of else if
        
        // Spindle torus, r > R
        else {
            type = "Spindle";
        } // end of else
        return type;
    } // end of method
    
    // Method to calculate Torus volume
    private double calculateTorusVolume (int minorRadius, int majorRadius,
                                         String torusType) {
        // Calculate volume for Ring and Horn torus
        if ("Ring".equals(torusType) || "Horn".equals(torusType)) {
            volume = (Math.PI * Math.pow(minorRadius, 2.0)) 
                    * (2.0 * Math.PI * majorRadius);
        } // end of if
        
        // Volume cannot be calculated for Spindle Torus
        else {
            volume = Double.NaN;
        } // end of else
        return volume;
    } // end of method
    
    // toString() override
    @Override
    public String toString () {
        return "name = " + name + ", numberOfDimensions = " + numberOfDimensions 
                + ", volume = "  + volume + ", minorRadius = " + minorRadius + 
                ", majorRadius = " + majorRadius + ", torusType = " + torusType;
    } // end of method
} // end of class
