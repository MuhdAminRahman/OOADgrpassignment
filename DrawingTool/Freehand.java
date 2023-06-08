package DrawingTool;

import java.awt.*;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

class Freehand extends myShape {
    List<Point> points;

    public Freehand(int x, int y, int newX, int newY, Color color,int lineThickness) {
        super(x, y, newX, newY, color, lineThickness);
        points = new ArrayList<>();
        points.add(new Point(x, y));
    }

    public void draw(Graphics2D g) {
        g.setColor(this.color);
        g.setStroke(new BasicStroke(this.lineThickness));
        if (!points.isEmpty()) {
            Point prevPoint = points.get(0);
            for (int i = 1; i < points.size(); i++) {
                Point currentPoint = points.get(i);
                g.drawLine(prevPoint.x, prevPoint.y, currentPoint.x, currentPoint.y);
                prevPoint = currentPoint;
            }
        }
    }

    public void addPoint(int x, int y) {
        points.add(new Point(x, y));
    }
}
