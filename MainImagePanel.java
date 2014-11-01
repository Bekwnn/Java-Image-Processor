import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import java.io.*;
import java.awt.event.*;
import javax.imageio.*;

public class MainImagePanel extends JPanel {
	protected BufferedImage combinedImage;
	private static MainImagePanel instance_;
	public static ArrayList<BufferedImage> layers = new ArrayList<BufferedImage>();
	public static BufferedImage currentLayer;
	public static int currentLayerIndex;
	public static Color bgColor = Color.WHITE;
	
	private MainImagePanel() {
		BufferedImage newbi = new BufferedImage(JIP.iWidth, JIP.iHeight, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = newbi.createGraphics();
		
		layers.add(newbi);
		currentLayer = newbi;
		currentLayerIndex = layers.size()-1;
		updateCombinedImage();
		setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
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
	
	public static MainImagePanel getInstance() {
		if (instance_ == null) instance_ = new MainImagePanel();
		return instance_;
	}
}