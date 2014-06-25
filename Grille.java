import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Grille extends JFrame implements MouseListener, ActionListener, WindowListener {
	
	/**
	 * A REVOIR: 
	 * Redimensionnement de la grille
	 * Meilleur design des pions (le cercle)
	 */
	private static final long serialVersionUID = 1L; //

	/** Creation composant de linterface du jeu */
	JPanel ensGrille = new JPanel(); // l'ensemble du jeu
	JPanel aireJeu = new JPanel();   // aire de jeu contenant les cases de pion
	GridLayout misePageAirJeu;	// la mise en page de l'aire de jeu
	JToolBar toolBar = new JToolBar();
	
	/** Creation des boutton */
	JButton Jdemarrer = new JButton("Demarrer");
	JButton Jouvrir = new JButton("Ouvrir");
	JButton Jarreter = new JButton("Arreter");
	JButton Jannuler = new JButton("Annuler");
	JButton Jconfigurer = new JButton("Configurer");
	JLabel statuJoueuractuel;
    
	public Grille(int nbrLign, int nbrColon, Jeu jeu) {
		super("Jeu Puissance 5");
		setSize(500, 450);
		setLocation(200, 150);
		ensGrille.setLayout(new BorderLayout());
		misePageAirJeu = new GridLayout(nbrLign, nbrColon, 5, 5);
		aireJeu.setLayout(misePageAirJeu);
		
		/** Definition placement barre des bouttons */
		creerPartieBoutton();
		ensGrille.add(toolBar, "North");
		
		/** Definition d'une case de pion */
		creerCasedePion(nbrLign, nbrColon, jeu);
		aireJeu.setBackground(Color.BLUE);
		ensGrille.add(aireJeu, "Center");
		
		/** Definition de rappel qui joue*/
		statuJoueuractuel = new JLabel("Joueur actuel: Joueur 1", JLabel.LEFT);
		ensGrille.add(statuJoueuractuel, "South");
		
		setContentPane(ensGrille);
		setVisible(false);
		
		addWindowListener(this);
		
	}
	
	/** Methode qui permet de creer un toolbar et y mettre les bouttons de menu*/	
	public void creerPartieBoutton() {
		
		toolBar.add(Jdemarrer);
		toolBar.add(Jouvrir);
		toolBar.add(Jarreter);
		toolBar.add(Jannuler);
		toolBar.add(Jconfigurer);
		
		Jdemarrer.addActionListener(this);
		Jouvrir.addActionListener(this);
		Jarreter.addActionListener(this);
		Jannuler.addActionListener(this);
		Jconfigurer.addActionListener(this);
		
	}
	
	/** On creait dans la grille les cases de pion
	 * @param nbLign le nombre de ligne donne en argument: le prof avait donne une limite je crois
	 * @param nbColon le nombre de ligne donne en argument: le prof avait aussi donne une limite je crois
	 * @param le jeu sur lequel on joue
	 * @return la grille de jeu avec le nbr de ligne et colonne */	
	public void creerCasedePion(int nbLign, int nbColon, Jeu jeu) {
		Pion pion;
		for (int i = 0; i < nbLign; i++) {
			for (int j = 0; j < nbColon; j++) {
				pion = new Pion(i+1, j+1, 0, jeu);
				pion.addMouseListener(this);
				aireJeu.add(pion);
			}
		}	
	}
	
	
	/** METHODES A IMPLEMENTER */
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
