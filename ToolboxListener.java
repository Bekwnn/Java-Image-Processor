import java.awt.event.*;
import javax.swing.*;

public class ToolboxListener implements ActionListener {

	public ToolboxListener() {
		super();
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand() + " pressed.");
	}
}