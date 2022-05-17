package manager;

import mylistener.PaintingListener;

public class ButtonManager {
	public static boolean canPressBtn() {
		if (PaintingListener.tempPoints == null) return true;
		return false;
	}
}
