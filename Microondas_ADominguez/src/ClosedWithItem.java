
public class ClosedWithItem extends Estado_Microwave {

	public ClosedWithItem(Microwave microwave) {
		super(microwave);
		// TODO Auto-generated constructor stub

	}

	@Override
	public void door_opened() {

		// Al abrir la puerta se debe de encender la lámpara
		microwave.getLamp().lamp_on();
		microwave.setDoorOpen(true);

		// Se pasa al estado OpenWithNoItem
		Estado openwithitem = new OpenWithItem(microwave);
		microwave.change_state(openwithitem);

	}

	@Override
	public void door_closed() {

		// Cerrar la puerta con la puerta cerrada no involucra ninguna accin
		throw new RuntimeException("Door currently closed");

	}

	@Override
	public void item_placed() {

		// Meter comida con la puerta cerrada no involucra ninguna accin
		throw new RuntimeException("Door currently closed");

	}

	@Override
	public void item_removed() {

		// Sacar comida con la puerta cerrada no involucra ninguna accin
		throw new RuntimeException("Door currently closed");
	}

	@Override
	public void power_dec() {

		// Casos:
		// Power = 0 -> No acción -> Display "Power: 0"
		// Power > 0 -> Decremento power -> Display "Power: valorActual"
		if (microwave.getPower() == 0) {
			microwave.getDisplay().setDisplay("Power: 0");
		} else {
			microwave.setPower(microwave.getPower() - 1);
		}

	}

	@Override
	public void power_inc() {

		// Incremento power
		microwave.setPower(microwave.getPower() + 1);
	}

	@Override
	public void power_reset() {

		// Reset power
		microwave.setPower(0);
		microwave.getDisplay().setDisplay("Power Reset");

	}

	@Override
	public void time_inc() {

		// Incremento time
		microwave.setTimer(microwave.getTimer() + 1);

	}

	@Override
	public void time_dec() {

		// Casos:
		// Timer = 0 -> No acción -> Display "Time: 0"
		// Timer > 0 -> Decremento timer -> Display "Time: valorActual"
		if (microwave.getTimer() == 0) {
			microwave.getDisplay().setDisplay("Time: 0");

		} else {
			microwave.setTimer(microwave.getTimer() - 1);
		}

	}

	@Override
	public void time_reset() {

		// Reset power
		microwave.setTimer(0);
		microwave.getDisplay().setDisplay("Timer Reset");

	}

	@Override
	public void cooking_start() {

		if (microwave.getPower() > 0 & microwave.getTimer() > 0) {
			// Se actualiza estdo de variables
			microwave.setCooking(true);

			// Se pasa al estado Cooking
			Estado cooking = new Cooking(microwave);
			microwave.change_state(cooking);
		} else {
			microwave.getDisplay().setDisplay("Error Configuration");
		}

	}

	@Override
	public void cooking_stop() {

		// Cooking Stop en este estado no involucra ninguna accin
		throw new RuntimeException("Action not possible in this state");

	}

	@Override
	public void tick() {

		// Cooking Stop en este estado no involucra ninguna accin
		throw new RuntimeException("Action not possible in this state");

	}

}
