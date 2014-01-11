package Animation;
import javax.sound.midi.Patch;
import java.awt.Rectangle;

/**
 * Black and white keys or notes on the piano.
 */
class Touche extends Rectangle {
	int noteState;
	int numTouche;
	final int ON = 0, OFF = 1;
	final int NOTEON = 144;
	final int NOTEOFF = 128;
	final boolean record=true;

	public Touche(int x, int y, int width, int height, int num) {
		super(x, y, width, height);
		numTouche = num;
	}
	public boolean isNoteOn() {
		return noteState == ON;
	}
	public void on() {
		setNoteState(ON);
	}
	public void off() {
		setNoteState(OFF);
	}
	public void setNoteState(int state) {
		noteState = state;
	}
}