package GUI;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import GUIElements.GUIElement;

public class GUICanvas extends Canvas {
	//TODO: generate new long for serialVersionUID
	private static final long serialVersionUID = -557652432650828632L;
	private int width;
	private int height;
	private ArrayList<GUIElement> elements;
	
	public GUICanvas(int width, int height) {
		this.setBackground(Color.GRAY);
		this.setSize(width, height-20);
		this.width = width;
		this.height = height;
	}
	
	
	public void draw(Graphics2D g2) {
		BufferedImage img = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = (Graphics2D) img.getGraphics();
		this.clear(g2);
		//test that it works
		
		g.fillRect(10, 10, 50, 50);
		g.setColor(Color.BLUE);
		g.fillRect(30,30,50,50);
		for(GUIElement e: elements) {
			if(!e.isHidden())
				g.drawImage(e.getImage(), e.getTransform(), null);
		}
		this.render(g2, img);		
	}
	
	public void clear(Graphics g) {
		g.setColor(this.getBackground());
		g.fillRect(0, 0, this.width, this.height);
	}
	
	public void render(Graphics g, BufferedImage img) {
		
		img = this.scaleToFrameSize(img);
		g.drawImage(img, 0, 0, null);
		g.dispose();
		
	}
	
	public BufferedImage scaleToFrameSize(BufferedImage img) {
		
		int[] targetRes = new int[2];
		targetRes[0] = this.getWidth();
		targetRes[1] = this.getHeight();
		
		return scale(targetRes, img);
		
	}
	
	public BufferedImage scale(int[] targetRes, BufferedImage img) {
		if(targetRes[1] != Main.WIDTH && targetRes[0] != Main.HEIGHT - 20) {
			Image image = img.getScaledInstance(targetRes[0], targetRes[1], Image.SCALE_SMOOTH);
			BufferedImage resizedImage = new BufferedImage(targetRes[0], targetRes[1], BufferedImage.TYPE_INT_ARGB); 
			Graphics2D g = resizedImage.createGraphics();
			g.drawImage(image, 0, 0, targetRes[0], targetRes[1], null);
			g.dispose();
		    return resizedImage;
		}
		return img;
	}
	
	public void setGUIElements(ArrayList<GUIElement> elements) {
		this.elements = elements;
	}
	
	public void addEventQueue(GUIEventQueue queue)  {

		this.addKeyListener(queue);
		this.addMouseListener(queue);
		this.addMouseMotionListener(queue);

		return;
	}
		
}
