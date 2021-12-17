package model.agents.animaux;

import java.awt.Point;

import model.agents.PointPositif;
import model.agents.Sexe;
import model.decor.Ruche;

public class AbeilleSolitaire extends Abeille{

	public AbeilleSolitaire(Sexe s, Point p) {
		super(s,p);
	}

	public AbeilleSolitaire(Sexe s, PointPositif p) {
		this(s,p.getPoint());
	}

	@Override
	public AbeilleSolitaire clone() {
		return new AbeilleSolitaire(Sexe.Assexue,new Point());
    }

}
