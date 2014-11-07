import java.awt.event.MouseEvent;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.Color;

public class BucketFillTool extends Tool {
	
	private static class Point {
		public int x, y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private ArrayList<Point> pQueue;
	
	public BucketFillTool() {}
	
	public void mouseReleased(MouseEvent e) {
		MainImagePanel mip = MainImagePanel.getInstance();
		boolean[][] processed = new boolean[JIP.iWidth][JIP.iHeight];
		floodFill((int)e.getX(), (int)e.getY(), processed);
		mip.updateCombinedImage();
	}
	
	//Queue based flooFill algorithm; very fast
	//targetColor = the color clicked on that we plan to flood
	//replacementColor = the color we'll be flooding
	private void floodFill(int x, int y, boolean[][] processed) {
		BufferedImage curLayer = MainImagePanel.getInstance().getLayer();
		
		//get the colors as int values for comparisons
		int targetColor = curLayer.getRGB(x, y);
		int replacementColor = BasicToolbox.getInstance().getPrimaryColor().getRGB();
		
		//if the target color is the replacement color, work is already done
		if (replacementColor == targetColor)
			return;
		
		//create queue and add starting point
		pQueue = new ArrayList<Point>();
		pQueue.add(new Point(x, y));
		
		//while queue is not empty, flood pixels and add their unprocessed neighbors to the queue
		while (!pQueue.isEmpty()) {
			Point n = pQueue.remove(pQueue.size()-1);
			if (curLayer.getRGB(n.x, n.y) == targetColor) {
				curLayer.setRGB(n.x, n.y, replacementColor);
				processed[n.x][n.y] = true;
				if (n.x-1 >= 0 && processed[n.x-1][n.y] == false)
					pQueue.add(new Point(n.x-1, n.y));
				if (n.y-1 >= 0 && processed[n.x][n.y-1] == false)
					pQueue.add(new Point(n.x, n.y-1));
				if (n.x+1 < JIP.iWidth && processed[n.x+1][n.y] == false)
					pQueue.add(new Point(n.x+1, n.y));
				if (n.y+1 < JIP.iWidth && processed[n.x][n.y+1] == false)
					pQueue.add(new Point(n.x, n.y+1));
			}
		}
	}
}