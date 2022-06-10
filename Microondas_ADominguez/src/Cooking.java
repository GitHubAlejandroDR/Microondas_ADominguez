import java.util.concurrent.TimeUnit;

public class Cooking extends Estado_Microwave {

	public Cooking(Microwave microwave) {
		super(microwave);

	}

	@Override
	public void door_opened() {

		// Al abrir la puerta se debe de encender la lámpara
		microwave.setDoorOpen(true);
		microwave.setCooking(false);

		// Se pasa al estado OpenWithNoItem
		Estado openwithitem = new OpenWithItem(microwave);
		microwave.change_state(openwithitem);

	}

	@Override
	public void door_closed() {

		// Cerrar la puerta con la puerta cerrada no involucra ninguna acción
		throw new RuntimeException("Door currently closed");

	}

	@Override
	public void item_placed() {

		// Meter comida con la puerta cerrada no involucra ninguna acción
		throw new RuntimeException("Item currently inside");

	}

	@Override
	public void item_removed() {

		// Sacar comida con la puerta cerrada no involucra ninguna acción
		throw new RuntimeException("Action not possible in this state");

	}

	@Override
	public void power_dec() {

		// Casos:
		// Power = 0 -> No acción -> Display "Power: 0"
		// Power > 0 -> Decremento power -> Display "Power: valorActual"
		if (microwave.getPower() == 0) {
			microwave.getDisplay().setDisplay("Power: 0");
			microwave.setCooking(false);
			Estado closedwithitem = new ClosedWithItem(microwave);
			microwave.change_state(closedwithitem);
		} else {
			microwave.setPower(microwave.getPower() - 1);
		}

	}

	@Override
	public void power_inc() {

		microwave.setPower(microwave.getPower() + 1);

	}

	@Override
	public void power_reset() {

		// Reset power
		microwave.setPower(0);
		microwave.getDisplay().setDisplay("Power Reset");
		microwave.setCooking(false);
		Estado closedwithitem = new ClosedWithItem(microwave);
		microwave.change_state(closedwithitem);
	}

	@Override
	public void time_inc() {

		// Incremento time
		microwave.setTimer(microwave.getTimer() + 1);

	}

	@Override
	public void time_dec() {

		// Casos:
		// Timer = 0 -> No acción -> Display "Time: 0" -> Se pasa al estado
		// OpenWithNoItem
		// Timer > 0 -> Decremento timer -> Display "Time: valorActual"
		if (microwave.getTimer() > 1) {
			microwave.setTimer(microwave.getTimer() - 1);
			System.out.println(microwave.getTimer().toString());
		} else if (microwave.getTimer() == 1) {
			microwave.setTimer(microwave.getTimer() - 1);
			microwave.getBeeper().beep(3);
			microwave.getDisplay().setDisplay("Food ready!!");
			this.cooking_stop();
		}

	}

	@Override
	public void time_reset() {

		// Reset power
		microwave.setTimer(0);
		microwave.getDisplay().setDisplay("Timer Reset");
		microwave.setCooking(false);
		Estado closedwithitem = new ClosedWithItem(microwave);
		microwave.change_state(closedwithitem);

	}

	@Override
	public void cooking_start() {

		// Cooking en el estado cooking on no involucra ninguna acción
		throw new RuntimeException("Microwave currently working");

	}

	@Override
	public void cooking_stop() {

		// Se actualiza cooking
		microwave.setCooking(false);

		// Se pasa al estado OpenWithNoItem
		Estado closedwithitem = new ClosedWithItem(microwave);
		microwave.change_state(closedwithitem);

	}

	@Override
	public void tick() {

		this.time_dec();

	}

}
