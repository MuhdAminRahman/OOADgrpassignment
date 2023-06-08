package DrawingTool;

import java.awt.*;

class Circle extends myShape {
    public Circle(int x, int y, int newX, int newY, Color color, int lineThickness) {
        super(x, y, newX, newY, color, lineThickness);
    }

    public void draw(Graphics2D g) {
        g.setColor(this.color);
        g.setStroke(new BasicStroke(this.lineThickness));
        int width = Math.abs(newX - x);
        int height = Math.abs(newY - y);
        int startX = Math.min(x, newX);
        int startY = Math.min(y, newY);
        int diameter = Math.min(width, height);
        g.drawOval(startX, startY, diameter, diameter);
    }
}