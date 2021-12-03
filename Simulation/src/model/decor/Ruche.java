package model.decor;

import java.awt.Point;
import java.util.HashSet;
import java.util.Iterator;

import model.agents.Animal;
import model.agents.Sexe;
import model.agents.animaux.AbeilleDomestique;
import model.comportements.Hebergeur;

public class Ruche extends Decor implements Hebergeur{
	
	/**
	 * Liste des abeilles de la ruche 
	 */
	//private TODO population;
	/**
	 * constante taille maximale de la ruche
	 */
	private static int populationMax = 1000;
	private HashSet<AbeilleDomestique> population;
	
	public Ruche(Point p) {
		super(p);
		population = new HashSet<AbeilleDomestique>();
	}

	@Override
	public boolean peutAccueillir(Animal a) {
		return a instanceof AbeilleDomestique && population.size() < populationMax;
	}

	@Override
	public boolean accueillir(Animal a) {
		boolean ret = false;
		if(peutAccueillir(a)) {
			// Ne pas faire ça ici: c'est à l'animal de mettre à jour ses attributs
			//a.setHebergeur(this);
			population.add((AbeilleDomestique)a);
			ret=true;
		}
		return ret;
	}
	
	public String toString() {
		/*
		 * "\t" code une tabulation dans une chaine de caractères
		 * "\n" un saut de ligne 
		 */
		String ret = getClass().getSimpleName() + " (" + getCoord().x + ";" + getCoord().y + ") : population " + population.size() + " abeilles \n";
		Iterator<AbeilleDomestique> it = population.iterator();
		while(it.hasNext()) {
			  ret += "\t*" + it.next().toString() + "\n";
		}
		return ret;
	}
	
	public static void main(String[] a) {
		
		Ruche r = new Ruche(new Point(0,0));
		new AbeilleDomestique(Sexe.Assexue, new Point(10,20),r);
		System.out.println(r);
		new AbeilleDomestique(Sexe.Assexue, new Point(10,20),r);
		System.out.println(r);
		new AbeilleDomestique(Sexe.Femelle, new Point(5,10),r);
		System.out.println(r);
		
	}
}
