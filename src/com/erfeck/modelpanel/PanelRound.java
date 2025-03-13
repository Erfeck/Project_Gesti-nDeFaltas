package com.erfeck.modelpanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

public class PanelRound extends JPanel {

    private int roundTopLeft;
    private int roundTopRight;
    private int roundBottomLeft;
    private int roundBottomRight;
    
    public PanelRound() {
        setOpaque(false);
        this.roundTopLeft = 0;
        this.roundTopRight = 0;
        this.roundBottomLeft = 0;
        this.roundBottomRight = 0;
    }

    public int getRoundTopLeft() {
        return roundTopLeft;
    }
    public void setRoundTopLeft(int roundTopLeft) {
        this.roundTopLeft = roundTopLeft;
        repaint();
    }
    public int getRoundTopRight() {
        return roundTopRight;
    }
    public void setRoundTopRight(int roundTopRight) {
        this.roundTopRight = roundTopRight;
        repaint();
    }
    public int getRoundBottomLeft() {
        return roundBottomLeft;
    }
    public void setRoundBottomLeft(int roundBottomLeft) {
        this.roundBottomLeft = roundBottomLeft;
        repaint();
    }
    public int getRoundBottomRight() {
        return roundBottomRight;
    }
    public void setRoundBottomRight(int roundBottomRight) {
        this.roundBottomRight = roundBottomRight;
        repaint();
    }
    
    
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        
        Area area = new Area(createRoundTopLeft());
        if (this.roundTopRight > 0) {
            area.intersect(new Area(createRoundTopRight()));
        }
        if (this.roundBottomLeft > 0) {
            area.intersect(new Area(createRoundBottomLeft()));
        }
        if (this.roundBottomRight > 0) {
            area.intersect(new Area(createRoundBottomRight()));
        }
        
        g2.fill(area);
        g2.dispose();
        super.paintComponent(g);
    }
    
    
    private Shape createRoundTopLeft() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, this.roundTopLeft);
        int roundY = Math.min(height, this.roundTopLeft);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
        
        return area;
    }
    private Shape createRoundTopRight() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, this.roundTopRight);
        int roundY = Math.min(height, this.roundTopRight);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, width)));
        area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
        
        return area;
    }
    private Shape createRoundBottomLeft() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, this.roundBottomLeft);
        int roundY = Math.min(height, this.roundBottomLeft);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
        
        return area;
    }
    private Shape createRoundBottomRight() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, this.roundBottomRight);
        int roundY = Math.min(height, this.roundBottomRight);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
        
        return area;
    }
}