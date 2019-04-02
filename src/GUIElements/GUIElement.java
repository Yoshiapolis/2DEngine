package GUIElements;

import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import Animations.Animation;
import GUI.GUIEvent;

public class GUIElement {
	
	protected float[] appearance;
	//default x, y, width, height, scale, rotation
	private boolean hidden;
	private Image image;
	protected ArrayList<Animation> anims;
	
	public GUIElement(int x, int y, int numValues) {
		anims = new ArrayList<Animation>();
		appearance = new float[numValues];
		this.appearance[0] = x;
		this.appearance[1] = y;
		this.appearance[4] = 1f;
		this.image = null;
		
	}
	
	public GUIElement(int x, int y, Image image, int numValues) {
		anims = new ArrayList<Animation>();
		appearance = new float[numValues];
		this.appearance[0] = x;
		this.appearance[1] = y;
		this.image = image;
	}
	
	protected void setAppearance(int[] fixed, int[] specified) {
		for(int i = 0; i < this.appearance.length; i ++) {
			if(i < specified.length) {
				this.appearance[i] = specified[i];
			} else {
				this.appearance[i] = fixed[i];
			}
		}
	}
	
	public AffineTransform getTransform() {
		AffineTransform at = new AffineTransform();
		
		at.translate(this.getX(), this.getY());
		at.scale(this.appearance[4], this.appearance[4]);
		at.rotate(Math.toRadians(this.appearance[5]));
		
		return at;
	}
	
	public void addAnimation(Animation a) {
		this.anims.add(a);
	}
	
	protected void setImage(Image img) {
		this.image = img;
	}
	
	public void render() {
		
	}
	
	public void update(GUIEvent e) {
		
	}
	
	public void updateAnimations() {
		for(Animation a: this.anims) {
			a.update();
			int[] tags = a.getTags();
			float[] values = a.getOutput();
			for(int i = 0; i < tags.length; i ++) {
				System.out.println(values[i]);
				this.appearance[tags[i]] = values[i];
			}
		}
	}
	
	public int getX() {
		return (int) this.appearance[0];
	}
	
	public int getY() {
		return (int) this.appearance[1];
	}
	
	public void toggle() {
		this.hidden = !this.hidden;
	}
	
	public boolean isHidden() {
		return this.hidden;
	}
	
	public Image getImage() {
		return this.image;
	}
}
