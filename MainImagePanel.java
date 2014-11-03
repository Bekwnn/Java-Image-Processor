import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import java.io.*;
import java.awt.event.*;
import javax.imageio.*;

public class MainImagePanel extends JPanel {
	private BufferedImage combinedImage;
	private static MainImagePanel instance_;
	public ArrayList<BufferedImage> layers = new ArrayList<BufferedImage>();
	public BufferedImage currentLayer;
	public int currentLayerIndex;
	public Color bgColor = Color.WHITE;
	
	private MainImagePanel() {
		initializeMIP();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		updateCombinedImage();
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(combinedImage, 0, 0, bgColor, null);
	}
	
	public void updateCombinedImage() {
		combinedImage = new BufferedImage(JIP.iWidth, JIP.iHeight, BufferedImage.TYPE_INT_ARGB);
		Graphics g = combinedImage.getGraphics();
		for (BufferedImage i : layers) {
			g.drawImage(i, 0, 0, null);
		}
		validate();
		repaint();
	}
	
	//performs constructor initialization, reused when starting a new file
	private void initializeMIP() {
		layers = new ArrayList<BufferedImage>();
		BufferedImage newbi = new BufferedImage(JIP.iWidth, JIP.iHeight, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = newbi.createGraphics();
		
		layers.add(newbi);
		currentLayer = newbi;
		currentLayerIndex = layers.size()-1;
		updateCombinedImage();
		setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
	}
	
	public void newCombinedImage() {
		initializeMIP();
		LayerBox.getInstance().updateLayerBox();
	}
	
	public void updateColorSelection() {
		
	}
	
	public static MainImagePanel getInstance() {
		if (instance_ == null) instance_ = new MainImagePanel();
		return instance_;
	}
}