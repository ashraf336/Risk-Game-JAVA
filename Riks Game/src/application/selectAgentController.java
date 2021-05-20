package application;
import java.awt.Desktop.Action;
import java.io.IOException;

import aiAgents.AstarAgent;
import aiAgents.GreedyAgent;
import aiAgents.MinMax;
import aiAgents.RealTimeAStar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import logic.Game;
import nonAiAgents.AgreesiveAgent;
import nonAiAgents.NearlyPacifistAgent;
import nonAiAgents.NonAiAgents;
import nonAiAgents.PassiveAgent;
import players.HumanPlayer;
import players.player;



public class selectAgentController {
	private boolean passiveAgent;
	private boolean aggresiveAgent;
	private boolean pacifistAgent;
	private boolean greedyAgent;
	private boolean astarAgent;
	private boolean realtimeastarAgent;
	private boolean minimaxAgent;
	
		
	private int player1Type,player2Type;
	//"1"-> passive
	//"2" -> aggressive
	//"3" -> pacifist
	//"4" -> greedy
	//"5" -> astar
	//"6" -> realtimeAstar
	//"7" -> minimax
	
	private int playerNum=1; //defult is player number1
	
	private char gameMode ; // "P" -> play , "S" -> simulation 
	
	@FXML
	private Label playerNumLabel;
	
	
	@FXML
	void selectPassiveAgent(ActionEvent event) throws IOException
	{
		nextplayer( 1, event);
		
	}
	@FXML
	void selectAggrissiveAgent(ActionEvent event) throws IOException
	{
		nextplayer(2,event);
	}
	@FXML
	void selectPacifistAgent(ActionEvent event) throws IOException
	{
		nextplayer(3,event);
	}
	@FXML
	void selectgreedyAgent(ActionEvent event) throws IOException
	{
		nextplayer(4,event);
	}
	@FXML
	void selectAstarAgent(ActionEvent event) throws IOException
	{
		nextplayer(5,event);
	}
	@FXML
	void selectRealtimeAstarAgent(ActionEvent event) throws IOException
	{
		nextplayer(6,event);
	}
	@FXML
	void selectMinimaxAgent(ActionEvent event) throws IOException
	{
		nextplayer(7,event);
	}
	
	
	
	void nextplayer ( int playerType,ActionEvent event ) throws IOException
	{
		this.playerNum++;
		this.gameMode=Game.getMyGameType();
		
		
		/**playing mode**/
		 if ( playerNum>1 && this.gameMode=='P')
		{
			this.player2Type= playerType;
			player player1 = new HumanPlayer(Game.getMymap().getP1_terrs());
			Game.setMyplayer1(player1);
			Game.setMyplayer2(createNewPlayer2(playerType));
			GameController.display();
			player1.setBonusArmy(Game.calcBouns(player1));
			System.out.println("Player1 bonus "+player1.getBonusArmy());

			Parent tableViewParent = FXMLLoader.load(getClass().getResource("gamemap.fxml"));
	        Scene tableViewScene = new Scene(tableViewParent);

	        //This line gets the Stage information
	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

	        window.setScene(tableViewScene);
	        window.show();			


		}
		 
		 /**simulation mode **/ 
		 else if ( playerNum >2)
		{
		 this.player2Type=playerType;
		 Game.setMyplayer2(createNewPlayer2(playerType));
			GameController.display();
		 //go to next scene
		 	Parent tableViewParent = FXMLLoader.load(getClass().getResource("gamemap.fxml"));
	        Scene tableViewScene = new Scene(tableViewParent);
	        //This line gets the Stage information
	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        window.setScene(tableViewScene);
	        window.show();			

		}
		 else
		 {
		 this.player1Type =playerType ; 
		 player player1 =  new HumanPlayer(Game.getMymap().getP1_terrs());
		 Game.setMyplayer1(player1);
		 this.playerNumLabel.setText("2");	
		 GameController.createPopUP("Select Second Player","");


		 }
	}
	private player createNewPlayer2(int playerType) {

		player player2 = null;
		switch (playerType) {
		case 1: {
			 player2 = new PassiveAgent(Game.getMymap().getP2_terrs());
			 System.out.println("passive");

			 break;}
		case 2: {
			 player2 = new AgreesiveAgent((Game.getMymap().getP2_terrs()));
			 System.out.println("agg");

			 break;}
		case 3: {
			 player2 = new NearlyPacifistAgent((Game.getMymap().getP2_terrs()));
			 System.out.println("nearly");

		break;}
		case 4: {
			 player2 = new  GreedyAgent((Game.getMymap().getP2_terrs()));
			 System.out.println("greedy");


			 break;}	case 5: {
			player2 = new AstarAgent((Game.getMymap().getP2_terrs()));
			

			break;}	case 6: {
			 player2 = new RealTimeAStar((Game.getMymap().getP2_terrs()));

			 break;}
		case 7: {
			 player2 = new MinMax((Game.getMymap().getP2_terrs()));

			 break;}
		
		}
		System.out.println("\nBefore");
		Game game = new Game();


		return player2;
	}
	
	
}
