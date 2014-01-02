package Sons;

public class Joueur extends Thread{

        EmettreSon s;
        Clavier c;
        int a=0;
        int[] note = new int[1000];
        int compteur=0;


        public Joueur(EmettreSon so, Clavier cl){
                s=so;
                c=cl;
        }
        
        public void decompte(int b){
                if(b<note.length-2){
                        s.off(note[b+1]);
                }
                if(b==note.length-1){
                        s.off(note[0]);
                }
        }

        public void run(){
                while(true){
                        a=c.getNote();
                        s.accord(a);
                        note[compteur]=a;
                        decompte(compteur);
                        compteur++;
                        if(compteur==note.length)
                                compteur=0;
                        try {
                                Thread.sleep(1);
                        } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                        }

                }
        }
}