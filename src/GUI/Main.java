package GUI;

import javax.swing.JFrame;

import GameLoop.GameLoop;

public class Main {
	
	public static final int LOOP_SPEED_MS = 10;
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 1020;

	public static void main(String args[]) {
		GameLoop loop = new GameLoop();
		GUIEventQueue queue = new GUIEventQueue();
		JFrame frame = new JFrame("Frame Name");
		GUICanvas canvas = new GUICanvas(WIDTH, HEIGHT);
		GUIFrame uiFrame = new GUIFrame(canvas, frame, loop);
		uiFrame.setSize(Main.WIDTH, Main.HEIGHT);
        canvas.addEventQueue(queue);
        loop.setElements(queue, canvas, uiFrame);
        uiFrame.start(uiFrame.getWidth(), uiFrame.getHeight());
        
        
	}
	
	public static void wait(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
