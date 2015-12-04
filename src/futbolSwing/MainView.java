package futbolSwing;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;

import com.alee.laf.WebLookAndFeel;
/*import com.fourpointzeroteam.nathan.fantasyfutbol.Futbol.exception.IdLengthException;
import com.fourpointzeroteam.nathan.fantasyfutbol.Futbol.exception.InvalidInputException;
import com.fourpointzeroteam.nathan.fantasyfutbol.Futbol.exception.NameLengthException;
import com.fourpointzeroteam.nathan.fantasyfutbol.Futbol.exception.NumberLengthException;
import com.fourpointzeroteam.nathan.fantasyfutbol.Futbol.soccer.Player;
*/

public class MainView{

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	private JFrame frame;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//WebLookAndFeel.install ();
		
		//DatabaseManager dbase = new DatabaseManager();
		DatabaseManager.initiateData();
		/*ArrayList<Team> teamArrayList = new ArrayList<>();
	    ArrayList<Player> playerArrayList = new ArrayList<>();*/
		/*initiateData();*/
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WebLookAndFeel.install ();
					MainView window = new MainView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/*public ArrayList<Team> getListTeam(){
		return teamArrayList;
	}
	public ArrayList<Player> getListPlayer(){
		return playerArrayList;
	}*/
	/**
	 * Create the application.
	 */
	public MainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Futbol 1.0");
		frame.setBounds(100, 100, 600, 580);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		JPanel mainPane = new JPanel(new CardLayout());
		//mainPane.setLayout(new CardLayout(500, 480));
		
		JPanel outerPan = new JPanel(new BorderLayout());
		//outerPan.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		
		JPanel outerPanCard = new JPanel();
		
		JPanel topPan = new JPanel(new BorderLayout());
		topPan.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		
		
		//frame.getContentPane().add(topPan, BorderLayout.CENTER);
		
		//JLabel lblFutbolImg = new JLabel("Futbol img");
		//panel.add(lblFutbolImg);
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
		outerPan.add(topPan,BorderLayout.NORTH);
		
		JPanel ctrPan = new JPanel(new BorderLayout());
		ctrPan.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		//frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		JPanel ctrPan2_1 = new JPanel(new BorderLayout());
		ctrPan.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		
		JPanel ctrPan1 = new JPanel();
		ctrPan1.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		
		JPanel ctrPan2 = new JPanel();
		ctrPan2.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		
		JPanel ctrPan3 = new JPanel();
		ctrPan3.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		
		JButton btnPlayerAnalysis = new JButton("Player Analysis");
		ctrPan1.add(btnPlayerAnalysis);
		
		// TEST
		/*public void addComponentToPane(Container pane) {
	        JTabbedPane tabbedPane = new JTabbedPane();
	 
	        //Create the "cards".
	        JPanel card1 = new JPanel() {
	            //Make the panel wider than it really needs, so
	            //the window's wide enough for the tabs to stay
	            //in one row.
	            public Dimension getPreferredSize() {
	                Dimension size = super.getPreferredSize();
	                size.width += extraWindowWidth;
	                return size;
	            }
	        };
	        card1.add(new JButton("Button 1"));
	        card1.add(new JButton("Button 2"));
	        card1.add(new JButton("Button 3"));
	 
	        JPanel card2 = new JPanel();
	        card2.add(new JTextField("TextField", 20));
	 
	        tabbedPane.addTab(BUTTONPANEL, card1);
	        tabbedPane.addTab(TEXTPANEL, card2);
	 
	        pane.add(tabbedPane, BorderLayout.CENTER);
	    }*/
		
		
		// BUTTON PANEL
		JPanel buttonPanel = new JPanel(); 
        final JButton previousButton = new JButton("Back");
        
        CardLayout cardLayout = (CardLayout) mainPane.getLayout();
        
        previousButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                //CardLayout cardLayout = (CardLayout) mainPane.getLayout();
                cardLayout.previous(mainPane);
            }
        });
        
        buttonPanel.add(previousButton);
        ///////////////////////////////////////
        
        //BUTTON FOR AUTHENTICATION UI
		JPanel buttonPanelAuth = new JPanel(); 
        final JButton previousButtonAuth = new JButton("Back");
        
        //CardLayout cardLayout = (CardLayout) mainPane.getLayout();
        
        previousButtonAuth.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                //CardLayout cardLayout = (CardLayout) mainPane.getLayout();
                //cardLayout.previous(mainPane);
                cardLayout.first(mainPane);
            }
        });
        
        buttonPanelAuth.add(previousButtonAuth);
		
		// TABBED PANE CODE ///////////////////
		JPanel lAnaPanel = new LeagueAnalysisView();
    	
    	JPanel pAnaPanel = new PlayerAnalysisView();	
    	
    	
    	JTabbedPane tabbedPane = new JTabbedPane();
    	JPanel tabPan = new JPanel();
    	
    	tabbedPane.addTab("Player Analysis", pAnaPanel);
    	tabbedPane.addTab("League Analysis", lAnaPanel);
    	
    	
    	tabPan.add(tabbedPane,BorderLayout.CENTER);
    	
    	tabPan.add(buttonPanel, BorderLayout.SOUTH);
    	/////////////////////////////////////
    	
    	
    	//Adding all Panes to Parent pane

    	JPanel AuthPanel = new AuthenticationView();
    	AuthPanel.add(buttonPanelAuth);
    	
    	ctrPan.add(ctrPan1,BorderLayout.NORTH);
		ctrPan.add(ctrPan2_1,BorderLayout.CENTER);
		ctrPan2_1.add(ctrPan2,BorderLayout.NORTH);
		ctrPan2_1.add(ctrPan3,BorderLayout.CENTER);
		
		outerPan.add(ctrPan,BorderLayout.CENTER);
		
		//////////////////////////////////////
		
		//BUTTON ACTION LISTENERS 
		btnPlayerAnalysis.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            /*JFrame frame = new JFrame ("MyPanel");
	            frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	            frame.getContentPane().add(new PlayerAnalysis());*/
	        	
	        	/*JPanel pAnaPanel = new PlayerAnalysisView();
	        	
	        	JPanel lAnaPanel = new LeagueAnalysisView(); 	
	        	JTabbedPane tabbedPane = new JTabbedPane();
	        	
	        	tabbedPane.addTab("Player Analysis", pAnaPanel);
		        tabbedPane.addTab("League Analysis", lAnaPanel);*/
	        	
	        	tabbedPane.setSelectedIndex(0);
	        	
	        	//frame.removeAll();
	        	//frame.dispose();
	        	frame.invalidate();
	        	frame.validate();
	        	frame.repaint();

	            //pAnaPanel.addComponentToPane(frame.getContentPane());
	        	
	        	//frame.setContentPane(pAnaPanel); 
	        	//frame.setContentPane(tabbedPane);
	        	
	        	//tabPan.add(tabbedPane,BorderLayout.CENTER);
	        	//frame.setContentPane(tabPan);
	        	cardLayout.show(mainPane,"AnalysisUI");
	            //frame.pack();
	            frame.setVisible (true);

	        }
		});
		JButton btnLeagueAnalysis = new JButton("League Analysis");
		ctrPan2.add(btnLeagueAnalysis);
		
		btnLeagueAnalysis.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {

	        	
	        	tabbedPane.setSelectedIndex(1);
	        	
	        	//frame.removeAll();
	        	//frame.dispose();
	        	frame.invalidate();
	        	frame.validate();
	        	frame.repaint();

	        	//frame.setContentPane(lAnaPanel); 
	        	
	        	//tabPan.add(tabbedPane,BorderLayout.CENTER);
	        	//frame.setContentPane(tabPan);
	        	cardLayout.show(mainPane,"AnalysisUI");
	            //frame.pack();
	            frame.setVisible (true);

	        }
		});
		
		JButton btnLogin = new JButton("Scorekeeper Login");
		ctrPan3.add(btnLogin);
		
		btnLogin.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            
	        	JPanel AuthPanel = new AuthenticationView();
      	
	        	
	        	
	        	//frame.removeAll();
	        	//frame.dispose();
	        	frame.invalidate();
	        	frame.validate();
	        	frame.repaint();

	        	//JPanel LSPanel = new LiveScoreView();
	        	//frame.setContentPane(AuthPanel); 
	        	
	        	
	        	/*JPanel ScorekeeperPanel = new ScorekeeperView();
	        	frame.setContentPane(ScorekeeperPanel); */
	        	
	        	cardLayout.show(mainPane,"AuthUI");
	            //frame.pack();
	            frame.setVisible (true);

	        }
		});
		
		
	
		outerPanCard.add(outerPan);
		mainPane.add(outerPanCard,"MainMenuUI");
		mainPane.add(tabPan,"AnalysisUI");
		mainPane.add(AuthPanel,"AuthUI");
		//frame.setContentPane(mainPane,BorderLayout.CENTER);
		frame.add(mainPane,BorderLayout.CENTER);
		frame.pack();
	}
}

