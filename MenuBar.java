import javax.swing.*;

public class MenuBar extends JMenuBar {
	public MenuBar() {
		super();
		//main menus
		addFileMenu();
		addEditMenu();
		addViewMenu();
		addHelpMenu();
	}
	
	private void addFileMenu() {
		JMenu fileMenu = new JMenu("File");
		
		JMenuItem openMenuItem = new JMenuItem("Open");
		JMenuItem saveMenuItem = new JMenuItem("Save");
		JMenuItem saveAsMenuItem = new JMenuItem("Save As");
		fileMenu.add(openMenuItem);
		fileMenu.add(saveMenuItem);
		fileMenu.add(saveAsMenuItem);
		
		add(fileMenu);
	}
	
	private void addEditMenu() {
		JMenu editMenu = new JMenu("Edit");
	
		JMenuItem cutMenuItem = new JMenuItem("Cut");
		JMenuItem copyMenuItem = new JMenuItem("Copy");
		JMenuItem pasteMenuItem = new JMenuItem("Paste");
		editMenu.add(cutMenuItem);
		editMenu.add(copyMenuItem);
		editMenu.add(pasteMenuItem);
		
		add(editMenu);
	}
	
	private void addViewMenu() {
		JMenu viewMenu = new JMenu("View");
		
		JMenuItem toolBoxMenuItem = new JMenuItem("Tool Box");
		viewMenu.add(toolBoxMenuItem);
		
		add(viewMenu);
	}
	
	private void addHelpMenu() {
		JMenu helpMenu = new JMenu("Help");
		
		JMenuItem shortcutsMenuItem = new JMenuItem("Short-cuts");
		JMenuItem docMenuItem = new JMenuItem("Documentation");
		JMenuItem versionMenuItem = new JMenuItem("Version");
		JMenuItem aboutMenuItem = new JMenuItem("About");
		helpMenu.add(shortcutsMenuItem);
		helpMenu.add(docMenuItem);
		helpMenu.add(versionMenuItem);
		helpMenu.add(aboutMenuItem);
		
		add(helpMenu);
	}
}