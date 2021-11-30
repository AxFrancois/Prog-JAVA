package tp.model.agents;

import java.awt.Point;

import tp.model.comportements.Hebergeur;

public class Arbre extends Vegetal implements Hebergeur{
	public int tailleArbre;

	// CONSTRUCTEURS
	public Arbre(Point coord, int tailleArbre) {
		super(coord);
		this.tailleArbre = tailleArbre;
		quantitePollen = 0;
	}
	
	public Arbre(Point coord) {
		this(coord, 5);
	}
	
	public Arbre(int tailleArbre) {
		this(new Point(), tailleArbre);
	}
	
	public Arbre() {
		this(new Point(), 5);
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
		quantitePollen = 2^tailleArbre;
	}

}
