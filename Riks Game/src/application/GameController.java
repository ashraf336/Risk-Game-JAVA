package application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent; 
import javafx.scene.control.TextField;
import logic.Game;
import logic.GameInterface;
import nonAiAgents.NearlyPacifistAgent;
import nonAiAgents.NonAiAgents;
import players.HumanPlayer;
import players.player;

import java.beans.EventHandler;
import java.io.IOException;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;


public class GameController  {
	
	private int numOftroops ;
	private int attackingId;
	private int attackedId;
	private boolean flagAttacking1=true;
	private int playerNum;
	private player attackingPlayer=Game.getMyplayer1();
	private boolean flagBounsP1 = true;//indicate the start turn for player 
	private boolean flagBounsP2 = true;//indicate the start turn for player 2
	@FXML
	private TextField troopsNumField;
	@FXML
	private TextField attackingIDField;
	@FXML
	private TextField attackedIDField;
	@FXML
	private Label playerNumLabel;
	@FXML Button attackButton;
	@FXML Button distributeButton;
	@FXML Button endAttackButton;
	@FXML ImageView mapImage;
	@FXML Button startButton;
	@FXML Button nextAttackButton;
	@FXML Button placeBonusButton;

	@FXML
	void attackcontroller(ActionEvent event) throws IOException
	{
		
		/**playing mode 
		 * 1. cal ,set bonus and place it 
		 */
		if ( flagBounsP1==true)// we are in a new turn 
		{

			placeBonusButton.setDisable(false);
		}
	
		//continue on same attack turn  
		if(attackingPlayer.getBonusArmy()>0 && Game.getMyplayer2() instanceof HumanPlayer) {
			createPopUP("Finish Bounst step First", null);
					}
		else {
			/**playing **/
			boolean flag1 = false;
			boolean flag2 = false;
			 if (Game.getMyplayer2() instanceof HumanPlayer)
			 {flag1 = false;
				flag2 = false;

			try{
				this.attackedId= Integer.parseInt(this.attackedIDField.getText());
				flag1=false;
				
			} catch(NumberFormatException ex) {
				// TODO: handle exception
				createPopUP("Enter Vaild arguments","enter correct attacked ID");
				attackedIDField.setText("");
			}
			try{
				this.attackingId= Integer.valueOf(attackingIDField.getText());
				flag2=false;

				
			} catch(NumberFormatException ex) {
				createPopUP("Enter Vaild arguments","Enter correct attacking ID");
				attackingIDField.setText("");}
			 }
			// Read Fields successful 
			if (flag1==false&&flag2==false) {
					

			  if ( flagAttacking1 == true&& Game.getMyplayer2() instanceof HumanPlayer)
				{
					 attackingPlayer= Game.getMyplayer1();
					 attackingPlayer.attack(Game.getMyplayer2(), 
							 Integer.valueOf(this.attackingIDField.getText()),
							 Integer.valueOf(this.attackedIDField.getText()));
				}
				else
				{
					attackingPlayer = Game.getMyplayer2();
				 if (Game.getMyplayer2() instanceof NonAiAgents)
				 {int bonus=  Game.calcBouns(attackingPlayer);
					attackingPlayer.setBonusArmy(bonus);
					 ((NonAiAgents)Game.getMyplayer2()).placeBonus();
					 if (Game.getMyplayer2() instanceof NearlyPacifistAgent)
					 {
						 ((NonAiAgents)Game.getMyplayer2()).attack( Game.getMyplayer1());

							if (flagAttacking1==true)
								{
								flagAttacking1=false;
								flagBounsP2=true ;
								playerNumLabel.setText("2");
								attackingPlayer=Game.getMyplayer2();
								}
							else
							{
								flagAttacking1=true;
								flagBounsP1=true ;
								playerNumLabel.setText("1");
								attackingPlayer=Game.getMyplayer1();
								
							}
								createPopUP("Next agent attack !", null);
								
								
								this.clear();
					 }
					if ( ! ((NonAiAgents)Game.getMyplayer2()).attack( Game.getMyplayer1()))
					{
						createPopUP("Finsh attacking", null);
					}
				}

				}


			  System.out.println("\nAfter");
			  display();
			}
		}
		
			
		}
	
