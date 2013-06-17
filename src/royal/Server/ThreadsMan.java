/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package royal.Server;


import java.io.IOException;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import royal.Client.Ture;



/**
 * Threadmanageren for servere så vi nemmere kan vælge en client med et nummer "count"
 * @author Niclas Bade
 */
public class ThreadsMan {
    private int i;
    /**
     *antal online
     */
    public static int count = 0;    
    private static Socket[] brugerSockets;
    private static String[] brugere;
    private static String[] tidLoggetInd;
    /**
     * instansiere thread manager
     */
    public ThreadsMan(){
       
    }

       /**
     *
     * @return retunere antal indloggede brugere til beregninger
     */
    public int getOnlineBrugere(){
         return count;
    }
       /**
     *
     * @return returnere strin[] brugere
     */
    public String[] getBrugere(){
           return this.brugere;
           
       }
    /**
     *
     * @return retunere socket sockets[] til bearbejdelse
     */
    public Socket[] getSockets(){
        return this.brugerSockets;
    }
    /**
     *
     * @return retunere String tid[] hvorpå folk er logget ind
     */
    public String[] getTimeStamp(){
        return tidLoggetInd;
    }
    
    private String getTid(){
        Calendar cal = Calendar.getInstance();
    	cal.getTime();
    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    	return sdf.format(cal.getTime());
    }
    /**
     *
     * @param tur 
     * @return  
     */
    
    public Ture tur(Ture tur){
        
        return tur;
    }
    
    /**
     *
     * @param socket logger en socket ud hvis en client formår at gå ud uden af logge ud
     */
    public void logUd(Socket socket){
        int arrayIndex;
        String findSocket = socket.toString();
        for(int i = 0; i < brugerSockets.length; i++){
            if(brugerSockets[i].toString().equalsIgnoreCase(findSocket)){
                System.out.println(brugere[i] + " loggede af med " + brugerSockets[i]);
                arrayIndex = i;
                fjernInfo(arrayIndex);
            }
        }
    }
    /**
     *
     * @param BrugerNavn - når admin logger ind ville brugenavnet ikke logge ud denne metode imødegår det bug med fjernInfo(i) og dræber den socket
     * @throws IOException
     */
    public void checkForKopi(String BrugerNavn) throws IOException{
        try{
        for(int i = 0; i < brugere.length; i++){
           
            if(brugere[i].equalsIgnoreCase(BrugerNavn)){
                brugerSockets[i].close();
                 System.out.println("brugeren der skal fjerns er " + brugere[i]);
                fjernInfo(i);
            }
        }
        }
        catch(NullPointerException e){
            
        }
    }
    
    private void fjernInfo(int index){
        int seed = 0;
        int length = brugerSockets.length - 1 ;
        String[] tempBrugere = new String[length];
        String[] tempTidsStempler = new String[length];
        Socket[] tempSockets = new Socket[length];
        for(int i = 0; i < brugerSockets.length - 1; i++){
                if(i == index){
                    index = -1;
                    i -= 1;
                    seed = 1;
                }else{
                    tempBrugere[i] = brugere[i+seed];
                    tempTidsStempler[i] = tidLoggetInd[i+seed];
                    tempSockets[i] = brugerSockets[i+seed];
                }
            }
        brugere = tempBrugere;
        tidLoggetInd = tempTidsStempler;
        brugerSockets = tempSockets;
        count--;
        }
       /**
     * 
     * @param socket tilføjer et brugersocket til listen. 
     */
    public void setBrugerSockets(Socket socket){        
           if(brugerSockets == null){
               brugerSockets = new Socket[0];

           }          
           if(brugerSockets.length < 1){
               brugerSockets = new Socket[1];
               brugerSockets[0] = socket;

               System.out.println(brugerSockets[0] + " added");
           }
           else{
               int length = brugerSockets.length + 1;
               Socket[] tempArray = new Socket[length];
               for(int i = 0; i < length; i++){
                   if(i < brugerSockets.length ){
                       tempArray[i] = brugerSockets[i];                      
                   }
                   else{
                       tempArray[i] = socket;
                   }
               }
                   brugerSockets = new Socket[length];
                   for(int i = 0; i < length; i++){
                       brugerSockets[i] = tempArray[i];
                   }
           }   
          printSockets();
       }

    /**
     * printer sockets 
     */
    public void printSockets(){
         for(int i = 0; i < brugere.length; i++){
               System.out.print("brugernavn,id,socket" + brugere[i] + " " +i+" " + brugerSockets[i].toString());
         }
           }


    /**
     *
     * @param brugerNavn tilføjer et brugernavn til listen samt tidstempel.
     */
    public void tilføjBruger(String brugerNavn){
         String loggedInAt = getTid();
           if(brugere == null){
               brugere = new String[0];
               tidLoggetInd = new String[0];
           }          
           if(brugere.length < 1){
               brugere = new String[1];
               tidLoggetInd = new String[1];
               brugere[0] = brugerNavn;
               tidLoggetInd[0] = loggedInAt;
               System.out.println(brugere[0] + " added");
           }
           else{
               int length = brugere.length + 1;
               String[] tempArray = new String[length];
               String[] tempTimeStamp = new String[length];
               for(int i = 0; i < length; i++){
                   if(i < brugere.length ){
                       tempTimeStamp[i] = tidLoggetInd[i];
                       tempArray[i] = brugere[i];                      
                   }
                   else{
                       tempTimeStamp[i] = loggedInAt;
                       tempArray[i] = brugerNavn;
                   }
               }
                   tidLoggetInd = new String[length];
                   brugere = new String[length];
                   for(int i = 0; i < length; i++){
                       tidLoggetInd[i] = tempTimeStamp[i];
                       brugere[i] = tempArray[i];
                   }
           }             
          count++;     
       }
}


