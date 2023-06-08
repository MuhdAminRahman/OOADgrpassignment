package DrawingTool;

import java.awt.*;


class Oval extends myShape {
    public Oval(int x, int y, int newX, int newY, Color color, int lineThickness) {
        super(x, y, newX, newY, color, lineThickness);
    }

    public void draw(Graphics2D g) {
        g.setColor(this.color);
        g.setStroke(new BasicStroke(this.lineThickness));
        int width = Math.abs(newX - x);
        int height = Math.abs(newY - y);
        int startX = Math.min(x, newX);
        int startY = Math.min(y, newY);
        g.drawOval(startX, startY, width, height);
    }
}