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
		add(fileMenu);
		
		JMenuItem newMenuItem = new JMenuItem("New");
		JMenuItem openMenuItem = new JMenuItem("Open");
		JMenuItem saveMenuItem = new JMenuItem("Save");
		JMenuItem saveAsMenuItem = new JMenuItem("Save As");
		fileMenu.add(newMenuItem);
		fileMenu.add(openMenuItem);
		fileMenu.add(saveMenuItem);
		fileMenu.add(saveAsMenuItem);
	}
	
	private void addEditMenu() {
		JMenu editMenu = new JMenu("Edit");
		add(editMenu);
	
		JMenuItem cutMenuItem = new JMenuItem("Cut");
		JMenuItem copyMenuItem = new JMenuItem("Copy");
		JMenuItem pasteMenuItem = new JMenuItem("Paste");
		editMenu.add(cutMenuItem);
		editMenu.add(copyMenuItem);
		editMenu.add(pasteMenuItem);
	}
	
	private void addViewMenu() {
		JMenu viewMenu = new JMenu("View");
		add(viewMenu);
		
		JMenuItem toolBoxMenuItem = new JMenuItem("Tool Box");
		viewMenu.add(toolBoxMenuItem);
	}
	
	private void addHelpMenu() {
		JMenu helpMenu = new JMenu("Help");
		add(helpMenu);
		
		JMenuItem shortcutsMenuItem = new JMenuItem("Short-cuts");
		JMenuItem docMenuItem = new JMenuItem("Documentation");
		JMenuItem versionMenuItem = new JMenuItem("Version");
		JMenuItem aboutMenuItem = new JMenuItem("About");
		helpMenu.add(shortcutsMenuItem);
		helpMenu.add(docMenuItem);
		helpMenu.add(versionMenuItem);
		helpMenu.add(aboutMenuItem);
	}
}