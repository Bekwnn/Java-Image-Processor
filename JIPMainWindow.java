import java.awt.*;
import javax.swing.*;

public class JIPMainWindow extends JFrame{
	public JIPMainWindow () {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		BasicToolBox basicToolBox = new BasicToolBox();
		getContentPane().add(basicToolBox, BorderLayout.WEST);
		
		MenuBar menu = new MenuBar();
		setJMenuBar(menu);
		pack();
	}
}