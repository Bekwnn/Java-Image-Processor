import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import java.io.*;
import javax.imageio.*;

public class MainImagePanel extends JPanel {
	protected BufferedImage combinedImage;
	public static ArrayList<BufferedImage> layers = new ArrayList<BufferedImage>();
	public static BufferedImage currentLayer;
	public static int currentLayerIndex;
	protected Color bgColor = Color.WHITE;
	
	public MainImagePanel() {
		BufferedImage newbi = new BufferedImage(JIP.iWidth, JIP.iHeight, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = newbi.createGraphics();
		int i = layers.size();
		
		layers.add(newbi);
		currentLayer = newbi;
		currentLayerIndex = layers.size()-1;
		updateCombinedImage();
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
	}
}