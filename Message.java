import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Message {
    String NomSender;
    String Date;
    String NbrCaractere;
    String Message;

    static File  file = new File("C:\\Users\\FERNANDY ELOKA\\OneDrive\\Documents\\INFR\\MiniChat\\MesInfosSender.log");


    public void Affiche(){

        System.out.println("Message de : "+NomSender+"\n"+"Date envoie : "+Date+"\n"+"Nbr caractere message : "+NbrCaractere+"\n"+"Message : "+Message+"\n");
    }

    public void AjoutMessageFichier(Message message) throws IOException {

        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter dWrite = new FileWriter(file,true);
        BufferedWriter writer = new BufferedWriter(dWrite);
        writer.newLine();
        writer.newLine();
        writer.write("Nom : "+message.NomSender);
        writer.newLine();
        writer.write("Date Envoie : "+message.Date);
        writer.newLine();
        writer.write("Nbr Carctere : "+message.NbrCaractere);
        writer.newLine();
        writer.write("Message : "+message.Message);
        writer.flush();
        writer.close();
    }

}
