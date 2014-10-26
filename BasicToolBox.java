import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.*;

public class BasicToolBox extends JToolBar {
	private Image brushIcon;
	private Image eraserIcon;
	private Image lineIcon;
	private Image rectIcon;
	private Image ellipseIcon;
	private Image bucketIcon;
	
	public BasicToolBox() {
		super(JToolBar.VERTICAL);
		
		getIconArt();
		
		add(new JButton(new ImageIcon(brushIcon)));
		add(new JButton(new ImageIcon(eraserIcon)));
		add(new JButton(new ImageIcon(lineIcon)));
		add(new JButton(new ImageIcon(rectIcon)));
		add(new JButton(new ImageIcon(ellipseIcon)));
		add(new JButton(new ImageIcon(bucketIcon)));
	}
	
	private void getIconArt() {
		try {
			brushIcon = ImageIO.read(getClass().getResource("icons/I_BrushTool.png"));
			eraserIcon = ImageIO.read(getClass().getResource("icons/I_EraserTool.png"));
			lineIcon = ImageIO.read(getClass().getResource("icons/I_LineTool.png"));
			rectIcon = ImageIO.read(getClass().getResource("icons/I_RectTool.png"));
			ellipseIcon = ImageIO.read(getClass().getResource("icons/I_EllipseTool.png"));
			bucketIcon = ImageIO.read(getClass().getResource("icons/I_BucketTool.png"));
		} catch (IOException ex) {
			System.out.println("Image not found");
		}
	}
}