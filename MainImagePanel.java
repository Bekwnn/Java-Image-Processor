import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import java.io.*;
import javax.imageio.*;

public class MainImagePanel extends JPanel {
	protected BufferedImage combinedImage;
	
	protected Color bgColor = Color.WHITE;
	
	public MainImagePanel() {
		updateCombinedImage();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(combinedImage, 0, 0, bgColor, null);
	}
	
	public void updateCombinedImage() {
		//change later to make it the combination layers
		combinedImage = new BufferedImage(JIP.iWidth, JIP.iHeight, BufferedImage.TYPE_INT_ARGB);
	}
}