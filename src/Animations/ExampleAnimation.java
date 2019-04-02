package Animations;

public class ExampleAnimation extends Animation {
	
	static int[] tags = {0, 1, 2, 3, 4, 5, 6, 7, 8};
	int range;
	
	public ExampleAnimation(int range, int duration) {
		super(tags, duration, true);
		this.range = range;
	}
	
	@Override
	public void update() {
		super.progressAnimation();
		super.output[0] = (int) (super.progress * (float)range);
		super.output[1] = (int) (super.progress * (float)range);
		super.output[2] = (int) (((1-super.progress) * (float)range))/2 + 1;
		super.output[3] = (int) (super.progress * (float)range) + 1;
		super.output[4] = super.progress;
		super.output[5] = (int) (super.progress * 360) + 1;
		super.output[6] = (float)Math.cos(super.progress);
		super.output[7] = (float)Math.sin(super.progress);
		super.output[8] = 20f/255f;
	}
	
}
