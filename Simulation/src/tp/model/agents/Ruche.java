package tp.model.agents;

import java.awt.Point;

import tp.model.comportements.Hebergeur;

public class Ruche extends Agent implements Hebergeur{

	public Ruche(Point coord) {
		super(Sexe.Assexue, coord);
	}
	
	public Ruche() {
		this(new Point());
	}

	@Override
	public boolean peutAccueillir(Agent a) {
		boolean valren = false;
		if (a instanceof Abeille_domestique) {
			valren = true;
		}
		return valren;
	}

	@Override
	public boolean accueillir(Agent a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void majData() {
		// TODO Auto-generated method stub
		
	}

}
