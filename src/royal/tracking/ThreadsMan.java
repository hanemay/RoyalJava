/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package royal.tracking;

import royal.server.ClientThread;

/**
 *
 * @author root
 */
public class ThreadsMan {
    private int i;
    public ClientThread[] threads;
  
    private String[] users;
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
       public void setUserCount(String k){
        
           if(users == null){
               users = new String[1];
           }
           String[] temp = new String[users.length];
          
           if(users.length == 1){
               System.out.println("user length første omgang" + users.length);
               users = new String[2];
               System.out.println("user length anden omgang" + users.length);
               users[0] = k;
               System.out.println("user[0] trdje length" + users.length );
           }
           else{
               int length = users.length + 1;
               System.out.println("");
               String[] tempArray = new String[length];
               for(int i = 0; i < length; i++){
                   if(i < users.length){
                       tempArray[i] = users[i];
                       
                   }
                   else{
                       tempArray[i] = k;
                   }

               }
                   users = new String[length];
                   for(int i = 0; i < length; i++){
                       System.out.println("Før ;" + users[i] +" nu: " + tempArray[i]);
                       users[i] = tempArray[i];
                   }
           }
           
          
           
               
           }
       }


