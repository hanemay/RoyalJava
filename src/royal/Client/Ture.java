/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package royal.Client;

/**
 * klassen hvor ture bliver gemt så de kan bearbejdes nemmere
 * @author Niclas Bade
 */
public class Ture {
    private String afhentningsAdresse;
    private String afhentningsBy;
    private String afhentningsPostNr;
    private String leveringsAdresse;
    private String leveringsBy;
    private String leveringsPostNr;
    private String leveringsKundeNavn;
    private String afhentningsKundeNavn;
    private String telefonNummer;
    /**
     *
     */
    public Ture(){
        
    }
    /**
     *
     * @return - retunere postnummeret hvorpå pakken skal afhentes
     */
    public String getafhentningsPostNr(){
        return this.afhentningsPostNr;
    }
    /**
     *
     * @return - retunere afhentningsbyen hvor pakken skal hentes.
     */
    public String getafhentningsBy(){
        return this.afhentningsBy;
    }
    /**
     *
     * @return retunere adressen hvorpå pakken skal hentesn
     */
    public String getafhentningsAdresse(){
        return this.afhentningsAdresse;
    }
    /**
     *
     * @return - retunere navnet eller stedet på adressen hvorpå pakken skal hentes
     */
    public String getafhentningsKundeNavn(){
        return this.afhentningsKundeNavn;
    }
    /**
     *
     * @return -  retunere adresse hvorpå pakken skal leveres
     */
    public String getleveringsAdresse(){
        return this.leveringsAdresse;
    }
    /**
     *
     * @return - retunere postnummeret hvorpå pakken skal leveres
     */
    public String getleveringsPostNr(){
        return this.leveringsPostNr;
    }
    /**
     *
     * @return - retunere navnet eller stedet på adressen hvorpå pakken skal leveres
     */
    public String getleveringsKundeNavn(){
        return this.leveringsKundeNavn;
    }
    /**
     *
     * @return retunere kontaktnummeret på stedet hvorpå pakken skal hentes
     */
    public String getKontaktNr(){
        return this.telefonNummer;
    }
    /**
     *
     * @param telefonNummer - sætter telefonumeret hvorpå pakken skal hentes
     */
    public void setTelefonNummer(String telefonNummer){
        this.telefonNummer = telefonNummer;
    }
    /**
     *
     * @param afhentningsKundeNavn - sætter navnet eller stedet på adressen hvorpå pakken skal hentes
     */
    public void setAfhentningsKundeNavn(String afhentningsKundeNavn){
        this.afhentningsKundeNavn = afhentningsKundeNavn;
    }
    /**
     *
     * @param leveringsKundeNavn - sætter navnet eller stedet på adressen hvorpå pakken skal leveres
     */
    public void seteveLingsKundeNavn(String leveringsKundeNavn){
        this.leveringsKundeNavn = leveringsKundeNavn;
    }
    /**
     *
     * @param afhentningsAdresse sætter adressen hvorpå pakken skal hentes
     */
    public void setAfhentningsAdresse(String afhentningsAdresse){
        this.afhentningsAdresse = afhentningsAdresse;
    }
    /**
     *
     * @param afhentningsBy - sætter byen hvorpå pakken skal hentes
     */
    public void setAfhentningsBy(String afhentningsBy){
        this.afhentningsBy = afhentningsBy;
    }
    /**
     *
     * @param afhentningsPostNr - sætter adressens postNr hvorpå pakken skal hentes
     */
    public void setAfhentningsPostNr(String afhentningsPostNr){
        this.afhentningsPostNr = afhentningsPostNr;
    }
    /**
     *
     * @param leveringsAdresse - sætter adressen hvorpå pakken skal leveres
     */
    public void setLeveringsAdresse(String leveringsAdresse){
        this.leveringsAdresse = leveringsAdresse;
    }
    /**
     *
     * @param leveringsBy - sætter by hvorpå pakken skal leveres
     */
    public void setLeveringsBy(String leveringsBy){
        this.leveringsBy = leveringsBy;       
    }
    
    /**
     *
     * @param leveringsPostNr sætter postNr hvorpå pakken skal leveres
     */
    public void setLeveringsPostNr(String leveringsPostNr){
        this.leveringsPostNr = leveringsPostNr;
    }
    /**
     * checker for om en tur kan oprettes
     */
    public void opretTur(){
        if(this.afhentningsAdresse.equals(null) || this.afhentningsBy.equals(null)  ||  
                this.afhentningsPostNr.equals(null)  || this.leveringsAdresse.equals(null) || this.leveringsBy.equals(null) || 
                this.leveringsPostNr.equals(null) || leveringsKundeNavn.equals(null)||afhentningsKundeNavn.equals(null)){
                System.out.println("de nødvendige turdetajler er ikke indtastet");
        }else{
            
        }
        
    }
    @Override
    public String toString(){
        return "kunde: " + afhentningsKundeNavn + "\n"
                + "adresse: " + afhentningsAdresse + "\n"
                + "telefonnummer: " +telefonNummer + "\n"
                + "leverings adresse " + leveringsAdresse + " " + leveringsBy + " " + leveringsPostNr + "\n"
                + "navn på personen som skal modtage pakken: " + leveringsKundeNavn;
    }
                
}
