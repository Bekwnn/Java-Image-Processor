import java.awt.*;
import javax.swing.*;

public class JIPMainWindow extends JFrame{
	public JIPMainWindow () {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		BasicToolbox basicToolbox = new BasicToolbox();
		mainPanel.add(basicToolbox, BorderLayout.WEST);
		
		MainImagePanel mainImageWindow = new MainImagePanel();
		mainPanel.add(mainImageWindow, BorderLayout.CENTER);
		
		//leave layerbox after mainImagePanel so it updates
		LayerBox layerBox = new LayerBox();
		mainPanel.add(layerBox, BorderLayout.EAST);
		
		MenuBar menuBar = new MenuBar();
		setJMenuBar(menuBar);
		
		getContentPane().add(mainPanel);
		pack();
	}
}