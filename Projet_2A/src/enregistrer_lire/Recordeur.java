package enregistrer_lire;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Sons.Clavier;
import Sons.Synthetiseur;



public class Recordeur extends  JFrame implements ActionListener {
	Enregistreur e;
	static int i=1;
	JButton recordB, saveB;
	static Synthetiseur s;
	static TableauLecteur tl;
	
	
	public Recordeur(Clavier cl, Synthetiseur st, TableauLecteur t){
		this.addKeyListener(cl);
		e=new Enregistreur(cl);
		e.start();
		JPanel p2 = new JPanel();
		recordB = createButton("Record", p2, true);
		saveB = createButton("Stop", p2, false);
		s=st;
		tl=t;
		

	}
	
	public void record(){
		e.setRecord(true);
		i++;
	}
	
	public JButton getRecord(){
		return recordB;
	}
	
	public JButton getSave(){
		return saveB;
	}
	
	public ArrayList<Integer> stop(){
		e.setRecord(false);
		ArrayList<Integer> res = new ArrayList<Integer>();
		for(int k=0; k<e.list().size()-1;k++){
			res.add(k, e.list().get(k));
		}
		return res;
	}
	
	public int numero(){
		return i;
	}
	
	public void enregistrer(){
		saveB.setEnabled(true);
		recordB.setEnabled(false);
		this.record();
	}
	
	public void arreter(){
		tl.addLecteur(new Lecteur(s ,i, this.stop()));
		e.reset();
		saveB.setEnabled(false);
		recordB.setEnabled(true);
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

