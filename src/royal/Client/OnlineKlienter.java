/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package royal.Client;

/**
 * Onlineklienter, kun for en indlogget admin så de nemmere kan bearbejdes.
 * @author Niclas Bade
 */
public class OnlineKlienter {
    private String brugerNavn;
    private int brugerId;
    private String socket;
    private String tidLoggetInd;
    /**
     *
     */
    public OnlineKlienter(){
        
    }
    /**
     *
     * @param tidLoggetInd  - tiden hvorpå klienten er logget ind
     */
    public void setTidLoggetInd(String tidLoggetInd){
        this.tidLoggetInd = tidLoggetInd;
    }
    /**
     *
     * @param brugerNavn  - brugernavnet på brugeren
     */
    public void setBrugernavn(String brugerNavn){
        this.brugerNavn = brugerNavn;
    }
    /**
     *
     * @param brugerId - brugerId på brugeren  
     */
    public void setBrugerId(int brugerId){
        this.brugerId = brugerId;
    }
    /**
     *
     * @param socket - Socket på brugeren så vi nemmere kan vælge en brugere.
     */
    public void setSocket(String socket){
        this.socket = socket;
    }
    /**
     *
     * @return - retunere tid logget ind på brugere
     */
    public String getTidLoggetInd(){
        return this.tidLoggetInd;
    }
    /**
     *
     * @return - retunere brugernavnet på brugeren
     */
    public String getBrugerNavn(){
        return this.brugerNavn;
    }
    /**
     *
     * @return - retunere brugerId på brugeren
     */
    public int getBrugerId(){
        return this.brugerId;
    }
    /**
     *
     * @return - retunere socket.toString på brugeren så threadmanager nemmere kan finde brugeren hvis brugerId sku fejle
     */
    public String getSocket(){
        return this.socket;
    }
    @Override
    public String toString(){
        return "Brugernavn: "+ brugerNavn+"\n"; 
    }
}
