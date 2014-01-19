package main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.sound.midi.MetaMessage;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import metronome.BoutonMetro;

import enregistrer_lire.Recordeur;
import enregistrer_lire.TableauLecteur;


import Animation.ClavierAnime;
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
		Clavier cl2 = new Clavier();
		TableauLecteur tl = new TableauLecteur();
		EmettreSon es= new EmettreSon(0, s);
		Recordeur r = new Recordeur(cl, s, tl, es);
		Joueur j =new Joueur(es, c);
		
		Fenetre2 f = new Fenetre2(tl,r, s, c, cl, cl2, es, j);
		
		
		ClavierAnime a = new ClavierAnime(f.getGraphics(), cl2);
		a.start();
		
		
		j.start();

	}

}


class Fenetre2 extends JFrame implements ActionListener, ChangeListener, ItemListener {        
	/**
	 * 
	 */
	EmettreSon es;
	JButton lecture;
	JButton pause;
	JButton stop;
	JSlider profondeur;
	TableauLecteur t;
	Recordeur r;
	BoutonMetro bm;
	Joueur j;
	private static final long serialVersionUID = 1L;


	public Fenetre2(TableauLecteur tl, Recordeur rr, Synthetiseur s, Clavier cl, Clavier c, Clavier cl2, EmettreSon ees, Joueur jo){
		t=tl;
		r=rr;		
		es=ees;
		j=jo;
		bm = new BoutonMetro();
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
		this.addKeyListener(cl2);
		this.setVisible(true);                

		//Bouton pour lire et enregistrer en meme temps
		JPanel p = new JPanel();
		 lecture = createButton("l+r", p, true);
		 pause = createButton("p", p, false);
		 stop = createButton("s", p, false);
		p.add(lecture);
		p.add(pause);
		p.add(stop);
		getContentPane().add("East", p);
		
//metronome
		JPanel p0 = new JPanel();
		p0.add(bm.getOn());
		p0.add(bm.getOff());
		p0.add(bm.getVitesse());
		getContentPane().add("Center", p0);
		

//controle longeur note
		//utilisation p3
		profondeur = createSlider("profondeur", p3);
		p3.add(profondeur);
		getContentPane().add("South", p3);
		this.repaint();

	}

	public void meta(MetaMessage arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==lecture){
			
			r.enregistrer();
			t.lire();
			
			lecture.setEnabled(false);
			stop.setEnabled(true);
			pause.setEnabled(true);
		}
		if(arg0.getSource()==stop){
			r.arreter();
			t.stopper();
			lecture.setEnabled(true);
			stop.setEnabled(false);
			pause.setEnabled(false);
		}
		if(arg0.getSource()==pause){
			lecture.setEnabled(true);
			stop.setEnabled(true);
			pause.setEnabled(false);
			r.pause();
			t.pause();
		}

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
		int value = profondeur.getValue();
		j.setLongueur(value);
		TitledBorder tb = new TitledBorder(new EtchedBorder());
        tb.setTitle("profondeur = "+ value/1000 + " s");
        profondeur.setBorder(tb);

	}
	private JButton createButton(String name, JPanel p, boolean state) {
		JButton b = new JButton(name);
		b.setFont(new Font("serif", Font.PLAIN, 10));
		b.setEnabled(state);
		b.addActionListener(this);
		p.add(b);
		return b;
	}
	
	 private JSlider createSlider(String name, JPanel p) {
         JSlider slider = new JSlider(JSlider.HORIZONTAL, 100, 5000, 1000);
         slider.addChangeListener(this);
         TitledBorder tb = new TitledBorder(new EtchedBorder());
         tb.setTitle(name + " = 1 s");
         slider.setBorder(tb);
         p.add(slider);
         p.add(Box.createHorizontalStrut(5));
         return slider;
     }
}