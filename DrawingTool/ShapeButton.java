package DrawingTool;

import java.awt.event.*;
import javax.swing.*;

public class ShapeButton extends JButton implements ActionListener {
    DrawingPanel drawingPanel;
    private String shapeType;
    Icon icon;

    public ShapeButton(DrawingPanel panel,String type, Icon icn) {
        drawingPanel = panel;
        shapeType = type;
        this.setIcon(icn);
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        drawingPanel.setShapeType(shapeType);

    }
}
