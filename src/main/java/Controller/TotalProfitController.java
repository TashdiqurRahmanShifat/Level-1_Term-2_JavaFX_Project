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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TotalProfitController implements Initializable {

    @FXML
    private Label currencyfield;
    @FXML
    private ImageView image;
    @FXML
    private Label label;
    @FXML
    private void  backclick(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Menu-Scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Movie Database Management");
        stage.setScene(scene);

    }
    @FXML
    private void  refreshclick(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("TotalProfit-Scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Movie Database Management");
        stage.setScene(scene);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        long Totalprofit = 0;
        int flag3 = 0;
        for (int i = 0; i <HelloApplication.cinemasList.size(); i++) {
            Cinemas tprofit=HelloApplication.cinemasList.get(i);
            if (tprofit.getProductioncompany().equalsIgnoreCase(WindowController.username)) {
                Totalprofit += tprofit.getRevenue() - tprofit.getBudget();
                flag3 = 1;
            }
        }
        if(flag3==1)
        {
            currencyfield.setText(String.valueOf(Totalprofit));
        }
        for(int i=0;i<HelloApplication.cinemasList.size();i++){
            Cinemas m=HelloApplication.cinemasList.get(i);
            if(m.getProductioncompany().equalsIgnoreCase(WindowController.username))
                label.setText(m.getProductioncompany());
        }

    }
}
