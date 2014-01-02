package enregistrer_lire;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class TableauLecteur extends JFrame implements ActionListener{
	ArrayList<Lecteur> tl;
	JButton lecture, supprimer, stop;
	
	public TableauLecteur(){
		JPanel p2 = new JPanel();
		lecture = createButton("lecture", p2, true);
		supprimer = createButton("supprimer", p2, true);
		stop = createButton("stop", p2, false);
		
		tl= new ArrayList<Lecteur>();
	}
	
	public void addLecteur(Lecteur l){
		tl.add(l);
		l.start();
	}
	
	public JButton getLecture(){
		return lecture;
	}
	
	public JButton getStop(){
		return stop;
	}
	
	public JButton getSup(){
		return supprimer;
	}
	
	public void lire(){
		for(int i=0; i<tl.size(); i++){
			tl.get(i).setLecture(true);
		}
		lecture.setEnabled(false);
		stop.setEnabled(true);
	}
	
	public void stopper(){
		for(int i=0; i<tl.size(); i++){
			tl.get(i).setLecture(false);
		}
		lecture.setEnabled(true);
		stop.setEnabled(false);
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
	
	private JButton createButton(String name, JPanel p, boolean state) {
		JButton b = new JButton(name);
		b.setFont(new Font("serif", Font.PLAIN, 10));
		b.setEnabled(state);
		b.addActionListener(this);
		p.add(b);
		return b;
	}

}
