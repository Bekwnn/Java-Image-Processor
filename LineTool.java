import java.awt.event.MouseEvent;
import java.awt.Graphics2D;

public class LineTool extends Tool {
	private int startX, startY;
	
	public LineTool() {
		/*Toolkit toolkit =  Toolkit.getDefaultToolkit()
		Image image = toolkit.getImage("/icons/C_LineTool");
		Point center = new Point(12,12);
		cursor = toolkit.createCustomCursor(image, center, "Line Tool");*/
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
		g2d.drawLine(startX, startY, e.getX(), e.getY());
		mip.updateCombinedImage();
	}
	
	public void mouseDragged(MouseEvent e) {
		MainImagePanel mip = MainImagePanel.getInstance();
		Graphics2D g2d = mip.getLayerGraphics();
		g2d.setColor(BasicToolbox.getInstance().getPrimaryColor());
		g2d.drawLine(startX, startY, e.getX(), e.getY());
		mip.updateCombinedImage();
	}
}