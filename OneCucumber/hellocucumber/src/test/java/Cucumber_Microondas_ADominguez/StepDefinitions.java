package Cucumber_Microondas_ADominguez;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions.*;



	public class StepDefinitions {
	    
	    private Microwave microwave;
	    
	    
	    @Given("probar el microondas")
	    public void probar_el_microondas() {
	        microwave = new Microwave();
	    }

	    @Then("la puerta deberá de abrirse")
	    public void la_puerta_deberá_de_abrirse() {
	        assertEquals(true,microwave.getDoorOpen());
	    }

	    @Then("la luz deberá encenderse")
	    public void y_la_luz_deberá_de_encenderse() {
	        assertEquals(true,microwave.getLamp().isLampOn());
	    }

	    @When("pulso abrir la puerta")
	    public void pulso_abrir_la_puerta() {
	        microwave.door_opened();
	    }

	    @When("introduzco un alimento")
	    public void introduzco_un_alimento() {
	        microwave.item_placed();
	    }

	    @When("cierro la puerta")
	    public void cierro_la_puerta() {
	         microwave.door_closed();
	    }

	    @Then("la puerta deberá de estar cerrada")
	    public void la_puerta_deberá_de_estar_cerrada() {
	        assertEquals(false,microwave.getDoorOpen());
	    }

	    @Then("la luz deberá apagarse")
	    public void la_luz_apagada() {
	        assertEquals(false, microwave.getLamp().isLampOn());
	    }

	    @Then("deberá de mostrar la presencia de un alimento en el interior")
	    public void deberá_de_mostrar_la_presencia_de_un_alimento_en_el_interior() {
	        assertEquals(true, microwave.getWithItem());
	    }

	    @When("incremento la potencia {double}")
	    public void incremento_la_potencia(Double double1) {
	        microwave.setPower(double1.intValue());
	    }

	    @When("incremento el tiempo {double} segundos")
	    public void incremento_el_tiempo_segundo(Double double1) {
	    	microwave.setTimer(double1.intValue());
	    }

	    @Then("la deberá de abrirse")
	    public void la_deberá_de_abrirse() {
	        assertEquals(true, microwave.getDoorOpen());
	    }

	    @Then("el tiempo deber ser {double}")
	    public void el_tiempo_deber_ser(Double double1) {
	        assertEquals(double1.intValue(), microwave.getTimer());
	    }

	    @Then("la potencia debe ser {double}")
	    public void la_potencia_debe_ser(Double double1) {
	        assertEquals(double1.intValue(), microwave.getPower());
	    }

	    @When("pulso start cooking")
	    public void pulso_start_cooking() {
	       microwave.cooking_start();
	    }

	    
	    @When("y espero {double} segundo")
	    public void y_espero_segundo(Double double1) {
	        for(int i = 1; i <= double1; i++) {
	        	microwave.tick();
	        }
	    }

	    @When("pulso stop cooking")
	    public void pulso_stop_cooking() {
	        microwave.cooking_stop();
	    }

	    @Then("el plato deberá de pararse")
	    public void el_plato_deberá_de_pararse() {
	        assertEquals(false, microwave.getTurntable().isMoving());
	    }

	    @Then("el microondas parar de calentar")
	    public void el_microondas_parar_de_calentar() {
	        assertEquals(false, microwave.getHeating().isHeating());
	    }

	    @Then("el display deberá de mostrar {string}")
	    public void el_display_deberá_de_mostrar(String string) {
	        assertEquals(string, microwave.getDisplay().getDisplay());
	    }


	    
	}
	

