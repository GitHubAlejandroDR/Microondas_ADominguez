
public class OpenWithItem extends Estado_Microwave {

	public OpenWithItem(Microwave microwave) {
		super(microwave);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void door_opened() {

		// Abrir la puerta con la puerta abierta no involucra ninguna acción
		throw new RuntimeException("Door currently open");

	}

	@Override
	public void door_closed() {

		// Al cerrar la puerta se debe de apagar la lámpara
		microwave.getLamp().lamp_off();
		microwave.setDoorOpen(false);

		// Se pasa al estado ClosednWithItem
		Estado closedwithnoitem = new ClosedWithItem(microwave);
		microwave.change_state(closedwithnoitem);

	}

	@Override
	public void item_placed() {

		// Meter comida con comida dentro no involucra ninguna acción
		throw new RuntimeException("Item currently inside");

	}

	@Override
	public void item_removed() {

		// Actualizamos valor withItem
		microwave.setWithItem(false);

		// Se pasa al estado OpenWithNoItem
		Estado openwithnoitem = new OpenWithNoItem(microwave);
		microwave.change_state(openwithnoitem);

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

		// Cooking con la puerta con la puerta abierta no involucra ninguna acción
		throw new RuntimeException("Action not possible in this state");

	}

	@Override
	public void cooking_stop() {

		// Stop Cooking con la puerta con la puerta abierta no involucra ninguna acción
		throw new RuntimeException("Action not possible in this state");

	}

	@Override
	public void tick() {

		// Tick con la puerta con la puerta abierta no involucra ninguna acción
		throw new RuntimeException("Action not possible in this state");

	}

}
