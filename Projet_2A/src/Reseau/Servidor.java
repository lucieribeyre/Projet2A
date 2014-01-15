package Reseau;
import java.io.*;
import java.net.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.*;

public class Servidor {

	
    
    public static void main(String args[]) throws IOException {

        ServerSocket ss;
        System.out.print("Inicializando servidor... ");
        try {
            ss = new ServerSocket(1000);
            System.out.println("\t[OK]");
            int idSession = 0;
            
            //
            int j=0;
            int nclients;
            int nclientsMax=3;
            int stringOffset=0;
            
           nclients=nclientsMax;
            
            while (true) {
                Socket socket;
                socket = ss.accept();
                System.out.println("Noveau connection: "+socket);
                ((ServerThread) new ServerThread(socket, idSession, nclients, j, stringOffset)).start();
                idSession++;
                
                /// Envoyer le String "Sonets" nclients fois, s'il n'y a pas le maximun, le client ignore le message
                
                nclients=nclients-1;
                              
                if (nclients==0) {              
                	j = j+3;
                	nclients=nclientsMax;
                }
                
                
                if (idSession==10){
                	//System.out.println(stringOffset);
                	stringOffset=stringOffset+30;
                	//System.out.println(stringOffset);
                }
                
                
            }

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


//String etat_client[] = {"x"," "," ","x","x"};
//
//while(true){
//System.out.println("Conexion  1   2   3   4   5");
//System.out.println("          " + etat_client[0] + "   " + etat_client[1] + "   " + etat_client[2] + "   " + etat_client[3] + "   " + etat_client[4] + "\n");
//etat_client[0]=" "; 
//try {
//	TimeUnit.MILLISECONDS.sleep(10);
//} catch (InterruptedException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}
//
//for (int i=0; i<25; i++)
//	System.out.println("\n");
//
//}