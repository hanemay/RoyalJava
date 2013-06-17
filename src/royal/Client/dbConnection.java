/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package royal.Client;
import java.sql.*;

/**
 * Client Db connection, en begrænset databaseforbindelse hvor kurerne kan med sætte ture i en tilstand så de tilhøre dem, så hvis de bliver
 * smidt af deres client vil de blive loaded ind i memory når de starter clienten open igen fordi en det første en indlogget klient gør
 * er at forspørge på aktive ture til ens brugernavn.
 * @author Niclas Bade
 */
public class dbConnection{
    private static Connection forbindelse;
    private static int userId = 0;
    private boolean authenticated = false;
    


    /**
     *
     */
    public dbConnection() {
    }
    

    private Connection forbindelse(){    
        Connection forbindelse = null;
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "Royal";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root"; 
        String password = "toor";
        try {
        Class.forName(driver).newInstance();
        forbindelse = DriverManager.getConnection(url+dbName,userName,password);
        this.forbindelse = forbindelse;
        } catch (Exception e) {
        e.printStackTrace();
        } 
        return forbindelse;
    }

    
   
    /**
     *
     * @return
     */
    public Connection sqlForbindelse(){
        Connection forbindelse = forbindelse();
        return forbindelse;
    }

    private Ture getTur(Ture tur){
        return tur;
    }

    /**
     *
     * @return - retunere de ture som er færdige
     * @throws SQLException 
     */
    public Ture[] setUfærdigeTure() throws SQLException{
         Statement st = forbindelse.createStatement();
         ResultSet resultset;
         Ture[] ture = null;
         
         resultset = st.executeQuery("SELECT * FROM  Ture WHERE turAktivitet ='" + "false" +"'");
         
            while (resultset.next()) {
                if(ture == null){
                ture = new Ture[1];
            }
            Ture tur = new Ture();    
            Ture[] tempTure = null;
            tur.setAfhentningsAdresse(resultset.getNString("afhentningsAdresse"));
            tur.setAfhentningsBy(resultset.getNString("afhentningsBy"));
            tur.setAfhentningsPostNr(resultset.getNString("afhentningsPostNr"));
            tur.setAfhentningsKundeNavn(resultset.getNString("afhentningsKundeNavn"));
            tur.setLeveringsAdresse(resultset.getNString("leveringsAdresse"));
            tur.setLeveringsBy(resultset.getNString("leveringsBy"));
            tur.setLeveringsPostNr(resultset.getNString("leveringsPostNr"));
            tur.seteveLingsKundeNavn(resultset.getNString("leveringsKundeNavn"));
            tur.setTelefonNummer(resultset.getNString("telefonNummer"));
            if(ture.length < 2){
                 ture = new Ture[ture.length+1];
                ture[0] = tur;
                tempTure = ture;
            }else{     
                tempTure = ture;                        
              }  
            ture = new Ture[ture.length+1];
            int i;
        
            for( i = 0; i < ture.length-3; i++){
                ture[i] = tempTure[i];
            }ture[i] = tur;
           }
  
return ture;
    }
    
}