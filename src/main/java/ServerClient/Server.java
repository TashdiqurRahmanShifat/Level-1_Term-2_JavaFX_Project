package ServerClient;

import com.example.moviejava.Cinemas;
import com.example.moviejava.Fileoperation;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
public class Server {
    public static List<Cinemas>movielist;

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(22226);
        System.out.println("Server Started..");
        Server.movielist = new ArrayList<>();
        Fileoperation fileoperation = new Fileoperation();
        fileoperation.readfile();


        while (true) {
            Socket socket = serverSocket.accept();
            ThreadServer threadServer=new ThreadServer(socket);
        }
    }
}
class ThreadServer implements Runnable
{

    Socket socketclient;
    Thread thread;
    ThreadServer(Socket socketclient)
    {

        this.socketclient=socketclient;
        thread=new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                ObjectInputStream ois = new ObjectInputStream(socketclient.getInputStream());
                String type = (String) ois.readObject();
                try {
                    if (type.equals("read")) {

                        ObjectOutputStream oos = new ObjectOutputStream(socketclient.getOutputStream());
                        List<Cinemas>Newcinema= Server.movielist;
                        oos.writeObject(Newcinema);
                    } else if (type.equals("add movie")) {
                        Cinemas Movie = (Cinemas) ois.readObject();

                        Server.movielist.add((Movie));
                    }
                    else if(type.equals("Transfer Movie"))
                    {
                        String getcompany=(String) ois.readObject();
                        String getmovie=(String) ois.readObject();

                      for(int i=0;i< Server.movielist.size();i++)
                      {
                          Cinemas d=Server.movielist.get(i);
                          if(getmovie.equalsIgnoreCase(d.getName()))
                              d.setProductioncompany(getcompany);
                      }
                    }
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }catch (Exception e){}
        }
    }
}