
public class NoteAnimee extends Thread {
	/**
	 * Cette classe a pour fonction de faire changer de couleur une touche/note du clavier graphique
	 * lorsqu'elle re�oit le nom de la note NOTE.
	 * L'objet cr�� est un thread
	 */
	
	// l'attribut de cet objet est un clavier(cree par Claire). 
	// Methode Clavier : getNote(); qui renvoie un tableau d'entiers

	private Clavier c;
	
	public NoteAnimee(Clavier clavier){
		c=clavier;		
	}
	
	public void run(){
		for(int i=0; i<c.getNote().length;i++){
			
		}
	}

}