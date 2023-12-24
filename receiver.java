
import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class receiver{
    public static void main(String[] args) throws Exception{

//        CREATION DE LA LISTE DES MESSAGES
        List<Message> listMessage=new ArrayList<>();

//        OUVERTURE DU SERVEUR ET RECEPTION DU MESSAGE
        while (true) {


            ServerSocket serv= new ServerSocket(2001);

            Socket recupSock= serv.accept();
            InputStream input = recupSock.getInputStream();
            BufferedReader lecteur = new BufferedReader(new InputStreamReader(input));

            Message message= new Message();

            message.NomSender=lecteur.readLine();
            message.Date=lecteur.readLine();
            message.NbrCaractere=lecteur.readLine();
            message.Message= lecteur.readLine();


            serv.close();


//            AFFICHAGE DU MESSAFE, VERIFICATION DE LA TAILLE DU MESSAGE ET AJOUT A LA LISTE DES MESSAGES
            if(message.NbrCaractere.equals(""+message.Message.length())){
                listMessage.add(message);
                message.Affiche();
                message.AjoutMessageFichier(message);
            }else{

                System.out.println("Attention !!!! Le message a été altéré !");

            }














        }
    }
}
