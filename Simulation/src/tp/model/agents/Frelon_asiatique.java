package tp.model.agents;

import java.awt.Point;

public class Frelon_asiatique extends Frelon {
	public Frelon_asiatique(Sexe sexe, Point coord) {
		super(sexe, coord);
	}
	
	public Frelon_asiatique(Sexe sexe) {
		this(sexe, new Point());
	}
	
	public Frelon_asiatique(Point coord) {
		this(Sexe.Femelle,coord);
	}
	
	public Frelon_asiatique() {
		this(Sexe.Femelle, new Point());
	}

	@Override
	protected void majData() {
		// TODO Auto-generated method stub
		
	}
	
	public void rencontrer(Animal a) {
		if (a instanceof Abeille & etat != Etat.Normal & canHeal == true) {	//si elle recontre un frelon
			etat = Etat.Normal;
		}
		if (a instanceof Frelon_europeen) {
			etat = Etat.EnDetresse;
		}
	}
}
