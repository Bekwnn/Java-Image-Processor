import javax.swing.*;

public class MenuBar extends JMenuBar {
	private static MenuBar instance_;
	private MenuListener menuListener = new MenuListener();
	
	private MenuBar() {
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
		JMenuItem newLayerMenuItem = new JMenuItem("New Layer");
		JMenuItem openMenuItem = new JMenuItem("Open");
		JMenuItem saveMenuItem = new JMenuItem("Save");
		JMenuItem saveAsMenuItem = new JMenuItem("Save As");
		addMenuItem(newMenuItem, fileMenu);
		addMenuItem(newLayerMenuItem, fileMenu);
		addMenuItem(openMenuItem, fileMenu);
		addMenuItem(saveMenuItem, fileMenu);
		addMenuItem(saveAsMenuItem, fileMenu);
	}
	
	private void addEditMenu() {
		JMenu editMenu = new JMenu("Edit");
		add(editMenu);
	
		JMenuItem cutMenuItem = new JMenuItem("Cut");
		JMenuItem copyMenuItem = new JMenuItem("Copy");
		JMenuItem pasteMenuItem = new JMenuItem("Paste");
		addMenuItem(cutMenuItem, editMenu);
		addMenuItem(copyMenuItem, editMenu);
		addMenuItem(pasteMenuItem, editMenu);
	}
	
	private void addViewMenu() {
		JMenu viewMenu = new JMenu("View");
		add(viewMenu);
		
		JMenuItem toolBoxMenuItem = new JMenuItem("Toolbox");
		addMenuItem(toolBoxMenuItem, viewMenu);
	}
	
	private void addHelpMenu() {
		JMenu helpMenu = new JMenu("Help");
		add(helpMenu);
		
		JMenuItem shortcutsMenuItem = new JMenuItem("Short-cuts");
		JMenuItem docMenuItem = new JMenuItem("Documentation");
		JMenuItem versionMenuItem = new JMenuItem("Version");
		JMenuItem aboutMenuItem = new JMenuItem("About");
		addMenuItem(shortcutsMenuItem, helpMenu);
		addMenuItem(docMenuItem, helpMenu);
		addMenuItem(versionMenuItem, helpMenu);
		addMenuItem(aboutMenuItem, helpMenu);
	}
	
	private void addMenuItem(JMenuItem jmItem, JMenu jMenu) {
		jmItem.addActionListener(menuListener);
		jmItem.setActionCommand(jmItem.getText());
		jMenu.add(jmItem);
	}
	
	public static MenuBar getInstance() {
		if (instance_ == null) instance_ = new MenuBar();
		return instance_;
	}
}