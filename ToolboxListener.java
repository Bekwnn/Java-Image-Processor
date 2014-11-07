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
	
	//handles action commands
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand() + " pressed.");
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
	
	//swaps out previous tool's listeners for new tool's listeners
	private void swapTool(Tool newTool) {
		MainImagePanel mip = MainImagePanel.getInstance();
		mip.removeMouseListener(selectedTool);
		mip.removeMouseMotionListener(selectedTool);
		selectedTool = newTool;
		mip.addMouseListener(selectedTool);
		mip.addMouseMotionListener(selectedTool);
	}
	
	//tool selection functions
	private void boxSelect() { swapTool(new BoxSelectTool()); }
	private void brush() { swapTool(new BrushTool()); }
	private void eraser() { swapTool(new EraserTool()); }
	private void line() { swapTool(new LineTool()); }
	private void rect() { swapTool(new RectTool()); }
	private void ellipse() { swapTool(new EllipseTool()); }
	private void bucket() { swapTool(new BucketFillTool()); }
	
	public static ToolboxListener getInstance() {
		if (instance_ == null) instance_ = new ToolboxListener();
		return instance_;
	}
}