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

	Vector<Key> blackKeys = new Vector<Key>();
	Key prevKey;
	final int kw = 16, kh = 80;
	Vector<Key> whiteKeys = new Vector<Key>();
	Vector<Key> keys = new Vector<Key>();
	boolean record;
	final Color blue = new Color(204, 204, 255);
	final Color pink = new Color(255, 175, 175);



	// Constructeur : creation de notre clavier graphique avec les touches noires et blanches : 
	// blackKeys et whiteKeys
	public ClavierAnime() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(42*kw, kh+1));
		int transpose = 24;  
		int whiteIDs[] = { 0, 2, 4, 5, 7, 9, 11 }; 

		// touches blanches
		for (int i = 0, x = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++, x += kw) {
				int keyNum = i * 12 + whiteIDs[j] + transpose;
				whiteKeys.add(new Key(x, 0, kw, kh, keyNum));
			}
		}
		//touches noires
		for (int i = 0, x = 0; i < 6; i++, x += kw) {
			int keyNum = i * 12 + transpose;
			blackKeys.add(new Key((x += kw)-4, 0, kw/2, kh/2, keyNum+1));
			blackKeys.add(new Key((x += kw)-4, 0, kw/2, kh/2, keyNum+3));
			x += kw;
			blackKeys.add(new Key((x += kw)-4, 0, kw/2, kh/2, keyNum+6));
			blackKeys.add(new Key((x += kw)-4, 0, kw/2, kh/2, keyNum+8));
			blackKeys.add(new Key((x += kw)-4, 0, kw/2, kh/2, keyNum+10));
		}

		keys.addAll(blackKeys);
		keys.addAll(whiteKeys);
	}


	public Key getKey(Point point) {
		for (int i = 0; i < keys.size(); i++) {
			if (((Key) keys.get(i)).contains(point)) {
				return (Key) keys.get(i);
			}
		}
		return null;
	}



	// peindre les touches noires et blanches en bleu si on n'enregistre pas et en rose sinon
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Dimension d = getSize();

		g2.setBackground(getBackground());
		g2.clearRect(0, 0, d.width, d.height);

		g2.setColor(Color.white);
		g2.fillRect(0, 0, 42*kw, kh);

		for (int i = 0; i < whiteKeys.size(); i++) {
			Key key = (Key) whiteKeys.get(i);
			if (key.isNoteOn()) {
				g2.setColor(record ? pink : blue);
				g2.fill(key);
			}
			g2.setColor(Color.black);
			g2.draw(key);
		}
		for (int i = 0; i < blackKeys.size(); i++) {
			Key key = (Key) blackKeys.get(i);
			if (key.isNoteOn()) {
				g2.setColor(record ? pink : blue);
				g2.fill(key);
				g2.setColor(Color.black);
				g2.draw(key);
			} else {
				g2.setColor(Color.black);
				g2.fill(key);
			}
		}
	}
}