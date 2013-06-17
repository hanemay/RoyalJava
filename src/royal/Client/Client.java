/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package royal.Client;
import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
 
/**
 * Vores Klient
 * @author Niclas Bade
 */
public class Client extends Thread implements Runnable{
	/**
     *
     * @param args
     */
     private static boolean aktiv = false;
     private static Socket socket;
     private static PrintWriter output;
     private static BufferedReader input;
     private static String gammelKommando = "";
     private static String nyKommado = "";
     private static BufferedReader StandardSocketInput;
     /**
     * den information som køres i starten af en klient
     */
    public static Information info;
     
    
 
	/**
     *
     * @return retunere info til bearbejdelse af admin
     */
    public Information info(){
        return info;
    }
    

    /**
     * starter en client som skaber forbindelse til serveren som så logger ind og venter på info fra en admin.
     * @throws IOException
     */
    public void startClient() throws IOException {
                royal.Client.dbConnection c = new royal.Client.dbConnection();
                Connection forbindelse = c.sqlForbindelse();
		Socket socket = null;
		PrintWriter out = null;
		BufferedReader input = null;
		InetAddress host = null;
		BufferedReader stdIn = null;
 
		try {
			//host = InetAddress.getLocalHost();
                        
			socket = new Socket("127.0.0.1", 5559);
 
			out = new PrintWriter(socket.getOutputStream(), true);
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
 
			stdIn = new BufferedReader(new InputStreamReader(System.in));
			String beskedFraServer;
			String svar = null;
                       
			//Read from socket and write back the response to server. 
			while ((beskedFraServer = input.readLine()) != null) {                              
				System.out.println("Server - " + beskedFraServer);
				if (beskedFraServer.equals("exit")){
					break; 
                               }
                                if(beskedFraServer.equals("Login Successful...")){
                                   while (true) { 
                                    beskedFraServer = input.readLine();
                                    Scanner scan = new Scanner(beskedFraServer);
                                    while(scan.hasNext()){
                                        beskedFraServer = scan.next();
                                        if(beskedFraServer.equalsIgnoreCase("ture")){                                          
                                             Ture[] ture = c.setUfærdigeTure();
                                             System.out.println(ture[scan.nextInt()].toString());
                                             beskedFraServer = "";
                                             svar = stdIn.readLine();
                                             out.println(svar);
                                        }
                                    }
                                    System.out.println(beskedFraServer);
                                   }
                                }else{
				svar = stdIn.readLine();
                                }
				if (svar != null) {
					System.out.println("Client - " + svar);
					out.println(svar);
                                        
				}
			}
		} catch (UnknownHostException e) {
			System.err.println("Kan ikke finde host: " + host.getHostName());
			System.exit(1);
		} catch (IOException e) {
			System.err.println("kan ikke skrive eller læse fra forbindelsen: " + e.getMessage());
			System.exit(1);
		} catch (SQLException ex) {
           Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
       } finally { //Make sure we always clean up
			out.close();
			input.close();
			stdIn.close();
			socket.close();
		}
	}

     /**
     *
     * @param besked
     * @throws IOException
     */
    public void sendBesked(String besked) throws IOException{      
         output.println(besked);
         
       String svar = null;
       svar = input.readLine();
       System.out.println(svar);
       info.checkSvar(svar);      
     }


     /**
     * en client for en gui som blive initialiseret men ikke lukket før en gui trykker på logud
     * @param brugerNavn - brugernavnet
     * @param kodeord - kodeordet
     * @throws IOException
     */
   public void startClient(String brugerNavn, String kodeord) throws IOException {
                this.info = new Information();
                String[] adminCommands = new String[2];
                adminCommands[0] = brugerNavn;
                adminCommands[1] = kodeord;
		InetAddress host = null;
                int count = 0;
		try {
			this.socket = new Socket("127.0.0.1", 5559);
			this.output = new PrintWriter(socket.getOutputStream(), true);
			this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));                        
			this.StandardSocketInput = new BufferedReader(new InputStreamReader(System.in));
			String fromServer;
                        String oldFromServer = "";
			String fromUser = "GO";
                        System.out.println(fromUser);   
                        
			//Read from socket and write back the response to server. 
			while ((fromServer = input.readLine()) != null && count != 2) {
				System.out.println("Server - " + fromServer);
                                    
				if (fromServer.equals("exit"))
					break;
                                        if (!fromServer.equalsIgnoreCase(oldFromServer)) {	
                                        	if(count <= 1 ){
                                                output.println(adminCommands[count]);                                             
                                                 count++;
                                                }                                        
                                        }
                                    
			}
		} catch (UnknownHostException e) {
			System.err.println("Kan ikke forbinde til host: " + host.getHostName());
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Kan ikke skrive eller læse data, er forbindelsen røget ? " + e.getMessage());
			System.exit(1);
		}
	}
}