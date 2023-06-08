package DrawingTool;

import java.awt.*;

class Triangle extends myShape {
    public Triangle(int x, int y, int newX, int newY, Color color, int lineThickness) {
        super(x, y, newX, newY, color, lineThickness);
    }

    public void draw(Graphics2D g) {
        g.setColor(this.color);
        g.setStroke(new BasicStroke(this.lineThickness));
        int[] xPoints = { x, newX, (x + newX) / 2 };
        int[] yPoints = { newY, newY, y };
        g.drawPolygon(xPoints, yPoints, 3);
    }
}