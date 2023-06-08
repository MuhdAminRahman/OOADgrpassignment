package DrawingTool;

import java.awt.*;

abstract class myShape {
    int x, y, newX, newY;
    Color color;
    int lineThickness;
    boolean checkColorisEmpty = true, checklineThicknessisEmpty = true;

    public myShape(int x, int y, int newX, int newY, Color color,int lineThickness) {
        this.x = x;
        this.y = y;
        this.newX = newX;
        this.newY = newY;
        this.color = color;
        this.lineThickness = lineThickness;
    }

    public void setEndPoint(int x, int y) {
        this.newX = x;
        this.newY = y;
    }

    public void setColor(Color color) {
        this.color = color;

    }

    public void setLineThickness(int thickness) {
        this.lineThickness = thickness;
    }

    public void draw(Graphics2D g)
    {
        g.setColor(color);
        g.setStroke(new BasicStroke(lineThickness));
    };

}