	@FXML
	void placeBonuscontroller(ActionEvent event) throws IOException
	{		

		boolean flag1 = true;
		boolean flag2 = true;
			try{
				flag1=false;
				this.numOftroops= Integer.valueOf(troopsNumField.getText());					
			} catch(NumberFormatException ex) {
				// TODO: handle exception
				createPopUP("Enter Vaild arguments","enter correct num of troops");
				troopsNumField.setText("");
			}
			try{
				this.attackingId= Integer.valueOf(attackingIDField.getText());
				flag2=false;

			} catch(NumberFormatException ex) {
				// TODO: handle exception
				createPopUP("Enter Vaild arguments","Enter correct attacking ID");
				attackingIDField.setText("");}

			// valid fields 
			if (flag1==false&&flag2==false) {
				
				//placing bonus
				if(attackingPlayer.getBonusArmy()>0&&Game.getMyplayer2() instanceof HumanPlayer)
				{
				int bonus = Integer.valueOf(this.troopsNumField.getText());
				int id =Integer.valueOf(this.attackingIDField.getText());
					if (((HumanPlayer)attackingPlayer).placeBonus(bonus,id)==false)
					{
						createPopUP("Enter Vaild arguments","Enter correct attacking ID and bonus");


					}
					else {
						int bonusPast= attackingPlayer.getBonusArmy();
						int newbonus = bonus;
						attackingPlayer.setBonusArmy(Math.abs(bonusPast-newbonus));
						if (attackingPlayer.getBonusArmy()==0)
							{createPopUP("Placing Bonus Finished!", null);
							System.out.println("after bonus");
							display();
							flagBounsP1=false;
							this.attackButton.setDisable(false);
							this.clear();
							}
						
					}
									
				}else if (Game.getMyplayer2() instanceof NonAiAgents)
				{
					int bonus=  Game.calcBouns(attackingPlayer);
					attackingPlayer.setBonusArmy(bonus);
					 ((NonAiAgents)Game.getMyplayer2()).placeBonus();
				}
				this.clear();

				
			}
	

		}
		
	@FXML
	void endAttack(ActionEvent event) throws IOException
	{		

			if (flagAttacking1==true)
				{
				flagAttacking1=false;
				flagBounsP2=true ;
				playerNumLabel.setText("2");
				attackingPlayer=Game.getMyplayer2();
				}
			else
			{
				flagAttacking1=true;
				flagBounsP1=true ;
				playerNumLabel.setText("1");
				attackingPlayer=Game.getMyplayer1();
				
			}
				createPopUP("Next agent attack !", null);
				
				
				this.clear();

			
	
		
	}
	
	
	public static void  display ()
	{
		 System.out.println("Player1");
	      for(int i=0;i<Game.getMyplayer1().getMy_terrs().size();i++)
	      {
	    	  Game.getMyplayer1().getMy_terrs().get(i).printTerr();;

	      }
	      System.out.println("\nPlayer2");
	      for(int i=0;i<Game.getMyplayer2().getMy_terrs().size();i++)

	      {
	    	  Game.getMyplayer2().getMy_terrs().get(i).printTerr();;

	      }

		}

	
	
	public static void createPopUP(String headerMessage,String contentMessage)
	{
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle("Error");
		alert.setHeaderText(headerMessage);
		alert.setContentText(contentMessage);
		alert.showAndWait();
	}
	private void clear() {
		// TODO Auto-generated method stub
		this.attackedIDField.setText("");
		this.attackingIDField.setText("");
		this.troopsNumField.setText("");
		
	}
}
