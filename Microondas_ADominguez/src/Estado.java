
public interface Estado {

	void door_opened();
	void door_closed();
	void item_placed();
	void item_removed();
	void power_dec();
	void power_inc();
	void power_reset();
	void time_inc();
	void time_dec();
	void time_reset();
	void cooking_start();
	void cooking_stop();
	void tick();
	
}
