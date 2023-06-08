package DrawingTool;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class LineThicknessSlider extends JPanel implements ChangeListener {
    DrawingPanel drawingPanel;
    JLabel thicknessLabel;
    JSlider thicknessSlider;

    public LineThicknessSlider(DrawingPanel panel) {
        drawingPanel = panel;
        thicknessLabel = new JLabel("Line Thickness");
        thicknessSlider = new JSlider(JSlider.HORIZONTAL, 1, 10, 1);
        thicknessSlider.setMajorTickSpacing(1);
        thicknessSlider.setPaintTicks(true);
        thicknessSlider.setPaintLabels(true);
        thicknessSlider.addChangeListener(this);

        add(thicknessLabel);
        add(thicknessSlider);
    }

    public void stateChanged(ChangeEvent e) {
        drawingPanel.lineThickness = thicknessSlider.getValue();
    }
}