package tp.model.agents;

import java.awt.Point;

public class Abeille_domestique extends Abeille {
	public Abeille_domestique(Sexe sexe, Point coord) {
		super(sexe, coord);
	}
	
	public Abeille_domestique(Sexe sexe) {
		this(sexe, new Point());
	}
	
	public Abeille_domestique(Point coord) {
		this(Sexe.Femelle,coord);
	}
	
	public Abeille_domestique() {
		this(Sexe.Femelle, new Point());
	}


	@Override
	protected void majData() {
		// TODO Auto-generated method stub
		
	}
}
