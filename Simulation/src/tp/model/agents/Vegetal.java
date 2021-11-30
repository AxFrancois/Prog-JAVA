package tp.model.agents;

import java.awt.Point;

public abstract class Vegetal extends Agent {
	public int quantitePollen;
	
	public Vegetal(Point coord) {
		super(Sexe.Assexue, coord);
	}
	
}
