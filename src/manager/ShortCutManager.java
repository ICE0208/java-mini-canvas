package manager;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import mypanel.MenuPanel;

public class ShortCutManager {
	MenuPanel targetPanel = null;
	InputMap im = null;
	
	public ShortCutManager(MenuPanel target) {
		this.targetPanel = target;
		this.im = targetPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		
	}
	
	@SuppressWarnings("serial")
	public void setShortCutAll() {
		//undo for mac
        im.put(KeyStroke.getKeyStroke("meta Z"), "undo");
        targetPanel.getActionMap().put("undo", new AbstractAction(){
            public void actionPerformed(ActionEvent e) {
                targetPanel.undoListener.doUndo();
            }
        });
      //undo for win + mac
        im.put(KeyStroke.getKeyStroke("control Z"), "undo");
        targetPanel.getActionMap().put("undo", new AbstractAction(){
            public void actionPerformed(ActionEvent e) {
                targetPanel.undoListener.doUndo();
            }
        });
      //redo for mac
        im.put(KeyStroke.getKeyStroke("meta shift Z"), "redo");
        targetPanel.getActionMap().put("redo", new AbstractAction(){
            public void actionPerformed(ActionEvent e) {
                targetPanel.redoListener.doRedo();
            }
        });
      //redo for win + mac
        im.put(KeyStroke.getKeyStroke("control Y"), "redo");
        targetPanel.getActionMap().put("redo", new AbstractAction(){
            public void actionPerformed(ActionEvent e) {
                targetPanel.redoListener.doRedo();
            }
        });
        //save for mac
        im.put(KeyStroke.getKeyStroke("meta S"), "save");
        targetPanel.getActionMap().put("save", new AbstractAction(){
            public void actionPerformed(ActionEvent e) {
                targetPanel.saveListener.doSave();
            }
        });
      //save for win + mac
        im.put(KeyStroke.getKeyStroke("control S"), "save");
        targetPanel.getActionMap().put("save", new AbstractAction(){
            public void actionPerformed(ActionEvent e) {
                targetPanel.saveListener.doSave();
            }
        });
	}
}
