package model.decor;

import java.awt.Point;

//partie 2
//import model.agents.PointPositif;

public abstract class Decor{
	/**
	 * coordonnées de l'élément de décor
	 */
	//partie 2
	//private PointPositif coord;
	//partie 1
	private Point coord;


	public Decor(Point p) {
		coord = p;
		//partie 2
		//coord = new PointPositif(p);
	}
	
	/* partie 2
	public PointPositif getCoord() {
		return (PointPositif)coord.clone();
	}
	*/
	//partie 1
	public Point getCoord() {
		return new Point(coord);
	}

}
