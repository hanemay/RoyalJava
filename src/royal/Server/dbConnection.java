/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package royal.Server;
import java.sql.*;

/**
 * Serverens database managemen med adgang til brugernavn og kodeord så den kan give svar tilbage til en klient om den er logget ind, ellers bliver der ikke åbnet for socket
 * @author root
 */
public class dbConnection{
    private static Connection forbindelse;
    private static int brugerId = 0;
    private boolean authenticated = false;
    


    /**
     * instans af dbconnection
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
     * @param brugerNavn - brugernavn der skal bruges
     * @param kodeord - kodeord som skal valideres
     * @return retunere om brugeren har tilladelse til at logge ind, true/false
     * @throws SQLException
     */
    public boolean getState(String brugerNavn, String kodeord) throws SQLException{
        Valider(brugerNavn,kodeord);
        return authenticated;
    }
    /**
     * 
     * @param brugerNavn - brugernavn som skal valideres
     * @param kodeord kodeord som skal valideres
     * @throws SQLException authenthicated
     */
    public void Valider(String brugerNavn, String kodeord) throws SQLException{
       boolean brugerNavnStatus = false;
        brugerNavnStatus = validerBrugernavn(brugerNavn);
       boolean pwd = false;
        pwd = validerKodeord(kodeord);
       if(brugerNavnStatus != true )authenticated = false;
       else {
            if(pwd != false){
            authenticated = true;
            }
            else{
                authenticated = false;
            }
        }
    }
    
    /**
     * 
     * @param brugerNavn - brugernavnet som skal testes om eksistere i databasen
     * @return retunere true hvis brugernavnet eksistere
     * @throws SQLException 
     */
    private boolean validerBrugernavn(String brugerNavn) throws SQLException{
        boolean brugerNavnValideret = false;
         Statement st = forbindelse.createStatement();
         ResultSet res;
        res = st.executeQuery("SELECT * FROM  Users WHERE username ='" + brugerNavn+"'");
            while (res.next()) {
            brugerId = res.getInt("idUser");
            String s = res.getString("username");
            if(s.equals(brugerNavn)){
               brugerNavnValideret = true;
            }
        }
  
        return brugerNavnValideret;
    }
    private boolean validerKodeord(String kodeord) throws SQLException{
        boolean godkendtKodeord = false;
        String midlertidigKodeord = null;
        Statement st = forbindelse.createStatement();
        ResultSet res;
              res = st.executeQuery("SELECT * FROM words WHERE idUser ='"+brugerId+"'");
        while(res.next()){
              midlertidigKodeord  = res.getString("pwd");
        }

        if(kodeord.equals(midlertidigKodeord)){
            godkendtKodeord = true;
            return godkendtKodeord;
        }
        else{
            return godkendtKodeord;
        }
    }
    private String[] returnerRettigheder(String username){
        String[] credentials = new String[2];
        credentials[0] = username;
        return credentials;
    }
    /**
     *
     * @return retunere en forbindelse til databasen
     */
    public Connection fobind(){
        Connection forbindelse = forbindelse();
        return forbindelse;
    }

    /**
     *
     * @param userName
     */

    
}