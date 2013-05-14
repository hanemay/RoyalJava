/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package royal.Client;

import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author root
 */
public class Information {
    private String[] users;
    private int[] userId;
    private int count;
    private String[] loggedIn;
    private String[] sockets;
    public Information(){
        
    } 
    public Information(String info){
        
    }
    public int[] getUserIds(){
        return userId;
    }
    public String[] getTimeLoggedIn(){
        return loggedIn;
    }
    public String[] getUsers(){
        return users;
    }
    public void writeSockets(Socket socket){
        
    }

    public void checkSockets(){
       for(int i = 0; i < sockets.length; i++){
           System.out.println(sockets[i]);
       }
    }
    public void checkReply(String Reply){
        try{
        Scanner scan = new Scanner(Reply);
        count = scan.nextInt();
         
        String checkString = scan.next();
            while(scan.hasNext()){
                if(checkString.equalsIgnoreCase("getUsers")){
                        users = new String[count];
                        loggedIn = new String[count];
                        for(int i = 0; i < users.length; i++){
                            users[i] = scan.next();
                            loggedIn[i] = scan.next();
                        }
                }
                if(checkString.equalsIgnoreCase("getSockets")){
                        sockets = new String[count];
                        for(int i = 0; i < sockets.length; i++){
                            sockets [i] = scan.next();
                        }
                }
      

            }
        }
        catch(InputMismatchException e){
            
        }
    }

    
}
