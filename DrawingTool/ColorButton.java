package DrawingTool;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ColorButton extends JButton implements ActionListener {
    DrawingPanel drawingPanel;

    public ColorButton(DrawingPanel panel) {
        super("Choose paint colour");
        drawingPanel = panel;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        Color selectedColor = JColorChooser.showDialog(null, "Choose Drawing Color", getBackground());
        if (selectedColor != null) {
            drawingPanel.drawingColor = selectedColor;
        }
    }
}