import java.awt.event.*;
import javax.swing.*;

public class MenuListener implements ActionListener {

	public MenuListener(){
		super();
	}
	
	public void actionPerformed(ActionEvent e) {
		JMenuItem source = (JMenuItem)e.getSource();
		System.out.println(source.getText() + " pressed.");
		/*if (source.getText() == "New")
		else if (source.getText() == "New Layer")
		else if (source.getText() == "Open")
		else if (source.getText() == "Save")
		else if (source.getText() == "Save As")
		else if (source.getText() == "Cut")
		else if (source.getText() == "Copy")
		else if (source.getText() == "Paste")
		else if (source.getText() == "Toolbox")
		else if (source.getText() == "Short-cuts")
		else if (source.getText() == "Documentation")
		else if (source.getText() == "Version")
		else if (source.getText() == "About")*/
	}
}