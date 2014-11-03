import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

public class ToolboxListener implements ActionListener {
	private static ToolboxListener instance_;
	private Tool selectedTool;

	private ToolboxListener() {
		super();
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand() + " pressed.");
		drawRect();
		if (e.getActionCommand() == "BOXSELECT") {
			boxSelect();
		}
		else if (e.getActionCommand() == "BRUSH") {
			brush();
		}
		else if (e.getActionCommand() == "ERASER") {
			eraser();
		}
		else if (e.getActionCommand() == "LINE") {
			line();
		}
		else if (e.getActionCommand() == "RECT") {
			rect();
		}
		else if (e.getActionCommand() == "ELLIPSE") {
			ellipse();
		}
		else if (e.getActionCommand() == "BUCKET") {
			bucket();
		}
	}
	
	void boxSelect() {
	
	}
	
	void brush() {
	
	}
	
	void eraser() {
	
	}
	
	void line() {
	
	}
	
	void rect() {
	
	}
	
	void ellipse() {
	
	}
	
	void bucket() {
	
	}
	
	public void drawRect() {
		MainImagePanel mip = MainImagePanel.getInstance();
		Graphics2D g2d = mip.currentLayer.createGraphics();
		int i = mip.currentLayerIndex;
		if (i%3 == 0)
			g2d.setColor(new Color(1.0f,0.0f,0.0f));
		else if (i%3 == 1)
			g2d.setColor(new Color(0.0f,1.0f,0.0f));
		else if (i%3 == 2)
			g2d.setColor(new Color(0.0f,0.0f,1.0f));
		
		g2d.fill(new Rectangle2D.Double(i*20,i*20,40,40));
		LayerBox lb = LayerBox.getInstance();
		lb.updateLayerBox();
	}
	
	public static ToolboxListener getInstance() {
		if (instance_ == null) instance_ = new ToolboxListener();
		return instance_;
	}
}