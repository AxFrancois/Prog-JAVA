package model.comportements;

import model.agents.Animal;

/**
 * un hébergeur peut accueillir un animal
 * @author bruno
 *
 */
public interface Hebergeur {
	/**
	 * Renvoie vrai si a peut être acceuilli
	 * Il s'agit d'un test de faisabilité
	 * (l'animal doit répondre aux conditions)
	 * @param a Animal candidat à l'accueil
	 * @return
	 */
	public boolean peutAccueillir(Animal a);
	/**
	 * Animal a demande à être hébergé par l'herbergeur
	 * Si l'hébergeur accepte, renvoie true
	 * @param a
	 * @return
	 */
	public boolean accueillir(Animal a);
}
