
public class Control {
	Grille plateauJeu;
	int[][] matriceJeu;
	int nbrCoups;		// Contient le nombre de coups jou�s (d�tection partie nulle)
	boolean enCours;	// Indique si la partie est en cours ou termin�e
	boolean joueur;		// Indique le joueur en cours
	//Options option;
	
	public boolean coupValable(int ligne, int col, Jeu leJeu) {
		if (ligne == -1) {
			affichMessage.erreurMsgOk("Vous ne pouvez pas jouer ce coup : la colonne est remplie", "Coup invalide");
			return false;
		}
		return true;
	}
}
