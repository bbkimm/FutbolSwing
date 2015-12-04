package futbolSwing;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.fourpointzeroteam.nathan.fantasyfutbol.Futbol.exception.InvalidInputException;
import com.fourpointzeroteam.nathan.fantasyfutbol.Futbol.soccer.Player;

public class BatchModeView extends JPanel {
	private int team1NumGoals = 0;
    private int team2NumGoals = 0;
	/**
	 * Create the panel.
	 */
	public BatchModeView() {
	JPanel outerPan = new JPanel(new BorderLayout());
		
		JPanel topPan = new JPanel(new BorderLayout());
		topPan.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		
		String IMG_PATH = "futbol_logo.png";
		try{
			BufferedImage img = ImageIO.read(new File(IMG_PATH));
	         ImageIcon icon = new ImageIcon(img);
	         JLabel imgLabel = new JLabel(icon);
	         topPan.add(imgLabel);

		} 
		catch (Exception e){
			e.printStackTrace();
		}
		JLabel lblLiveScore = new JLabel("Batch Score Input",JLabel.CENTER);
		lblLiveScore.setFont(new Font("Arial", Font.BOLD, 24));
        topPan.add(lblLiveScore, BorderLayout.SOUTH);
        outerPan.add(topPan,BorderLayout.NORTH);
        
        // INITIALIZE STRING ARRAY FOR COMBO BOX
        int listTeamSize = DatabaseManager.listTeams.size();
        
		 String[] comboDesc = new String[listTeamSize+1];
		 comboDesc[0] ="";
		 int i = 1;
		 for (Team team:DatabaseManager.listTeams){
			 comboDesc[i] = team.getName();
			 i++;
		 }
		
        
        //Left Panel
        JPanel leftPan = new JPanel(new BorderLayout());
        
        JComboBox leftCombo = new JComboBox(comboDesc);
        
				
		/*Team1 = new JTextField();
		leftPan.add(Team1,BorderLayout.CENTER);
		Team1.setColumns(10);*/
		
        leftPan.add(leftCombo,BorderLayout.CENTER);
        
		JLabel lblTeam1 = new JLabel("Team 1",JLabel.CENTER);
		leftPan.add(lblTeam1,BorderLayout.NORTH);
		
		outerPan.add(leftPan,BorderLayout.WEST);
		
		// VS. Label
		JPanel ctrPan = new JPanel(new BorderLayout());
		
		JLabel lblVs = new JLabel(" Vs. ",JLabel.CENTER);
		
		lblVs.setFont(new Font("Arial", Font.BOLD, 18));
		ctrPan.add(lblVs,BorderLayout.NORTH);
		
		
		// Right Panel
		JPanel rightPan = new JPanel(new BorderLayout());
		
		 JComboBox rightCombo = new JComboBox(comboDesc);
		 
		/*Team2 = new JTextField();
		rightPan.add(Team2,BorderLayout.CENTER);
		Team2.setColumns(10);*/
		
		rightPan.add(rightCombo,BorderLayout.CENTER);
		
		JLabel lblTeam2 = new JLabel("Team 2",JLabel.CENTER);
		rightPan.add(lblTeam2,BorderLayout.NORTH);
		
		outerPan.add(rightPan,BorderLayout.EAST);
		
		//Button
		/*JPanel southPan = new JPanel(new BorderLayout());
		JPanel southPan2 = new JPanel(new BorderLayout());*/
		
		JButton btnLiveStart = new JButton("SELECT TEAMS");
		ctrPan.add(btnLiveStart,BorderLayout.CENTER);
		/*southPan2.add(btnLiveStart);
		southPan.add(southPan2,BorderLayout.CENTER);
		
		outerPan.add(southPan,BorderLayout.SOUTH);*/
		outerPan.add(ctrPan,BorderLayout.CENTER);
		add(outerPan);
		
		outerPan.updateUI();
		updateUI();
		
		//"START GAME" Button ActionListener
		btnLiveStart.addActionListener(new ActionListener() {

	        @Override
	        public void actionPerformed(ActionEvent e) {

	        	if(!leftCombo.getSelectedItem().equals(rightCombo.getSelectedItem()) && !leftCombo.getSelectedItem().equals("") && !rightCombo.getSelectedItem().equals("")){
	        		/*JOptionPane.showMessageDialog(null,  "Gucci",
	        	             "Error!",
	        	             JOptionPane.ERROR_MESSAGE);*/
	        	
	        		// REMOVE CONTENT FROM PANELS
	        		outerPan.removeAll();
	        		leftPan.removeAll();
	        		rightPan.removeAll();
	        		ctrPan.removeAll();
	        		topPan.removeAll();
	        		
	        		
	        		// TOP PANEL
	        		String IMG_PATH = "futbol_logo.png";
	        		try{
	        			BufferedImage img = ImageIO.read(new File(IMG_PATH));
	        	         ImageIcon icon = new ImageIcon(img);
	        	         JLabel imgLabel = new JLabel(icon);
	        	         topPan.add(imgLabel);
	        		} 
	        		catch (Exception e2){
	        			e2.printStackTrace();
	        		}
	                topPan.add(lblLiveScore, BorderLayout.SOUTH);
	                
	                
	                // CENTER PANEL
	                ctrPan.add(lblVs,BorderLayout.NORTH);
	                
	                
	                
	                
	                
	                // INITIALIZE STRING ARRAYS FOR EACH TEAMS' COMBO BOX
	                int team1Index = leftCombo.getSelectedIndex() - 1;
	                int team2Index = rightCombo.getSelectedIndex() - 1;
	                
	                List<Player> team1Players = DatabaseManager.listTeams.get(team1Index).getPlayerList();
	                List<Player> team2Players = DatabaseManager.listTeams.get(team2Index).getPlayerList();
	                
	        		 String[] team1ComboDesc = new String[team1Players.size()];
	        		 int j = 0;
	        		 for (Player player:team1Players){
	        			 team1ComboDesc[j] = player.getName();
	        			 j++;
	        		 }
	        		 
	        		 String[] team2ComboDesc = new String[team2Players.size()];
	        		 int k = 0;
	        		 for (Player player:team2Players){
	        			 team2ComboDesc[k] = player.getName();
	        			 k++;
	        		 }
	        		 // CREATE COMBO BOXES
	        		 JComboBox team1Combo = new JComboBox(team1ComboDesc);
	        		 JComboBox team2Combo = new JComboBox(team2ComboDesc);
	        		 
	                
	                //BUTTONS	                
	                JButton lBtnGoal = new JButton("(+) Goal");
	                JButton lBtnMiss = new JButton("(+) Missed Shot");
	                JButton lYellow = new JButton("(+) Yellow Card");
	                JButton lRed = new JButton("(+) Red Card");
	                JButton lKick = new JButton("(+) Penalty Kick");
	                
	                JButton lBtnGoalX = new JButton("(-) Goal");
	                JButton lBtnMissX = new JButton("(-) Missed Shot");
	                JButton lYellowX = new JButton("(-) Yellow Card");
	                JButton lRedX = new JButton("(-) Red Card");
	                JButton lKickX = new JButton("(-) Penalty Kick");
	                
	                JButton rBtnGoal = new JButton("(+) Goal");
	                JButton rBtnMiss = new JButton("(+) Miss");
	                JButton rYellow = new JButton("(+) Yellow Card");
	                JButton rRed = new JButton("(+) Red Card");
	                JButton rKick = new JButton("(+) Penalty Kick");
	                
	                JButton rBtnGoalX = new JButton("(-) Goal");
	                JButton rBtnMissX = new JButton("(-) Missed Shot");
	                JButton rYellowX = new JButton("(-) Yellow Card");
	                JButton rRedX = new JButton("(-) Red Card");
	                JButton rKickX = new JButton("(-) Penalty Kick");
	                
	                
	                //CLASS INFO INSTANTIATE FOR EACH PLAYER
	                for(Player player:team1Players){
	                	
	                }
	                
	                //BUTTON ACTION LISTENERS
	                
	                //LEFT SIDE
	                lBtnGoal.addActionListener(new ActionListener() {

	        	        @Override
	        	        public void actionPerformed(ActionEvent e) {
	        	        	 int team1PlayerIndex = team1Combo.getSelectedIndex();
	        	        	 team1Players.get(team1PlayerIndex).addShot(true);
	        	        	 team1NumGoals++;
	        	        	 try{
	        	        	 DatabaseManager.listTeams.get(team1Index).addNumGoals(1);
	        	        	 }
	        	        	 catch (InvalidInputException ex){
	        	        	 }
	        	        	 try{
	        	        	 DatabaseManager.listTeams.get(team1Index).addNumGoals(1);
	        	        	 }
	        	        	 catch (InvalidInputException ex){
	        	        	 }
	        	        	 
	        	        }
	                });
	                
	                lBtnMiss.addActionListener(new ActionListener() {

	        	        @Override
	        	        public void actionPerformed(ActionEvent e) {
	        	        	 int team1PlayerIndex = team1Combo.getSelectedIndex();
	        	        	 team1Players.get(team1PlayerIndex).addShot(false);
	        	        }
	                });
	                
	                lYellow.addActionListener(new ActionListener() {

	        	        @Override
	        	        public void actionPerformed(ActionEvent e) {
	        	        	 int team1PlayerIndex = team1Combo.getSelectedIndex();
	        	        	 team1Players.get(team1PlayerIndex).addInfraction(1);
	        	        	 try{
		        	        	 DatabaseManager.listTeams.get(team1Index).addNumPenalties(1);
	        	        	 }
	        	        	 catch (InvalidInputException ex){
	        	        	 }
	        	        }
	                });
	                
	                lRed.addActionListener(new ActionListener() {

	        	        @Override
	        	        public void actionPerformed(ActionEvent e) {
	        	        	 int team1PlayerIndex = team1Combo.getSelectedIndex();
	        	        	 team1Players.get(team1PlayerIndex).addInfraction(2);
	        	        	 
	        	        	 try{
		        	        	 DatabaseManager.listTeams.get(team1Index).addNumPenalties(1);
	        	        	 }
	        	        	 catch (InvalidInputException ex){
	        	        	 }
	        	        }
	                });
	                
	                lKick.addActionListener(new ActionListener() {

	        	        @Override
	        	        public void actionPerformed(ActionEvent e) {
	        	        	 int team1PlayerIndex = team1Combo.getSelectedIndex();
	        	        	 team1Players.get(team1PlayerIndex).addInfraction(3);
	        	        	 
	        	        	 try{
		        	        	 DatabaseManager.listTeams.get(team1Index).addNumPenalties(1);
	        	        	 }
	        	        	 catch (InvalidInputException ex){
	        	        	 }
	        	        }
	                });
	                
	                //RIGHT SIDE
	                rBtnGoal.addActionListener(new ActionListener() {

	        	        @Override
	        	        public void actionPerformed(ActionEvent e) {
	        	        	 int team2PlayerIndex = team2Combo.getSelectedIndex();
	        	        	 team2Players.get(team2PlayerIndex).addShot(true);
	        	        	 team2NumGoals++;
	        	        	 try{
		        	        	 DatabaseManager.listTeams.get(team1Index).addNumGoals(1);
	        	        	 }
	        	        	 catch (InvalidInputException ex){
	        	        	 }
	        	        }
	                });
	        		
	                rBtnMiss.addActionListener(new ActionListener() {

	        	        @Override
	        	        public void actionPerformed(ActionEvent e) {
	        	        	 int team2PlayerIndex = team2Combo.getSelectedIndex();
	        	        	 team2Players.get(team2PlayerIndex).addShot(false);
	        	        }
	                });
	                
	                rYellow.addActionListener(new ActionListener() {

	        	        @Override
	        	        public void actionPerformed(ActionEvent e) {
	        	        	 int team2PlayerIndex = team2Combo.getSelectedIndex();
	        	        	 team2Players.get(team2PlayerIndex).addInfraction(1);
	        	        	 
	        	        	 try{
		        	        	 DatabaseManager.listTeams.get(team2Index).addNumPenalties(1);
		       	        	 }
		       	        	 catch (InvalidInputException ex){
		       	        	 }
	        	        }
	                });
	                
	                rRed.addActionListener(new ActionListener() {

	        	        @Override
	        	        public void actionPerformed(ActionEvent e) {
	        	        	 int team2PlayerIndex = team2Combo.getSelectedIndex();
	        	        	 team2Players.get(team2PlayerIndex).addInfraction(2);
	        	        	 
	        	        	 try{
		        	        	 DatabaseManager.listTeams.get(team2Index).addNumPenalties(1);
		       	        	 }
		       	        	 catch (InvalidInputException ex){
		       	        	 }
	        	        }
	                });
	                
	                rKick.addActionListener(new ActionListener() {

	        	        @Override
	        	        public void actionPerformed(ActionEvent e) {
	        	        	 int team2PlayerIndex = team2Combo.getSelectedIndex();
	        	        	 team2Players.get(team2PlayerIndex).addInfraction(3);
	        	        	 
	        	        	 try{
		        	        	 DatabaseManager.listTeams.get(team2Index).addNumPenalties(1);
		       	        	 }
		       	        	 catch (InvalidInputException ex){
		       	        	 }
	        	        }
	                });
	                
	                
	        		//LEFT leftPan
	        		
	        		//String team1Name = leftCombo.getSelectedItem().toString();
	        		String team1Name = DatabaseManager.listTeams.get(team1Index).getName();
	        		
	        		JLabel lblTeam1 = new JLabel(team1Name,JLabel.CENTER);
	        		lblTeam1.setFont(new Font("Arial", Font.BOLD, 15));
	        		leftPan.add(lblTeam1,BorderLayout.NORTH);
	        		
	        		JPanel leftWestPan = new JPanel(new BorderLayout());
	        		leftWestPan.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
	        		JPanel leftWestGridPanAdd = new JPanel(new GridLayout(0,1));
	        		leftWestGridPanAdd.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
	        		
	        		leftWestGridPanAdd.add(lBtnGoal);
	        		leftWestGridPanAdd.add(lBtnMiss);
	        		leftWestGridPanAdd.add(lYellow);
	        		leftWestGridPanAdd.add(lRed);
	        		leftWestGridPanAdd.add(lKick);
	        		
	        		leftWestPan.add(team1Combo,BorderLayout.NORTH);
	        		leftWestPan.add(leftWestGridPanAdd,BorderLayout.CENTER);
	        		
	        		
	        		JPanel leftWestGridPanSub = new JPanel(new GridLayout(0,1));
	        		leftWestGridPanSub.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
	        		
	        		leftWestGridPanSub.add(lBtnGoalX);
	        		leftWestGridPanSub.add(lBtnMissX);
	        		leftWestGridPanSub.add(lYellowX);
	        		leftWestGridPanSub.add(lRedX);
	        		leftWestGridPanSub.add(lKickX);
	        		
	        		leftWestPan.add(leftWestGridPanSub,BorderLayout.SOUTH);
	        		
	        		leftPan.add(leftWestPan,BorderLayout.CENTER);
	        		

	        		//RIGHT rightPan
	        		
	        		//String team2Name = rightCombo.getSelectedItem().toString();
	        		String team2Name = DatabaseManager.listTeams.get(team2Index).getName();
	        		
	        		JLabel lblTeam2 = new JLabel(team2Name,JLabel.CENTER);
	        		lblTeam2.setFont(new Font("Arial", Font.BOLD, 15));
	        		rightPan.add(lblTeam2,BorderLayout.NORTH);
	        		
	        		JPanel rightWestPan = new JPanel(new BorderLayout());
	        		rightWestPan.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
	        		JPanel rightWestGridPanAdd = new JPanel(new GridLayout(0,1));
	        		rightWestGridPanAdd.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
	        		
	        		rightWestGridPanAdd.add(rBtnGoal);
	        		rightWestGridPanAdd.add(rBtnMiss);
	        		rightWestGridPanAdd.add(rYellow);
	        		rightWestGridPanAdd.add(rRed);
	        		rightWestGridPanAdd.add(rKick);
	        		
	        		rightWestPan.add(team2Combo,BorderLayout.NORTH);
	        		rightWestPan.add(rightWestGridPanAdd,BorderLayout.CENTER);
	        		
	        		JPanel rightWestGridPanSub = new JPanel(new GridLayout(0,1));
	        		rightWestGridPanSub.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
	        		
	        		rightWestGridPanSub.add(rBtnGoalX);
	        		rightWestGridPanSub.add(rBtnMissX);
	        		rightWestGridPanSub.add(rYellowX);
	        		rightWestGridPanSub.add(rRedX);
	        		rightWestGridPanSub.add(rKickX);
	        		
	        		rightWestPan.add(rightWestGridPanSub,BorderLayout.SOUTH);
	        		
	        		rightPan.add(rightWestPan,BorderLayout.CENTER);
	        		
	        		
	        		//END GAME BUTTON
	                JButton btnLiveEnd = new JButton("SUBMIT MATCH");
	                btnLiveEnd.addActionListener(new ActionListener() {
	        	        @Override
	        	        public void actionPerformed(ActionEvent e) {
	        	        	 if(team1NumGoals > team2NumGoals){
	        	        		 JOptionPane.showMessageDialog(null,  "Team 1 Wins!", "Winner!", JOptionPane.INFORMATION_MESSAGE);
	        	        		 try{
			        	        	 DatabaseManager.listTeams.get(team1Index).addNumPoints(3);
		        	        	 }
		        	        	 catch (InvalidInputException ex){
		        	        	 }
	        	        	 }
	        	        	 else if(team1NumGoals < team2NumGoals){
	        	        		 JOptionPane.showMessageDialog(null,  "Team 2 Wins!", "Winner!", JOptionPane.INFORMATION_MESSAGE);
	        	        		 try{
			        	        	 DatabaseManager.listTeams.get(team2Index).addNumPoints(3);
		        	        	 }
		        	        	 catch (InvalidInputException ex){
		        	        	 }
	        	        	 }
	        	        	 else{
	        	        		 JOptionPane.showMessageDialog(null,  "It's a draw!", "Winner?", JOptionPane.INFORMATION_MESSAGE);
	        	        		 try{
	        	        			 DatabaseManager.listTeams.get(team1Index).addNumPoints(1);
			        	        	 DatabaseManager.listTeams.get(team2Index).addNumPoints(1);
		        	        	 }
		        	        	 catch (InvalidInputException ex){
		        	        	 }
	        	        	 }
	        	        	 ScorekeeperView.getCardLayout().show(ScorekeeperView.getMainPane(),"ScorekeeperUI");
	        	        	 
	        	        	// REMOVE CONTENT FROM PANELS, PREP FOR REFRESH (in ScorekeeperView)
	     	        		outerPan.removeAll();
	     	        		leftPan.removeAll();
	     	        		rightPan.removeAll();
	     	        		ctrPan.removeAll();
	     	        		topPan.removeAll();
	     	        		removeAll();
	     	        		
	     	        		//add(outerPanCopy);
	     	        		outerPan.updateUI();
	     	        		updateUI();
	        	        }
	                });
	                
	                ctrPan.add(btnLiveEnd,BorderLayout.PAGE_END);
	        		
	        		
	        		//Add all Pans to outerPan
	        		outerPan.add(topPan,BorderLayout.NORTH);
	        		outerPan.add(leftPan,BorderLayout.WEST);
	        		outerPan.add(ctrPan,BorderLayout.CENTER);
	        		outerPan.add(rightPan,BorderLayout.EAST);
	        		
	        		outerPan.updateUI();
	    		}
	        	// Error Messages
	        	else if(!leftCombo.getSelectedItem().equals("") || !rightCombo.getSelectedItem().equals("") || leftCombo.getSelectedItem().equals(rightCombo.getSelectedItem())){
	        		JOptionPane.showMessageDialog(null,  "You must select two different (non-empty) teams.", "Error!", JOptionPane.ERROR_MESSAGE);
	        	}
	        	else{
	        		JOptionPane.showMessageDialog(null,  "Unknown Error.", "Error!", JOptionPane.ERROR_MESSAGE);
	        	}
	        }
		});
		
	
	}
	//Info container for each player... work in progress
	class PlayerInfo{
		public PlayerInfo(Player player){
			this.player = player;
		}
		private Player player;
		
