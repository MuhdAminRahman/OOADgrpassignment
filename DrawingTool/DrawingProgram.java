package DrawingTool;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class DrawingProgram extends JFrame {
    DrawingPanel drawingPanel;
    String shapeType;

    Image freehandImage;
    Image lineImage;
    Image rectangleImage;
    Image circleImage;
    Image ovalImage;
    Image triangleImage;

    public DrawingProgram() {
        super("Painter");
        JPanel toolbar = new JPanel(new FlowLayout(FlowLayout.LEFT));

        toolbar.add(new JLabel("Drag mouse to draw"));
        this.add(toolbar, BorderLayout.SOUTH);

        try {
            freehandImage = ImageIO.read(getClass().getResource("icons/freehand.png")).getScaledInstance(10, 10, java.awt.Image.SCALE_SMOOTH);
            lineImage = ImageIO.read(getClass().getResource("icons/line.png")).getScaledInstance(10, 10, java.awt.Image.SCALE_SMOOTH);
            rectangleImage = ImageIO.read(getClass().getResource("icons/rectangle.png")).getScaledInstance(10, 10, java.awt.Image.SCALE_SMOOTH);
            circleImage = ImageIO.read(getClass().getResource("icons/circle.png")).getScaledInstance(10, 10, java.awt.Image.SCALE_SMOOTH);
            ovalImage = ImageIO.read(getClass().getResource("icons/oval.png")).getScaledInstance(10, 10, java.awt.Image.SCALE_SMOOTH);
            triangleImage = ImageIO.read(getClass().getResource("icons/triangle.png")).getScaledInstance(10, 10, java.awt.Image.SCALE_SMOOTH);
        } catch (Exception e) {
            System.out.println(e);

        }

        drawingPanel = new DrawingPanel();
        toolbar.add(new ColorButton(drawingPanel));
        toolbar.add(new LineThicknessSlider(drawingPanel));
        toolbar.add(new ShapeButton(drawingPanel, "Freehand", new ImageIcon(freehandImage)));
        toolbar.add(new ShapeButton(drawingPanel, "Line", new ImageIcon(lineImage)));
        toolbar.add(new ShapeButton(drawingPanel, "Rectangle", new ImageIcon(rectangleImage)));
        toolbar.add(new ShapeButton(drawingPanel, "Circle", new ImageIcon(circleImage)));
        toolbar.add(new ShapeButton(drawingPanel, "Oval", new ImageIcon(ovalImage)));
        toolbar.add(new ShapeButton(drawingPanel, "Triangle", new ImageIcon(triangleImage)));

        this.add(drawingPanel, BorderLayout.CENTER);

        setSize(900, 600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] a) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DrawingProgram();
            }
        });
    }
}
