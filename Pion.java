import javax.swing.*;
import java.awt.*;

public class Pion extends JPanel {
	
	private static final long serialVersionUID = 1L; // Eclipse demande d'ajouter
	public int nbRangees;	// A enlever
	public int nbColonnes;
	public int nbrLign;
	private int valPion;
	Jeu leJeu;
	Color fondPanneau;
	
	/** Je definis le constructeur */
	public Pion(int nbLign, int nbCol, int valeurPion, Jeu jeu) {
		super();
		this.valPion = valeurPion;		// Qui en fonction de la valeur va dire si la couleur doit changer
		this.nbRangees = nbLign;
		this.nbColonnes = nbCol;
		this.leJeu = jeu;
		this.fondPanneau = Color.white;
	}
	
	public void modifierVal(int val) {
		this.valPion = val;
		this.fondPanneau = Color.BLUE; // Pour bien confirmer le fond blanc de la case
		repaint();
	}
	
	/** Modifie la couleur du pion en fonction de l'evenement*/
	public void modifierCouleur(Color laCouleur) {
		this.fondPanneau = laCouleur;
		repaint();
	}
	
	public void setValPion(int val) {
		this.valPion = val;
		this.fondPanneau = Color.BLUE; // Pour bien confirmer le fond blanc de la case
		repaint();
	}
	
	/** Site du zero */
	public void paintComponent(Graphics comp) {
		Graphics2D nouvComp = (Graphics2D)comp;
		
		nouvComp.setColor(fondPanneau);			// on va mettre comme fond du jeu le fond de fondPanneau
		nouvComp.fillOval(0, 0, getWidth(), getHeight());	// et on positionne les pions (type cercle)
	
		nouvComp.setColor(Color.BLUE);
              
		
		if (valPion != 0) {
			if (valPion == 1)
				nouvComp.setColor(Color.red);
			else
				nouvComp.setColor(Color.green);
			nouvComp.fillOval(3, 3, getWidth() - 4, getHeight() - 4);
		}
	}
}
