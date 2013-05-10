/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package royal.Client;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author root
 */
public class Information {
    public String[] users;
    public Information(){
        
    } 
    public Information(String info){
        
    }
    public String[] getUsers(){
        return users;
    }
    public void checkReply(String Reply){
        try{
        Scanner scan = new Scanner(Reply);
         int count = scan.nextInt();
        String checkString = scan.next();
        while(scan.hasNext()){
            if(checkString.equalsIgnoreCase("getUsers")){
                    users = new String[count];
                    for(int i = 0; i < users.length; i++){
                        users[i] = scan.next();
                    }
            }
        }
        }
        catch(InputMismatchException e){
            
        }
    }

    
}
