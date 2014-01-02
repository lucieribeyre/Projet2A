package Sons;
import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Soundbank;
import javax.sound.midi.Synthesizer;


public class Synthetiseur {

	Sequencer sequencer;
	Sequence sequence;
	Synthesizer synthesizer = null;
	Instrument instruments[];
	ChannelData channels[];

	public Synthetiseur(){
		try {
			if (synthesizer == null) {
				if ((synthesizer = MidiSystem.getSynthesizer()) == null) {
					System.out.println("getSynthesizer() failed!");
					return;
				}
			} 
			synthesizer.open();
			sequencer = MidiSystem.getSequencer();
			sequence = new Sequence(Sequence.PPQ, 10);
		} catch (Exception ex) { ex.printStackTrace(); return; }

		Soundbank sb = synthesizer.getDefaultSoundbank();
		if (sb != null) {
			instruments = synthesizer.getDefaultSoundbank().getInstruments();
			synthesizer.loadInstrument(instruments[12]);
		}
		MidiChannel midiChannels[] = synthesizer.getChannels();
		channels = new ChannelData[midiChannels.length];
		for (int i = 0; i < channels.length; i++) {
			channels[i] = new ChannelData(midiChannels[i], i);
		}
	}

	public ChannelData chaine(int i){
		return channels[i];
	}

	public Instrument getInstr(int i){
		return instruments[i];
	}

	public void changeInstr(int i){
		synthesizer.loadInstrument(instruments[i]);
	}

	public String[] intru(){
		String[] instr = new String[instruments.length];

		for(int i=0; i<instruments.length-1; i++){
			if(instruments[i]!=null)
				instr[i]=instruments[i].toString();
		if(instruments[i]==null)
			instr[i]="bonjour";
		}
		return instr;
	}
}
class ChannelData {

    MidiChannel channel;
    boolean solo, mono, mute, sustain;
    int velocity, pressure, bend, reverb;
    int row, col, num;

    public ChannelData(MidiChannel channel, int num) {
        this.channel = channel;
        this.num = num;
        velocity = pressure = bend = reverb = 64;
    }


    
}
