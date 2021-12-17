package model.world;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.Timer;

import model.agents.Agent;
import model.agents.Etat;
import model.agents.PointPositif;
import model.agents.Sexe;
import model.agents.Animal;
import model.agents.animaux.Abeille;
import model.agents.animaux.AbeilleDomestique;
import model.agents.animaux.AbeilleSolitaire;
import model.agents.animaux.FrelonAsiatique;
import model.agents.animaux.FrelonEuropeen;
import model.agents.animaux.Varroa;
import model.agents.vegetaux.Arbre;
import model.agents.vegetaux.Fleur;
import model.decor.Decor;
import model.decor.Ruche;

public class Monde implements MondeAnimable{
	/**
	 * population d'agents dans le monde
	 */
	private Set<Agent>agents;
	
	private double rayon = 10.0;
	
	/**
	 * Decor
	 */
	private Set<Decor>decors;
	/**
	 * map de probabilité pour trouver un agent
	 */
	/*
	 * par commodité: la map n'est plus statique pour permettre le paramétrage
	 * par l'interface graphique des probabilités d'apparition d'agents.
	 */
	private Map<Integer,Agent> proba;
	/**
	 * constante: largeur du monde
	 */
	private static int LARGEUR = 200;

	/**
	 * constante: longueur du monde
	 */
	private static int LONGUEUR = 300;
	/**
	 * Timer pour déclencher un évènement toutes les x ms
	 */
	private Timer timer;
	

	private TreeSet<Agent> generateAgents(int nbAgents) {
			/*
			 * NE PAS TOUCHER!
			 */
		TreeSet<Agent> ts = new TreeSet<Agent>();
		for(int i=0;i<nbAgents;i++) {
			int alea = (int)(Math.random()*100);
			System.out.println(alea);
			//partie 2
			ts.add((Agent)tirage(alea).clone());
			//partie 1
			//ts.add(copieAgent(tirage(alea)));
			System.out.println(ts);
		}
		return ts;
	}
	
	/*
	
	 * à supprimer dès la partie deux lorsqu'il devient possible de
	 * cloner les agents
	 * place toutes les abeilles dans la même ruche
	 * les arbres ont tous la même taille
	 * ne respecte pas les bonnes pratiques (switch case sur le type) 
	 * @param tirage
	 * @return
	private Agent copieAgent(Agent tirage) {
		// TODO Auto-generated method stub
		Ruche ruche =new Ruche(new Point(10,50));
		Agent ret = null;
		String classeAgentName = tirage.getClass().getSimpleName();
		switch(classeAgentName) {
			case "AbeilleDomestique":
				AbeilleDomestique ad = (AbeilleDomestique) tirage;
				ret = new AbeilleDomestique(ad.getSexe(),ad.getCoord(),ruche);
				break;
			case "AbeilleSolitaire":
				AbeilleSolitaire as = (AbeilleSolitaire) tirage;
				ret = new AbeilleSolitaire(as.getSexe(),as.getCoord());
				break;
			case "FrelonEuropeen":
				FrelonEuropeen fe = (FrelonEuropeen) tirage;
				ret = new FrelonEuropeen(fe.getSexe(),fe.getCoord());
				break;
			case "FrelonAsiatique":
				FrelonAsiatique fa = (FrelonAsiatique) tirage;
				ret = new FrelonAsiatique(fa.getSexe(),fa.getCoord());
				break;
			case "Varroa":
				Varroa v = (Varroa) tirage;
				ret = new Varroa(v.getSexe(),v.getCoord());
				break;
			case "Arbre":
				Arbre a = (Arbre) tirage;
				ret = new Arbre(a.getCoord(),1.0);
				break;
			default:
				Fleur f = (Fleur) tirage;
				ret = new Fleur(f.getCoord());
				break;
		}
		return ret;
	}
	*/

	/**
	 * génère un cycle de vie dans le monde
	 */
	public void cycle() {
		/*
		 * TODO appeler la méthode cycle sur tous les agents		
		 */
		HashMap<Agent,HashSet<Agent>> MapRencontre = gererRencontre();
		
	    for (Agent a : MapRencontre.keySet()) {
	    	for (Agent voisin : MapRencontre.get(a)) {
	    		a.rencontrer(voisin);
	    	}
	    }    
		for(Agent a:agents) {
			a.cycle();
			if (a instanceof Animal) {
				if (((Animal)a).getEtat() == Etat.Mourant) {
					supprimer(a);
				}
			}
		}
	}
	
	private void supprimer(Agent a) {
		// TODO Auto-generated method stub
		agents.remove(a);
		if (a instanceof AbeilleDomestique) {
			// faire liste ruche et vérifier si l'abeille est dedans, la pop
		}
		if (a instanceof Abeille) {
			if (((Abeille)a).isParasite()) {
				for(Agent ag:agents) {
					if (ag instanceof Varroa) {
						/*if (((Varroa)a).) {}
						 * 
						 * Si le varroa est hébergé par CETTE abeille, il n'a plus d'hébergeur
						 * */
						break;
					}
				}
			}
		}
		if (a instanceof Varroa) {
			// si le varroa est mort l'abeille n'est plus parasité
		}
	}

