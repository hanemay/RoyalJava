/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package royal.tracking;


import java.net.Socket;
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
            
    private static Socket[] userSockets;
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
    public Socket[] getSockets(){
        return this.userSockets;
    }
    public String[] getTimeStamp(){
        return timeLoggedIn;
    }
    private String getTime(){
        Calendar cal = Calendar.getInstance();
    	cal.getTime();
    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    	return sdf.format(cal.getTime());
    }
    public void logoff(Socket socket){
        int arrayIndex;
        String findSocket = socket.toString();
        for(int i = 0; i < userSockets.length; i++){
            if(userSockets[i].toString().equalsIgnoreCase(findSocket)){
                System.out.println(users[i] + " loggede af med " + userSockets[i]);
                arrayIndex = i;
                removeInfo(arrayIndex);
            }
        }
    }
    private void removeInfo(int index){
        boolean thisIndex = false;
        int length = userSockets.length - 1 ;
        String[] tempUsers = new String[length];
        String[] tempTimeStamp = new String[length];
        Socket[] tempSockets = new Socket[length];
        for(int i = 0; i < userSockets.length - 1; i++){
            if(i == index){
                thisIndex = true;
            }
                tempUsers[i] = users[i];
                tempTimeStamp[i] = timeLoggedIn[i];
                tempSockets[i] = userSockets[i];
                if(thisIndex == true){
                    tempUsers[i] = users[i + 1];
                    tempTimeStamp[i] = timeLoggedIn[i + 1];
                    tempSockets[i] = userSockets[i + 1]; 
                }
                
            }
        }
    }

    
       /**
     *
     * @param k
     */
    public void setUserSockets(Socket k){        
           if(userSockets == null){
               userSockets = new Socket[0];

           }          
           if(userSockets.length < 1){
               userSockets = new Socket[1];
               userSockets[0] = k;

               System.out.println(userSockets[0] + " added");
           }
           else{
               int length = userSockets.length + 1;
               Socket[] tempArray = new Socket[length];
               for(int i = 0; i < length; i++){
                   if(i < userSockets.length ){
                       tempArray[i] = userSockets[i];                      
                   }
                   else{
                       tempArray[i] = k;
                   }
               }
                   userSockets = new Socket[length];
                   for(int i = 0; i < length; i++){
                       userSockets[i] = tempArray[i];
                   }
           }                               
       }

    public void setUserCount(String k){
         String loggedInAt = getTime();
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
                       timeLoggedIn[i] = tempTimeStamp[i];
                       users[i] = tempArray[i];
                   }
           }                              
          count++;     
       }
}


