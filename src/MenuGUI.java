/*
* File: MenuGUI.java
* Author: John Kucera
* Date: November 21, 2020
* Purpose: This Java program constructs a GUI that allows a user to
* construct grandchild objects of the Shape class, such as Circle, Rectangle,
* Sphere, and Cone. After selecting which shape they want to construct, the
* user is prompted to enter dimensions for that shape. The input is used to
* calculate mathematical information about the shapes, such as area and volume.
* Additional unique information, such as the circumference of a circle, is
* also returned depending on the selected shape. Finally, a visual of the shape
* is displayed in a new JFrame, containing a drawing from java.awt.Graphics 
* (if 2d shape) or an image loaded from a file (if 3d shape).
*
* Methods: changeMenu method is used to edit the I/O panel to fit the selected shape.
* For example, if Circle is selected, the menu will contain radius and area, and
* if Cube is selected, the menu will contain length and volume. The Validator
* inner class listens to keys released in the textfields and notifies the user
* if the input is valid. The SelectComboListener inner class listens to the combo
* box and fires the menu changes when different shapes are selected. CalculateBtnListener
* inner class listens to the "Calculate Properties" button and uses the shape
* classes to create the shapes with the input dimensions. This also outputs
* shape properties and visuals to the user. loadImage method is used to load an
* image of a 3d shape as a JLabel. DrawShape inner class uses Graphics and
* input dimensions to draw the shapes as JComponent to be added to the GUI.
* MenuGUI() constructor creates the main menu JFrame and adds all required
* characteristics from other methods. Main method calls MenuGUI() constructor
* when program begins.
*
* References (also cited in the code where the images are loaded):
*   sphere.jpg (loaded at line 452):
*   Cangiano, A. (2007). Sphere. Retrieved November 15, 2020, 
*       from https://mathblog.com/reference/geometry/sphere/
*
*   cube.jpg (loaded at line 485):
*   BenFrantzDale. (2007). Necker cube. Retrieved 
*       November 15, 2020, from 
*       https://commons.wikimedia.org/wiki/File:Necker_cube.svg
*
*   cone.jpg (loaded at line 506):
*   Cangiano, A. (2007). Cone. Retrieved November 15, 2020, 
*       from https://mathblog.com/reference/geometry/cone/
*
*   cylinder.jpg (loaded at line 526):
*   Boddie, K. (2003). Surface Area of a Cylinder: Formula 
*       Examples. Retrieved November 15, 2020, from
*       https://study.com/academy/lesson/finding-the-area-of-a-cylinder-formula-example.html
*
*   ringtorus.jpg (loaded at line 546):
*   Lamb, E. (2015, November 28). A Few of My Favorite Spaces: 
*       The Torus. Retrieved November 15, 2020, from 
*       https://blogs.scientificamerican.com/roots-of-unity/a-few-of-my-favorite-spaces-the-torus/
*
*   horntorus.jpg (loaded at line 559):
*   Sharma, R. (2020, November 14). Torus. Retrieved 
*       November 15, 2020, from https://alchetron.com/Torus
*
*   spindletorus.jpg (loaded at line 571):
*   Murdzek, R. (2007). The Geometry Of The Torus Universe. 
*       International Journal of Modern Physics D, 16(04), 681-686.
*       doi:10.1142/s0218271807009826. Retrieved November 15, 2020,
*       from https://www.worldscientific.com/doi/abs/10.1142/S0218271807009826?journalCode=ijmpd
*/


// import of necessary java classes
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// MenuGUI Class
public class MenuGUI extends JFrame {
    
    // Variable Initialization/Declaration
    private int triangleLongestSide, input1int, input2int, input3int;
    private final String[] selectItems = { "Circle", "Square", "Triangle", 
                                           "Rectangle", "Sphere", "Cube", "Cone", 
                                           "Cylinder", "Torus" };
    private String select;
    private final JLabel inputMsg = new JLabel();
    private final JComboBox<String> selectCombo = new JComboBox<>(selectItems);
    private final JPanel ioPanel = new JPanel();
    private JTextField input1Txt, input2Txt, input3Txt;
    private JTextArea output1Txt, output2Txt;
    
