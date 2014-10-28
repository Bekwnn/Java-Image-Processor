import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import javax.swing.*;

public class MenuListener implements ActionListener {

	public MenuListener(){
		super();
	}
	
	public void actionPerformed(ActionEvent e) {
		JMenuItem source = (JMenuItem)e.getSource();
		System.out.println(source.getText() + " pressed.");
		//if (source.getText() == "New")
		if (source.getText() == "New Layer")
			newLayer();
		/*else if (source.getText() == "Open")
		else if (source.getText() == "Save")
		else if (source.getText() == "Save As")
		else if (source.getText() == "Cut")
		else if (source.getText() == "Copy")
		else if (source.getText() == "Paste")
		else if (source.getText() == "Toolbox")
		else if (source.getText() == "Short-cuts")
		else if (source.getText() == "Documentation")
		else if (source.getText() == "Version")
		else if (source.getText() == "About")*/
	}
	
	private void newLayer() {
		BufferedImage newbi = new BufferedImage(JIP.iWidth, JIP.iHeight, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = newbi.createGraphics();
		int i = MainImagePanel.layers.size();
		
		MainImagePanel.layers.add(newbi);
		MainImagePanel.currentLayer = newbi;
		MainImagePanel.currentLayerIndex = MainImagePanel.layers.size()-1;
	}
}