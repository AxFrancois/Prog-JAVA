package model.agents.animaux;

import java.awt.Point;

import model.decor.Ruche;
import model.agents.Agent;
import model.agents.Sexe;

public class AbeilleDomestique extends Abeille {

	public AbeilleDomestique(Sexe s, Point p, Ruche r) {
		super(s,p);
		hebergeur = r;
		r.accueillir(this);
	}
	
}
