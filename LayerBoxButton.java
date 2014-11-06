import java.awt.event.*;
import javax.swing.*;

public class LayerBoxButton extends JButton implements ActionListener {
	int layerIndex;
	public LayerBoxButton(int layer, ImageIcon i) {
		super("Layer "+(layer+1), i);
		addActionListener(this);
		layerIndex = layer;
	}
	
	public void actionPerformed(ActionEvent e) {
		MainImagePanel.getInstance().changeLayer(layerIndex);
		LayerBox.getInstance().updateLayerBox();
	}
}