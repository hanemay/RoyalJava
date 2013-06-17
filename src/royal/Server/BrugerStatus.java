/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package royal.Server;

/**
 *
 * @author Niclas Bade
 */
public class BrugerStatus {
    /**
     * Første status da første input fra en client altid er brugernavn.
     */
    public static final int loginBrugerNavn = 0; 
    /**
     * Anden status da kodeordet ting altid er andet input 
     */
    public static final int loginKodeord = 1;
    /**
     * statusen som biver sat når brugernavn og kodeord er opsamlet så mysql kan validere vi af dbConnection
     */
    public static final int tilladBrugerRettigheder = 2;
    /**
     * Status for hvis de er succesfuldt logget ind og vier servere tilladelse til at beholde client online og ikke dumpe socket
     */
    public static final int AuthSuccess   = 3;
    /**
     * status som bliver sat hvis client request = ture
     */
    public static final int Ture   = 4;
    /** 
     * status for hvis man er admin
     */
    public static final int Admin = 5;
    /**
     * status for at indhente brugere som bliver sat af clientrequest getUsers
     */
    public static final int getBrugere = 6;
    /**
     * status for at få sockets.tostring som info som bliver sat af clientRequest getSockets
     */
    public static final int getSockets = 7;
    /**
     * første state så vi ved det er et brugernavn:
     */
    public int status = 0;
    
   
    /**
     *
     */
    public BrugerStatus(){
        
    }
    /**
     *
     * @param clientRequest den request som ændre status alt efter hvem der skal sendes til og hvad der skal bruges af information
     */
    public void checkReuqest(String clientRequest){
        if(clientRequest != null && clientRequest.equalsIgnoreCase("login")) {
					status = loginKodeord;
        }if(clientRequest != null && clientRequest.equalsIgnoreCase("ture")) {
					status = Ture;
				}  
        if(clientRequest != null && clientRequest.equalsIgnoreCase("getSockets")) {
					status = getSockets;
	}      
                               
        if(clientRequest != null && clientRequest.equalsIgnoreCase("getUsers")){                             
                                    status = getBrugere;                              
       }
    }
}
