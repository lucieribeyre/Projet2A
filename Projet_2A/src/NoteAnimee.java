
public class NoteAnimee extends Thread{
	/**
	 * Cette classe a pour fonction de faire changer de couleur une touche/note du clavier graphique.
	 * La note devient bleue si on n'enregistre pas et rose dans le cas contraire.
	 * L'objet cree est un thread.
	 */

	// l'attribut de cet objet est un clavier(cree par Claire). 
	// Methode Clavier : getNote(); qui renvoie un entier

	private Clavier c;
	private Key k;
	private int note;

	public NoteAnimee(){
				
	}
}

