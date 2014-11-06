import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import javax.swing.filechooser.*;
import javax.imageio.ImageIO;

public class MenuListener implements ActionListener {
	private String currentFilePath;

	public MenuListener(){
		super();
	}
	
	public void actionPerformed(ActionEvent e) {
		JMenuItem source = (JMenuItem)e.getSource();
		System.out.println(source.getText() + " pressed.");
		if (source.getText() == "New")
			newFile();
		else if (source.getText() == "New Layer")
			newLayer();
		else if (source.getText() == "Open")
			openFile();
		else if (source.getText() == "Save")
			saveFile();
		else if (source.getText() == "Save As")
			saveAsFile();
		/*else if (source.getText() == "Cut")
		else if (source.getText() == "Copy")
		else if (source.getText() == "Paste")
		else if (source.getText() == "Toolbox")
		else if (source.getText() == "Short-cuts")
		else if (source.getText() == "Documentation")
		else if (source.getText() == "Version")
		else if (source.getText() == "About")*/
	}
	
	private void newFile() {
		currentFilePath = null;
		MainImagePanel.getInstance().newCombinedImage();
	}
	
	private void newLayer() {
		BufferedImage newbi = new BufferedImage(JIP.iWidth, JIP.iHeight, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = newbi.createGraphics();
		MainImagePanel mip = MainImagePanel.getInstance();
		mip.addLayer(newbi);
	}
	
	private void openFile() {
		JFileChooser chooser = new JFileChooser();
		int choice = chooser.showOpenDialog(null);
	}
	
	private void saveFile() {
		if (currentFilePath == null) {
			saveAsFile();
			return;
		}
		
	}
	
	private void saveAsFile() {
		JFileChooser chooser = new JFileChooser();
		int choice = chooser.showSaveDialog(null);
		if (choice == JFileChooser.APPROVE_OPTION) {
			try {
				ImageIO.write(MainImagePanel.getInstance().getCombined(), "png", chooser.getSelectedFile());
			} catch (IOException e) {
				System.out.println("Error saving.");
			}
		}
	}
}