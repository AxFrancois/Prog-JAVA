package model.agents.vegetaux;

import java.awt.Point;

import model.agents.Animal;
import model.agents.PointPositif;
import model.agents.Sexe;
import model.agents.animaux.AbeilleSolitaire;
import model.agents.animaux.Frelon;
import model.agents.animaux.Varroa;
import model.comportements.Hebergeur;

public class Arbre extends Vegetal implements Hebergeur{

	public Arbre(Point point, double taille) {
		super(point);
		this.taille=taille;
	}

	public Arbre(PointPositif point, double taille) {
		this(point.getPoint(), taille);
	}

	private double taille = 1.0;
	private int nbHeberges = 0;
	
	@Override
	public boolean peutAccueillir(Animal a) {
		return (a instanceof AbeilleSolitaire || a instanceof Frelon)&&nbHeberges<getMaxHeberges();
	}

	private int getMaxHeberges() {
		return (int)(Math.pow(taille,2));
	}

	@Override
	public boolean accueillir(Animal a) {
		boolean ret = false;
		if(peutAccueillir(a)) {
			nbHeberges++;
			ret=true;
		}
		return ret;
	}

	@Override
	public void produire() {
		qteNectar += Math.pow(2, taille);		
	}

	@Override
	public Arbre clone() {
		return new Arbre(new Point(getCoord().getX(),getCoord().getY()), taille);
    }

	public int getWidth() {
		return 75;
	}
	public int getHeight() {
		return 75;
	}
}
