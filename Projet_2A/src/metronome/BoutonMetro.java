package metronome;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BoutonMetro implements ActionListener, ChangeListener{
	/*cette classe permet de gerer les boutons du metronome*/
	private Metronom m;
	JButton on, off;
	JSlider vitesse;
	
	public BoutonMetro(){
		JPanel p2 = new JPanel();
		on = createButton("on", p2, true);
		off = createButton("off", p2, false);
		m=new Metronom();
		m.start();
		
		 vitesse = createSlider("vitesse", p2);

	}
	
	 private JSlider createSlider(String name, JPanel p) {
         JSlider slider = new JSlider(JSlider.HORIZONTAL, 40, 200, 60);
         slider.addChangeListener(this);
         TitledBorder tb = new TitledBorder(new EtchedBorder());
         tb.setTitle(name + " = 60");
         slider.setBorder(tb);
         p.add(slider);
         p.add(Box.createHorizontalStrut(5));
         return slider;
     }
	
	private JButton createButton(String name, JPanel p, boolean state) {
		JButton b = new JButton(name);
		b.setFont(new Font("serif", Font.PLAIN, 10));
		b.setEnabled(state);
		b.addActionListener(this);
		p.add(b);
		return b;
	}
	
	/*retourne le bouton on*/
	public JButton getOn(){
		return on;
	}
	
	/*retourne le bouton off*/
	public JButton getOff(){
		return off;
	}
	
	/*retourne le slider permettant de regler la vitesse*/
	public JSlider getVitesse(){
		return vitesse;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==on){
			on.setEnabled(false);
			off.setEnabled(true);
			m.setState(true);
		}
		if(arg0.getSource()==off){
			on.setEnabled(true);
			off.setEnabled(false);
			m.setState(false);
		}
		
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		int value = vitesse.getValue();
		m.setSpeed(value);
		TitledBorder tb = new TitledBorder(new EtchedBorder());
        tb.setTitle("vitesse = "+ value);
        vitesse.setBorder(tb);
		
		
	}

}
