package GameLoop;

import java.awt.Color;
import java.util.ArrayList;

import GUI.GUICanvas;
import GUI.GUIEvent;
import GUI.GUIEventQueue;
import GUI.GUIFrame;
import GUIElements.GUIElement;
import GUIElements.TestSquare;


public class GameLoop {

	public GUIEventQueue queue;
	public GUICanvas canvas;
	public GUIEvent event;
	public GUIFrame frame;
	public ArrayList<GUIElement> elements;
	
	public GameLoop() {
		elements = new ArrayList<GUIElement>();
		elements.add(new TestSquare(100, 100, 100, 100, Color.GREEN));
	}
	
	public void update() {
		
		
		
		if(queue.isEventToProcess()) {
			event = queue.getEvent();
			for(GUIElement e: elements) {
				e.update(event);
			}
		} else {
			for(GUIElement e: elements) {
				e.update(null);
			}
		}
	
	}

	
	public void setElements(GUIEventQueue q, GUICanvas c, GUIFrame f) {
		this.queue = q;
		this.canvas = c;
		this.frame = f;
		this.canvas.setGUIElements(this.elements);
	}
	
}
