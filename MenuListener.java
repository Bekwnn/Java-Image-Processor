import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import javax.imageio.ImageIO;

//listens to the actions performed in MenuBar
public class MenuListener implements ActionListener {
	private File currentFile;	//saves file info after "open"/"save as" for implicit saving

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
		else if (source.getText() == "Toolbox")			NOT YET IMPLEMENTED
		else if (source.getText() == "Short-cuts")
		else if (source.getText() == "Documentation")
		else if (source.getText() == "Version")
		else if (source.getText() == "About")*/
	}
	
	//starts a new image (progress lost on old image)
	private void newFile() {
		currentFile = null;
		MainImagePanel.getInstance().newCombinedImage();
	}
	
	//creates new buffered image the size of current image and adds it to the layer list
	private void newLayer() {
		BufferedImage newbi = new BufferedImage(JIP.iWidth, JIP.iHeight, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = newbi.createGraphics();
		MainImagePanel mip = MainImagePanel.getInstance();
		mip.addLayer(newbi);
	}
	
	private void openFile() {
		JFileChooser chooser = new JFileChooser();
		int choice = chooser.showOpenDialog(null);
		if (choice == JFileChooser.APPROVE_OPTION) {
			try {
				currentFile = chooser.getSelectedFile();
				newFile();
				MainImagePanel mip = MainImagePanel.getInstance();
				currentFile = chooser.getSelectedFile();	//store info about the file opened
				mip.setLayer(ImageIO.read(currentFile));
				mip.updateCombinedImage();
			} catch (IOException e) {
				System.out.println("Error opening file.");
			}
		}
	}
	
	private void saveFile() {
		if (currentFile == null) {
			saveAsFile();	//no file info, prompt user to "save as"
			return;
		}
		try {
			ImageIO.write(MainImagePanel.getInstance().getCombined(), "png", currentFile);	//save current file
		} catch (IOException e) {
			System.out.println("Error saving.");
		}
		
	}
	
	private void saveAsFile() {
		JFileChooser chooser = new JFileChooser();
		int choice = chooser.showSaveDialog(null);
		if (choice == JFileChooser.APPROVE_OPTION) {
			try {
				ImageIO.write(MainImagePanel.getInstance().getCombined(), "png", chooser.getSelectedFile());
				currentFile = chooser.getSelectedFile();
			} catch (IOException e) {
				System.out.println("Error saving.");
			}
		}
	}
}