import java.awt.event.*;
import javax.swing.*;

public class ToolboxListener implements ActionListener {

	public ToolboxListener() {
		super();
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand() + " pressed.");
		/*if (e.getActionCommand() == "BOXSELECT")
		else if (e.getActionCommand() == "BRUSH")
		else if (e.getActionCommand() == "ERASER")
		else if (e.getActionCommand() == "LINE")
		else if (e.getActionCommand() == "RECT")
		else if (e.getActionCommand() == "ELLIPSE")
		else if (e.getActionCommand() == "BUCKET")*/
	}
}