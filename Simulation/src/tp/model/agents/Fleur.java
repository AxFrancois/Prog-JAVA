package tp.model.agents;

import java.awt.Point;

import tp.model.comportements.Hebergeur;

public class Fleur extends Vegetal implements Hebergeur{

	// CONSTRUCTEURS
	public Fleur(Point coord) {
		super(coord);
		quantitePollen = 0;
	}
	
	public Fleur() {
		this(new Point());
	}
	
	@Override
	public boolean peutAccueillir(Agent a) {
		boolean valren = false;
		if (a instanceof Abeille | a instanceof Frelon) {
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
		//Auto-generated method stub
		quantitePollen = 1;
	}
}
