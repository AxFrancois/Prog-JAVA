package tp.model.agents;

import java.awt.Point;

public class Varroa extends Animal {
	public boolean surArbeille = false;
	
	public Varroa(Sexe sexe, Point coord) {
		super(sexe, coord);
	}
	
	public Varroa(Sexe sexe) {
		this(sexe, new Point());
	}
	
	public Varroa(Point coord) {
		this(Sexe.Femelle,coord);
	}
	
	public Varroa() {
		this(Sexe.Femelle, new Point());
	}

	@Override
	protected void majData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rencontrer(Animal a) {
		//Auto-generated method stub
		if (a.peutAccueillir(this)){	//si le varroa peut parasité, il parasite
			surArbeille = true;
			hostedBy = a;
		}
	}
}
