

public class LineTool extends Tool {
	private static LineTool instance_;
		
	private LineTool() {
		Toolkit toolkit =  Toolkit.getDefaultToolkit()
		Image image = toolkit.getImage("/icons/C_LineTool");
		Point center = new Point(12,12);
		cursor = toolkit.createCustomCursor(image, center, "Line Tool");
	}
	
	public LineTool getInstance() {
		if (instance_ == null) instance_ = new LineTool();
		return instance_;
	}
}