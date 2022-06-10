
public class Heating {

	private boolean heating;
	private Integer power;

	public void heating_on() {
		heating = true;
	}

	public void heating_off() {
		heating = false;
	}

	public void setPower(int p) {
		power = p;
	}

	public boolean isHeating() {
		return heating;
	}

	public Integer getPower() {
		return power;
	}
}
