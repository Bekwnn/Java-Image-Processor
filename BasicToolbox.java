import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.*;

public class BasicToolbox extends JToolBar {
	public enum Tools {
		BOXSELECT,
		BRUSH,
		ERASER,
		LINE,
		RECT,
		ELLIPSE,
		BUCKET
	}

	private Image boxSelectIcon;
	private Image brushIcon;
	private Image eraserIcon;
	private Image lineIcon;
	private Image rectIcon;
	private Image ellipseIcon;
	private Image bucketIcon;
	
	private ToolboxListener toolboxListener = new ToolboxListener();
	
	public BasicToolbox() {
		super(JToolBar.VERTICAL);
		
		getIconArt();
		JButton boxSelect = new JButton(new ImageIcon(boxSelectIcon));
		JButton brush = new JButton(new ImageIcon(brushIcon));
		JButton eraser = new JButton(new ImageIcon(eraserIcon));
		JButton line = new JButton(new ImageIcon(lineIcon));
		JButton rect = new JButton(new ImageIcon(rectIcon));
		JButton ellipse = new JButton(new ImageIcon(ellipseIcon));
		JButton bucket = new JButton(new ImageIcon(bucketIcon));
		addToToolbox(boxSelect, Tools.BOXSELECT.name());
		addToToolbox(brush, Tools.BRUSH.name());
		addToToolbox(eraser, Tools.ERASER.name());
		addToToolbox(line, Tools.LINE.name());
		addToToolbox(rect, Tools.RECT.name());
		addToToolbox(ellipse, Tools.ELLIPSE.name());
		addToToolbox(bucket, Tools.BUCKET.name());
	}
	
	private void getIconArt() {
		try {
			boxSelectIcon = ImageIO.read(getClass().getResource("icons/I_BoxSelectTool.png"));
			brushIcon = ImageIO.read(getClass().getResource("icons/I_BrushTool.png"));
			eraserIcon = ImageIO.read(getClass().getResource("icons/I_EraserTool.png"));
			lineIcon = ImageIO.read(getClass().getResource("icons/I_LineTool.png"));
			rectIcon = ImageIO.read(getClass().getResource("icons/I_RectTool.png"));
			ellipseIcon = ImageIO.read(getClass().getResource("icons/I_EllipseTool.png"));
			bucketIcon = ImageIO.read(getClass().getResource("icons/I_BucketTool.png"));
		} catch (IOException ex) {
			System.out.println("Images not found");
		}
	}
	
	private void addToToolbox(JButton button, String command) {
		button.addActionListener(toolboxListener);
		button.setActionCommand(command);
		add(button);
	}
}