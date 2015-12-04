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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

import com.fourpointzeroteam.nathan.fantasyfutbol.Futbol.exception.InvalidInputException;
import com.fourpointzeroteam.nathan.fantasyfutbol.Futbol.soccer.Player;

public class LiveScoreView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4048807602737536769L;

	private int team1NumGoals = 0;
    private int team2NumGoals = 0;

	/**
	 * Create the panel.
	 */
	public LiveScoreView() {
		JPanel outerPan = new JPanel(new BorderLayout());
		
		JPanel topPan = new JPanel(new BorderLayout());
		topPan.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		
		String IMG_PATH = "futbol_logo.png";
		try{
			BufferedImage img = ImageIO.read(new File(IMG_PATH));
	         ImageIcon icon = new ImageIcon(img);
	         JLabel imgLabel = new JLabel(icon);
	         topPan.add(imgLabel);
			/*BufferedImage wPic = ImageIO.read(this.getClass().getResource("futbol_logo.png"));
			JLabel wIcon = new JLabel(new ImageIcon(wPic));
			topPan.add(wIcon);*/
		} 
		catch (Exception e){
			e.printStackTrace();
		}
		JLabel lblLiveScore = new JLabel("Live Score Input",JLabel.CENTER);
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
		
		JButton btnLiveStart = new JButton("START GAME");
		ctrPan.add(btnLiveStart,BorderLayout.CENTER);
		/*southPan2.add(btnLiveStart);
		southPan.add(southPan2,BorderLayout.CENTER);
		
		outerPan.add(southPan,BorderLayout.SOUTH);*/
		outerPan.add(ctrPan,BorderLayout.CENTER);
		add(outerPan);
		
		outerPan.updateUI();
		updateUI();
		
		JPanel outerPanCopy = outerPan;
		
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
	                JButton lBtnGoal = new JButton("Goal");
	                JButton lBtnMiss = new JButton("Missed Shot");
	                JButton lYellow = new JButton("Yellow Card");
	                JButton lRed = new JButton("Red Card");
	                JButton lKick = new JButton("Penalty Kick");
	                
	                JButton rBtnGoal = new JButton("Goal");
	                JButton rBtnMiss = new JButton("Miss");
	                JButton rYellow = new JButton("Yellow Card");
	                JButton rRed = new JButton("Red Card");
	                JButton rKick = new JButton("Penalty Kick");
	                
	                
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
	        		JPanel leftWestGridPan = new JPanel(new GridLayout(0,1));
	        		leftWestGridPan.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
	        		
	        		leftWestGridPan.add(lBtnGoal);
	        		leftWestGridPan.add(lBtnMiss);
	        		leftWestGridPan.add(lYellow);
	        		leftWestGridPan.add(lRed);
	        		leftWestGridPan.add(lKick);
	        		
	        		leftWestPan.add(team1Combo,BorderLayout.NORTH);
	        		leftWestPan.add(leftWestGridPan,BorderLayout.CENTER);
	        		
	        		leftPan.add(leftWestPan,BorderLayout.CENTER);
	        		

	        		//RIGHT rightPan
	        		
	        		//String team2Name = rightCombo.getSelectedItem().toString();
	        		String team2Name = DatabaseManager.listTeams.get(team2Index).getName();
	        		
	        		JLabel lblTeam2 = new JLabel(team2Name,JLabel.CENTER);
	        		lblTeam2.setFont(new Font("Arial", Font.BOLD, 15));
	        		rightPan.add(lblTeam2,BorderLayout.NORTH);
	        		
	        		JPanel rightWestPan = new JPanel(new BorderLayout());
	        		rightWestPan.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
	        		JPanel rightWestGridPan = new JPanel(new GridLayout(0,1));
	        		rightWestGridPan.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
	        		
	        		rightWestGridPan.add(rBtnGoal);
	        		rightWestGridPan.add(rBtnMiss);
	        		rightWestGridPan.add(rYellow);
	        		rightWestGridPan.add(rRed);
	        		rightWestGridPan.add(rKick);
	        		
	        		rightWestPan.add(team2Combo,BorderLayout.NORTH);
	        		rightWestPan.add(rightWestGridPan,BorderLayout.CENTER);
	        		
	        		rightPan.add(rightWestPan,BorderLayout.CENTER);
	        		
	        		//END GAME BUTTON
	                
	                JButton btnLiveEnd = new JButton("END GAME");
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
	        	//Error Messages
	        	else if(!leftCombo.getSelectedItem().equals("") || !rightCombo.getSelectedItem().equals("") || leftCombo.getSelectedItem().equals(rightCombo.getSelectedItem())){
	        		JOptionPane.showMessageDialog(null,  "You must select two different (non-empty) teams.", "Error!", JOptionPane.ERROR_MESSAGE);
	        	}
	        	else{
	        		JOptionPane.showMessageDialog(null,  "Unknown Error.", "Error!", JOptionPane.ERROR_MESSAGE);
	        	}
	        }
		});
		
	}

}
