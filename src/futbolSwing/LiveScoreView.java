package futbolSwing;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class LiveScoreView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4048807602737536769L;
	private JTextField Team1;
	private JTextField Team2;

	/**
	 * Create the panel.
	 */
	public LiveScoreView() {
		JPanel outerPan = new JPanel(new BorderLayout());
		
		JPanel topPan = new JPanel(new BorderLayout());
		topPan.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		
		String IMG_PATH = "src/futbol_logo.png";
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
        
        //Left Panel
        JPanel leftPan = new JPanel(new BorderLayout());
				
		Team1 = new JTextField();
		leftPan.add(Team1,BorderLayout.CENTER);
		Team1.setColumns(10);
		
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
		
		Team2 = new JTextField();
		rightPan.add(Team2,BorderLayout.CENTER);
		Team2.setColumns(10);
		
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
		
		//Button ActionListener
		
		
		btnLiveStart.addActionListener(new ActionListener() {
			boolean Team1Field = false;
			boolean Team2Field = false;
			
			/*To-do:
			 * Authenticate Team names in Team1 and Team 2 JTextFields.
			 * */
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	if(!Team1.getText().isEmpty() && !Team2.getText().isEmpty()){
	        		Team1Field = true;
	        		Team2Field = true;
	        	}
	        	
	        	if(Team1Field == true && Team2Field == true){
	    			/*outerPan.revalidate();
	    			outerPan.repaint();
	    			outerPan.setVisible(true);*/
	        		outerPan.removeAll();
	        		
	        		leftPan.removeAll();
	        		rightPan.removeAll();
	        		ctrPan.removeAll();
	        		topPan.removeAll();
	        		
	        		
	        		String IMG_PATH = "src/futbol_logo.png";
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
	                	
	        		ctrPan.add(lblVs,BorderLayout.NORTH);
	        		
	        		//leftPan
	        		JLabel lblTeam1 = new JLabel("Team 1",JLabel.CENTER);
	        		leftPan.add(lblTeam1,BorderLayout.NORTH);
	        		
	        		JLabel team1Name = new JLabel(Team1.getText(),JLabel.CENTER);
	        		
	        		leftPan.add(team1Name,BorderLayout.CENTER);
	        		
	        		//rightPan
	        		JLabel lblTeam2 = new JLabel("Team 2",JLabel.CENTER);
	        		rightPan.add(lblTeam2,BorderLayout.NORTH);
	        		
	        		JLabel team2Name = new JLabel(Team2.getText(),JLabel.CENTER);
	        		
	        		rightPan.add(team2Name,BorderLayout.CENTER);
	        		
	        		//Add all Pans to outerPan
	        		outerPan.add(topPan,BorderLayout.NORTH);
	        		outerPan.add(leftPan,BorderLayout.WEST);
	        		outerPan.add(ctrPan,BorderLayout.CENTER);
	        		outerPan.add(rightPan,BorderLayout.EAST);
	        		
	        		outerPan.updateUI();
	    		}
	        }
		});
		
	}

}
