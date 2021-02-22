/*
* File: Sphere.java
* Author: John Kucera
* Date: November 21, 2020
* Purpose: This Java program is meant to accompany MenuGUI.java and is dedicated
* to constructing Sphere objects. Sphere inherits attributes from 
* ThreeDimensionalShape (parent) and Shape (grandparent) and has unique attributes
* int sphereRadius, int capHeight, and double capVolume.
* Constructor Sphere(int sphereRadius, int capHeight) uses arguments
* to determine the volume and spherical cap volume. calculateSphereVolume contains
* the formula to calculate volume and calculateCapVolume contains the formula
* to calculate the spherical cap's volume. toString method overrides that of
* ThreeDimensionalShape.
*/

// Sphere class, ThreeDimensionalShape is parent
public class Sphere extends ThreeDimensionalShape {
    
    // Variable initialization
    final int sphereRadius, capHeight;
    final double capVolume;
    
    // No-argument constructor
    public Sphere () {
        name = "Sphere";
        numberOfDimensions = 3;
        sphereRadius = 0;
        volume = 0.0;
        capHeight = 0;
        capVolume = 0.0;
    } // end of method
    
    // Constructor
    public Sphere (int sphereRadius, int capHeight) {
        name = "Sphere";
        numberOfDimensions = 3;
        this.sphereRadius = sphereRadius;
        volume = calculateSphereVolume(sphereRadius);
        this.capHeight = capHeight;
        capVolume = calculateCapVolume(sphereRadius, capHeight);
    } // end of method
    
    // Method to calculate sphere volume
    private double calculateSphereVolume (int sphereRadius) {
        volume = (4.0 / 3.0) * Math.PI * Math.pow(sphereRadius, 3.0);
        return volume;
    } // end of method
    
    // Method to calculate spherical cap volume
    private double calculateCapVolume (int sphereRadius, int capHeight) {
        double capVol = Math.PI * Math.pow(capHeight, 2.0) 
                   * (sphereRadius - (1.0 / 3.0) * capHeight);
        return capVol;
    } // end of method
    
    // toString() override
    @Override
    public String toString () {
        return "name = " + name + ", numberOfDimensions = " + numberOfDimensions 
                + ", volume = "  + volume + ", sphereRadius = " + sphereRadius + 
                ", capHeight = " + capHeight + ", capVolume = " + 
                capVolume;
    } // end of method
} // end of class
