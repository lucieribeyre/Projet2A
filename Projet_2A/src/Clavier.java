import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Clavier implements KeyListener{

	int[] note = new int[1];

	public void keyPressed(KeyEvent event) {
		note[0]=KeyConverter.Conversion(event.getKeyCode());
	}

	public int[] getNote(){
		return note;
	}

	public void keyReleased(KeyEvent event) {
		try {
			Thread.sleep(25);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		note[0]=0;
	}

	public void keyTyped(KeyEvent event) {

	}   	
}   

class KeyConverter {

	public static int Conversion(int i){
		switch (i) {
		case 17 : return 48;
		case 20 : return 49;
		case 16 : return 50;
		case 81 : return 51;
		case 153 : return 52;
		case 87 : return 53;
		case 83 : return 54;
		case 88 : return 55;
		case 68 : return 56;
		case 67 : return 57;
		case 70 : return 58;
		case 86 : return 59;
		case 66 : return 60;
		case 72 : return 61;
		case 78 : return 62;
		case 74 : return 63;
		case 44 : return 64;
		case 59 : return 65;
		case 75 : return 66;
		case 513 : return 67;
		case 76 : return 68;
		case 517 : return 69;
		case 77 : return 70;
		case 0 : return 71;
		case 151 : return 72;
		case 49 : return 73;
		case 65 : return 74;
		case 50 : return 75;
		case 90 : return 76;
		case 69 : return 77;
		case 52 : return 78;
		case 82 : return 79;
		case 53 : return 80;
		case 84 : return 81;
		case 54 : return 82;
		case 89 : return 83;
		case 85 : return 84;
		case 56 : return 85;
		case 73 : return 86;
		case 57 : return 87;
		case 79 : return 88;
		case 80 : return 89;
		case 522 : return 90;
		case 130: return 91;
		case 61 : return 92;
		case 515 : return 93;
		case 8 : return 94;
		case 10 : return 95;
		default : return 0;
		}

	}
}

