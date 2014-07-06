public class Options {
	private int nbreLigne;			// Nombre de lignes
	private int nbreColonne;			// Nombre de colonnes
	Jeu jeu;
	
	/** On lance la fenetre de l'option qui fait appel a l'interface
	 * on va le faire pour plus de commodite!!!
	 * On va faire appel a lui dans jeu
	 * */
	public Options(Jeu jeu, boolean affOption) {
		this.jeu = jeu;		// On creait le jeu...
		if(affOption) {
			InterfaceOption linterface = new InterfaceOption(this, affOption);
		}
	}
	
	public int getColJeu() {
		return nbreColonne;
	}
	
	public int getLignJeu() {
		return nbreLigne;
	}
	
	/** R�gle les dimensions du jeu
	 * @param changeTaille D�finit si le plateau de jeu doit �tre initalis� avec la taille entr�e
	 */
	public void changeTaille(int nbrLigne, int nbrColonne, boolean iniPlat, boolean posPionBas) {
		this.nbreLigne = nbrLigne;
		this.nbreColonne = nbrColonne;
		this.nbreColonne = nbrColonne;
		if (iniPlat)
			initPlateau(nbrLigne, nbrColonne, posPionBas);
	}
	
	/** Initialise le plateau de jeu */
	public void initPlateau(int nbrLign, int nbrColon, boolean posPionBas) {
		jeu.plateauJeu = new Grille(nbrLign, nbrColon, jeu);
		jeu.plateauJeu.setVisible(true);
		jeu.matriceJeu = new int[nbrLign][nbrColon];
		jeu.debutPionBas = posPionBas;
	}
}
