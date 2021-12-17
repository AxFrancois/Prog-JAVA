package model.agents.animaux;

import java.awt.Point;

import model.decor.Ruche;
import model.agents.PointPositif;
//import model.agents.Agent;
import model.agents.Sexe;

public class AbeilleDomestique extends Abeille {

	public AbeilleDomestique(Sexe s, Point p, Ruche r) {
		super(s,p);
		hebergeur = r;
		r.accueillir(this);
	}

	public AbeilleDomestique(Sexe s, PointPositif p, Ruche r) {
		this(s,p.getPoint(),r);
	}
	
	public AbeilleDomestique clone() {
		return new AbeilleDomestique(getSexe() ,new Point(getCoord().getX(),getCoord().getY()), (Ruche) hebergeur);
    }
}
