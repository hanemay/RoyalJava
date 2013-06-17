/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package royal.Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import static royal.Server.Server.tm;

/**
 *
 * @author Niclas Bade
 */
public class ServerLogik extends Thread {            
		BrugerStatus state = new BrugerStatus();
		private String brugerNavn =  null;
		private String userPassword =  null;
                dbConnection k = new dbConnection();
                Connection con = k.fobind();    
	/**
             *
             * @param clientForspørgsel 
             * @param socket den socket som afsender beskeden.
             * @return den reply som serveren sender tilbage til klienten kunne være informationener som "afhentningsadresse""leveringsadresse1"
             * "tid hentes"
             * @throws IOException
             * @throws SQLException  
             */
            public String håndterInput(String clientForspørgsel, Socket socket) throws IOException, SQLException {                  
			String svarTilbage = null;
                        int secondRequest = 0;
                            if(state.status == state.Admin){
                                Scanner scan = new Scanner(clientForspørgsel);
                                 clientForspørgsel = scan.next();
                                 if(clientForspørgsel.equalsIgnoreCase("ignore")){
                                      clientForspørgsel = scan.next();
                                      secondRequest = scan.nextInt();
                                     }
                                 if(scan.hasNext()){  
                                    secondRequest = scan.nextInt();
                                   if(scan.hasNext()){
                                       clientForspørgsel = "ignore " +clientForspørgsel +" "+ scan.next();
                                   }
                                  Socket[] sockets = tm.getSockets();
                                  System.out.println("REQUEST TIL HANEMAY: " + clientForspørgsel);
                                  håndterInput(clientForspørgsel,sockets[secondRequest]);
                                 }
                              }
                                state.checkReuqest(clientForspørgsel);		     
				if(state.status == state.loginBrugerNavn) {
					svarTilbage = "Please Enter your user name: ";
					state.status = state.loginKodeord;
				} else if(state.status == state.loginKodeord) {
					brugerNavn = clientForspørgsel;
					svarTilbage = "Please Enter your password: ";
					state.status = state.tilladBrugerRettigheder;                                       
				} else if(state.status == state.tilladBrugerRettigheder) {
					userPassword = clientForspørgsel;
                                        boolean authenticated = false;
					authenticated = k.getState(brugerNavn, userPassword);
                                        if(authenticated == true) { 
                                            svarTilbage = "Login Successful...";
                                            tm.checkForKopi(brugerNavn);
                                            tm.tilføjBruger(brugerNavn);
                                            tm.setBrugerSockets(socket);
                                            if(brugerNavn.equalsIgnoreCase("Admin")){
                                            state.status = state.Admin;
                                            }else{
						state.status = state.AuthSuccess;
                                                      }
					} else {
						svarTilbage = "Brugernavn eller kodeord passede ikke, prøv igen ";
						state.status = state.loginKodeord;
					}
				} else {
					svarTilbage = "Invalid Request!!!";
				}
                                if(state.status == state.getBrugere){
                                    if(brugerNavn.equalsIgnoreCase("Admin")){
                                    String[] users = tm.getBrugere();
                                    String[] timeStamps = tm.getTimeStamp();
                                    String tempReply = "getUsers ";
                                    for(int i = 0; i < users.length; i++){
                                        tempReply += users[i] + " " + timeStamps[i] +" ";
                                    }
                                    state.status = state.Admin;
                                    svarTilbage = tm.getOnlineBrugere() + " " + tempReply;
                                    }else{
                                        svarTilbage = "You shouldnt be able to parse this command, admin has been notified";
                                    }
                                }
                                if(state.status == state.getSockets){
                                    Socket[] sockets = tm.getSockets();
                                    svarTilbage = tm.getOnlineBrugere() + " getSockets ";
                                    for(int i = 0; i < sockets.length; i++){
                                        svarTilbage += sockets[i].toString() + " ";
                                    }
                                }        
                                if(state.status == state.Ture){
                                    PrintWriter out = null;
                                  out = new PrintWriter(socket.getOutputStream(), true);
                                  out.println(clientForspørgsel + " " + secondRequest);
                                    svarTilbage = "succes";
                                    return svarTilbage;
                                }			
			return svarTilbage;
		}
	}
