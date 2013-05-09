/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package royal.tracking;


import royal.Server.Server;


/**
 *
 * @author root
 */
public class ThreadsMan {
    private int i;
    /**
     *
     */
    public static int count = 0;
    /**
     *
     */
    public  Server[] threads;
            
  
    private static String[] users;
    /**
     *
     */
    public ThreadsMan(){
       
    }
       /**
     *
     * @param k
     */
    public void setThreads(Server[] k){
        this.threads[i] = k[i];
    }
       /**
     *
     * @return
     */
    public Server[] getThreads(){
           return this.threads;
       }
       /**
     *
     * @return
     */
    public String[] getUser(){
           return this.users;
           
       }
       /**
     *
     * @param k
     */
    public void setUserCount(String k){
        System.out.println("SetUsercount");
           if(users == null){
               users = new String[1];
               
           }
           String[] temp = new String[users.length];
          
           if(users.length == 1){
               users = new String[2];
               users[0] = k;
               System.out.println(users[0] + " added");
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
                       System.out.print(users[i] + " is added");
                   }
           }                              
          count++;     
       }
}


