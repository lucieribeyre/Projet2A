package enregistrer_lire;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import main.Clavier;

import Sons.EmettreSon;
import Sons.Synthetiseur;



public class Recordeur extends  JFrame implements ActionListener {
	private Enregistreur e;
	static int i=1;
	JButton recordB, saveB;
	static Synthetiseur s;
	static TableauLecteur tl;
	static EmettreSon es;


	public Recordeur(Clavier cl, Synthetiseur st, TableauLecteur t, EmettreSon ess){
		this.addKeyListener(cl);
		e=new Enregistreur(cl);
		e.start();
		JPanel p2 = new JPanel();
		recordB = createButton("Record", p2, true);
		saveB = createButton("Stop", p2, false);
		s=st;
		tl=t;
		es=ess;

	}

	/*lance l'enregistrement*/
	public void record(){
		e.setRecord(true);
		i++;
	}

	/*retourne l'enregistrement fait*/
	public JButton getRecord(){
		return recordB;
	}

	/*retourne le bouton save*/
	public JButton getSave(){
		return saveB;
	}

	/*permet de stopper l'enregistrement, il donne en retour la liste d'entier
	 * enregistre
	 */
	public ArrayList<Integer> stop(){
		e.setRecord(false);
		ArrayList<Integer> res = new ArrayList<Integer>();
		for(int k=0; k<e.list().size()-1;k++){
			res.add(k, e.list().get(k));
		}
		return res;
	}

	/*retourne le thread enregistreur*/
	public Thread getEnr(){
		return e;
	}

	/*retourne le numero de piste sur lequel doit etre enregitrer la piste*/
	public int numero(){
		return i;
	}

	/*parmet d'enregistrer, change l'etat des bouton*/
	public void enregistrer(){
		saveB.setEnabled(true);
		recordB.setEnabled(false);
		this.record();
	}

	/*permet d'arreter l'enregistrement, change l'etat des boutons*/
	public void arreter(){
		tl.addLecteur(new Lecteur(s ,i, this.stop(), es.getInstrument()));
		e.reset();
		saveB.setEnabled(false);
		recordB.setEnabled(true);
	}

	/*permet de faire une pause dans l'enregistrement*/
	public void pause(){
		e.setRecord(false);
		i--;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == recordB){
			this.enregistrer();
		}
		if(arg0.getSource() == saveB){
			this.arreter();
		}

	}

	private JButton createButton(String name, JPanel p, boolean state) {
		JButton b = new JButton(name);
		b.setFont(new Font("serif", Font.PLAIN, 10));
		b.setEnabled(state);
		b.addActionListener(this);
		p.add(b);
		return b;
	}


}

