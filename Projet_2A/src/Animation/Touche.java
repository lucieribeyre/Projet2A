package Animation;

import javax.xml.soap.Text;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * Touches noires et blanches du piano
 */
public class Touche extends Rectangle {
	int noteState;
	int numTouche; // entier correspondant au numero MIDI de la note jouee par la touche
	String lettre; // lettre du clavier de l'ordinateur qui sera affichee sur la note correspondante du clavier du piano virtuel
	Text nom_touche;

	public Touche(String l, int x, int y, int width, int height, int num) {
		super(x, y, width, height);
		this.numTouche = num;
		lettre = l;

		nom_touche = new Text(lettre);
		nom_touche.setFont(new Font(25));
		nom_touche.setfill(Color.red);
		nom_touche.setX(25);
        nom_touche.setY(45);

	}
}