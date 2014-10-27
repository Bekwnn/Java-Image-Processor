import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.*;

public class BasicToolbox extends JToolBar {
	private Image boxSelectIcon;
	private Image brushIcon;
	private Image eraserIcon;
	private Image lineIcon;
	private Image rectIcon;
	private Image ellipseIcon;
	private Image bucketIcon;
	
	public BasicToolbox() {
		super(JToolBar.VERTICAL);
		
		getIconArt();
		
		add(new JButton(new ImageIcon(boxSelectIcon)));
		add(new JButton(new ImageIcon(brushIcon)));
		add(new JButton(new ImageIcon(eraserIcon)));
		add(new JButton(new ImageIcon(lineIcon)));
		add(new JButton(new ImageIcon(rectIcon)));
		add(new JButton(new ImageIcon(ellipseIcon)));
		add(new JButton(new ImageIcon(bucketIcon)));
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
			System.out.println("Image not found");
		}
	}
}