package Sons;
import javax.sound.midi.Patch;



public class EmettreSon {

	
    private ChannelData cc;
    private Synthetiseur s;
    int numero;
    int ins;
    
	public EmettreSon(int i, Synthetiseur sy){
		s=sy;
		cc=s.chaine(i);
		numero =i;
		ins=0;
	}

	//renvoit le numero de la chaine
	public int getNumero(){
		return numero;
	}
	
	/*permet de changer l'instrument*/
	public void changerInstrument(int instr){
		ins=instr;
		s.changeInstr(instr);
        Patch p = s.getInstr(instr).getPatch();
        int bank = p.getBank(), program = p.getProgram();
        program |= (bank&1)<<7; bank >>>= 1; 
        cc.channel.programChange(bank, program);
	}
	
	/*retourne l'instrument choisi*/
	public int getInstrument(){
		return ins;
	}

		/*permet d'emettre le son de la note jouee*/
	public void accord(int j){
		if(j!=0)
			cc.channel.noteOn(j, 64);
		}
	
	/*permet d'arreter le son de la note qui a ete precedemment jouee
	 * pour certains instruments il faut obligatoirement arreter la note sinon elle joue
	 * en continu
	 */
	public void off(int j){
		cc.channel.noteOff(j);
	}
	
	/*permet d'arreter toutes les notes precedemment jouees*/
	public void allOff(){
		cc.channel.allNotesOff();
	}
	
}
