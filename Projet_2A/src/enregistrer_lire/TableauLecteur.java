package enregistrer_lire;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class TableauLecteur extends JFrame implements ActionListener{
	private ArrayList<Lecteur> tl;
	JButton lecture, supprimer, stop;
	
	public TableauLecteur(){
		JPanel p2 = new JPanel();
		lecture = createButton("lecture", p2, true);
		supprimer = createButton("supprimer", p2, true);
		stop = createButton("stop", p2, false);
		
		tl= new ArrayList<Lecteur>(); 
		
		
	}
	
	/*ajoute au lecteur a la liste*/
	public void addLecteur(Lecteur l){
		tl.add(l);
		l.start();
	}
	
	/*retourne le bouton lecture*/
	public JButton getLecture(){
		return lecture;
	}
	
	/*retourne le bouton stop*/
	public JButton getStop(){
		return stop;
	}
	
	/*retourne le bouton supprimer*/
	public JButton getSup(){
		return supprimer;
	}
	
	/*retourne le lecteur a l'index i de la liste*/
	public Lecteur getLecteur(int i){
		return tl.get(i);
	}
	
	/*retourne la taille de la liste*/
	public int getTaille(){
		return tl.size();
	}
	
	/*permet de mettre tous les lecteurs en mode lecture*/
	public void lire(){
		for(int i=0; i<tl.size(); i++){
			tl.get(i).setLecture(true);
		}
		lecture.setEnabled(false);
		stop.setEnabled(true);
	}
	
	/*permet de stopper tous les lecteurs et de les remettre a zero*/
	public void stopper(){
		for(int i=0; i<tl.size()-1; i++){
			tl.get(i).setLecture(false);
		}
		lecture.setEnabled(true);
		stop.setEnabled(false);
	}
	
	/*permet de faire une pause dans la lecture, la lecture se stoppe mais elle reprend
	 * au point ou elle en etait*/
	 
	public void pause(){
		for(int i=0; i<tl.size(); i++){
			tl.get(i).pause();
		}
	}
	
	 /*indique si tous les lecteurs ont fini leur lecture*/
	public Boolean fini(){
		Boolean result=true;
		for(int i=0; i<tl.size()-1; i++){
			if(!tl.get(i).getFini()){
				result=false;
			}
		}
		return result;
	}
	
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == lecture){
			this.lire();
		}
		if(arg0.getSource() == stop){
			this.stopper();
		}

	}
	
	/*creation des boutons*/
	private JButton createButton(String name, JPanel p, boolean state) {
		JButton b = new JButton(name);
		b.setFont(new Font("serif", Font.PLAIN, 10));
		b.setEnabled(state);
		b.addActionListener(this);
		p.add(b);
		return b;
	}

}
