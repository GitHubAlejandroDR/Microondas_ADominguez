package Cucumber_Microondas_ADominguez;

public class Lamp {

	private boolean lampOn;
	
	public void lamp_on() {
		lampOn = true;
	}
	
	public void lamp_off() {
		lampOn=false;
	}
	
	public boolean isLampOn() {
		return lampOn;
	}
}
