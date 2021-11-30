package tp.model.agents;

import java.awt.Point;

public class Frelon_europeen extends Frelon {
	public Frelon_europeen(Sexe sexe, Point coord) {
		super(sexe, coord);
	}
	
	public Frelon_europeen(Sexe sexe) {
		this(sexe, new Point());
	}
	
	public Frelon_europeen(Point coord) {
		this(Sexe.Femelle,coord);
	}
	
	public Frelon_europeen() {
		this(Sexe.Femelle, new Point());
	}

	@Override
	protected void majData() {
		// TODO Auto-generated method stub
		
	}
	
}
