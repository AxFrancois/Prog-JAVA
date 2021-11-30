package tp.model.agents;

import java.awt.Point;

public abstract class Frelon extends Animal {
	public Frelon(Sexe sexe, Point coord) {
		super(sexe, coord);
	}
	
	public void rencontrer(Animal a) {
		if (a instanceof Abeille & etat != Etat.Normal & canHeal == true) {	//si elle recontre un frelon
			etat = Etat.Normal;
		}
	}
}
