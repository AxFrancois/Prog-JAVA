package tp.model.agents;

import java.awt.Point;

public class Abeille_solitaire extends Abeille {
	public Abeille_solitaire(Sexe sexe, Point coord) {
		super(sexe, coord);
	}
	
	public Abeille_solitaire(Sexe sexe) {
		this(sexe, new Point());
	}
	
	public Abeille_solitaire(Point coord) {
		this(Sexe.Femelle,coord);
	}
	
	public Abeille_solitaire() {
		this(Sexe.Femelle, new Point());
	}

	@Override
	protected void majData() {
		// TODO Auto-generated method stub
		
	}
}