		private int nGoals =0;
		
		private int nShots = 0;
		
		private int nYellow=0;
		
		private int nRed=0;
	
		private int nKick=0;
		
		//Getters
		public Player getPlayer(){
			return this.player;
		}
		public int getnGoals(){
			return this.nGoals;
		}
		public int getnShots(){
			return this.nShots;
		}
		public int getnYellow(){
			return this.nYellow;
		}
		public int getnReds(){
			return this.nRed;
		}
		public int getnKick(){
			return this.nKick;
		}
		
		//Add 1
		public void addGoals() throws InvalidInputException{

				nGoals++;
		}
		public void addShots() throws InvalidInputException{

				nShots++;
		}
		public void addYellow() throws InvalidInputException{

				nYellow++;
		}
		public void addRed() throws InvalidInputException{

				nRed++;
		}
		public void addKick() throws InvalidInputException{
				nKick++;
		}
		
		//Substract 1
		public void subGoals() throws InvalidInputException{
			nGoals--;
			if(nGoals < 0){
				nGoals++;
			}
		}
		public void subShots() throws InvalidInputException{
			nShots--;
			if(nShots < 0){
				nShots++;
			}
		}
		public void subYellow() throws InvalidInputException{
			nYellow--;
			if(nYellow < 0){
				nYellow++;
			}
		}
		public void subRed() throws InvalidInputException{
			nRed--;
			if(nRed < 0){
				nRed++;
			}
		}
		public void subKick() throws InvalidInputException{
			nKick--;
			if(nKick < 0){
				nKick++;
			}
		}
	}

}
