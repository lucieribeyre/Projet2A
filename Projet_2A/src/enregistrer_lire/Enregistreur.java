package enregistrer_lire;
import java.util.ArrayList;

import Sons.Clavier;


public class Enregistreur extends Thread{

        private ArrayList<Integer> enre;
        static Clavier c;
        private Boolean record;

        public Enregistreur(Clavier cl){
                c=cl;
                enre = new ArrayList<Integer>();
                record = false;
        }

        public void addNote(int i){
                enre.add(i);
        }

        public ArrayList<Integer> list(){
                return enre;
        }

        public void reset(){
                enre.clear();
        }

        public void setRecord(Boolean b){
                record=b;
        }

        public void run(){
                while(true){
                        
                        if(record){
                                enre.add((c.getNote()));
                        }
                        try {
                                this.sleep(1);
                        } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                        }
                }

        }

}