package model.agents.animaux;

import java.awt.Point;

import model.agents.PointPositif;
import model.agents.Sexe;

public class FrelonAsiatique extends Frelon{

	public FrelonAsiatique(Sexe s, Point p) {
		super(s,p);
	}

	public FrelonAsiatique(Sexe s, PointPositif p) {
		this(s,p.getPoint());
	}

	@Override
	public FrelonAsiatique clone() {
		return new FrelonAsiatique(Sexe.Assexue,new Point());
    }

	

}
