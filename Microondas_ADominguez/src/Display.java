
public class Display {

	private String display;

	public void clearDisplay() {
		display = "";
		System.out.println(display);
	}

	public void setDisplay(String s) {
		display = s;
		System.out.println(display);
	}

	public String getDisplay() {
		return display.toString();
	}

}
