package Animations;

import GUI.Main;

public class Animation {
	
	protected float[] output;
	int[] tags;
	protected float speed; 
	protected float absProgress;
	protected float progress;
	protected boolean repeat;
	private boolean playing;
	
	public Animation(int[] tags, int speed, boolean repeat) {
		output = new float[tags.length];
		this.tags = tags;
		this.speed = speed;
		this.repeat = repeat;
		playing = true;
	}
	
	protected void progressAnimation() {
		if(this.playing) {
			this.absProgress += (float)Main.LOOP_SPEED_MS/500f;
			this.progress = this.absProgress/this.speed;
		}
		if(this.absProgress >= speed) {
			System.out.println("YE");
			this.progress = 0;
			this.absProgress = 0;
			if(!repeat) 
				this.playing = false;
		}
	}
	
	public void play() {
		this.playing = true;
	}
	
	public void stop() {
		this.playing = false;
	}
	
	public float[] getOutput() {
		return this.output;
	}
	
	public int[] getTags() {
		return this.tags;
	}
	
	public void update() {
		
	}
	
}
