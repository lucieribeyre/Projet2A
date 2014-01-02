import java.awt.Rectangle;


/**
* Black and white keys or notes on the piano.
*/
class Key extends Rectangle {
        int noteState;
        int kNum;
        final int ON = 0, OFF = 1;
        final int NOTEON = 144;
        final int NOTEOFF = 128;
        
        public Key(int x, int y, int width, int height, int num) {
                super(x, y, width, height);
                kNum = num;
        }
        public boolean isNoteOn() {
                return noteState == ON;
        }
        public void on() {
                setNoteState(ON);
                cc.channel.noteOn(kNum, cc.velocity);
                if (record) {
                        createShortEvent(NOTEON, kNum);
                }
        }
        public void off() {
                setNoteState(OFF);
                cc.channel.noteOff(kNum, cc.velocity);
                if (record) {
                        createShortEvent(NOTEOFF, kNum);
                }
        }
        public void setNoteState(int state) {
                noteState = state;
        }
}