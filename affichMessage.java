import javax.swing.JOptionPane;


public class affichMessage {
	
	public static void infoMsgOk(String message, String titre) {
		JOptionPane.showMessageDialog(null, message, titre, JOptionPane.INFORMATION_MESSAGE);
	}
	
	/** Affiche un message d'erreur avec un showMessageDialog
	 * @param message Message � afficher
	 * @param titre Titre de la fen�tre de message
	 */	
	public static void erreurMsgOk(String message, String titre) {
		JOptionPane.showMessageDialog(null, message, titre, JOptionPane.ERROR_MESSAGE);
	}
}
