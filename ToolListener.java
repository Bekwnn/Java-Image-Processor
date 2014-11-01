import java.awt.event.*;
import javax.swing.event.*;
import java.awt.*;

public class ToolListener extends MouseInputAdapter {
	private int newCursor;
	private final Cursor defaultCursor;
	private Rectangle bounds;

	public ToolListener(int cursorChange, Rectangle bounds) {
		defaultCursor = Cursor.getDefaultCursor();
		newCursor = cursorChange;
		this.bounds = bounds;
	}
	
	public void mousePressed(MouseEvent e) {
		
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	public void mouseEntered(MouseEvent e) {
	
	}
	
	public void mouseExited(MouseEvent e) {
		
	}
	
	public void mouseClicked(MouseEvent e) {
		
	}
}