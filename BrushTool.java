import java.awt.event.MouseEvent;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.BasicStroke;
import java.awt.geom.Ellipse2D;

public class BrushTool extends Tool {
	private BasicStroke stroke;
	private int prevX, prevY;
	
	public BrushTool() {
		stroke = new BasicStroke(8.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
	}
	
	public void mousePressed(MouseEvent e) {
		prevX = e.getX();
		prevY = e.getY();
		System.out.println("Mouse Pressed: "+prevX+", "+prevY);
		mouseDragged(e);
	}
	
	public void mouseReleased(MouseEvent e) {
		mouseDragged(e);
		LayerBox.getInstance().updateLayerBox();
	}
	
	//draws a line between mouse dragged positions; currently doesn't support transparency very well
	public void mouseDragged(MouseEvent e) {
		MainImagePanel mip = MainImagePanel.getInstance();
		Graphics2D g2d = mip.getLayerGraphics();
		g2d.setColor(BasicToolbox.getInstance().getPrimaryColor());
		g2d.setStroke(stroke);
		g2d.drawLine(prevX, prevY, e.getX(), e.getY());
		prevX = e.getX();
		prevY = e.getY();
		mip.updateCombinedImage();
	}
}