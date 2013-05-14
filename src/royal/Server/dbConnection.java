/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package royal.Server;
import java.sql.*;

/**
 *
 * @author root
 */
public class dbConnection{
    private static Connection conn;
    private static int userId = 0;
    private boolean authenticated = false;
    


    /**
     *
     */
    public dbConnection() {
    }
    

    private Connection con(){    
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "Royal";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root"; 
        String password = "djkolort";
        try {
        Class.forName(driver).newInstance();
        conn = DriverManager.getConnection(url+dbName,userName,password);
  

        this.conn = conn;

        } catch (Exception e) {
        e.printStackTrace();
        } 
        return conn;
    }
    
    public boolean getState(String username, String pw) throws SQLException{
        validate(username,pw);
        return authenticated;
    }
    /**
     * 
     * @param username
     * @param pw 
     * @throws SQLException authenthicated
     */
    public void validate(String username, String pw) throws SQLException{
       boolean go = false;
        go = validateUsername(username);
       boolean pwd = false;
        pwd = validatePassword(pw);
       if(go != true )authenticated = false;
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
     * @param username
     * @return
     * @throws SQLException 
     */
    private boolean validateUsername(String username) throws SQLException{
        boolean userNamevalidated = false;
         Statement st = conn.createStatement();
         ResultSet res;
        res = st.executeQuery("SELECT * FROM  Users WHERE username ='" + username+"'");
            while (res.next()) {
            userId = res.getInt("idUser");
            String s = res.getString("username");
            if(s.equals(username)){
               userNamevalidated = true;
            }
        }
  
        return userNamevalidated;
    }
    private boolean validatePassword(String password) throws SQLException{
        boolean truepw = false;
        String tempPwd = null;
        Statement st = conn.createStatement();
        ResultSet res;
              res = st.executeQuery("SELECT * FROM words WHERE idUser ='"+userId+"'");
        while(res.next()){
              tempPwd  = res.getString("pwd");
        }

        if(password.equals(tempPwd)){
            truepw = true;
            return truepw;
        }
        else{
            return truepw;
        }
    }
    private String[] returnCredentials(String username){
        String[] credentials = new String[2];
        credentials[0] = username;
        return credentials;
    }
    /**
     *
     * @param userName
     * @return
     */
    public Connection connect(){
        Connection conn = con();
        return conn;
    }

    /**
     *
     * @param userName
     */
    public dbConnection(String userName) {
         
    }

    /**
     *
     */
    public void validate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}