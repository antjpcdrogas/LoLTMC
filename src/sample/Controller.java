package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.json.JSONException;

public class Controller  implements Initializable{

    @FXML
    // fx:id="region_box"
     ComboBox<String> region_box;
    @FXML
    Button get_data;
    @FXML
    TextField sum_text;

    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {


        // Initialize your logic here: all @FXML variables will have been injected
        region_box.getItems().clear();
     region_box.getItems().addAll("EUW","EUNE","NA");



        //Ação do botão
        get_data.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                region_box.getValue();
                //System.out.println("->"+sum_text.getText()+"---"+region_box.getValue());
GetRequest getId= new GetRequest();

                try {
                    getId.RequestbyID_CurrentGame("Asd","WUS");
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }


              try {
                 int id=  getId.RequestIdbyName(sum_text.getText(),region_box.getValue());
                    System.out.println("->"+id);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        });



    }


}
