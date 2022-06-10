package Cucumber_Microondas_ADominguez;

public class Turntable {

	private boolean turntableOn;
	
	public void turntable_start() {
		turntableOn = true;
	}
	
	public void turntable_stop() {
		turntableOn = false;
	}
	
	public boolean isMoving() {
		return turntableOn;
	}
}
