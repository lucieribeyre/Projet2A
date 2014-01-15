package Reseau;
import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.logging.*;


public class ServerThread extends Thread {

    private Socket socket;
    private DataOutputStream dos;
    private DataInputStream dis;
    private int idSessio;
    private int j;
    private int nclients;
    private int stringOffset;

    
    
    public ServerThread(Socket socket, int id, int _nclients, int _j, int _stringOffset) {
        this.socket = socket;
        this.idSessio = id;
        this.j = _j;
        this.nclients = _nclients;
        this.stringOffset = _stringOffset;
        
        try {
            dos = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void desconectar() {
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Example Paquet	0Aa
    //ID PAQUET			0
	//NOTE				A
	//INSTRUMENT		a
    
//Liu où comence   |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  		
    String sonets="0Aa1Bb2Cc3Dd4Ee5Ff6Gg7Hh8Ii9Jj0Kk1Ll2Mm3Nn4Oo5Pp6Qq7Rr8Ss9Tt";
    char[] sonetsArray;
    String data;
      
    @Override
    public void run() {
    	
    		
        String accion = "";
        try {
            accion = "test";
        	char mensajerecividocliente = dis.readChar();
            if(accion.equals("test")){
                //System.out.println("Le client idSesion "+this.idSessio+" est connecte " + cosa);
            	
                //System.out.println(mensajerecividocliente);
                
                               
                sonetsArray = sonets.toCharArray();
                
                // Si j est plus longue qui l'array ,le serveur n'envoye rien   
                if(sonets.length()>=j+2){
                
                	data="" + sonetsArray[j] + sonetsArray[j+1] + sonetsArray[j+2] + "";
                    System.out.println(data);
                    
                    
                    System.out.println("nclients:" + nclients + "|J:" + j +"");	
                	
                }  else {
                	data="000";	//temps vide
                }
              
                 
                System.out.println(data);
                dos.writeUTF(data);
                
                
            }

        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }

        desconectar();
    }
}