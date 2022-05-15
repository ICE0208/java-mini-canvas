package point;

import java.util.ArrayList;

import main.MyFrame;
import mylistener.PaintingListener;

public class PointsHistory {
	private ArrayList<ArrayList<PointInfo>> history = new ArrayList<ArrayList<PointInfo>>();
	
	public PointsHistory() {
	}
	
	public void clear() {
		history.clear();
	}
	
	public void add(ArrayList<PointInfo> point) {
		history.add(point);
	}

	public void redo() {
		
		int historyLen = history.size();
		if (historyLen == 0) return;
		
		ArrayList<PointInfo> redoTarget;
		redoTarget = history.remove(historyLen-1);
		MyFrame.points.add(redoTarget);
		PaintingListener.paintPanel.repaint();
	}
}
