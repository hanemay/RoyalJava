package royal.Server;
import java.net.*;
import java.io.*;
import java.sql.Connection;
import royal.tracking.ThreadsMan;
 
/**
 * Demo Server: Contains a multi-threaded socket server sample code.
 */
public class Server extends Thread
{
    public static ThreadsMan tm = new ThreadsMan();
	final static int portNumber = 5559; //Arbitrary port number
 
	/**
     *
     * @param args
     */
    public static void main(String[] args) 
	{
		try {
			new Server().startServer();
		} catch (Exception e) {
			System.out.println("I/O failure: " + e.getMessage());
			e.printStackTrace();
		}
 
	}
 
	/**
     *
     * @throws Exception
     */
    public void startServer() throws Exception {
		ServerSocket serverSocket = null;
		boolean listening = true;
 
		try {
			serverSocket = new ServerSocket(portNumber);
		} catch (IOException e) {
			System.err.println("Could not listen on port: " + portNumber);
			System.exit(-1);
		}
 
		while (listening) {
		try {try{
                        String[] k = tm.getUser();
                        for(int i = 0; i < k.length; i++){
                        System.out.println(k[i]);
                        }
                }catch(NullPointerException e){
                    
                }
			new Server.ConnectionRequestHandler(serverSocket.accept()).start();       
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
 
		serverSocket.close();
        }

	/**state
	 * Handles client connection requests. 
	 */
	public class ConnectionRequestHandler extends Thread implements Runnable {
		private Socket socket = null;
		private PrintWriter out = null;
		private BufferedReader in = null;
        
		/**
             *
             * @param socket
             */
            public ConnectionRequestHandler(Socket socket){

			this.socket = socket;
		}
 
		/**
             *
             */
                @Override
            public void run() {
			System.out.println("Client connected to socket: " + socket.toString());
 
			try {
				out = new PrintWriter(socket.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
 
				String inputLine, outputLine;
				Server.BusinessLogic businessLogic = new Server.BusinessLogic();
				outputLine = businessLogic.processInput(null);
				out.println(outputLine);
 
				//Read from socket and write back the response to client. 
				while ((inputLine = in.readLine()) != null) {
					outputLine = businessLogic.processInput(inputLine);
					if(outputLine != null) {
						out.println(outputLine);
						if (outputLine.equals("exit")) {
							System.out.println("Server is closing socket for client:" + socket.getLocalSocketAddress());
							break;
						}
					} else {
						System.out.println("OutputLine is null!!!");
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally { //In case anything goes wrong we need to close our I/O streams and sockets.
				try {
					out.close();
					in.close();
					socket.close();
				} catch(Exception e) { 
					System.out.println("Couldn't close I/O streams");
				}
			}
		}
 
	}
 
	/**
	 * Handles business logic of application.
	 */
	public static class BusinessLogic extends Thread {
		private static final int LoginUserName = 0;
		private static final int LoginPassword = 1;
		private static final int AuthenticateUser = 2;
		private static final int AuthSuccess   = 3;
                private static final int Ture   = 4;
 
		private int state = LoginUserName;
                private int Admin = 5;
		private String userName =  null;
		private String userPassword =  null;
                private int getUsers = 6;
		/**
             *
             * @param clientRequest
             * @return
             */
            public String processInput(String clientRequest) {
                        dbConnection k = new dbConnection();
                        Connection con = k.connect();                        
			String reply = null;
			try {
				if(clientRequest != null && clientRequest.equalsIgnoreCase("login")) {
					state = LoginPassword;
				}if(clientRequest != null && clientRequest.equalsIgnoreCase("exit")) {
					return "exit";
				}
                                if(clientRequest != null && clientRequest.equalsIgnoreCase("ture")) {
					state = Ture;
				}      
                               
                                if(clientRequest != null && clientRequest.equalsIgnoreCase("getUsers")){
                              
                                    state = getUsers;
                               
                                }
 
				if(state == LoginUserName) {
					reply = "Please Enter your user name: ";
					state = LoginPassword;
				} else if(state == LoginPassword) {
					userName = clientRequest;
					reply = "Please Enter your password: ";
					state = AuthenticateUser;
                                       
				} else if(state == AuthenticateUser) {
					userPassword = clientRequest;
                                        boolean authenticated = false;
					authenticated = k.getState(userName, userPassword);
                                        System.out.println("STATE   = = = = = = =" + authenticated);
                                        if(authenticated == true) { 
                                            reply = "Login Successful...";
                                            tm.setUserCount(userName);
                                            if(userName.equalsIgnoreCase("Admin")){
                                            state = Admin;
                                            }else{
						state = AuthSuccess;
                                                      }
					} else {
						reply = "Invalid Credentials!!! Please try again. Enter you user name: ";
						state = LoginPassword;
					}
				} else {
					reply = "Invalid Request!!!";
				}
                                if(state == getUsers){
                                    if(userName.equalsIgnoreCase("Admin")){
                                    String[] users = tm.getUser();
                                    String[] timeStamps = tm.getTimeStamp();
                                    String tempReply = "getUsers ";
                                    for(int i = 0; i < users.length; i++){
                                        tempReply += users[i] + " " + timeStamps[i] +" ";
                                    }
                                    state = Admin;
                                    reply = tm.getOnlineUsers() + " " + tempReply;
                                    }else{
                                        reply = "You shouldnt be able to parse this command, admin has been notified";
                                    }
                                }
                                
                                if(state == Ture){
                                    reply = "TURE :-D :-D";
                                }
			} catch(Exception e) {
				System.out.println("input process falied: " + e.getMessage());
				return "exit";
			}
 
			return reply;
		}
	}
}