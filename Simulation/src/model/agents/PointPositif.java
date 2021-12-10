package model.agents;

import java.awt.Point;

public class PointPositif implements Cloneable {
	
	private Point p = new Point();
	
	public PointPositif(Point p) {
		this.p.x = (int) Math.abs(p.x);
		this.p.y = (int) Math.abs(p.y);
	}

	public int getX() {
		return p.x;
	}
	
	public int getY() {
		return p.y;
	}
	
	public Point getPoint() {
		return new Point(this.getX(), this.getY());
	}

	public boolean setX(int x) {
		this.p.x = Math.abs(x);
		return true;
	}
	
	public boolean setY(int y) {
		this.p.y = Math.abs(y);
		return true;
	}
	
    public Object clone() {
        Object o = null;
        try {
            // On récupère l'instance à renvoyer par l'appel de la 
            // méthode super.clone()
            o = super.clone();
        } catch(CloneNotSupportedException cnse) {
            // Ne devrait jamais arriver, car nous implémentons 
            // l'interface Cloneable
            cnse.printStackTrace(System.err);
        }
        // on renvoie le clone
        return o;
    }
	
	
	
}
