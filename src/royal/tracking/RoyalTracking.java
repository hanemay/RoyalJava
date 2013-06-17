
package royal.tracking;

import java.io.IOException;
import java.util.Scanner;
import royal.Client.Client;


/**
 * Main klassen for klienten.
 * @author Niclas Bade & Thore Caspersen
 */
public class RoyalTracking {

    /**
     * @param args the command line arguments
     * @throws IOException  
     */
    public static void main(String[] args) throws IOException {
        
       Client client = new Client();
       client.startClient();
        
    }
}
