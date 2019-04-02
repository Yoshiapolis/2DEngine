package GUIElements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Animations.TestAnimation;
import GUI.GUIEvent;

public class TestSquare extends GUIElement{
	
	
	public TestSquare(int x, int y, int width, int height, Color c) {
		super(x, y, 9);
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		super.appearance[2] = width;
		super.appearance[3] = height;
		Graphics g = img.getGraphics();
		g.setColor(c);
		g.fillRect(0, 0, width, height);
		g.dispose();
		
		super.setImage(img);
		super.addAnimation(new TestAnimation(200, 5));
	}
	
	@Override
	public void render() {
		Color c = new Color(super.appearance[6], super.appearance[7], super.appearance[8]);
		BufferedImage img = new BufferedImage((int)super.appearance[2], (int)super.appearance[3], BufferedImage.TYPE_INT_ARGB);
		Graphics g = img.getGraphics();
		
		g.setColor(c);
		g.fillRect(0, 0, (int)super.appearance[2], (int)super.appearance[3]);
		g.dispose();
		
		super.setImage(img);
	}
	
	@Override
	public void update(GUIEvent e) {
		this.render();
		super.updateAnimations();
	}
	
}
