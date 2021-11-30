package tp.model.agents;

import java.awt.Point;

public abstract class Agent {

	private static int currentId = 0;
	/** identifiant unique de l'agent*/
	protected int id;
	/** age en unité de temps*/
	protected int age;
	/** position sur la carte*/
	protected Point coord;
	/** état de santé de l'agent */
	protected Etat etat = Etat.Normal;
	/** Sexe de l'agent */
	protected Sexe sexe;
	
	/**
	 * Renvoie un identifiant unique non encore utilisé
	 * @return un identifiant entier unique d'animal
	 */
	protected static int getUniqueId() {
		return currentId++;
	}

	public Etat getEtat() {
		return etat;
	}

	public int getId() {
		return id;
	}

	public int getAge() {
		return age;
	}

	public Sexe getSexe() {
		return sexe;
	}
	
	public Point getCoord() {
		return new Point(coord);
	}

	public void vieillir() {
		//fait vieillir l'animal d'une unité de temps
		//une bonne manière de faire, une moins bonne...
		age ++;
	}

    public String toString() {
    	return getClass().getSimpleName() + " " + id + " (" + sexe + ", (" + coord.x + ";" + coord.y + "))";
    }
    
	public Agent(Sexe sexe, Point coord) {
		//Auto-generated constructor stub
		id = Agent.getUniqueId();
		this.sexe=sexe;
		this.coord=coord;
		age = 0;
	}

	public final void Cycle() {
		vieillir();
		if (this instanceof Animal) {
			Animal thisAsAnimal = (Animal) this;	//ça s'apelle un cast ça
			thisAsAnimal.seDeplacer();
			thisAsAnimal.seNourrir();
		}
		majData();	
	}
	
	protected abstract void majData();
}