    // Method to change menu bepending on shape selection
    private void changeMenu(String input1, String input2, String input3,
                            String output1, String output2) {
        // Initializing Components
        final JLabel input1Lbl = new JLabel(input1);
        final JLabel input2Lbl = new JLabel(input2);
        final JLabel input3Lbl = new JLabel(input3);
        final JLabel output1Lbl = new JLabel(output1);
        final JLabel output2Lbl = new JLabel(output2);
        input1Txt = new JTextField("");
        input2Txt = new JTextField("");
        input3Txt = new JTextField("");
        output1Txt = new JTextArea("");
        output2Txt = new JTextArea("");
        final JButton calcBtn = new JButton("Calculate Properties");
        
        // Creating Constraints for GridBag
        final GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8,8,8,8);
        gbc.anchor = GridBagConstraints.EAST;
        
        // ioPanel for Input/Output Menu items
        ioPanel.setLayout(new GridBagLayout());
        
        // Label: Message about input
        gbc.gridwidth = 2;
        gbc.gridy = 0;
        ioPanel.add(inputMsg, gbc);
                
        // Label: Input 1
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        ioPanel.add(input1Lbl, gbc);
        
        // Textfield: Input 1
        gbc.gridx = 1;
        input1Txt.addKeyListener(new Validator());
        input1Txt.setColumns(10);
        input1Txt.isFocusable();
        ioPanel.add(input1Txt, gbc);
            
        // Label: Output 1
        gbc.gridx = 2;
        gbc.gridy = 1;
        ioPanel.add(output1Lbl, gbc);
        
        // Label: Output 2
        gbc.gridy = 2;
        ioPanel.add(output2Lbl, gbc);
        
        // TextArea: Output 1
        gbc.gridx = 3;
        gbc.gridy = 1;
        output1Txt.setColumns(20);
        output1Txt.setEditable(false);
        ioPanel.add(output1Txt, gbc);
        
        // TextArea: Output 2
        gbc.gridy = 2;
        output2Txt.setColumns(20);
        output2Txt.setEditable(false);
        ioPanel.add(output2Txt, gbc);
        
        // Additional I/O Items if the shape has multiple necessary dimensions
        if (!"".equals(input2)) {
            // Label: Input 2
            gbc.gridx = 0;
            gbc.gridy = 2;
            ioPanel.add(input2Lbl, gbc);

            // Textfield: Input 2
            gbc.gridx = 1;
            gbc.gridy = 2;
            input2Txt.addKeyListener(new Validator());
            input2Txt.setColumns(10);
            input2Txt.isFocusable();
            ioPanel.add(input2Txt, gbc);
            
            if (!"".equals(input3)) {
                // Label: Input 3
                gbc.gridx = 0;
                gbc.gridy = 3;
                ioPanel.add(input3Lbl, gbc);

                // Textfield: Input 3
                gbc.gridx = 1;
                gbc.gridy = 3;
                input3Txt.addKeyListener(new Validator());
                input3Txt.setColumns(10);
                input3Txt.isFocusable();
                ioPanel.add(input3Txt, gbc);
            } // end of inner if
        } // end of if
        
