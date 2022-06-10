@tag
Feature: Funcionamiento de estados del microondas y componentes asociados. 
 

  @ScenarioOpenWithNoItem
  Scenario: Como usuario quiero encender el microondas y abrir la puerta
    Given probar el microondas
    When pulso abrir la puerta
    Then la puerta deberá de abrirse
    And la luz deberá encenderse

  @ScenarioClosedWithItem
  Scenario: Como usuario quiero encender el microondas, abrir la puerta, introducir un alimento y cerrar la puerta
    Given probar el microondas
    When pulso abrir la puerta
    And introduzco un alimento
    And cierro la puerta
    Then la puerta deberá de estar cerrada
    And la luz deberá apagarse
    And deberá de mostrar la presencia de un alimento en el interior
    
  @ScenarioOpenClosedPowerTimeInc
  Scenario: Como usuario quiero encender el microondas, abrir la puerta, introcducir un alimento y incrementar el tiempo y potencia
		Given probar el microondas
		When pulso abrir la puerta
		And introduzco un alimento
		And incremento la potencia 1.0
		And incremento el tiempo 1.0 segundos
		Then la puerta deberá de abrirse
		And deberá de mostrar la presencia de un alimento en el interior
		And el tiempo deber ser 1.0
		And la potencia debe ser 1.0
		
	@ScenarioCookingFinish
	Scenario: Como usuario quiero encender el microondas, abrir la puerta, introducir un alimento, cerrar la puerta, incrementar el tiempo y potencia y cocinar el alimento
		Given probar el microondas
		When pulso abrir la puerta
		And introduzco un alimento
		And incremento la potencia 1.0
		And incremento el tiempo 1.0 segundos
		And cierro la puerta
		And pulso start cooking
		And y espero 1.0 segundo
		Then deberá de mostrar la presencia de un alimento en el interior
		And la puerta deberá de estar cerrada
		And el tiempo deber ser 0.0
		And la potencia debe ser 1.0
		And la luz deberá encenderse
		
	@ScenarioStopCooking
	Scenario: Como usuario quiero encender el microondas, abrir la puerta, introducir un alimento, cerrar la puerta, incrementar el tiempo y potencia, cocinar el alimento y para la coción antes de terminar
		Given probar el microondas
		When pulso abrir la puerta
		And introduzco un alimento
		And incremento la potencia 1.0
		And incremento el tiempo 3.0 segundos
		And cierro la puerta
		And pulso start cooking
		And y espero 1.0 segundo
		And pulso stop cooking
		Then deberá de mostrar la presencia de un alimento en el interior
		And la puerta deberá de estar cerrada
		And el tiempo deber ser 2.0
		And la potencia debe ser 1.0
		And la luz deberá encenderse
		
	@ScenarioHeatingStop
	Scenario: Como usuario quiero encender el microondas, abrir la puerta, introducir un alimento, cerrar la puerta, incrementar el tiempo y potencia, cocinar el alimento, para la coción antes de terminar y verificar que el plato no esta girando ni el microondas calentando
		Given probar el microondas
		When pulso abrir la puerta
		And introduzco un alimento
		And incremento la potencia 1.0
		And incremento el tiempo 3.0 segundos
		And cierro la puerta
		And pulso start cooking
		And y espero 1.0 segundo
		And pulso stop cooking
		Then deberá de mostrar la presencia de un alimento en el interior
		And la puerta deberá de estar cerrada
		And el tiempo deber ser 2.0
		And la potencia debe ser 1.0
		And la luz deberá encenderse
		And el microondas parar de calentar
		
	@ScenarioDisplay
	Scenario: Como usuario quiero encender el microondas, abrir la puerta, introducir un alimento, cerrar la puerta, incrementar el tiempo y potencia y ver cuanto se ha incrementado
    Given probar el microondas
    When pulso abrir la puerta
    And introduzco un alimento
    And cierro la puerta
    And incremento la potencia 1.0
		And incremento el tiempo 1.0 segundos
    Then la puerta deberá de estar cerrada
    And la luz deberá apagarse
    And deberá de mostrar la presencia de un alimento en el interior
    And el display deberá de mostrar "Time:1"
   
  @ScenarioOpenDoorCooking
   Scenario: Como usuario quiero encender el microondas, abrir la puerta, introducir un alimento, cerrar la puerta, incrementar el tiempo y potencia, cocinar el alimento y abrir la puerta antes de terminar
		Given probar el microondas
		When pulso abrir la puerta
		And introduzco un alimento
		And incremento la potencia 1.0
		And incremento el tiempo 3.0 segundos
		And cierro la puerta
		And pulso start cooking
		And y espero 1.0 segundo
		And pulso abrir la puerta
		Then deberá de mostrar la presencia de un alimento en el interior
		And la puerta deberá de abrirse
		And la luz deberá encenderse
		And el tiempo deber ser 2.0
		And la potencia debe ser 1.0
		And la luz deberá encenderse
		
		
	@ScenarioStopCooking_outline
	Scenario:  Como usuario quiero encender el microondas, abrir la puerta, introducir un alimento, cerrar la puerta, incrementar el tiempo y potencia, cocinar el alimento y terminar la cocion
		Given probar el microondas
		When pulso abrir la puerta
		And introduzco un alimento
		And incremento la potencia 1.0
		And incremento el tiempo <value1> segundos
		And cierro la puerta
		And pulso start cooking
		And y espero <value2> segundo
		Then deberá de mostrar la presencia de un alimento en el interior
		And la puerta deberá de estar cerrada
		And el tiempo deber ser <status>
		And la potencia debe ser 1.0
		
		Examples: 
      | value1    | value2   | status    |
			|		2.0 		|    2.0   |    0.0    |
      |		1.0 		|    0.0   |    1.0    |
      |		3.0 		|    3.0   |    0.0    |
      |		2.0 		|   -2.0   |    2.0    |
      
      
      
 @ScenarioCookingDoorOpen_outline
	Scenario:  Como usuario quiero encender el microondas, abrir la puerta, introducir un alimento, cerrar la puerta, incrementar el tiempo y potencia, cocinar el alimento y para la coción en varios instantes
		Given probar el microondas
		When pulso abrir la puerta
		And introduzco un alimento
		And incremento la potencia 1.0
		And incremento el tiempo <value1> segundos
		And cierro la puerta
		And pulso start cooking
		And y espero <value2> segundo
		And pulso abrir la puerta
		Then deberá de mostrar la presencia de un alimento en el interior
		And la puerta deberá de abrirse
		And el tiempo deber ser <status>
		And la potencia debe ser 1.0
		And la luz deberá encenderse
		
		Examples: 
      | value1    | value2   | status    |
			|		2.0 		|    2.0   |    0.0    |
      |		1.0 		|    0.0   |    1.0    |
      |		3.0 		|    3.0   |    0.0    |
      |		2.0 		|   -2.0   |    2.0    |
      
 
 @ScenarioCookingPauseOpenClose_outline
	Scenario:  Como usuario quiero encender el microondas, abrir la puerta, introducir un alimento, cerrar la puerta, incrementar el tiempo y potencia, cocinar el alimento y para la coción en varios instantes
		Given probar el microondas
		When pulso abrir la puerta
		And introduzco un alimento
		And incremento la potencia 1.0
		And incremento el tiempo <value1> segundos
		And cierro la puerta
		And pulso start cooking
		And y espero <value2> segundo
		And pulso abrir la puerta
		And cierro la puerta
		And pulso start cooking
		And y espero <value3> segundo
		Then deberá de mostrar la presencia de un alimento en el interior
		And el tiempo deber ser <status>
		And la potencia debe ser 1.0
		And la luz deberá encenderse
		
		Examples: 
      | value1    | value2   | value3    | status |
			|		2.0 		|    1.0   |    1.0    |	0.0		|
      |		1.0 		|    0.0   |    1.0    |  0.0		| 
      |		3.0 		|    1.0   |    2.0    |  0.0		|
      |		2.0 		|   -2.0   |    2.0    |  0.0		|
 
 @ScenarioCookingPauseOpenClose_outline
	Scenario:  Como usuario quiero encender el microondas, abrir la puerta, introducir un alimento, cerrar la puerta, incrementar el tiempo y potencia, cocinar el alimento y para la coción en varios instantes
		Given probar el microondas
		When pulso abrir la puerta
		And introduzco un alimento
		And incremento la potencia 1.0
		And incremento el tiempo <value1> segundos
		And cierro la puerta
		And pulso start cooking
		And y espero <value2> segundo
		And pulso abrir la puerta
		And cierro la puerta
		And pulso start cooking
		And y espero <value3> segundo
		Then deberá de mostrar la presencia de un alimento en el interior
		And el tiempo deber ser <status>
		And la potencia debe ser 1.0
		
		Examples: 
      | value1    | value2   | value3    | status |
			|		2.0 		|    1.0   |    1.0    |	0.0		|
      |		1.0 		|    0.0   |    1.0    |  0.0		| 
      |		3.0 		|    1.0   |    0.0    |  2.0		|
      |		2.0 		|   -2.0   |    2.0    |  0.0		|
      
 
      