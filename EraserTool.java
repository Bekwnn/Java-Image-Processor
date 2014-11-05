import java.awt.event.MouseEvent;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.BasicStroke;
import java.awt.AlphaComposite;

public class EraserTool extends Tool {
	private BasicStroke stroke;
	//private int startX, startY;
	
	public EraserTool() {
		stroke = new BasicStroke(12.0f);
	}
	
	public void mousePressed(MouseEvent e) {
		//startX = e.getX();
		//startY = e.getY();
		//System.out.println("Mouse Pressed: "+startX+", "+startY);
	}
	
	public void mouseReleased(MouseEvent e) {
		mouseDragged(e);
		LayerBox.getInstance().updateLayerBox();
	}
	
	public void mouseDragged(MouseEvent e) {
		MainImagePanel mip = MainImagePanel.getInstance();
		Graphics2D g2d = mip.getLayerGraphics();
		g2d.setComposite(AlphaComposite.Clear);
		int x = (int)(e.getX()-stroke.getLineWidth()/2);
		int y = (int)(e.getY()-stroke.getLineWidth()/2);
		int size = (int)stroke.getLineWidth();
		g2d.fillRect(x, y, size, size);
		mip.updateCombinedImage();
	}
}