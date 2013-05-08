/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package royal.tracking;

import royal.server.ClientThread;
import royal.server.Server;

/**
 *
 * @author root
 */
public class ThreadsMan {
    private int i;
    public ClientThread[] threads;
  
    private static String[] users;
    public ThreadsMan(){
       
    }
       public void setThreads(ClientThread[] k){
        this.threads[i] = k[i];
    }
       public ClientThread[] getThreads(){
           return this.threads;
       }
       public String[] getUser(){
           return this.users;
           
       }
       public static void setUserCount(String k){
        System.out.println("SetUsercount");
           if(users == null){
               users = new String[Server.count];
           }
           String[] temp = new String[users.length];
          
           if(users.length == 1){
               users = new String[2];
               users[0] = k;
           }
           else{
               int length = users.length + 1;
               String[] tempArray = new String[length];
               for(int i = 0; i < length; i++){
                   if(i < users.length - 1){
                       tempArray[i] = users[i];                      
                   }
                   else{

                       tempArray[i] = k;
                   }
               }
                   users = new String[length];
                   for(int i = 0; i < length - 1; i++){
                       System.out.println("Før ;" + users[i] +" nu: " + tempArray[i]);
                       users[i] = tempArray[i];
                   }
           }                              
          Server.count++;     
       }
}


