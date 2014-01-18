package main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.sound.midi.MetaMessage;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import enregistrer_lire.Recordeur;
import enregistrer_lire.TableauLecteur;

import Animation3.ClavierAnime2;
import Sons.Clavier;
import Sons.EmettreSon;
import Sons.Joueur;
import Sons.Synthetiseur;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Synthetiseur s= new Synthetiseur();
		Clavier c=new Clavier();
		Clavier cl=new Clavier();
		TableauLecteur tl = new TableauLecteur();
		Recordeur r = new Recordeur(cl, s, tl);

		EmettreSon es= new EmettreSon(0, s);
		Fenetre2 f = new Fenetre2(tl,r, s, c, cl, es);
		Joueur j =new Joueur(es, c);
		
		new ClavierAnime2(f.getGraphics(), cl).start();
		
		j.start();

	}

}


class Fenetre2 extends JFrame implements ActionListener, ChangeListener, ItemListener {        
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	EmettreSon es;

	public Fenetre2(TableauLecteur tl, Recordeur r, Synthetiseur s, Clavier cl, Clavier c, EmettreSon ees){
		es=ees;
		this.setTitle("Clavier");
		this.setSize(1000, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setBackground(Color.white);
		this.setLayout(new BorderLayout());


		//la fenetre
		JPanel p2 = new JPanel();
		JPanel p4 = new JPanel();

		//les boutons


		p4.add(tl.getLecture());
		p4.add(tl.getStop());


		p2.add(r.getRecord());
		p2.add(r.getSave());



		getContentPane().add("West", p4);
		getContentPane().add("North", p2);

		//choix des instruments
		final String[] names = s.intru();
		JPanel p3 = new JPanel();

		JComboBox<String> combo = new JComboBox<String>();
		combo.setPreferredSize(new Dimension(400,25));
		combo.setMaximumSize(new Dimension(400,25));
		for (int i = 0; i <= names.length-1; i++) {
			combo.addItem(names[i]);
		}
		combo.addItemListener(this);
		p3.add(combo);
		p3.add(Box.createHorizontalStrut(20));
		getContentPane().add("South", p3);
		this.repaint();


		//On ajoute l'écouteur à notre composant                
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(cl);
		this.addKeyListener(c);
		this.setVisible(true);                


	}

	public void meta(MetaMessage arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() instanceof JComboBox) {
			JComboBox combo = (JComboBox) e.getSource();
			int g= combo.getSelectedIndex();
			es.changerInstrument(g);
		}

	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub

	}

}