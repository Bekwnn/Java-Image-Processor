import javax.swing.*;

public class BasicToolBox extends JToolBar {
	public BasicToolBox() {
		super(JToolBar.VERTICAL);
		add(new JButton("Brush"));
		add(new JButton("Eraser"));
		add(new JButton("Line"));
		add(new JButton("Rectangle"));
		add(new JButton("Ellipse"));
		add(new JButton("Bucket"));
	}
}