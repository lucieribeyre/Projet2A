package Sons;
import javax.sound.midi.Patch;



public class EmettreSon {

        
    ChannelData cc;
    Synthetiseur s;
    int numero;
    
        public EmettreSon(int i, Synthetiseur sy){
                s=sy;
                cc=s.chaine(i);
                numero =i;
        }

        //renvoit le numero de la chaine
        public int getNumero(){
                return numero;
        }
        
        public void changerInstrument(int instr){
                s.changeInstr(instr);
        Patch p = s.getInstr(instr).getPatch();
        int bank = p.getBank(), program = p.getProgram();
        program |= (bank&1)<<7; bank >>>= 1; // correction d'un bug Java
        cc.channel.programChange(bank, program);
        }

                
        public void accord(int j){
                if(j!=0)
                        cc.channel.noteOn(j, 64);
                }
        
        public void off(int j){
                cc.channel.noteOff(j);
        }
        
}
