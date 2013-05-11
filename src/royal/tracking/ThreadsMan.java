/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package royal.tracking;


import java.text.SimpleDateFormat;
import java.util.Calendar;
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
    private static String[] timeLoggedIn;
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
    public int getOnlineUsers(){
    return count;
}
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
    public String[] getTimeStamp(){
        return timeLoggedIn;
    }
    private String getTime(){
        Calendar cal = Calendar.getInstance();
    	cal.getTime();
    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        System.out.print("GETTING TIME");
    	return sdf.format(cal.getTime());
    }
    
       /**
     *
     * @param k
     */
    public void setUserCount(String k){
         String loggedInAt = getTime();
        System.out.println("SetUsercount");
           if(users == null){
               users = new String[0];
               timeLoggedIn = new String[0];
           }          
           if(users.length < 1){
               users = new String[1];
               timeLoggedIn = new String[1];
               users[0] = k;
               timeLoggedIn[0] = loggedInAt;
               System.out.println(users[0] + " added");
           }
           else{
               int length = users.length + 1;
               String[] tempArray = new String[length];
               String[] tempTimeStamp = new String[length];
               for(int i = 0; i < length; i++){
                   if(i < users.length ){
                       tempTimeStamp[i] = timeLoggedIn[i];
                       tempArray[i] = users[i];                      
                   }
                   else{
                       tempTimeStamp[i] = loggedInAt;
                       tempArray[i] = k;
                   }
               }
                   timeLoggedIn = new String[length];
                   users = new String[length];
                   for(int i = 0; i < length; i++){
                       System.out.println("Før ;" + users[i] +" nu: " + tempArray[i]);
                       timeLoggedIn[i] = tempTimeStamp[i];
                       users[i] = tempArray[i];
                       System.out.print(users[i] + " is added");
                   }
           }                              
          count++;     
       }
}


