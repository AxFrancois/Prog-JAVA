package model.decor;

import java.awt.Point;

import model.agents.PointPositif;
import model.world.Dessinable;

//partie 2
//import model.agents.PointPositif;

public abstract class Decor implements Dessinable{
	/**
	 * coordonnées de l'élément de décor
	 */
	//partie 2
	private PointPositif coord;
	//partie 1
	//private Point coord;
	private int Width = 50;
	private int Height = 50;


	public Decor(Point p) {
		//coord = p;
		//partie 2
		coord = new PointPositif(p);
	}
	
	// partie 2
	public PointPositif getCoord() {
		return (PointPositif)coord.clone();
	}
	
	/*partie 1
	public Point getCoord() {
		return new Point(coord);
	}
	*/
	public int getWidth() {
		return Width;
	}
	public int getHeight() {
		return Height;
	}
	
	public String getImage() {
		return"images/"+getClass().getSimpleName()+".gif";
	}
}
