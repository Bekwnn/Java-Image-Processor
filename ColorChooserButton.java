import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.event.*;

public class ColorChooserButton extends JButton {
	private Color color;
	public ColorChooserButton(Color startColor) {
		super();
		setBackground(startColor);
		setMaximumSize(new Dimension(30,30));
		setPreferredSize(new Dimension(30,30));
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color c = JColorChooser.showDialog(null, "Choose a Color", getBackground());
				if (c != null)
					color = c;
					setBackground(color);
			}
		});
	}
	
	public Color getColor() { return color; }
}