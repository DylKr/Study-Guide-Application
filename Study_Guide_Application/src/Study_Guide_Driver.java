import java.io.IOException;

public class Study_Guide_Driver {

	public static void main(String[] args) {

		input_manually input = new input_manually();
		try {
			input.input_Manual_Data();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
