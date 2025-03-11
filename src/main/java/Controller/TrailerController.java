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
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class TrailerController implements Initializable {
    static String youtubeLink;
    static String thumbnail;
    @FXML
    private WebView webview1;
    @FXML
    private WebView webview2;

    private  WebEngine engine;
    private WebEngine engine1;
    @FXML
    private Label labelfield;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        engine=webview1.getEngine();
        engine1=webview2.getEngine();
        loadpage();
        loadpage1();
        for(int i=0;i<HelloApplication.cinemasList.size();i++){
            Cinemas m=HelloApplication.cinemasList.get(i);
            if(m.getProductioncompany().equalsIgnoreCase(WindowController.username))
                labelfield.setText(m.getProductioncompany());}
    }
    @FXML
    private void  backclick(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Menu-Scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Movie Database Management");
        stage.setScene(scene);
    }
    public void loadpage()
    {
        engine.load(youtubeLink);
    }
    public void loadpage1()
    {
        engine1.load(thumbnail);
    }
}
