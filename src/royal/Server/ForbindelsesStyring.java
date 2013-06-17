/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package royal.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static royal.Server.Server.tm;

/**
 *
 * @author Niclas Bade
 */
	/**
	 * den class som tager imodmod requests
	 */
public class ForbindelsesStyring extends Thread implements Runnable {
	private Socket socket = null;
	private PrintWriter out = null;
	private BufferedReader in = null;
		/**
             *
             * @param socket den socket som vil connecte
             */
        public ForbindelsesStyring(Socket socket){
			this.socket = socket;
	}
                
		/**
             * kører en ny thread for hversocket som forbinder
             */
                @Override
        public void run() {
			System.out.println("Klient forbundet til: " + socket.toString());
 
			try {
				out = new PrintWriter(socket.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String inputLine, outputLine;
				ServerLogik serverLogik = new ServerLogik();
				outputLine = serverLogik.håndterInput(null,socket);
				out.println(outputLine);
				//læser fra socket og skriver til clienten
				while ((inputLine = in.readLine()) != null) {
                                    
					outputLine = serverLogik.håndterInput(inputLine,socket);
					if(outputLine != null) {
						out.println(outputLine);
						if (outputLine.equals("exit")) {
                                                        tm.logUd(socket);
                                                        
							System.out.println("server locket for socket: " + socket.getLocalSocketAddress());
							break;
						}
					} else {
						System.out.println("output tekst er null");
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    } finally { //hvis noget går galt skal der ryddes op
				try {
					out.close();
					in.close();
					socket.close();
				} catch(Exception e) { 
					System.out.println("kan ikke læse I/O strømme");
				}
			}
		}
 
	}