import javax.swing.event.MouseInputAdapter;
import java.awt.Cursor;

//base tool class all other tools inherit from. Plan to have a constructor that sets tool's cursor icon
public class Tool extends MouseInputAdapter {
	protected Cursor cursor;	//cursor the mouse changes to when mousing over the main image panel (currently not used)
}