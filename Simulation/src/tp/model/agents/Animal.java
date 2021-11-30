package tp.model.agents;

import java.awt.Point;

import tp.model.comportements.Hebergeur;

/**
 * Cette classe modélise un Animal dans la simulation
 * @author bruno (et du coup moi Axel)
 *
 */
public abstract class Animal extends Agent implements Hebergeur{
	protected Agent hostedBy;
	private int sasiete = 10; 	//sasiété
	public boolean canHeal = true;
	
	/* 
	 * constructeurs 
	 */
	
	public Animal(Sexe sexe, Point coord) {
		super(sexe, coord);
	}
	
	public Animal(Sexe sexe) {
		/* crée un animal avec le sexe passé en paramètre, à la position (0;0), d'âge 0 et lui attribue un id unique
		 * une bonne manière de faire 
		 * en utilisant ce qui existe déjà, une moins bonne
		 */
		this(sexe, new Point());
	}
	
	public Animal(Point coord) {
		this(Sexe.Femelle,coord);
	}
	
	public Animal() {
		/* crée un animal de sexe femelle, à la position (0;0), d'âge 0 et lui attribue un id unique
		 * une bonne manière de faire 
		 * en utilisant ce qui existe déjà, une moins bonne
		 */
		this(Sexe.Femelle, new Point());
	}
	
	/*
	 *  Accesseurs et mutateurs
	 */	
	public Sexe getSexe() {
		return sexe;
	}

	/*
	 * Redéfinitions de méthodes d'object
	 */
    public String toString() {
    	return getClass().getSimpleName() + " " + id + " (" + coord.x + ";" + coord.y + "), " + sexe;
    }
    
    public boolean equals(Animal Animal) {
    	return (age == Animal.age &&  sexe == Animal.sexe &&  etat == Animal.etat);
    }
	

	/* 
	 * comportements d'instance
	 */
	
	public void seDeplacer() {
		//utiliser Math.random() pour choisir une direction de déplacement
		double dx = Math.round(2*Math.random()) - 1;
		double dy = Math.round(2*Math.random()) - 1;
		coord.x += dx;
		coord.y += dy;
	}
	
	public abstract void rencontrer(Animal a);

	@Override
	public boolean peutAccueillir(Agent a) {
		return false;
	}

	@Override
	public boolean accueillir(Agent a) {
		return false;
	}

	public void seNourrir() {
		sasiete--;
		if (sasiete == 0) {
			etat = Etat.Mourant;
			canHeal = false;
		}
	}
	
}
