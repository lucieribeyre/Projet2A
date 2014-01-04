package Animation;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Vector;
import javax.swing.JPanel;


public class ClavierAnime extends JPanel{

	Vector<Touche> touchesNoires = new Vector<Touche>();
	Touche prevKey;
	final int kw = 16, kh = 80; // largeur et hauteur en pixels du rectangle blanc de base sur lequel s'ajoutera le rectangle noir
	Vector<Touche> touchesBlanches = new Vector<Touche>();
	Vector<Touche> touches = new Vector<Touche>();
	boolean record;
	final Color bleu = new Color(204, 204, 255); //bleu si on joue sans enregistrer
	final Color rose = new Color(255, 175, 175); // rose si on enregistre



	// Constructeur : creation du clavier graphique avec les touches noires et blanches : blackKeys et whiteKeys

	public ClavierAnime() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(28*kw, kh+1)); // 28 touches blanches
		int transpose = 24;  
		int whiteIDs[] = { 0, 2, 4, 5, 7, 9, 11 }; // nombre de demi-tons entre deux notes blanches

		// 28 touches blanches
		for (int i = 2, x = 0; i < 6; i++) { // 4 octaves
			for (int j = 0; j < 7; j++, x += kw) { // transposition de l'abscisse x de kw pixels pour dessiner la note suivante
				int numTouche = i * 12 + whiteIDs[j] + transpose; // 12 demi-tons donc i*12 pour passer a l'octave suivante
				touchesBlanches.add(new Touche(x, 0, kw, kh, numTouche)); 
			}
		}
		//20 touches noires
		for (int i = 2, x = 0; i < 6; i++, x += kw) { //4 octaves
			int numTouche = i * 12 + transpose;
			touchesNoires.add(new Touche((x += kw)-4, 0, kw/2, kh/2, numTouche+1)); //keyNum + a : ajout du bon nombre de demi-tons a au keyNum de reference de la touche blanche
			touchesNoires.add(new Touche((x += kw)-4, 0, kw/2, kh/2, numTouche+3));
			x += kw; // pour passer du re# au fa#
			touchesNoires.add(new Touche((x += kw)-4, 0, kw/2, kh/2, numTouche+6));
			touchesNoires.add(new Touche((x += kw)-4, 0, kw/2, kh/2, numTouche+8));
			touchesNoires.add(new Touche((x += kw)-4, 0, kw/2, kh/2, numTouche+10));
		}

		touches.addAll(touchesNoires);
		touches.addAll(touchesBlanches);
	}
	// fin constructeur


	

	public Touche getTouche(Point point) {
		for (int i = 0; i < touches.size(); i++) {
			if (((Touche) touches.get(i)).contains(point)) {
				return (Touche) touches.get(i);
			}
		}
		return null;
	}



	// On peint les touches noires et blanches en bleu si on n'enregistre pas et en rose sinon
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Dimension d = getSize();

		g2.setBackground(getBackground());
		g2.clearRect(0, 0, d.width, d.height);

		g2.setColor(Color.white);
		g2.fillRect(0, 0, 28*kw, kh);

		for (int i = 0; i < touchesBlanches.size(); i++) {
			Touche touche = (Touche) touchesBlanches.get(i);
			if (touche.isNoteOn()) {
				g2.setColor(record ? rose : bleu);
				g2.fill(touche);
			}
			g2.setColor(Color.black);
			g2.draw(touche);
		}
		for (int i = 0; i < touchesNoires.size(); i++) {
			Touche touche = (Touche) touchesNoires.get(i);
			if (touche.isNoteOn()) {
				g2.setColor(record ? rose : bleu);
				g2.fill(touche);
				g2.setColor(Color.black);
				g2.draw(touche);
			} else {
				g2.setColor(Color.black);
				g2.fill(touche);
			}
		}
	}
}