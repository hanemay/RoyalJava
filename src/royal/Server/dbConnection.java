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
    
    


    /**
     *
     */
    public dbConnection() {
    }

    private Connection con(String username){    
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "Royal";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root"; 
        String password = "djkolort";
        try {
        Class.forName(driver).newInstance();
        conn = DriverManager.getConnection(url+dbName,userName,password);
        System.out.println(username + " succesfully connected to the db");    

        this.conn = conn;

        } catch (Exception e) {
        e.printStackTrace();
        } 
        return conn;
    }
    /**
     * 
     * @param username
     * @param pw 
     * @throws SQLException 
     */
    public void validate(String username, String pw) throws SQLException{
       boolean go = validateUsername(username);
       boolean pwd = validatePassword(pw);
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
  System.out.println("Emp_code: " + "\t" + "Emp_name: ");
  while (res.next()) {
  userId = res.getInt("idUser");
  String s = res.getString("username");

  }
        return userNamevalidated;
    }
      private boolean validatePassword(String password) throws SQLException{
          System.out.println(userId + " USER ID ID ID");
      boolean truepw = false;
      String tempPwd = null;
      Statement st = conn.createStatement();
      ResultSet res;
            res = st.executeQuery("SELECT * FROM words WHERE idUser ='"+userId+"'");
      while(res.next()){
            tempPwd  = res.getString("pwd");
             System.out.println("PASSWORD = " + tempPwd);
      }
     
      if(password.equals(tempPwd)){
          truepw = true;
          System.out.println("pw er " + truepw);
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
    public Connection connect(String userName){
       Connection conn = con(userName);
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