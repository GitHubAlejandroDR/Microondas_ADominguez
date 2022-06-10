package Cucumber_Microondas_ADominguez;

public class OpenWithNoItem extends Estado_Microwave {

	
	
	public OpenWithNoItem(Microwave microwave) {
		super(microwave);
		// TODO Auto-generated constructor stub
	}

	
	
	@Override
	public void door_opened() {

		// Abrir la puerta con la puerta abierta no involucra ninguna acci�n
	} 

	@Override
	public void door_closed() {

		// Actualizamos estados de las variables
		microwave.getLamp().lamp_off();
		microwave.setDoorOpen(false);

		// Se pasa al estado ClosedWithNoItem
		Estado closedwithnoitem = new ClosedWithNoItem(microwave);
		microwave.change_state(closedwithnoitem);
	}

	@Override
	public void item_placed() {

		//Actualizamos valor withitem
		microwave.setWithItem(true);
		
		// Se pasa al estado OpenWithItem
		Estado openwithitem = new OpenWithItem(microwave);
		microwave.change_state(openwithitem);

	}

	@Override
	public void item_removed() {

		// Sacar comida en este estado no involucra ninguna acci�n

	}

	@Override
	public void power_dec() {

		// Casos:
		// Power = 0 -> No acci�n -> Display "Power: 0"
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
		// Timer = 0 -> No acci�n -> Display "Time: 0"
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

		// Cooking con la puerta con la puerta abierta sin comida no involucra ninguna
		// acci�n

	}

	@Override
	public void cooking_stop() {

		// Stop Cooking con la puerta con la puerta abierta sin comida no involucra
		// ninguna acci�n

	}

	@Override
	public void tick() {

		// Tick con la puerta con la puerta abierta sin comida no involucra ninguna
		// acci�n

	}
	
	
	

}
