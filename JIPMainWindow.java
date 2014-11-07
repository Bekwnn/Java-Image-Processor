import java.awt.*;
import javax.swing.*;

//the main window. Creates the other nested components
public class JIPMainWindow extends JFrame{
	private static JIPMainWindow instance_;
	public BasicToolbox basicToolbox;
	public MainImagePanel mainImagePanel;
	public LayerBox layerBox;
	
	private JIPMainWindow () {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		basicToolbox = BasicToolbox.getInstance();
		mainPanel.add(basicToolbox, BorderLayout.WEST);
		
		mainImagePanel = MainImagePanel.getInstance();
		mainPanel.add(mainImagePanel, BorderLayout.CENTER);
		
		ToolListener toolListener = new ToolListener(Cursor.CROSSHAIR_CURSOR, mainPanel.getBounds());
		mainPanel.addMouseListener(toolListener);
		mainPanel.addMouseMotionListener(toolListener);
		
		//leave layerbox after mainImagePanel so it updates
		layerBox = LayerBox.getInstance();
		mainPanel.add(layerBox, BorderLayout.EAST);
		
		MenuBar menuBar = MenuBar.getInstance();
		setJMenuBar(menuBar);
		
		getContentPane().add(mainPanel);
		pack();
	}
	
	public static JIPMainWindow getInstance() {
		if (instance_ == null) instance_ = new JIPMainWindow();
		return instance_;
	}
}