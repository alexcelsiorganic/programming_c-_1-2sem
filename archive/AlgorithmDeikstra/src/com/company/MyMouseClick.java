package com.company;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

class MyMouseClick extends MouseAdapter {
    public MyMouseClick(MainFrame frame) {
            super();
            this.frame = frame;
    }
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        int index_1 = frame.getTopIndex(e.getX(), e.getY());
        int index_2 = frame.getMouseIndex(e.getX(), e.getY());
        if(index_1 != -1) {
            frame.changePoint(e.getX(), e.getY(), index_1);
            if (index_2 != -1) {
                frame.mouseChangePoint(e.getX(), e.getY(), index_2);
            }
        }
        frame.repaint();
    }

    public void mouseClicked(MouseEvent e) {
        if(SwingUtilities.isRightMouseButton(e)) {
            super.mouseClicked(e);
            frame.addPoint(new Point2D.Float((float) e.getX(), (float) e.getY()));
            frame.repaint();
        }
    }
    private MainFrame frame;
}