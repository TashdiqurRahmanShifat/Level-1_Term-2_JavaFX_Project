package Controller;

import com.example.moviejava.Cinemas;
import com.example.moviejava.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuSceneController implements Initializable {


    @FXML
    private Label LabelName;
    @FXML
    private void  backclick(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Main-Scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Movie Database Management");
        stage.setScene(scene);

    }
    @FXML
    private void  allmovieslistclick(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AllMovies.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Movie Database Management");
        stage.setScene(scene);

    }

    public void onmaximumrevenueclick(ActionEvent actionEvent)throws IOException {
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MostMaximumRevenue.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Movie Database Management");
        stage.setScene(scene);
    }

    public void OnRecentMovieclick(ActionEvent actionEvent) throws IOException{
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Most Recent Movie.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Movie Database Management");
        stage.setScene(scene);

    }
    public void OnTotalProfitClick(ActionEvent actionEvent) throws IOException{
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("TotalProfit-Scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Movie Database Management");
        stage.setScene(scene);
    }

    public void OnAddMovieClick(ActionEvent actionEvent) throws IOException{
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Addmovie.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Movie Database Management");
        stage.setScene(scene);
    }
    public void Ontransferclick(ActionEvent actionEvent) throws IOException{
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MovieTransfer-Scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Movie Database Management");
        stage.setScene(scene);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        for(int i=0;i<HelloApplication.cinemasList.size();i++){
            Cinemas m=HelloApplication.cinemasList.get(i);
            if(m.getProductioncompany().equalsIgnoreCase(WindowController.username))
                LabelName.setText(m.getProductioncompany());
        }


    }
}
