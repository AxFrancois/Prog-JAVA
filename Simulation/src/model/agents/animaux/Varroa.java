package model.agents.animaux;

//import model.agents.animaux.Abeille;

import java.awt.Point;

import model.agents.Sexe;
import model.agents.Agent;
import model.agents.Animal;
import model.agents.PointPositif;

/**
 * 
 * @author bruno
 *
 */
public class Varroa extends Animal {
	
	public Varroa(Sexe s, Point p) {
		super(s,p);
	}
		
	public Varroa(Sexe s, PointPositif p) {
		this(s,p.getPoint());
	}

	@Override
	public void rencontrer(Agent a) {
		//code à trouver en section 6
		if(a instanceof Abeille) {
			Abeille candidateAuParasitage = (Abeille) a;
			this.sInstaller(candidateAuParasitage);
		}
	}

	@Override
	protected void maj() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void seNourrir() {
		// TODO Auto-generated method stub
		if(hebergeur != null) {
			Abeille abeillehote = (Abeille)hebergeur;
			coord = abeillehote.getCoord(); 
		}
		else {
			super.seDeplacer();
		}
		
	}
	/**
	 * si le Varroa a un hébergeur, il se déplace avec l'abeille
	 */
	public void seDeplacer() {
		//TODO
	}

	@Override
	public Varroa clone() {
		return new Varroa(getSexe() ,new Point(getCoord().getX(),getCoord().getY()));
    }
}
