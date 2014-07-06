public class Jeu {
	Grille plateauJeu;		// l'interface graphique
	int[][] matriceJeu;
	Options option;		// Une fen�tre d'options
	int nbrCoups;		// Nombre de coups de jeu pour controler une partie nulle
	boolean enCours;	// Indique si la partie est en cours ou termin�e
	boolean joueur;		// Indique le joueur en cours
	boolean debutPionBas;
	
	public static void gameOrOption(int game) {
		Jeu leJeu = new Jeu(game);
	}

	private Jeu(int onJoue) {
		option = new Options(this, false);
		nbrCoups = 0;
		if (onJoue<0) {
			option.changeTaille(1, 1, true, false);	// Permet d'afficher directement la grille sans pion
		}else if(onJoue>0){
			enCours=true;
			option.changeTaille(6, 7, true, false);
		}else {
			InterfaceOption linterface = new InterfaceOption(option, true);
		}
	}
	
	public void jouer(int col) {
		boolean coupValable;	// Contient la validite du coup que le jouer veut jouer
		int ligne = 0;		// La ou sera stockee la ligne jouee
		coupValable = false;
		ligne = this.rechercheLignJouabl(col);
		coupValable = this.coupValable(ligne, col);
		if (coupValable)
			validerCoup(ligne, col);
		
	}
	
	/** Recherche la 1�re ligne jouable d'une colonne
	 * @param colon col for which the method searches the line
	 * @return numero correcpondant a la ligne du colonne et -1 si la colonne est pleine
	 */	
	public int rechercheLignJouabl(int colon) {
		for (int i = option.getLignJeu(); i >= 1; i--) {
			if (matriceJeu[i - 1][colon - 1] == 0)
				return i;
		}
		return -1;
	}
	
	public void validerCoup(int ligne, int col) {
		if (!joueur) {
			this.matriceJeu[ligne-1][col-1] = 1;  // 1 d�signe dans la matrice un pion du joueur "false"
			Pion pion = (Pion)plateauJeu.aireJeu.getComponent((option.getColJeu()) * (ligne-1) + (col-1));
			pion.modifierVal(1);
		} else {
			this.matriceJeu[ligne - 1][col - 1] = 2;  // 2 d�signe dans la matrice un pion du joueur "true"
			Pion pion = (Pion)plateauJeu.aireJeu.getComponent((option.getColJeu()) * (ligne - 1) + (col - 1));
			pion.modifierVal(2);
		}
		nbrCoups++;
		
		/** Gerer les parties nulles */
		if (nbrCoups >= option.getLignJeu() * option.getColJeu()) {
			affichMessage.infoMsgOk("Match nul", "Partie nulle");
			enCours = false;
			/** On doit gerer aussi un message doit sM'afficher et demander si
			 * on veut demarrer une nouvelle partie
			 */
		}
		// On change de joueur apres chaque coup
		joueur = !joueur;
		if (joueur) {
			plateauJeu.statuJoueuractuel.setText("Joueur actuel: Joueur 2");
		}
		else {
			plateauJeu.statuJoueuractuel.setText("Joueur actuel: Joueur 1");
		}	
	}
	
	/** Check si le coup joue est jouable*/
	public boolean coupValable(int ligne, int col) {
		if (ligne == -1) {
			affichMessage.erreurMsgOk("Vous ne pouvez pas jouer ce coup : la colonne est remplie", "Coup invalide");
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		Jeu partie = new Jeu(-1);
		
	}
}
