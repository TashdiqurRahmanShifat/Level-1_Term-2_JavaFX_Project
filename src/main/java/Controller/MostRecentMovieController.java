package Controller;

import com.example.moviejava.Cinemas;
import com.example.moviejava.HelloApplication;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MostRecentMovieController implements Initializable  {
    public static List<Cinemas> result;
    @FXML
    private TableColumn<Cinemas,Integer > budgetcol;
    @FXML
    private TableColumn<Cinemas, Integer> runtimecol;
    @FXML
    private TableColumn<Cinemas,String> genrecol;
    @FXML
    private TableColumn<Cinemas, String> genre1col;
    @FXML
    private TableColumn<Cinemas, String> genre2col;
    @FXML
    private TableColumn<Cinemas, String> genre3col;
    @FXML
    private TableColumn<Cinemas, String> namecol;
    @FXML
    private TableColumn<Cinemas, Integer> revcol;

    @FXML
    public TableView<Cinemas> table;

    @FXML
    private TableColumn<Cinemas, Integer> yrcol;
    @FXML
    private Label productionName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        namecol.setCellValueFactory(new PropertyValueFactory<Cinemas,String>("name"));
        yrcol.setCellValueFactory(new PropertyValueFactory<Cinemas,Integer>("year"));
        revcol.setCellValueFactory(new PropertyValueFactory<Cinemas,Integer>("revenue"));
        runtimecol.setCellValueFactory(new PropertyValueFactory<Cinemas,Integer>("duration"));
        budgetcol.setCellValueFactory(new PropertyValueFactory<Cinemas,Integer>("budget"));
        genre1col.setCellValueFactory(new PropertyValueFactory<Cinemas,String>("Genre1"));
        genre2col.setCellValueFactory(new PropertyValueFactory<Cinemas,String>("Genre2"));
        genre3col.setCellValueFactory(new PropertyValueFactory<Cinemas,String>("Genre3"));

        for(int i=0;i<HelloApplication.cinemasList.size();i++){
            Cinemas m=HelloApplication.cinemasList.get(i);
            if(m.getProductioncompany().equalsIgnoreCase(WindowController.username))
                productionName.setText(m.getProductioncompany());}
        mostrecentmovie();
        table.setItems(FXCollections.observableList(result));
        table.setOnMouseClicked((MouseEvent event)->{
            if(event.getClickCount()==2){
                String name=table.getSelectionModel().getSelectedItem().getName();
                for(int i=0;i<HelloApplication.cinemasList.size();i++)
                {
                    Cinemas mOVie=HelloApplication.cinemasList.get(i);
                    if(mOVie.getName().equalsIgnoreCase(name))
                    {
                        TrailerController.youtubeLink=mOVie.getYoutubelink();
                        TrailerController.thumbnail=mOVie.getThumbnaillink();
                        try{
                            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Trailer.fxml"));
                            Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
                            Scene scene = new Scene(fxmlLoader.load());
                            stage.setTitle("Movie Database Management");
                            stage.setScene(scene);
                            stage.show();
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }
     public static void mostrecentmovie()
    {
        int yr=0;
        result=new ArrayList<>();
        for (int i = 0; i < HelloApplication.cinemasList.size(); i++) {
            if (HelloApplication.cinemasList.get(i).getProductioncompany().equalsIgnoreCase(WindowController.username)) {
                if (yr <  HelloApplication.cinemasList.get(i).getYear()) {
                    yr = HelloApplication.cinemasList.get(i).getYear();
                }
            }
        }

        for (int i = 0; i < HelloApplication.cinemasList.size(); i++) {
            Cinemas recentcinema =  HelloApplication.cinemasList.get(i);
            if (yr == recentcinema.getYear() && recentcinema.getProductioncompany().equalsIgnoreCase(WindowController.username)) {
                result.add(recentcinema);
            }
        }
    }

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
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Most Recent Movie.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Movie Database Management");
        stage.setScene(scene);
    }
}
