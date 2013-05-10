/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package royal.Client;
import java.io.*;
import java.net.*;
 
/**
 *
 * @author root
 */
public class Client{
	/**
     *
     * @param args
     */
    public static void main(String[] args) {
		try {
			new Client().startClient();
		} catch (Exception e) {
			System.out.println("Something falied: " + e.getMessage());
			e.printStackTrace();
		}
	}
 
	/**
     *
     * @throws IOException
     */
    public void startClient() throws IOException {
 
		Socket socket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		InetAddress host = null;
		BufferedReader stdIn = null;
 
		try {
			host = InetAddress.getLocalHost();
			socket = new Socket(host.getHostName(), 5559);
 
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
 
			stdIn = new BufferedReader(new InputStreamReader(System.in));
			String fromServer;
			String fromUser;
 
			//Read from socket and write back the response to server. 
			while ((fromServer = in.readLine()) != null) {
				System.out.println("Server - " + fromServer);
				if (fromServer.equals("exit"))
					break;
 
				fromUser = stdIn.readLine();
				if (fromUser != null) {
					System.out.println("Client - " + fromUser);
					out.println(fromUser);
				}
			}
		} catch (UnknownHostException e) {
			System.err.println("Cannot find the host: " + host.getHostName());
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't read/write from the connection: " + e.getMessage());
			System.exit(1);
		} finally { //Make sure we always clean up
			out.close();
			in.close();
			stdIn.close();
			socket.close();
		}
	}
     public Information startClient(String Login, String password, String commando) throws IOException {
                Information info = new Information();
                String exit = "exit";
                String[] adminCommands = new String[4];
                adminCommands[0] = Login;
                adminCommands[1] = password;
                adminCommands[2] = commando;
                adminCommands[3] = exit;
		Socket socket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		InetAddress host = null;
		BufferedReader stdIn = null;
                int count = 0;
		try {
			host = InetAddress.getLocalHost();
			socket = new Socket(host.getHostName(), 5559);
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        
			stdIn = new BufferedReader(new InputStreamReader(System.in));
			String fromServer;
                        String oldFromServer = "";
			String fromUser = "GO";
                        System.out.println(fromUser);
                         
                     
			//Read from socket and write back the response to server. 
			while ((fromServer = in.readLine()) != null) {
				System.out.println("Server - " + fromServer);
                                    info.checkReply(fromServer);
				if (fromServer.equals("exit"))
					break;
                                 
                                      
                                System.out.println(adminCommands[count]);
                                        if (!fromServer.equalsIgnoreCase(oldFromServer)) {
                                              fromUser = adminCommands[count];
                                        	System.out.println("Client - " + adminCommands[count]);
                                        	out.println(fromUser);
                                                count++;
                                        }
                                    
			}
		} catch (UnknownHostException e) {
			System.err.println("Cannot find the host: " + host.getHostName());
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't read/write from the connection: " + e.getMessage());
			System.exit(1);
		} finally { //Make sure we always clean up
			out.close();
			in.close();
			stdIn.close();
			socket.close();
		}
                return info;
	}
}