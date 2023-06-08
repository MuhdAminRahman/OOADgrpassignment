package DrawingTool;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

class DrawingPanel extends JPanel {
    List<myShape> shapes;
    myShape currentShape;
    Color drawingColor = Color.BLACK;;
    int lineThickness = 1;;
    String shapeType = "Freehand";;
    Freehand currentFreehand;
    

    public DrawingPanel() {
        setBackground(Color.WHITE);
        setOpaque(false);
        shapes = new ArrayList<>();
        

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                setStartPoint(e.getX(), e.getY());
            }

            public void mouseReleased(MouseEvent e) {
                setEndPoint(e.getX(), e.getY());
                addShape(currentShape);
                currentShape = null;
                repaint();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (shapeType.equals("Freehand")) {
                    addFreehandPoint(e.getX(), e.getY());
                } else {
                    setEndPoint(e.getX(), e.getY());
                    repaint();
                }
            }
        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(drawingColor);
        g2.setStroke(new BasicStroke(lineThickness));

        for (myShape shape : shapes)// redraw the painted structures after repaint() is called
        {
            //shape.setColor(drawingColor);
            //shape.setLineThickness(lineThickness);
            shape.draw(g2);
        }

        if (currentShape != null) //drawing current structure
        {
            currentShape.draw(g2);
        }
    }

    public void setStartPoint(int x, int y) {
        if (shapeType.equals("Freehand")) {
            currentFreehand = new Freehand(x, y, x, y, drawingColor, lineThickness);
            addShape(currentFreehand);
        } else if (shapeType.equals("Line")) {
            currentShape = new Line(x, y, x, y, drawingColor, lineThickness);
        } else if (shapeType.equals("Rectangle")) {
            currentShape = new Rectangle(x, y, x, y, drawingColor, lineThickness);
        } else if (shapeType.equals("Circle")) {
            currentShape = new Circle(x, y, x, y, drawingColor, lineThickness);
        } else if (shapeType.equals("Oval")) {
            currentShape = new Oval(x, y, x, y, drawingColor, lineThickness);
        } else if (shapeType.equals("Triangle")) {
            currentShape = new Triangle(x, y, x, y, drawingColor, lineThickness);
        }
    }

    public void setEndPoint(int x, int y) {
        if (currentFreehand != null) {
            currentFreehand.setEndPoint(x, y);
            currentFreehand = null;
        } else if (currentShape != null) {
            currentShape.setEndPoint(x, y);
        }
    }

    public void addShape(myShape shape) {
        if (shape != null) {
            shapes.add(shape);
        }
    }

    public void setShapeType(String type) {
        shapeType = type;
    }

    public void setDrawingColor(Color color) {
        drawingColor = color;
    }

    public void setLineThickness(int thickness) {
        lineThickness = thickness;
    }

    public void addFreehandPoint(int x, int y) {
        if (currentFreehand != null) {
            currentFreehand.addPoint(x, y);
            repaint();
        }
    }
}