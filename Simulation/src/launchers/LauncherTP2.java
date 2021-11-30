package launchers;

import java.awt.Point;

import tp.model.agents.*;


public class LauncherTP2 {
	
	public static void main(String [] args) {
		//Agent a = new Animal(Sexe.Femelle,new Point(25,30));
		
		//TODO
		//tester la hiérarchie d'agent

		
		//tests unitaires de la classe Animal
		//décommentez les lignes pour approfondir le test unitaire
		//complétez la méthode pour tester les nouvelles fonctionnalités que vous allez implémenter
		/*
		Animal a = new Animal();
		Animal b = new Animal(Sexe.Male);
		Animal c = new Animal(Sexe.Assexue);
		Animal d = new Animal(Sexe.Femelle,new Point(25,30));
		Animal e = new Animal(Sexe.Femelle,new Point(25,30));
		*/
		Abeille_domestique a = new Abeille_domestique();
		Abeille_domestique b = new Abeille_domestique(Sexe.Male);
		Abeille_domestique c = new Abeille_domestique(Sexe.Assexue);
		Abeille_domestique d = new Abeille_domestique(Sexe.Femelle,new Point(25,30));
		Abeille_domestique e = new Abeille_domestique(Sexe.Femelle,new Point(25,30));
		/*
		 * les lignes suivantes doivent afficher à terme: NomDeLaClasse n° id_animal(sexe, (position x; position y)).
		 * ex: 28 (FEMELLE, (25;30))
		 */
		System.out.println("*** Animaux créés: **********");
		System.out.println(a);
		System.out.println(a.toString());
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		
		System.out.println("*** Getters et setters **********");
		
		System.out.println(d.getSexe());
		//Sexe ss = d.getSexe();
		//ss=Sexe.Male;
		System.out.println(d.getSexe());
		
		//les lignes suivantes devraient afficher la même chose....
		
		System.out.println(d.getCoord());
		Point pt = d.getCoord();
		pt.x=50;
		System.out.println(d.getCoord());
		
		
		//ajoutez vos propres tests de getters et setters
		System.out.println("Test Age :");
		System.out.println(d.getAge());
		//int TestAge = d.getAge();
		//TestAge= 15;
		System.out.println(d.getAge());
		
		System.out.println("Test ID :");
		System.out.println(d.getId());
		//int TestID = d.getId();
		//TestID=1;
		System.out.println(d.getId());
		
		System.out.println("Test Etat :");
		System.out.println(d.getEtat());
		//Etat TestEtat = d.getEtat();
		//TestEtat=Etat.EnDetresse;
		System.out.println(d.getEtat());
		
		//test vieillir
		
		System.out.println("Test vieillir :");
		System.out.println(a.getAge());
		a.vieillir();
		System.out.println(a.getAge());
		
		//test seDeplacer
		System.out.println("Test seDeplacer :");
		System.out.println(a.getCoord());
		((Animal) a).seDeplacer();
		System.out.println(a.getCoord());
		((Animal) a).seDeplacer();
		System.out.println(a.getCoord());
		
		//test id
		
		System.out.println(a.getId());
		System.out.println(b.getId());
		
		
		/*
		 * Test comparaison
		 */
		
		System.out.println(d==e);
		System.out.println(d.equals(e));
		System.out.println("Bonjour"=="Bonjour");
		System.out.println("Bonjour".equals("Bonjour"));
		
		
		
		// Seconde serie de test
		
		Fleur f = new Fleur();
		Arbre g = new Arbre(new Point(30,30));
		Frelon_asiatique h = new Frelon_asiatique(Sexe.Male);
		Frelon_europeen i = new Frelon_europeen(new Point(10,30));
		Abeille_domestique j = new Abeille_domestique();
		Abeille_solitaire k = new Abeille_solitaire(Sexe.Femelle,new Point(25,30));
		Varroa l = new Varroa();
		
		System.out.println("*** Animaux créés: **********");
		System.out.println(f);
		System.out.println(g);
		System.out.println(h);
		System.out.println(i);
		System.out.println(j);
		System.out.println(k);
		System.out.println(l);
		
		System.out.println("*** Tests Acceuils **********");
		System.out.println(j.peutAccueillir(l)); //true
		System.out.println(j.peutAccueillir(h)); //false
		System.out.println(h.peutAccueillir(k)); //false
		System.out.println(f.peutAccueillir(j)); //true
		System.out.println(g.peutAccueillir(k)); //true
		System.out.println(g.peutAccueillir(i)); //true
		System.out.println(f.peutAccueillir(l)); //false
		
		System.out.println("*** Tests Cycle **********");
		f.Cycle();
		g.Cycle();
		h.Cycle();
		i.Cycle();
	}

}
