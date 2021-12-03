package model.agents.vegetaux;

import java.awt.Point;

public class Fleur extends Vegetal {

	public Fleur(Point point) {
		super(point);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void produire() {
		qteNectar+=1;
	}

}
