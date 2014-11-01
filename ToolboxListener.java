import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

public class ToolboxListener implements ActionListener {

	public ToolboxListener() {
		super();
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand() + " pressed.");
		drawRect();
		/*if (e.getActionCommand() == "BOXSELECT")
		else if (e.getActionCommand() == "BRUSH")
		else if (e.getActionCommand() == "ERASER")
		else if (e.getActionCommand() == "LINE")
		else if (e.getActionCommand() == "RECT")
		else if (e.getActionCommand() == "ELLIPSE")
		else if (e.getActionCommand() == "BUCKET")*/
	}
	
	public void drawRect() {
		Graphics2D g2d = MainImagePanel.currentLayer.createGraphics();
		int i = MainImagePanel.currentLayerIndex;
		if (i%3 == 0)
			g2d.setColor(new Color(1.0f,0.0f,0.0f));
		else if (i%3 == 1)
			g2d.setColor(new Color(0.0f,1.0f,0.0f));
		else if (i%3 == 2)
			g2d.setColor(new Color(0.0f,0.0f,1.0f));
		
		g2d.draw(new Rectangle2D.Double(i*10,i*10,20,20));
		LayerBox lb = LayerBox.getInstance();
		lb.updateLayerBox();
	}
}