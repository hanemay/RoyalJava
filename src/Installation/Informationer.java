/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Installation;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class Informationer {
    private String dbIp = null;
    private String dbPort = null;
    private String brugerFil = null;
    private String dbNavn = null;
    private String serverIp;
    private boolean dbTest = false;
    public Informationer(){
        Scanner scan = new Scanner(System.in);
        Skriv("MySql server information");
        Skrive("Databasens ip: ");
        dbIp = scan.next(); 
        Skrive("Porten til databasen: ");
        dbPort = scan.next();
        Skrive("Databasens navn: ");
        dbNavn = scan.next();
        Skriv("tester database forbindelse");
        if(dbTest = false){
            Skriv("databasen er ikke sat op til programmet skal systemet gøre det ? j/n: ");
            String svar = scan.next();
            if(svar.equals("j")){
                //Server.setupdb()
            }
        }
        Skriv("Hvad er skal serverens ip være ? typisk serverens lokal ip på netværket: ");
        serverIp = scan.next();
        Skriv("skal programmet sætte systemets bruger database op eller vil du gør det manuelt ? j/n: ");
        String svar = scan.next();
        if(svar.equals("j")){
            Skrive("skriv filens navn med bruger navne hvor de er sat op med brugernavn først og kodeord\n bagefter skifter linjer ved hver bruger");
            brugerFil = scan.next();
            //dbConnection.opretBruger(brugerFil, serverIp);
            /**
             * if(db.connection.Brugerstatus == true){
             * dbTest = true;
             * }
             * else{
             * skriv("testen fejlede");
             * }
             * 
             */
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter("Config.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Informationer.class.getName()).log(Level.SEVERE, null, ex);
        }

        out.write("dbIp = " + dbIp +"\n");
        out.write("dbPort = " + dbPort+"\n");
        out.write("dbNavn  = " + dbNavn+"\n");       
        out.write("serverIp = " + serverIp+"\n");
        out.close();
        
    }

    private static void Skrive(String besked){
        System.out.print(besked);
    }

    private static void Skriv(String besked){
        System.out.println(besked);
    }
}
