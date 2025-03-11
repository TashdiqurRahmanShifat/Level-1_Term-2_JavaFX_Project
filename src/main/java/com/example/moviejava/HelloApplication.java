package com.example.moviejava;

import Controller.AllMoviesController;
import Controller.MostRecentMovieController;
import Controller.MovieWithMaxRevenue;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.util.List;




public class HelloApplication extends Application {
    public static List<Cinemas>cinemasList;
    @Override
    public void start(Stage stage) throws IOException {
        Thread t = new Thread(new myThread());
        t.start();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Window-Scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Movie Database Management");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(true);
        stage.setOnCloseRequest(event -> {
//            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
//            alert.setTitle("Exit");
//            alert.setHeaderText("You're about to exit!");
//            alert.setContentText("Do you want to save before exiting?");
//            if(alert.showAndWait().get()== ButtonType.OK)
//            {

            try {

                BufferedWriter bw = new BufferedWriter(new FileWriter("movies.txt"));
                for(int i = 0; i< HelloApplication.cinemasList.size(); i++)
                {
                    bw.write(HelloApplication.cinemasList.get(i).getName()+","+HelloApplication.cinemasList.get(i).getYear()+","+HelloApplication.cinemasList.get(i).getGenre1()+","+HelloApplication.cinemasList.get(i).getGenre2()+","+
                            HelloApplication.cinemasList.get(i).getGenre3()+","+HelloApplication.cinemasList.get(i).getDuration()+","+HelloApplication.cinemasList.get(i).getProductioncompany()+","+
                            HelloApplication.cinemasList.get(i).getBudget()+","+HelloApplication.cinemasList.get(i).getRevenue());
                    bw.write(System.lineSeparator());
                }
                bw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
         //   }


        });
    }


    public static void main(String[] args)throws IOException
    {
        launch();
    }
}
class myThread implements Runnable{

    @Override
    public void run() {
        while(true) {
            try {

                Socket socket = new Socket("127.0.0.1", 22226);
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                oos.writeObject("read");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Object fromServer = ois.readObject();
                HelloApplication.cinemasList=(List<Cinemas>) fromServer;

                MostRecentMovieController.mostrecentmovie();
                MovieWithMaxRevenue.movierevenue();
                AllMoviesController.aLLmovie();

            }catch (Exception e){}
        }
    }
}