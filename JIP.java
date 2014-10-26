public class JIP {
	public static int iWidth = 300;
	public static int iHeight = 300;
	private static JIPMainWindow mainWindow;
	public static void main(String[] args) {
		mainWindow = new JIPMainWindow();
		mainWindow.setSize(600,600);
		mainWindow.setTitle("Java Image Processor");
		mainWindow.setVisible(true);
	}
}