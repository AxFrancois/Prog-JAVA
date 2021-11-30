package tp.model.agents;

import java.awt.Point;
import tp.model.comportements.*;

public abstract class Abeille extends Animal implements Hebergeur{
	public int quantiteMiel;
	public boolean parasitee = false;
	
	// CONSTRUCTEURS
	public Abeille(Sexe sexe, Point coord) {
		super(sexe, coord);
		quantiteMiel = 0;
	}
	
	@Override
	public boolean peutAccueillir(Agent a) {
		boolean valren = false;
		if (a instanceof Varroa & parasitee == false) {
			valren = true;
		}
		return valren;
	}
	
	@Override
	public void rencontrer(Animal a) {
		//Auto-generated method stub
		if (a instanceof Frelon) {	//si elle recontre un frelon
			etat = Etat.EnDetresse;
			if (a.etat != Etat.Normal) {	//si le frelon la mange
				etat = Etat.Mourant;
				canHeal = false;
			}
		}
		else if (a instanceof Varroa & parasitee == false & etat != Etat.Mourant) {	//si elle rencontre un Varroa et n'est pas parasitée
			parasitee = true;
			etat = Etat.EnDifficulte;
		}
		
	}

}
