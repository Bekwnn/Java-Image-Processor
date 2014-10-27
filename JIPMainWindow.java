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
		
		MenuBar menuBar = new MenuBar();
		setJMenuBar(menuBar);
		
		getContentPane().add(mainPanel);
		pack();
	}
}