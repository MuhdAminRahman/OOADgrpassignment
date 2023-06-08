package DrawingTool;

import java.awt.*;

class Line extends myShape {
    public Line(int x, int y, int newX, int newY, Color color, int lineThickness) {
        super(x, y, newX, newY, color, lineThickness);
    }

    public void draw(Graphics2D g) {
        g.setColor(this.color);
        g.setStroke(new BasicStroke(this.lineThickness));
        g.drawLine(x, y, newX, newY);
    }
}