package model.agents.animaux;

import java.awt.Point;
import java.util.ArrayList;

import model.agents.Agent;
import model.agents.Animal;
import model.agents.Sexe;

public abstract class Frelon extends Animal {
	/**
	 * list d'objets de type "Class"
	 * Ces types Class sont paramétrés par <? extends Animal>
	 * Cela signifie que la classe représentée par Class doit hériter de la classe Animal
	 */
	protected ArrayList<Class<? extends Animal>> proies;
	
	public Frelon(Sexe s,Point p) {
		super(s,p);
		proies = new ArrayList<Class<? extends Animal>>();
		/*
		 * TODO: ajouter l'objet Class qui représente la classe Abeille à la liste proie
		 */
		proies.add(Abeille.class);
	}
	
	@Override
	public void rencontrer(Agent a) {
		try {
			gestionProie((Animal)a);
		}
		catch (ClassCastException cce) {
			System.err.println(a+" n'est pas un Animal");
		}
		
	}
	
	protected void gestionProie(Animal a) {
		//si le frelon a faim et 
		// TODO: qu'il a bien affaire à une proie, c'est à dire que la classe de a 
		// appartient bien à la liste proies
		// supprimer le instanceof et remplacer par cette vérification
		if(faim && a instanceof Abeille) {
			faim=false;
		}
	}
	
	@Override
	protected void maj() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void seNourrir() {
		// TODO Auto-generated method stub
		
	}
	
}
