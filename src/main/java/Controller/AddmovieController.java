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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;


public class AddmovieController implements Initializable {

    @FXML
    private TextField genre1bar;

    @FXML
    private TextField genre2bar;

    @FXML
    private TextField genre3bar;

    @FXML
    private TextField moviebudgetbar;

    @FXML
    private TextField movierevenuebar;

    @FXML
    private TextField movietitlebar;

    @FXML
    private TextField releasingyearbar;

    @FXML
    private TextField runtimebar;
    @FXML
    private Label showmessage;
    @FXML
    private Label label;
    @FXML
    private void backclick(ActionEvent actionEvent)throws IOException {
        Stage stage= (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Menu-Scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load() );
        stage.setTitle("Movie Database Management");
        stage.setScene(scene);
        //stage.show();
    }
    @FXML
    private void logoutclick(ActionEvent actionEvent)throws IOException {
        Stage stage= (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Window-Scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load() );
        stage.setTitle("Movie Database Management");
        stage.setScene(scene);
        //stage.show();
    }

    @FXML
     private void saveclick(ActionEvent actionEvent)throws IOException{

        int flag=0,flag1=0,flag2=0,flag3=0,flag4=0;

        if(movietitlebar.getText().isEmpty()||releasingyearbar.getText().isEmpty()||runtimebar.getText().isEmpty()
        ||moviebudgetbar.getText().isEmpty()||movierevenuebar.getText().isEmpty()
        ||(genre1bar.getText().isEmpty()&&genre2bar.getText().isEmpty()&&genre3bar.getText().isEmpty()))
        {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("Add Movie Window");
            a.setContentText("Movie is not added");
            a.showAndWait();
            showmessage.setText("You can only keep any two of the three genre empty");
            flag=1;
        }
        if(flag==0)
        {
            try{
                Integer.parseInt(releasingyearbar.getText());
            }
            catch (NumberFormatException e)
            {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setHeaderText("Add Movie Window");
                a.setContentText("Movie is not added");
                a.showAndWait();
                showmessage.setText("You have to put numerical value in the Release Year field");
                flag1 = 1;
            }
        }
        if(flag==0&&flag1==0)
        {
            try{
                Integer.parseInt(runtimebar.getText());
            }
            catch (NumberFormatException e)
            {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setHeaderText("Add Movie Window");
                a.setContentText("Movie is not added");
                a.showAndWait();
                showmessage.setText("You have to put numerical value in the Movie Duration field");
                flag2 = 1;
            }
        }
        if(flag==0&&flag1==0&&flag2==0)
        {
            try{
                Integer.parseInt(moviebudgetbar.getText());
            }
            catch (NumberFormatException e)
            {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setHeaderText("Add Movie Window");
                a.setContentText("Movie is not added");
                a.showAndWait();
                showmessage.setText("You have to put numerical value in the Movie Budget field");
                flag3 = 1;
            }
        }
        if(flag==0&&flag1==0&&flag2==0&&flag3==0)
        {
            try{
                Integer.parseInt(movierevenuebar.getText());
            }
            catch (NumberFormatException e)
            {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setHeaderText("Add Movie Window");
                a.setContentText("Movie is not added");
                a.showAndWait();
                showmessage.setText("You have to put numerical value in the Movie Revenue field");
                flag4 = 1;
            }
        }
        if(flag1==0&&flag2==0&&flag3==0&&flag4==0)
        {
            Cinemas newcinema=new Cinemas();
            newcinema.setName(movietitlebar.getText());
            newcinema.setYear(Integer.parseInt(releasingyearbar.getText()));
            newcinema.setGenre1(genre1bar.getText());
            newcinema.setGenre2(genre2bar.getText());
            newcinema.setGenre3(genre3bar.getText());
            newcinema.setDuration(Integer.parseInt(runtimebar.getText()));
            newcinema.setBudget(Integer.parseInt(moviebudgetbar.getText()));
            newcinema.setRevenue(Integer.parseInt(movierevenuebar.getText()));
            newcinema.setProductioncompany(WindowController.username);

        HelloApplication.cinemasList.add(newcinema);


        Socket socket1=new Socket("127.0.0.1",22226);

        ObjectOutputStream objectOutputStream=new ObjectOutputStream(socket1.getOutputStream());

        objectOutputStream.writeObject("add movie");
        objectOutputStream.writeObject(newcinema);
        showmessage.setText("Congratulations!You have successfully added a movie");
        }
//      public static boolean check(String str)
//        {
//            int x;
//            if(x=Integer.parseInt(str))
//        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for(int i=0;i<HelloApplication.cinemasList.size();i++){
            Cinemas m=HelloApplication.cinemasList.get(i);
            if(m.getProductioncompany().equalsIgnoreCase(WindowController.username))
                label.setText(m.getProductioncompany());
    }}
}
