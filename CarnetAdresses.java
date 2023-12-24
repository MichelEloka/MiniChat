import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CarnetAdresses {




    static ArrayList<String> tabIP = new ArrayList<String>();
    public CarnetAdresses() throws FileNotFoundException {
    }

    static public void LireCarnet() throws IOException {
        String line= "Initialisation";
        FileReader ipChat= new FileReader("IPmv.txt");

        BufferedReader ipChatRead = new BufferedReader(ipChat);
        while (line !=null) {
            line= ipChatRead.readLine();
            tabIP.add(line);

        }
        ipChatRead.close();
    }
}