	public HashMap<Agent,HashSet<Agent>> gererRencontre(){
		HashMap<Agent,HashSet<Agent>> ret = new HashMap<Agent,HashSet<Agent>>();
		for(Agent a:agents) {
			HashSet<Agent> listevoisin = new HashSet<Agent>();
			for(Agent potentielvoisin:agents) {
				if (potentielvoisin != a) {
				double distance = Math.sqrt(Math.pow(a.getX() - potentielvoisin.getX(), 2) + Math.pow(a.getY() - potentielvoisin.getY(), 2));
					if (distance < rayon) {
						listevoisin.add(potentielvoisin);
					}
				}
			}
			ret.put(a, listevoisin);
		}
		return ret;
	}
	
	
	/**
	 * 
	 * @param nbAgents
	 */
	
	public Monde(int nbAgents) {
		this(nbAgents,10);
	}
	
	public Monde(int nbAgents, int delai) {
		proba = probaAgent();
		agents=generateAgents(nbAgents);
		timer=new Timer(delai, this);
	}
	
	/**
	 * @return the lARGEUR
	 */
	public static int getLARGEUR() {
		return LARGEUR;
	}

	/**
	 * @return the lONGUEUR
	 */
	public static int getLONGUEUR() {
		return LONGUEUR;
	}

	/**
	 * Méthode utilitaire statistique pour produire la table de proba
	 * d'apparition d'un agent
	 * @return
	 */
	private Map<Integer, Agent> probaAgent() {
		/*
		 * par commodité: la map n'est plus statique pour permettre le paramétrage
		 * par l'interface graphique des probabilités d'apparition d'agents.
		 */
		decors = new HashSet<Decor>();
		Ruche r1 =new Ruche(new Point(10,50));
		Ruche r2 =new Ruche(new Point(100,20));
		decors.add(r1);
		decors.add(r2);		
		Map<Integer,Agent> myMap = new LinkedHashMap<Integer,Agent>();
	    myMap.put(20,new AbeilleDomestique(Sexe.Assexue,new Point(0,0),r1));
	    myMap.put(40,new AbeilleDomestique(Sexe.Assexue,new Point(0,0),r2));
	    myMap.put(50,new AbeilleSolitaire(Sexe.Assexue,new Point(0,0)));
	    myMap.put(55,new FrelonEuropeen(Sexe.Assexue,new Point(0,0)));
	    myMap.put(60,new FrelonAsiatique(Sexe.Assexue,new Point(0,0)));
	    myMap.put(70,new Varroa(Sexe.Assexue,new Point(0,0)));
	    myMap.put(80,new Arbre(new Point(0,0),1.0));
	    myMap.put(85,new Arbre(new Point(0,0),2.0));
	    myMap.put(100,new Fleur(new Point(0,0)));
	    return myMap;
	}
	
	/**
	 * fabrication aléatoire d'un Agent par tirage dans la Map
	 * et positionnement aléatoire
	 * @param alea
	 * @return
	 */
	private Agent tirage(int alea) {
		Agent agent=null;
		if(alea<100 && alea>=0) {
			boolean trouve = false;
			Iterator<Integer> it = proba.keySet().iterator();
			while(!trouve && it.hasNext()) {
				Integer clef = it.next();
				if(clef>=alea) {
					agent = proba.get(clef);
					trouve=true;
				}
			}
		}
		else {
			agent = new Fleur(new Point(0,0));
		}
		//positionnement aléatoire entre Longueur et Largeur
		int aleaX = (int)(Math.random()*LONGUEUR);
		int aleaY = (int)(Math.random()*LARGEUR);
		agent.setCoord(aleaX, aleaY);
		return agent;
	}

//	private TreeSet<Agent> generateAgents(int nbAgents) {
//		TreeSet<Agent> ts = new TreeSet<Agent>();
//		for(int i=0;i<nbAgents;i++) {
//			int alea = (int)(Math.random()*100);
//			Agent agent = (Agent)tirage(alea).clone();
//			ts.add(agent);
//		}
//		return ts;
//	}
	
	private Set<Agent> getAgentByCoord(){
		Set<Agent> coordSet = new TreeSet<Agent>(new CoordComparator());
		coordSet.addAll(agents);
		
		return coordSet;
	}
	
	public String toString() {
		String ret="";
		ret+="******************************\n";
		ret+="Le monde contient "+agents.size()+" agents:\n";
		Set<Agent> coordSet = getAgentByCoord();

		for(Agent a:coordSet) {
			ret+="\t"+a+"\n";
		}
		return ret;
	}
	
	public static String remplir(Integer indice, PointPositif coord) {
		int cible = coord.getX()*LARGEUR + coord.getY()-indice;
		indice=cible+1;
		return String.format("%" + cible+"s","");		
	}

	/**
	 * génère un cycle de vie dans le monde
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		cycle();		
		System.out.println("cycle");
	}

	@Override
	public void lancerAnimation() {
		timer.start();
	}

	@Override
	public void stopperAnimation() {
		timer.stop();	
	}

	@Override
	public List<Dessinable> getElementsMonde() {
		List<Dessinable> ret = new ArrayList<Dessinable>();
		ret.addAll(decors);
		ret.addAll(agents);
		return ret;
	}
	


}
