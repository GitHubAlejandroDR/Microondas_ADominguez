import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Test_Microwave {


	@Test
	public void tests(){
		
		// Comprobamos las variables y operaciones en el estado ClosedWithNoItem
		Microwave microwave = new Microwave();
		assertEquals(0,microwave.getPower());
		assertEquals(0,microwave.getTimer());
		assertEquals(false,microwave.getWithItem());
		assertEquals(false,microwave.getDoorOpen());
		assertEquals(false,microwave.getCooking()); 
		assertEquals(false,microwave.getLamp().isLampOn());
		assertEquals(false,microwave.getLamp().isLampOn());
		assertThrows(RuntimeException.class, () -> { microwave.cooking_start();});
		assertThrows(RuntimeException.class, () -> { microwave.tick();});
		assertThrows(RuntimeException.class, () -> { microwave.door_closed();});
		assertThrows(RuntimeException.class, () -> { microwave.cooking_stop();});

		

		// Comprobamos que no ser permiten valores negativos de time y power
		microwave.power_dec();
		microwave.time_dec();
		assertEquals(0,microwave.getPower());
		assertEquals(0,microwave.getTimer());
		
		// Comprobamos variables y operaciones en el estado OpenWithNoItem
		microwave.door_opened(); 
		assertEquals(0,microwave.getPower());
		assertEquals(0,microwave.getTimer());
		assertEquals(false,microwave.getWithItem());
		assertEquals(true,microwave.getDoorOpen());
		assertEquals(false,microwave.getCooking());
		assertEquals(true,microwave.getLamp().isLampOn());
		assertThrows(RuntimeException.class, () -> { microwave.cooking_start();});
		assertThrows(RuntimeException.class, () -> { microwave.tick();});
		assertThrows(RuntimeException.class, () -> { microwave.door_opened();});
		assertThrows(RuntimeException.class, () -> { microwave.cooking_stop();});
		assertThrows(RuntimeException.class, () -> { microwave.item_removed();});

		 
		// Comprobamos variables y operaciones en el estado OpenWithItem
		microwave.item_placed();
		assertEquals(0,microwave.getPower());
		assertEquals(0,microwave.getTimer());
		assertEquals(true,microwave.getWithItem());
		assertEquals(true,microwave.getDoorOpen());
		assertEquals(false,microwave.getCooking());
		assertEquals(true,microwave.getLamp().isLampOn());
		assertThrows(RuntimeException.class, () -> { microwave.cooking_start();});
		assertThrows(RuntimeException.class, () -> { microwave.tick();});
		assertThrows(RuntimeException.class, () -> { microwave.door_opened();});
		assertThrows(RuntimeException.class, () -> { microwave.cooking_stop();});
		assertThrows(RuntimeException.class, () -> { microwave.item_placed();});
		
		// Comprobamos variables y operaciones en el estado ClosedWithItem
		microwave.door_closed();
		assertEquals(0,microwave.getPower());
		assertEquals(0,microwave.getTimer());
		assertEquals(true,microwave.getWithItem());
		assertEquals(false,microwave.getDoorOpen());
		assertEquals(false,microwave.getCooking());
		assertEquals(false,microwave.getLamp().isLampOn());
		assertThrows(RuntimeException.class, () -> { microwave.tick();});
		assertThrows(RuntimeException.class, () -> { microwave.door_closed();});
		assertThrows(RuntimeException.class, () -> { microwave.cooking_stop();});
		assertThrows(RuntimeException.class, () -> { microwave.item_placed();});

		
		// Comprobamos variables en el estado ClosedWithItem con configuración no permitida
		microwave.cooking_start();
		assertEquals(0,microwave.getPower());
		assertEquals(0,microwave.getTimer());
		assertEquals(true,microwave.getWithItem());
		assertEquals(false,microwave.getDoorOpen());
		assertEquals(false,microwave.getCooking());
		assertEquals(false,microwave.getLamp().isLampOn());
		
		// Comprobamos variables y operaciones en el estado Cooking
		microwave.time_inc();
		microwave.power_inc();
		assertEquals(1,microwave.getPower());
		assertEquals(1,microwave.getTimer());
		microwave.cooking_start();
		microwave.tick();
		assertEquals(1,microwave.getPower());
		assertEquals(0,microwave.getTimer());
		assertEquals(true,microwave.getWithItem());
		assertEquals(false,microwave.getDoorOpen());
		assertEquals(false,microwave.getCooking());
		assertEquals(true,microwave.getLamp().isLampOn());
		
		// Comprobamos variables y operaciones en el estado Cooking abriendo la puerta antes de terminar
		microwave.setTimer(20);
		assertEquals(1, microwave.getPower());
		microwave.cooking_start();
		// "Reloj externo" -> Simulamos 15 segundos
		for(int i = 1;i <= 15;i++) {
			microwave.tick();
		}
		microwave.door_opened();
		assertEquals(1, microwave.getPower());
		assertEquals(5, microwave.getTimer());
		assertEquals(true, microwave.getWithItem());
		assertEquals(true, microwave.getDoorOpen());
		assertEquals(false, microwave.getCooking());
		assertEquals(true, microwave.getLamp().isLampOn());
		assertThrows(RuntimeException.class, () -> { microwave.tick();});
		assertThrows(RuntimeException.class, () -> { microwave.door_opened();});
		assertThrows(RuntimeException.class, () -> { microwave.cooking_stop();});
		assertThrows(RuntimeException.class, () -> { microwave.item_placed();});
		
		// Comprobamos la posibilidad de aumentar la potencia el tiempo y potencia mientras el microondas está calentado
		microwave.door_closed();
		microwave.setTimer(15);
		microwave.cooking_start();
		// "Reloj externo" -> Simulamos 15 segundos
		for(int i = 1;i <= 10;i++) {
			microwave.tick();
		}
		microwave.time_inc();
		microwave.power_inc();
		assertEquals(2, microwave.getPower());
		assertEquals(6, microwave.getTimer());
		// "Reloj externo" -> Simulamos los 6 segundos restantes
		for(int i = 1;i <= 6;i++) {
			microwave.tick();
		}
		assertEquals(2, microwave.getPower());
		assertEquals(0, microwave.getTimer());
		assertEquals(true, microwave.getWithItem());
		assertEquals(false, microwave.getDoorOpen());
		assertEquals(false, microwave.getCooking());
		assertEquals(true, microwave.getLamp().isLampOn());
		assertThrows(RuntimeException.class, () -> { microwave.tick();});
		assertThrows(RuntimeException.class, () -> { microwave.door_closed();});
		assertThrows(RuntimeException.class, () -> { microwave.cooking_stop();});
		assertThrows(RuntimeException.class, () -> { microwave.item_placed();});
		
		//Volvemos en los estados desde Cooking
		//Comprobamos variables estado OpenWithItem
		microwave.door_opened();
		assertEquals(2,microwave.getPower());
		assertEquals(0,microwave.getTimer());
		assertEquals(true,microwave.getWithItem());
		assertEquals(true,microwave.getDoorOpen());
		assertEquals(false,microwave.getCooking());
		assertEquals(false, microwave.getTurntable().isMoving());
		assertEquals(true,microwave.getLamp().isLampOn());
		assertThrows(RuntimeException.class, () -> { microwave.tick();});
		assertThrows(RuntimeException.class, () -> { microwave.door_opened();});
		assertThrows(RuntimeException.class, () -> { microwave.cooking_stop();});
		assertThrows(RuntimeException.class, () -> { microwave.item_placed();});
		
		// Comprobamos variables estado OpenWithNoItem
		microwave.item_removed();;
		assertEquals(2,microwave.getPower());
		assertEquals(0,microwave.getTimer());
		assertEquals(false,microwave.getWithItem());
		assertEquals(true,microwave.getDoorOpen());
     	assertEquals(false,microwave.getCooking());
		assertEquals(true,microwave.getLamp().isLampOn());
		assertThrows(RuntimeException.class, () -> { microwave.tick();});
		assertThrows(RuntimeException.class, () -> { microwave.door_opened();});
		assertThrows(RuntimeException.class, () -> { microwave.cooking_stop();});
		assertThrows(RuntimeException.class, () -> { microwave.item_removed();});
		
		// Comprobamos variables estado ClosedWithNoItem
		microwave.door_closed();
		assertEquals(2,microwave.getPower());
		assertEquals(0,microwave.getTimer());
		assertEquals(false,microwave.getWithItem());
		assertEquals(false,microwave.getDoorOpen());
		assertEquals(false,microwave.getCooking());
		assertEquals(false,microwave.getLamp().isLampOn());
		assertThrows(RuntimeException.class, () -> { microwave.tick();});
		assertThrows(RuntimeException.class, () -> { microwave.door_closed();});
		assertThrows(RuntimeException.class, () -> { microwave.cooking_stop();});
		assertThrows(RuntimeException.class, () -> { microwave.item_removed();});
		
		
	}

}
