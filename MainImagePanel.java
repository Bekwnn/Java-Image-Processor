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
	private ArrayList<BufferedImage> layers = new ArrayList<BufferedImage>();
	private BufferedImage currentLayer;
	private BufferedImage graphicsLayer;
	private int currentLayerIndex;
	private Color bgColor = Color.WHITE;
	
	private MainImagePanel() {
		initializeMIP();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(combinedImage, 0, 0, bgColor, null);
	}
	
	//updates the combinedImage (the displayed image)
	public void updateCombinedImage() {
		//draw layers on top of one another
		combinedImage = new BufferedImage(JIP.iWidth, JIP.iHeight, BufferedImage.TYPE_INT_ARGB);
		Graphics g = combinedImage.getGraphics();
		for (BufferedImage i : layers) {
			g.drawImage(i, 0, 0, null);
		}
		
		//draw graphics layer on top of everything else
		if (graphicsLayer != null)
			g.drawImage(graphicsLayer, 0, 0, null);
		
		//repaint
		validate();
		repaint();
	}
	
	//sets new image for graphics layer
	public void setGraphicsLayer(BufferedImage i) {
		graphicsLayer = i;
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
	
	//creates a blank new image with a single layer to work from
	public void newCombinedImage() {
		initializeMIP();
		LayerBox.getInstance().updateLayerBox();
	}
	
	//clears the graphics layer
	public void clearGraphicsLayer() {
		Graphics2D g2d = graphicsLayer.createGraphics();
		g2d.setComposite(AlphaComposite.Clear);
		g2d.fillRect(0, 0, JIP.iWidth, JIP.iHeight);
	}
	
	//adds new layer with BufferedImage i
	public void addLayer(BufferedImage i) {
		layers.add(i);
		currentLayer = i;
		currentLayerIndex = layers.size()-1;
		LayerBox lb = LayerBox.getInstance();
		lb.updateLayerBox();
	}
	
	//returns Graphics2D object of current layer
	public Graphics2D getLayerGraphics() {
		return currentLayer.createGraphics();
	}
	
	//returns BufferedImage reference to current layer
	public BufferedImage getLayer() {
		return currentLayer;
	}
	
	//sets a layer's BufferedImage to i
	public void setLayer(BufferedImage i) {
		layers.set(currentLayerIndex, i);
		currentLayer = i;
	}
	
	//returns the index of current layer
	public int getLayerIndex() {
		return currentLayerIndex;
	}
	
	//changes to layer with given index
	public void changeLayer(int index) {
		currentLayer = layers.get(index);
		currentLayerIndex = index;
	}
	
	//returns the combined image
	public BufferedImage getCombined() {
		return combinedImage;
	}
	
	//returns list of layers
	public ArrayList<BufferedImage> getLayers() {
		return layers;
	}
	
	//gets the singleton instance of MainImagePanel
	public static MainImagePanel getInstance() {
		if (instance_ == null) instance_ = new MainImagePanel();
		return instance_;
	}
}