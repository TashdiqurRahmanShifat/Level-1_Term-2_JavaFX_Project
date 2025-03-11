package Controller;

import com.example.moviejava.Cinemas;
import com.example.moviejava.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

public class MovieTransferSceneController implements Initializable{


    @FXML
    private ChoiceBox<String> choicebox;
    @FXML
    private ChoiceBox<String>movienames;
    @FXML
    private Label showmsg;

    @FXML
    private void  backclick(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Menu-Scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Movie Database Management");
        stage.setScene(scene);

    }
    @FXML
    private void logoutclick(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Window-Scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Movie Database Management");
        stage.setScene(scene);

    }
    @FXML
    private void refreshclick(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MovieTransfer-Scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Movie Database Management");
        stage.setScene(scene);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Set<String> st=new HashSet<>();
        for(int i=0;i<HelloApplication.cinemasList.size();i++)
        {
            Cinemas k=HelloApplication.cinemasList.get(i);
            st.add(k.getProductioncompany());
        }
        for (String p:st)
        {
            choicebox.getItems().add(p);
        }

        Set<String> movieset=new HashSet<>();
        for(int i=0;i<HelloApplication.cinemasList.size();i++)
        {

            Cinemas MovieName=HelloApplication.cinemasList.get(i);
            if(MovieName.getProductioncompany().equalsIgnoreCase(WindowController.username))
            movieset.add(MovieName.getName());
        }
        for(String s:movieset){
            movienames.getItems().add(s);
        }
    }
    @FXML
    private void OnTransferClick(ActionEvent actionEvent) throws IOException {
       String productioncomName=choicebox.getValue();
       String moviesName=movienames.getValue();
       for(int i=0;i<HelloApplication.cinemasList.size(); i++)
        {
            if(HelloApplication.cinemasList.get(i).getName().equalsIgnoreCase(moviesName))
                HelloApplication.cinemasList.get(i).setProductioncompany(productioncomName);
        }
       if(moviesName==null||productioncomName==null)
       {
           Alert a = new Alert(Alert.AlertType.ERROR);
           a.setHeaderText("Movie Transfer Window");
           a.setContentText("Movie is not transferred");
           a.showAndWait();
           showmsg.setText("You must select movie name & company name");
       }
       else{
        showmsg.setText("You have successfully transferred the movie!");
        Socket socket2=new Socket("127.0.0.1",22226);
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(socket2.getOutputStream());
        objectOutputStream.writeObject("Transfer Movie");
        objectOutputStream.writeObject(productioncomName);
        objectOutputStream.writeObject(moviesName);}

    }

}
