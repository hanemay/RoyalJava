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
public class NewMain {
 public static ClientThread[] threads;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       ThreadsMan k = new ThreadsMan();
       String[] count = k.getUser();
       for(int i = 0; i < count.length; i++){
           System.out.println(count[i].toString());
       }
    }
    
 
}
