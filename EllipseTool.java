import java.awt.event.MouseEvent;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.geom.Ellipse2D;

public class EllipseTool extends Tool {
	private int startX, startY;
	
	public EllipseTool() {}
	
	public void mousePressed(MouseEvent e) {
		startX = e.getX();
		startY = e.getY();
		System.out.println("Mouse Pressed: "+startX+", "+startY);
	}
	
	public void mouseReleased(MouseEvent e) {
		MainImagePanel mip = MainImagePanel.getInstance();
		Graphics2D g2d = mip.getLayerGraphics();
		g2d.setColor(BasicToolbox.getInstance().getPrimaryColor());
		int minX = Math.min(startX, e.getX());
		int minY = Math.min(startY, e.getY());
		int w = Math.max(startX, e.getX()) - minX;
		int h = Math.max(startY, e.getY()) - minY;
		g2d.draw(new Ellipse2D.Double(minX, minY, w, h));
		mip.updateCombinedImage();
	}
	
	public void mouseDragged(MouseEvent e) {
		MainImagePanel mip = MainImagePanel.getInstance();
		BufferedImage i = new BufferedImage(JIP.iWidth, JIP.iHeight, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = i.createGraphics();
		g2d.setColor(BasicToolbox.getInstance().getPrimaryColor());
		int minX = Math.min(startX, e.getX());
		int minY = Math.min(startY, e.getY());
		int w = Math.max(startX, e.getX()) - minX;
		int h = Math.max(startY, e.getY()) - minY;
		g2d.draw(new Ellipse2D.Double(minX, minY, w, h));
		mip.setGraphicsLayer(i);
		mip.updateCombinedImage();
	}
}