/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package royal.Client;

import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Den klasse som retunere informationer og gemmer dem til bearbejdelse for en eventuel indlogget administrator
 * @author Niclas Bade
 */
public class Information {
    private String[] brugere;
    private int[] brugerId;
    private int Antal;
    private String[] tidLoggetInd;
    private String[] sockets;
    private static OnlineKlienter[] klienter = null;
    /**
     *
     */
    public Information(){
        
    } 

    /**
     *
     * @return  retunere onlineKlienter[]
     */

    public OnlineKlienter[] getKlienter(){
        return klienter;
    }
    /**
     *
     * @return - retunere antal onlline klientere i et String[]
     */
    public String[] getBrugere(){
        return brugere;
    }
    /**
     *
     * @param socket
     */
    public void skrivSockets(Socket socket){
        
    }

    /**
     *
     * @param modtagetSvar - det svar fra serveren som man har fået på sin forspørgelsel.
     */
    public void checkSvar(String modtagetSvar){
        try{
        Scanner scan = new Scanner(modtagetSvar);
        Antal = scan.nextInt();
      
        String checkString = scan.next();
        klienter = new OnlineKlienter[Antal];
            while(scan.hasNext()){
                if(checkString.equalsIgnoreCase("getUsers")){  
                    
                        for(int i = 0; i < klienter.length; i++){
                            String user = scan.next();
                            String timeStamp = scan.next();
                            System.out.println("USER !!!!  !!! !! !! ! ! !  ======= " + user + "\n skal tilføjes til clients [" + i +"]");
                            OnlineKlienter k = new OnlineKlienter();
                            k.setBrugernavn(user);
                            k.setTidLoggetInd(timeStamp);
                            klienter[i] = k;
                        }
                }
                if(checkString.equalsIgnoreCase("getSockets")){
                        sockets = new String[Antal];
                        for(int i = 0; i < klienter.length; i++){
                            klienter[i].setSocket(scan.next());
                            klienter[i].setBrugerId(i);
                        }
                }
            }
        }
        catch(InputMismatchException e){
            
        }
    }

    
}
