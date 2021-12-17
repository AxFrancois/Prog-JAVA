package ui.guiSimple;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.world.MondeAnimable;


public class WorldFrame extends JFrame implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * une instance du Monde animable
	 */
	private MondeAnimable monde;
	
	/**
	 * Thread d'éxécution
	 */
	private Thread thread;
	private JLabel labelInfo = new JLabel();
	
		/**
	 * Constructeur
	 * Vous verrez plus tard comment limiter le couplage fort entre une UI et un model: le MVC
	 * @param m
	 */
	public WorldFrame(MondeAnimable m) {
		super("Le fabuleux monde des abeilles");
		/*
		 * initialisation des attributs
		 */
		this.monde = m;
		thread = new Thread(this);
		/*
		 * positionnement de la fenètre
		 */
		dimensionnerFenetre();
		/*
		 * construction des composants de la fenetre
		 */
		fabriqueFenetre();
		/*
		 * opération par défaut en cas de fermeture
		 */
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*
		 * affichage
		 */
		this.setVisible(true);
	}

	private void fabriqueFenetre() {
		Container panneau = new JPanel();
		panneau.setLayout(new BorderLayout());
		
		JPanel panStats = new JPanel();
		panStats.setBackground(Color.red);
		
		JPanel panInfo = new JPanel();
		panInfo.setBackground(Color.blue);
		panInfo.add(labelInfo);
		
		JPanel panCommandes = new JPanel();
		panCommandes.setBackground(Color.green);
		panCommandes.setLayout(new GridLayout(10,1));
				
		//JPanel panMonde = new JPanel();
		JPanel panMonde = new PanneauPrincipal(monde);
		panMonde.setBackground(Color.orange);
		
		JButton boutonStop = new JButton("Stop");
		boutonStop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				stop();
				
			}
			
		});
		JButton boutonStart = new JButton("Start");
		boutonStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				start();
				
			}
			
		});
		
		/*
		 * net pas utiliser setSize mais setPreferredSize
		 */
		//panStats.setSize(new Dimension(200,0));
		panStats.setPreferredSize(new Dimension(200,0));
		panCommandes.setPreferredSize(new Dimension(200,50));
		panInfo.setPreferredSize(new Dimension(0,100));
		
		panCommandes.add(boutonStop);
		panCommandes.add(boutonStart);
		
		panneau.add(panStats,BorderLayout.WEST);
		panneau.add(panInfo,BorderLayout.SOUTH);
		panneau.add(panCommandes,BorderLayout.EAST);
		panneau.add(panMonde,BorderLayout.CENTER);
		
		setContentPane(panneau);
	}

	/**
	 * lance l'animation
	 */
	private void stop() {
		/*
		 * ne pas modifier la ligne suivante
		 */
		monde.stopperAnimation();
		
		labelInfo.setText("Animation en cours");
	}

	private void start() {
		/*
		 * ne pas modifier les 4 lignes suivantes
		 */
		monde.lancerAnimation();
		if(!thread.isAlive()) {
			thread.start();
		}

		labelInfo.setText("Animation en pause");
	}

	private void dimensionnerFenetre() {
		/*
		 * TODO placer la fenetre au centre de l'écran
		 */
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		dim.height = dim.height/3*2;
		dim.width = dim.width/3*2;
		this.setPreferredSize(dim);
		this.pack();
		this.setLocationRelativeTo(null);
	}

	@Override
	public void run() {
		while(true) {
			repaint();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	
	

}
