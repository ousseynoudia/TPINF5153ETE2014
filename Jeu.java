public class Jeu {
	Grille plateauJeu;		// l'interface graphique
	Options option;		// Une fen�tre d'options
	
	public static void gameOrOption(int game) {
		Jeu leJeu = new Jeu(game);
	}

	//private Jeu(boolean onJoue) {
	private Jeu(int onJoue) {
		option = new Options(this, false);
		if (onJoue<0) {
			option.changeTaille(1, 1, true);	// Permet d'afficher directement la grille sans pion
		}else if(onJoue>0){
			option.changeTaille(6, 7, true);
		}else {
			InterfaceOption linterface = new InterfaceOption(option, true);
		}
	}
	
	public static void main(String[] args) {
		
		Jeu partie = new Jeu(-1);
		
	}
}
