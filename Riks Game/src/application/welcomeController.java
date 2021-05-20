package application;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import logic.Game;
import logic.USmap;

public class welcomeController {
	
	
	 @FXML
	 private Button playButton;
	 private Button simulateButton;
	 
	 
	@FXML 
    void GotoAgentSelectViewPlay(ActionEvent  event) throws IOException 
	{
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("SelectAgent.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        USmap usmap = new USmap();
        Game.setMymap(usmap);

        Game.setMyGameType('P');
        window.setScene(tableViewScene);
        window.show();

	}
	@FXML 
    void GotoAgentSelectViewSim(ActionEvent  event) throws IOException 
	{
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("SelectAgent.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        USmap usmap = new USmap();
        Game.setMymap(usmap);

        Game.setMyGameType('S');
        window.setScene(tableViewScene);
        window.show();

	}
	
}
