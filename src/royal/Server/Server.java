package royal.Server;
import java.net.*;
import java.io.*;
 
/**
 * Royal Kurer server tager input og output til clienter.
 * @author Niclas Bade
 */
public class Server extends Thread
{
    /**
     * Threadmanager som serveren skal starte opnår den bliver startet den skal ikke  initialiseres i hver enkelt thread
     */
    public static ThreadsMan tm = new ThreadsMan();
    final static int portNumber = 5559; //portnummeret

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
     * starter serveren smider en stacktrace ved fejl.
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
			new ForbindelsesStyring(serverSocket.accept()).start();       
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		serverSocket.close();
        }
}	