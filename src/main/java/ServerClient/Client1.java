package ServerClient;

import com.example.moviejava.Cinemas;
import com.example.moviejava.HelloApplication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Client1 {

    public void read()throws IOException

    {

        Socket socket = new Socket("127.0.0.1", 22226);

        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        try
        {
            oos.writeObject("read");

            Object fromServer = ois.readObject();
            HelloApplication.cinemasList=new ArrayList<>((List<Cinemas>) fromServer);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

