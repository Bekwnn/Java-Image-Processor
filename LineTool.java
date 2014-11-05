import java.awt.event.MouseEvent;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.BasicStroke;

public class LineTool extends Tool {
	private int startX, startY;
	private BasicStroke stroke;
	
	public LineTool() {
		stroke = new BasicStroke(3.0f);
	}
	
	public void mousePressed(MouseEvent e) {
		startX = e.getX();
		startY = e.getY();
		System.out.println("Mouse Pressed: "+startX+", "+startY);
	}
	
	public void mouseReleased(MouseEvent e) {
		MainImagePanel mip = MainImagePanel.getInstance();
		Graphics2D g2d = mip.getLayerGraphics();
		g2d.setColor(BasicToolbox.getInstance().getPrimaryColor());
		g2d.setStroke(stroke);
		g2d.drawLine(startX, startY, e.getX(), e.getY());
		mip.clearGraphicsLayer();
		mip.updateCombinedImage();
	}
	
	public void mouseDragged(MouseEvent e) {
		MainImagePanel mip = MainImagePanel.getInstance();
		BufferedImage i = new BufferedImage(JIP.iWidth, JIP.iHeight, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = i.createGraphics();
		g2d.setColor(BasicToolbox.getInstance().getPrimaryColor());
		g2d.setStroke(stroke);
		g2d.drawLine(startX, startY, e.getX(), e.getY());
		mip.setGraphicsLayer(i);
		mip.updateCombinedImage();
	}
}