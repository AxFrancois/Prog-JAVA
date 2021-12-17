package model.agents.vegetaux;

import java.awt.Point;

import model.agents.PointPositif;

public class Fleur extends Vegetal {

	public Fleur(Point point) {
		super(point);
		// TODO Auto-generated constructor stub
	}

	public Fleur(PointPositif point) {
		this(point.getPoint());
	}

	@Override
	public void produire() {
		qteNectar+=1;
	}

	@Override
	public Fleur clone() {
		return new Fleur(new Point(getCoord().getX(),getCoord().getY()));
    }

}
