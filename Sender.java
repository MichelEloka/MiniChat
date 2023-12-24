
import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Sender {
    public static void main(String[] args) throws Exception {

//        INITIALISATION DU NOM SU SENDER, RECUPERATION DE L'HEURE ACTUELLE ET RECUPERATION DES ADRESSES IP
        CarnetAdresses.LireCarnet();
        String name= "Eloka";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

//        CONNEXION AUX SERVEURS DES RECEIVER ET ENVOIE DU MESSAGE
        while (true) {

            int i=0;
            System.out.println("Entrez Votre message");
            Scanner scMsg= new Scanner(System.in);
            String msg = scMsg.nextLine();

//            ENVOIE A UN ADDRESS IP A PARTIR DU TABLEAU D'ADDRESS DE LA CLASSE Carnet Adresse
            while (i!=CarnetAdresses.tabIP.size()-1) {
                Boolean verificateurDeConnexion= true;
                Socket sock2 = null;
                try {
                    sock2 = new Socket(CarnetAdresses.tabIP.get(i), 2001);
                } catch (IOException e1) {
                    System.out.println(CarnetAdresses.tabIP.get(i)+ " est deconnecté");
                    verificateurDeConnexion =false;
                }

                if(verificateurDeConnexion) {
                    OutputStream output = sock2.getOutputStream();
                    BufferedWriter ecriveur = new BufferedWriter(new OutputStreamWriter(output));

                    ecriveur.write(name);
                    ecriveur.newLine();

                    ecriveur.write(dtf.format(LocalDateTime.now()));
                    ecriveur.newLine();

                    ecriveur.write(Integer.toString(msg.length()));
                    ecriveur.newLine();


                    ecriveur.write(msg);


                    ecriveur.close();
                    sock2.close();


                }

                i++;
            }


              // scMsg.close();

            



            
        }
    }
}