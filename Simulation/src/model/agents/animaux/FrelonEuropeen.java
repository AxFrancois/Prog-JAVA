package model.agents.animaux;

import java.awt.Point;
import java.util.ArrayList;

import model.agents.Animal;
import model.agents.Sexe;

public class FrelonEuropeen extends Frelon {
	
	public FrelonEuropeen(Sexe s, Point p) {
		super(s,p);
		proies.add(FrelonAsiatique.class);
	}

	/* inutile avec la liste de proies à partir des collections
	@Override
	public void rencontrer(Agent a) {
		//penser à réutiliser l'existant
		super.rencontrer(a);
		
		if(a instanceof FrelonAsiatique) {
			Animal b = (Animal)a;
			gestionProie(b);
		}

	}
	*/

}
