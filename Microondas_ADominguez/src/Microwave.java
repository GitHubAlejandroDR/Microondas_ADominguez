
public class Microwave {

	private Estado estado;

	private Boolean doorOpen;
	private Integer power;
	private Integer timer;
	private Boolean cooking;
	private Boolean withItem;

	private Heating heating;
	private Lamp lamp;
	private Turntable turntable;
	private Beeper beeper;
	private Display display;

	public Microwave() {
 
		// Inicializamos los componentes
		this.estado = new ClosedWithNoItem(this);
		this.heating = new Heating();
		this.lamp = new Lamp();
		this.turntable = new Turntable();
		this.beeper = new Beeper();
		this.display = new Display();

		// Inicializamos las variables
		power = 0;
		doorOpen = false;
		timer = 0;
		cooking = false;
		withItem = false;
		lamp.lamp_off();
		turntable.turntable_stop();
		heating.heating_off();
		display.setDisplay("");

	}

	// Getters Componentes Microwave/////////////////////////////////////////////

	public Heating getHeating() {
		return heating;
	}

	public Lamp getLamp() {
		return lamp;
	}

	public Turntable getTurntable() {
		return turntable;
	}

	public Beeper getBeeper() {
		return beeper;
	}

	public Display getDisplay() {
		return display;
	}

	// Métodos Getters y Setters Atributos Microwave////////////////////////////

	public Boolean getDoorOpen() {
		return doorOpen;
	}

	public void setDoorOpen(Boolean doorOpen) {
		this.doorOpen = doorOpen;
	}

	public Integer getPower() {
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
		heating.setPower(power);
		display.setDisplay("Power:" + power.toString());
	}

	public Integer getTimer() {
		return timer;
	}

	public void setTimer(Integer timer) {
		this.timer = timer;
		display.setDisplay("Time:" + timer.toString());
	}

	public Boolean getCooking() {
		return cooking;
	}

	public void setCooking(Boolean cooking) {
		this.cooking = cooking;
		if (cooking == true) {
			turntable.turntable_start();
			heating.heating_on();
			lamp.lamp_off();
		} else {
			turntable.turntable_stop();
			heating.heating_off();
			lamp.lamp_on();
		}
	}

	public Boolean getWithItem() {
		return withItem;
	}

	public void setWithItem(Boolean withItem) {
		this.withItem = withItem;
	}

	// Métodos Interfaz Microwave //////////////////////////////////////////////

	public void door_opened() {
		estado.door_opened();
	}

	public void change_state(Estado estado) {
		this.estado = estado;
	}

	public void door_closed() {
		estado.door_closed();
	}

	public void item_placed() {
		estado.item_placed();
	}

	public void item_removed() {
		estado.item_removed();
	}

	public void power_dec() {
		estado.power_dec();
	}

	public void power_inc() {
		estado.power_inc();
	}

	public void power_reset() {
		estado.power_reset();
	}

	public void time_inc() {
		estado.time_inc();
	}

	public void time_dec() {
		estado.time_dec();
	}

	public void time_reset() {
		estado.time_reset();
	}

	public void cooking_start() {
		estado.cooking_start();
	}

	public void cooking_stop() {
		estado.cooking_stop();
	}

	public void tick() {
		estado.tick();
	}

}
