import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class LayerBox extends JToolBar{
	private static final int LAYER_ICON_SIZE = 30;
	private static LayerBox instance_;
	private static int numLayers;

	private LayerBox() {
		super(JToolBar.VERTICAL);
		updateLayerBox();
	}

	public void updateLayerBox() {
		int j = 0;
		removeAll();
		for (BufferedImage i : MainImagePanel.getInstance().getLayers()) {
			j++;
			BufferedImage newi = new BufferedImage(LAYER_ICON_SIZE, LAYER_ICON_SIZE, BufferedImage.TYPE_INT_RGB);
			Graphics2D g2d = newi.createGraphics();
			g2d.drawImage(i, 0, 0, LAYER_ICON_SIZE, LAYER_ICON_SIZE, Color.WHITE, null);
			JButton newButton = new JButton("Layer " + j, new ImageIcon(newi));
			add(newButton);
		}
		repaint();
	}
	
	public static LayerBox getInstance() {
		if (instance_ == null) instance_ = new LayerBox();
		return instance_;
	}
}