        // Button: Calculate Properties
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 3;
        gbc.gridy = 0;
        calcBtn.addActionListener(new CalculateBtnListener());
        ioPanel.add(calcBtn, gbc);
    } // End of method
    
    // Validator for input
    private class Validator extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            select = selectCombo.getSelectedItem().toString();
            switch (select) {
                // Shapes that take 1 input dimension
                case "Circle":
                case "Square":
                case "Cube":
                    // Only digits allowed, cannot be only 0
                    if (Pattern.matches("[0-9]+", input1Txt.getText().trim())
                        && !Pattern.matches("[0]+", input1Txt.getText().trim())) {
                        inputMsg.setText("<HTML><U>Input is Valid</U></HTML>");
                    } // end of if
                    else if (input1Txt.getText().equals("")) {
                        inputMsg.setText("<HTML><U>Input Positive Integer(s) "
                                         + "below :</U></HTML>");
                    } // end of else if
                    else {
                        inputMsg.setText("<HTML><U>Input is Invalid</U></HTML>");
                    } // end of else
                    break;
                    
                // Shapes that take 2 input dimensions
                case "Rectangle":
                case "Sphere":
                case "Cone":
                case "Cylinder":
                case "Torus":
                    // Only digits allowed, cannot be only 0
                    if (Pattern.matches("[0-9]+", input1Txt.getText().trim())
                        && Pattern.matches("[0-9]+", input2Txt.getText().trim())
                        && !Pattern.matches("[0]+", input1Txt.getText().trim())
                        && !Pattern.matches("[0]+", input2Txt.getText().trim())) {
                        inputMsg.setText("<HTML><U>Input is Valid</U></HTML>");
                    } // end of if
                    else if (input1Txt.getText().equals("") 
                             || input2Txt.getText().equals("")) {
                        inputMsg.setText("<HTML><U>Input Positive Integer(s) "
                                         + "below :</U></HTML>");
                    } // end of else if
                    else {
                        inputMsg.setText("<HTML><U>Input is Invalid</U></HTML>");
                    } // end of else
                    break;
                
                // Shapes that take 3 input dimensions
                case "Triangle":
                    // Only digits allowed, cannot be only 0
                    if (Pattern.matches("[0-9]+", input1Txt.getText().trim())
                        && Pattern.matches("[0-9]+", input2Txt.getText().trim())
                        && Pattern.matches("[0-9]+", input3Txt.getText().trim())
                        && !Pattern.matches("[0]+", input1Txt.getText().trim())
                        && !Pattern.matches("[0]+", input2Txt.getText().trim())
                        && !Pattern.matches("[0]+", input3Txt.getText().trim())) {
                        inputMsg.setText("<HTML><U>Input is Valid</U></HTML>");
                    } // end of if
                    else if (input1Txt.getText().equals("") 
                             || input2Txt.getText().equals("")
                             || input3Txt.getText().equals("")) {
                        inputMsg.setText("<HTML><U>Input Positive Integer(s) "
                                         + "below :</U></HTML>");
                    } // end of else if
                    else {
                        inputMsg.setText("<HTML><U>Input is Invalid</U></HTML>");
                    } // end of else
                    break;
            } // end of switch
        } // end of method
    } // end of inner class

    // Combo Box Listener
    private class SelectComboListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            // Clear previous menu
            if (JPanel.class.isInstance(ioPanel)) {
                ioPanel.removeAll();
            } // end of if
            
            // Change menu labels based on shape selection
            inputMsg.setText("<HTML><U>Input Positive Integer(s) below :</U></HTML>");
            select = selectCombo.getSelectedItem().toString();
            switch (select) {
                case "Circle":
                    changeMenu("Radius: ", "", "", "Area: ", "Circumference: ");
                    break;
                case "Square":
                    changeMenu("Length/Width: ", "", "", "Area: ", "Diagonal: ");
                    break;
                case "Triangle":
                    changeMenu("Side 1 Length: ", "Side 2 Length: ", 
                               "Side 3 Length: ", "Area: ", "Triangle Type: ");
                    break;
                case "Rectangle":
                    changeMenu("Length: ", "Width: ", "", "Area: ", "Diagonal: ");
                    break;
                case "Sphere":
                    changeMenu("Radius: ", "Spherical Cap Height: ", "", 
                               "Volume: ", "Spherical Cap Volume: ");
                    break;
                case "Cube":
                    changeMenu("Length/Width/Height: ", "", "", "Volume: ",
                               "Space Diagonal: ");
                    break;
                case "Cone":
                    changeMenu("Radius: ", "Height: ", "", "Volume: ",
                               "Slant Height: ");
                    break;
                case "Cylinder":
                    changeMenu("Radius: ", "Height: ", "", "Volume: ", 
                               "Longest Diagonal: ");
                    break;
                case "Torus":
                    changeMenu("Minor Radius: ", "Major Radius: ", "", "Volume: ",
                               "Torus Type: ");
                    break;
            } // end of switch
            pack();
        } // end of method
    } // end of listener class
    
    // Calculate Button Listener
    private class CalculateBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Clear output
            output1Txt.setText("");
            output2Txt.setText("");
            
            // Only allow shape creation if input is valid
            outerloop:
            if (inputMsg.getText().equals("<HTML><U>Input is Valid</U></HTML>")) {
                // Create frame for visual, create shape/visual based on shape
                // selection
                JFrame visualFrame = new JFrame();
                select = selectCombo.getSelectedItem().toString();
                switch (select) {
                    case "Circle":
                        // Circle creation
                        input1int = Integer.parseInt(input1Txt.getText());
                        Circle circle = new Circle(input1int);
                        output1Txt.setText(String.valueOf(circle.area));
                        output2Txt.setText(String.valueOf(circle.circumference));

                        // Draw circle, set frame size to fit
                        DrawShape circleVisual = new DrawShape();
                        visualFrame.setSize((circle.circleRadius*2+50),
                                            (circle.circleRadius*2+60));
                        visualFrame.setTitle(circle.name);
                        visualFrame.add(circleVisual);
                        break;
                    
                    case "Square":
                        // Square creation
                        input1int = Integer.parseInt(input1Txt.getText());
                        Square square = new Square(input1int);
                        output1Txt.setText(String.valueOf(square.area));
                        output2Txt.setText(String.valueOf(square.squareDiagonal));

                        // Draw square, set frame size to fit
                        DrawShape squareVisual = new DrawShape();
                        visualFrame.setSize((square.squareLength+50),
                                            (square.squareLength+60));
                        visualFrame.setTitle(square.name);
                        visualFrame.add(squareVisual);
                        break;

                    case "Triangle":
                        // Triangle creation
                        input1int = Integer.parseInt(input1Txt.getText());
                        input2int = Integer.parseInt(input2Txt.getText());
                        input3int = Integer.parseInt(input3Txt.getText());
                        Triangle triangle = new Triangle(input1int, input2int, input3int);
                        
                        // Only continue if triangle can exist with input dimensions
                        if (!Double.isNaN(triangle.area) && triangle.area > 0.0) {
                            output1Txt.setText(String.valueOf(triangle.area));
                            output2Txt.setText(triangle.triangleType);

                            // Finding Longest Side to adjust frame size/triangle center point
                            if ((triangle.side1Length > triangle.side2Length) 
                                && (triangle.side1Length > triangle.side3Length)) {
                                triangleLongestSide = triangle.side1Length;
                            } // end of inner if
                            else if (triangle.side2Length > triangle.side3Length) {
                                triangleLongestSide = triangle.side2Length;
                            } // end of inner else if
                            else {
                                triangleLongestSide = triangle.side3Length;
                            } // end of inner else
                            
                            // Draw Triangle, set frame size to fit
                            DrawShape triangleVisual = new DrawShape();
                            visualFrame.setSize(triangleLongestSide+100, 
                                                triangleLongestSide+100);
                            visualFrame.setTitle(triangle.name);
                            visualFrame.add(triangleVisual);
                            break;
                        } // end of if
                        // Display message if triangle cannot exist with input dimensions
                        else {
                            visualFrame.dispose();
                            final JOptionPane invalidMsg = new JOptionPane();
                            JOptionPane.showMessageDialog(invalidMsg, "This "
                                                          + "Triangle cannot "
                                                          + "exist with the "
                                                          + "dimensions provided."
                                                          + " Please try again.");
                            break outerloop;
                        } // end of inner else
                        
                    case "Rectangle":
                        // Rectangle creation
                        input1int = Integer.parseInt(input1Txt.getText());
                        input2int = Integer.parseInt(input2Txt.getText());
                        Rectangle rectangle = new Rectangle(input1int, input2int);
                        output1Txt.setText(String.valueOf(rectangle.area));
                        output2Txt.setText(String.valueOf(rectangle.rectangleDiagonal));

                        // Draw rectange, set frame size to fit
                        DrawShape rectangleVisual = new DrawShape();
                        visualFrame.setSize((rectangle.rectangleLength+50),
                                            (rectangle.rectangleWidth+60));
                        visualFrame.setTitle(rectangle.name);
                        visualFrame.add(rectangleVisual);
                        break;
                    
                    case "Sphere":
                        // Sphere creation
                        input1int = Integer.parseInt(input1Txt.getText());
                        input2int = Integer.parseInt(input2Txt.getText());
                        Sphere sphere = new Sphere(input1int, input2int);
                        
                        // Only continue if radius is greater than cap height
                        if (sphere.sphereRadius > sphere.capHeight) {
                            output1Txt.setText(Double.toString(sphere.volume));
                            output2Txt.setText(Double.toString(sphere.capVolume));
                            
                            // Load sphere image
                            visualFrame.setTitle(sphere.name);
                            visualFrame.add(loadImage("sphere.jpg")); // Citation below
                            
                            /*
                                * Cangiano, A. (2007). Sphere. Retrieved November 15, 2020, 
                                *   from https://mathblog.com/reference/geometry/sphere/
                            */
                            
                            visualFrame.pack();
                            break;
                        } // end of if
                        
                        // Display message if radius is not greater than cap height
                        else {
                            visualFrame.dispose();
                            final JOptionPane invalidMsg = new JOptionPane();
                            JOptionPane.showMessageDialog(invalidMsg, "The "
                                                          + "Spherical Cap "
                                                          + "cannot have a Height "
                                                          + "greater than or equal"
                                                          + " to the Sphere's Radius."
                                                          + " Please try again.");
                            break outerloop;
                        } // end of else
                    
                    case "Cube":
                        // Cube creation
                        input1int = Integer.parseInt(input1Txt.getText());
                        Cube cube = new Cube(input1int);
                        output1Txt.setText(String.valueOf(cube.volume));
                        output2Txt.setText(String.valueOf(cube.spaceDiagonal));
                        
                        // Load cube image
                        visualFrame.setTitle(cube.name);
                        visualFrame.add(loadImage("cube.jpg")); // citation below
                            
                            /*
                            * BenFrantzDale. (2007). Necker cube. Retrieved 
                            *   November 15, 2020, from 
                            *   https://commons.wikimedia.org/wiki/File:Necker_cube.svg
                            */
                            
                        visualFrame.pack();
                        break;
                        
                    case "Cone":
                        // Cone creation
                        input1int = Integer.parseInt(input1Txt.getText());
                        input2int = Integer.parseInt(input2Txt.getText());
                        Cone cone = new Cone(input1int, input2int);
                        output1Txt.setText(String.valueOf(cone.volume));
                        output2Txt.setText(String.valueOf(cone.slantHeight));
                        
                        // Load cone image
                        visualFrame.setTitle(cone.name);
                        visualFrame.add(loadImage("cone.jpg")); // citation below
                            
                            /*
                            * Cangiano, A. (2007). Cone. Retrieved November 15, 2020, 
                            *   from https://mathblog.com/reference/geometry/cone/
                            */
                            
                        visualFrame.pack();
                        break;
                    
                    case "Cylinder":
                        // Cylinder creation
                        input1int = Integer.parseInt(input1Txt.getText());
                        input2int = Integer.parseInt(input2Txt.getText());
                        Cylinder cylinder = new Cylinder(input1int, input2int);
                        output1Txt.setText(String.valueOf(cylinder.volume));
                        output2Txt.setText(String.valueOf(cylinder.cylinderLongestDiagonal));
                        
                        // Load cylinder image
                        visualFrame.setTitle(cylinder.name);
                        visualFrame.add(loadImage("cylinder.jpg"));
                            
                            /*
                            * Boddie, K. (2003). Surface Area of a Cylinder: Formula 
                            *   Examples. Retrieved November 15, 2020, from
                            *   https://study.com/academy/lesson/finding-the-area-of-a-cylinder-formula-example.html
                            */
                            
                        visualFrame.pack();
                        break;

                    case "Torus":
                        // Torus creation
                        input1int = Integer.parseInt(input1Txt.getText());
                        input2int = Integer.parseInt(input2Txt.getText());
                        Torus torus = new Torus(input1int, input2int);
                        output2Txt.setText(torus.torusType);
                        
                        // Load Ring Torus image
                        if ("Ring".equals(torus.torusType)) {
                            visualFrame.add(loadImage("ringtorus.jpg")); // citation below
                            
                            /*
                            * Lamb, E. (2015, November 28). A Few of My Favorite Spaces: 
                            *   The Torus. Retrieved November 15, 2020, from 
                            *   https://blogs.scientificamerican.com/roots-of-unity/a-few-of-my-favorite-spaces-the-torus/
                            */
                            
                            output1Txt.setText(String.valueOf(torus.volume));
                        } // end of if

                        // Load Horn Torus image
                        else if ("Horn".equals(torus.torusType)) {
                            visualFrame.add(loadImage("horntorus.jpg")); // citation below
                            
                            /*
                            * Sharma, R. (2020, November 14). Torus. Retrieved 
                            *   November 15, 2020, from https://alchetron.com/Torus
                            */
                            
                            output1Txt.setText(String.valueOf(torus.volume));
                        } // end of else if
                        
                        // Load Spindle Torus image
                        else {
                            visualFrame.add(loadImage("spindletorus.jpg")); // citation below
                            
                            /*
                            * Murdzek, R. (2007). The Geometry Of The Torus Universe. 
                            *   International Journal of Modern Physics D, 16(04), 681-686.
                            *   doi:10.1142/s0218271807009826. Retrieved November 15, 2020,
                            *   from https://www.worldscientific.com/doi/abs/10.1142/S0218271807009826?journalCode=ijmpd
                            */
                            
                            output1Txt.setText("Cannot be calculated for Spindle");
                        } // end of else
                        visualFrame.setTitle(torus.name);
                        visualFrame.pack();
                        break;
                } // end of switch
                
                // Misc frame settings
                visualFrame.setMinimumSize(new Dimension(60,60));
                visualFrame.setVisible(true);
                visualFrame.setLocationRelativeTo(null);  
            } // end of if
            
            // Create Dialog if input is invalid or empty
            else {
                final JOptionPane invalidMsg = new JOptionPane();
                JOptionPane.showMessageDialog(invalidMsg, "Please enter a "
                                              + "positive integer(s).");
            } // end of else
        } // end of method
    } // end of inner class
    
    // Method for loading image and turning into JLabel
    private JLabel loadImage (String filename) {
        ImageIcon shapeImg = new ImageIcon(getClass().getResource(filename));
        JLabel shapeLbl = new JLabel(shapeImg);
        return shapeLbl;
    } // end of method
    
    // Inner Class to draw with Graphics
    private class DrawShape extends JComponent {
        // Constructor
        DrawShape() {
            
        } // end of constructor
        
        // Method for drawing shape based on shape selection
        @Override
        protected void paintComponent(Graphics g) {
            select = selectCombo.getSelectedItem().toString();
            switch (select) {
                case "Circle":
                    super.paintComponent(g);
                    // input is radius
                    g.drawOval(10, 10, input1int*2, input1int*2);
                    break;
                case "Square":
                    super.paintComponent(g);
                    // input is length/width
                    g.drawRect(10, 10, input1int, input1int);
                    break;
                case "Triangle":
                    super.paintComponent(g);
                    // input is lengths of 3 sides
                    // Law of cosines to determine angle
                    final double theta = Math.acos(-(Math.pow(input1int, 2.0) 
                                   - Math.pow(input2int, 2.0) - Math.pow(input3int, 2.0)) 
                                   / (2.0 * input2int * input3int));

                    // Array for points, determine points with law of cosines
                    final Point[] points = new Point[3];
                    points[0] = new Point(0, 0);
                    points[1] = new Point(input2int, 0);
                    points[2] = new Point((int)(input3int * Math.cos(theta)), 
                                     (int)(input3int * Math.sin(theta)));

                    // Determine center point
                    Point center = new Point((points[0].x + points[1].x + points[2].x) / 3, 
                                             (points[0].y + points[1].y + points[2].y) / 3);
                    // Translate array elements to coordinates
                    for (Point i : points) 
                        i.translate(-center.x, -center.y);
                        final Point coord = new Point(triangleLongestSide/2,
                                                      triangleLongestSide/2);
                        g.translate(coord.x, coord.y);
                        for (int i = 0; i < points.length; i++) {
                            g.drawLine(points[i].x, points[i].y, 
                                       points[(i+1) % points.length].x, 
                                       points[(i+1) % points.length].y);
                        } // end of inner for
                    break;
                
                case "Rectangle":
                    super.paintComponent(g);
                    // input is length/width
                    g.drawRect(10, 10, input1int, input2int);
                    break;
            } // end of switch
        } // end of method
    } // end of inner class
    
    // Constructor
    public MenuGUI() {
        
        // Selection Label
        final JPanel selectPanel = new JPanel();
        final JLabel selectLbl = new JLabel("Select Shape:");
        selectPanel.add(selectLbl);
        
        // Selection Combo box, set selected item to fire item changed event,
        // then set selected item back to Circle for start-up
        selectCombo.addItemListener(new SelectComboListener());
        selectCombo.setSelectedItem("Square");
        selectCombo.setSelectedItem("Circle");
        selectPanel.add(selectCombo);
        
        // Adding shape selection and menu to frame
        final JPanel main = new JPanel(new BorderLayout());
        main.add(selectPanel, BorderLayout.PAGE_START);
        main.add(ioPanel, BorderLayout.CENTER);
        add(main);
        
        // Frame characteristics
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Shape Calculator");
        setLocationRelativeTo(null);
        setResizable(false);
        pack();
    } // end of constructor
    
    // Main method
    public static void main (String[] args) {
        // GUI Creation
        MenuGUI newGUI = new MenuGUI();
    } // end of main method
} // end of class
