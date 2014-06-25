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
	
	/** Site du zero */
	public void paintComponent(Graphics comp) {
		Graphics2D nouvComp = (Graphics2D)comp;
		
		nouvComp.setColor(fondPanneau);			// on va mettre comme fond du jeu le fond de fondPanneau
		nouvComp.fillOval(0, 0, getWidth(), getHeight());	// et on positionne les pions (type cercle)
	}
	
}
