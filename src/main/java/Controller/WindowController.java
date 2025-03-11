package Controller;

import com.example.moviejava.Cinemas;
import com.example.moviejava.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WindowController {


    static List<Cinemas> comname=new ArrayList<>();
    static String username="";
    @FXML
    private TextField userText;
    @FXML
    private PasswordField passwordText;


    public static void transfer() {
        for(int i=0;i<HelloApplication.cinemasList.size();i++)
        {
            Cinemas name=HelloApplication.cinemasList.get(i);
            if(name.getProductioncompany().equalsIgnoreCase(username))
                comname.add(name);
        }
    }

    @FXML
    private void submit(ActionEvent event) throws IOException
    {
        username = userText.getText();
        String password = passwordText.getText();
        Set<String> st=new HashSet<>();

        int flag=0;
            for(int i = 0; i< HelloApplication.cinemasList.size(); i++)
            {
                Cinemas k=HelloApplication.cinemasList.get(i);
                st.add(k.getProductioncompany());
            }
            for(String sname:st)
            {
                if (username.equalsIgnoreCase(sname) && password.equals("1234")) {
                    Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                    a.setHeaderText("Login Window");
                    a.setContentText("Login successful");
                    a.showAndWait();
                    flag=1;
                    Stage stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Main-Scene.fxml"));

                    Scene scene = new Scene(fxmlLoader.load() );
                    stage.setTitle("Movie Database Management");
                    stage.setScene(scene);

                }


            }
            if(flag==0)
            {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setHeaderText("Login Window");
                a.setContentText("Login unsuccessful");
                a.showAndWait();
            }
    }
}


