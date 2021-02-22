/*
* File: Cube.java
* Author: John Kucera
* Date: November 21, 2020
* Purpose: This Java program is meant to accompany MenuGUI.java and is dedicated
* to constructing Cube objects. Cube inherits attributes from 
* ThreeDimensionalShape (parent) and Shape (grandparent) and has unique attributes
* int cubeLength and double spaceDiagonal. Constructor Cube(int cubeLength)
* uses the arguments to determine volume and space diagonal. calculateCubeVolume
* contains the formula to calculate volume and calculateCubeSpaceDiagonal contains
* the formula to calculate the cube's space diagonal. toString method overrides
* that of ThreeDimensionalShape.
*/

// Cube class, ThreeDimensionalShape is parent
public class Cube extends ThreeDimensionalShape {
    
    // Variable initialization
    final int cubeLength;
    final double spaceDiagonal;
    
    // No-argument constructor
    public Cube () {
        name = "Cube";
        numberOfDimensions = 3;
        cubeLength = 0;
        volume = 0.0;
        spaceDiagonal = 0.0;
    } // end of method
    
    // Constructor
    public Cube (int cubeLength) {
        name = "Cube";
        numberOfDimensions = 3;
        this.cubeLength = cubeLength;
        volume = calculateCubeVolume(cubeLength);
        spaceDiagonal = calculateCubeSpaceDiagonal(cubeLength);
    } // end of method
    
    // Method to calculate cube volume
    private double calculateCubeVolume (int cubeLength) {
        volume = Math.pow(cubeLength, 3.0);
        return volume;
    } // end of method
    
    // Method to calculate space diagonal
    private double calculateCubeSpaceDiagonal (int cubeLength) {
        double spaceDiag = cubeLength * Math.sqrt(3.0);
        return spaceDiag;
    } // end of method
    
    // toString() override
    @Override
    public String toString () {
        return "name = " + name + ", numberOfDimensions = " + numberOfDimensions 
                + ", volume = "  + volume + ", cubeLength = " + cubeLength + 
                ", spaceDiagonal = " + spaceDiagonal;
    } // end of method
} // end of class
