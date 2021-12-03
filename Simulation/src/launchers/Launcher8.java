package launchers;

import model.world.Monde;

public class Launcher8 {

	public static void main(String[] args) {
		Monde m = new Monde(50);
		System.out.println(m);
		m.cycle();
		System.out.println(m);
	}

}
