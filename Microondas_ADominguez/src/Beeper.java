import java.util.concurrent.TimeUnit;

public class Beeper {

	public void beep(int d) {

		for (int i = 1; i <= d; i++) {
			System.out.println("Beep");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
