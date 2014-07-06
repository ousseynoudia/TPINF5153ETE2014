import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class InterfaceOption extends JFrame implements ActionListener {
	
	Options option;
	GridBagLayout lagrilleLay = new GridBagLayout();
	GridBagConstraints laPosit = new GridBagConstraints();	// positionnement
	JPanel plateauPane = new JPanel();		// le plateau contenant tout
	JPanel lignesColPane = new JPanel(new GridLayout(2, 2, 10, 10));
	JLabel nbrLignLabel = new JLabel("Nombre de lignes du tableau :");
	JLabel nbrColLabel = new JLabel("Nombre de colonnes du tableau :");
	JLabel couleurJou1 = new JLabel("Couleur du joueur 1 :");
	JTextField nbrLignTexF = new JTextField("6", 2);
	JTextField nbrColonTexF = new JTextField("7", 2);
	
	JCheckBox siOrdiJoue = new JCheckBox("Jouer contre l'ordinateur", false);	
	JCheckBox posPion = new JCheckBox("Position pion en bas", true);	
	JButton ok = new JButton("Jouer");
	
	/** On creait l'instance comme ca on pourra initialiser l'instance de l'option */
	public InterfaceOption(Options loption, boolean affoption) { //---------------------------------------
		super("Options de jeu");
		
		if(affoption) { 	//----------------------------------------
			setSize(500, 300);
			setLocation(200, 150);
			plateauPane.setLayout(lagrilleLay);
			// Nb de lignes, colonnes
			ajustePosit(laPosit, 0, 0, 2, 1, 80, 30);
			lignesColPane.add(nbrLignLabel);
			lignesColPane.add(nbrLignTexF);
			lignesColPane.add(nbrColLabel);
			lignesColPane.add(nbrColonTexF);
			lagrilleLay.setConstraints(lignesColPane, laPosit);
			plateauPane.add(lignesColPane);
		
			/** On creait le checkBox et on le positionne */
			JPanel computerPane = new JPanel(new GridLayout(4, 1));
			computerPane.add(siOrdiJoue);
			computerPane.add(posPion);		//-----------------------
			siOrdiJoue.addActionListener(this);
			posPion.addActionListener(this);	//--------------------------
			ajustePosit(laPosit, 0, 1, 2, 1, 0, 20);
			lagrilleLay.setConstraints(computerPane, laPosit);
			plateauPane.add(computerPane);    
			ajustePosit(laPosit, 0, 1, 2, 1, 0, 30);
			lagrilleLay.setConstraints(computerPane, laPosit);
		
			// Bouton Ok on joue
			ok.addActionListener(this);
			ajustePosit(laPosit, 1, 3, 1, 1, 0, 10);
			lagrilleLay.setConstraints(ok, laPosit);
			plateauPane.add(ok);
			setContentPane(plateauPane);
		
			/** Site du zero */
			setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
			this.option = loption;
		}else{	//-----------------------------------------------------------------------------------
			this.option = loption;
			option.changeTaille(1, 1, true, posPion.isSelected());
		}//--------------------------------------------------------------------
		setVisible(true);
	}
	/** FIN public OptionsGUI(Options loption) */


	/** Methode pour bien mettre les boutons, textfields... 
	 * tire forum
	 * */
	private void ajustePosit (GridBagConstraints gbc, int gx, int gy, int gw, int gh, int wx, int wy) {
		gbc.gridx = gx;			// Coordonnées dans la "grille"
		gbc.gridy = gy;
		gbc.gridwidth = gw;		// Nombre de cellules sur lesquelles s'étend l'objet
		gbc.gridheight = gh; 
		gbc.weightx = wx;		// "Largeur", en proportion
		gbc.weighty = wy;
	}
	
	/** Au clic du bouton on recupere le donnees du formulaire qu'on transmet
	 * pour afficher la grille.
	 * On fait le try catch au cas ou on aurait des blems sur les saisis
	 */
	public void actionPerformed(ActionEvent evt) {
		Object src = evt.getSource();
		
		if (src == ok) {
			try {
				int nbLIGN = Integer.parseInt(nbrLignTexF.getText());
				int nbCOL = Integer.parseInt(nbrColonTexF.getText());
				if (nbLIGN <= 0 || nbCOL <= 0)
					throw new NumberFormatException();
					option.changeTaille(nbLIGN, nbCOL, true, posPion.isSelected());
				
				setVisible(false);
				
			} catch (NumberFormatException e) {
				/** A TRAITER PLUTARD
				 * On affiche 1 fenetre d'erreur si on entre autre chose qu'un entier ou une limite
				 * de chiffre fixee pour les lignes ou colonnes
				 */
			}
			
		}
	}
	
}