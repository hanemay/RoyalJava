/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package royal.tracking;

import java.sql.Connection;
import java.sql.SQLException;
import royal.Server.dbConnection;



/**
 *
 * @author root
 */
public class NewMain {

    /**
     *
     * @param args
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException {
dbConnection k = new dbConnection();
Connection con = k.connect("hanemay");
k.validate("hanemay", "djkolort");



        //ThreadsMan k = new ThreadsMan();
       //String[] count = k.getUser();
       //for(int i = 0; i < count.length; i++){
         //  System.out.println(count[i].toString());
       //}
    }
    
 
}
