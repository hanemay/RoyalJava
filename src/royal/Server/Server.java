package royal.Server;
import java.net.*;
import java.io.*;
 
/**
 * Demo Server: Contains a multi-threaded socket server sample code.
 */
public class Server extends Thread
{
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
		try {

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
            public ConnectionRequestHandler(Socket socket) {
			this.socket = socket;
		}
 
		/**
             *
             */
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
 
		private String userName =  null;
		private String userPassword =  null;
 
		/**
             *
             * @param clientRequest
             * @return
             */
            public String processInput(String clientRequest) {
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
 
				if(state == LoginUserName) {
					reply = "Please Enter your user name: ";
					state = LoginPassword;
				} else if(state == LoginPassword) {
					userName = clientRequest;
					reply = "Please Enter your password: ";
					state = AuthenticateUser;
				} else if(state == AuthenticateUser) {
					userPassword = clientRequest;
					if(userName.equalsIgnoreCase("John") && userPassword.equals("doe")) { 
						reply = "Login Successful...";
						state = AuthSuccess;
					} else {
						reply = "Invalid Credentials!!! Please try again. Enter you user name: ";
						state = LoginPassword;
					}
				} else {
					reply = "Invalid Request!!!";
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