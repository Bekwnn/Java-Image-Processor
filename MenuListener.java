import java.awt.event.*;
import javax.swing.*;

public class MenuListener implements ActionListener {

	public MenuListener(){
		super();
	}
	
	public void actionPerformed(ActionEvent e) {
		JMenuItem source = (JMenuItem)e.getSource();
		if (source.getText() == "New")
			System.out.println("New pressed.");
		else if (source.getText() == "Open")
			System.out.println("Open pressed.");
		else if (source.getText() == "Save")
			System.out.println("Save pressed.");
		else if (source.getText() == "Save As")
			System.out.println("Save As pressed.");
		else if (source.getText() == "Cut")
			System.out.println("Cut pressed.");
		else if (source.getText() == "Copy")
			System.out.println("Copy pressed.");
		else if (source.getText() == "Paste")
			System.out.println("Paste pressed.");
		else if (source.getText() == "Toolbox")
			System.out.println("Toolbox pressed.");
		else if (source.getText() == "Short-cuts")
			System.out.println("Short-cuts pressed.");
		else if (source.getText() == "Documentation")
			System.out.println("Documentation pressed.");
		else if (source.getText() == "Version")
			System.out.println("Version pressed.");
		else if (source.getText() == "About")
			System.out.println("About pressed.");
	}
}