public class Jeu {
	Grille plateauJeu;		// l'interface graphique
	Options option;		// Une fen�tre d'options
	
	private Jeu(boolean onJoue) {
		if (onJoue)
			option = new Options(this);
			option.changeTaille(1, 1, true);	// Permet d'afficher directement la grille sans pion
	}
	
	public static void main(String[] args) {
		
		Jeu partie = new Jeu(true);
		
	}
}
