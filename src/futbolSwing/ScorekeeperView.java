package futbolSwing;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class ScorekeeperView extends JPanel {
	private static CardLayout cardLayout;
	private static JPanel mainPane;
	/**
	 * Create the panel.
	 */
	public ScorekeeperView() {
		JPanel mainPane = new JPanel(new CardLayout());
		
		JPanel outerPan = new JPanel(new BorderLayout());
		
		JPanel outerPanCard = new JPanel();
		
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
		outerPan.add(topPan,BorderLayout.NORTH);
		
		//JPanel ctrPan = new JPanel(new BorderLayout());
		JPanel ctrPan = new JPanel(new GridLayout(0,1));
		ctrPan.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		//frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		/*JPanel ctrPan2_1 = new JPanel(new BorderLayout());
		ctrPan.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		
		JPanel ctrPan1 = new JPanel();
		ctrPan1.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		
		JPanel ctrPan2 = new JPanel();
		ctrPan2.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		
		JPanel ctrPan3 = new JPanel();
		ctrPan3.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));*/
		
		JButton btnPlayerAnalysis = new JButton("Player Analysis");
		JButton btnLeagueAnalysis = new JButton("League Analysis");
		JButton btnLiveInput = new JButton("Live Input");
		JButton btnBatchInput = new JButton("Batch Input");
		
		ctrPan.add(btnPlayerAnalysis);
		ctrPan.add(btnLeagueAnalysis);
		ctrPan.add(btnLiveInput);
		ctrPan.add(btnBatchInput);
		
		
		// BUTTON PANEL
		JPanel buttonPanel = new JPanel(); 
        
        
        CardLayout cardLayout = (CardLayout) mainPane.getLayout();
        
        final JButton previousButton = new JButton("Back");
        previousButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                //CardLayout cardLayout = (CardLayout) mainPane.getLayout();
                cardLayout.first(mainPane);
            }
        });
        
        buttonPanel.add(previousButton);
        
        
        // TABBED PANE CODE ///////////////////
		JPanel lAnaPanel = new LeagueAnalysisView();
    	JPanel pAnaPanel = new PlayerAnalysisView();	
    	
    	JTabbedPane tabbedPane = new JTabbedPane();
    	JPanel tabPan = new JPanel();
    	
    	tabbedPane.addTab("Player Analysis", pAnaPanel);
    	tabbedPane.addTab("League Analysis", lAnaPanel);
    	
    	tabPan.add(tabbedPane,BorderLayout.CENTER);
    	
    	//tabPan.add(buttonPanel, BorderLayout.SOUTH);
    	//tabPan.add(previousButton,BorderLayout.SOUTH);
    	
    	
    	//CENTER PANE
		outerPan.add(ctrPan,BorderLayout.CENTER);
		
		JPanel livePanContainer = new JPanel(new BorderLayout());
		JPanel batchPanContainer = new JPanel(new BorderLayout());
		
    	/*JPanel LivePanel = new LiveScoreView();
    	livePanContainer.add(LivePanel,BorderLayout.CENTER);*/
    	    	
    	
    	/*JPanel buttonPanelLive = new JPanel(); 
    	final JButton previousButtonLive = new JButton("Back");
        previousButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                //CardLayout cardLayout = (CardLayout) mainPane.getLayout();
                cardLayout.show(mainPane,"ScorekeeperUI");
            }
        });
        
        buttonPanelLive.add(previousButtonLive);
        livePanContainer.add(buttonPanelLive,BorderLayout.SOUTH);*/
        
        
    	
    	/*JPanel BatchPanel = new BatchModeView();
    	batchPanContainer.add(BatchPanel,BorderLayout.CENTER);*/
    	
    	//batchPanContainer.add(buttonPanel,BorderLayout.PAGE_END);
    	
    	/*JPanel buttonPanelBatch = new JPanel(); 
    	final JButton previousButtonBatch = new JButton("Back");
        previousButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                //CardLayout cardLayout = (CardLayout) mainPane.getLayout();
                cardLayout.first(mainPane);
            }
        });
        
        buttonPanelBatch.add(previousButtonBatch);
        batchPanContainer.add(buttonPanelBatch,BorderLayout.SOUTH);*/
    	
    	
    	//BUTTON ACTIONLISTENERS
		btnPlayerAnalysis.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            /*JFrame frame = new JFrame ("MyPanel");
	            frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	            frame.getContentPane().add(new PlayerAnalysis());
	        	
	        	JPanel pAnaPanel = new PlayerAnalysisView();
	        	
	        	JPanel lAnaPanel = new LeagueAnalysisView(); 	
	        	JTabbedPane tabbedPane = new JTabbedPane();
	        	
	        	tabbedPane.addTab("Player Analysis", pAnaPanel);
		        tabbedPane.addTab("League Analysis", lAnaPanel);*/
	        	
	        	tabbedPane.setSelectedIndex(0);
	        	
	        	//frame.removeAll();
	        	//frame.dispose();
	        	/*frame.invalidate();
	        	frame.validate();
	        	frame.repaint();*/
	        	
	        	

	            //pAnaPanel.addComponentToPane(frame.getContentPane());
	        	
	        	//frame.setContentPane(pAnaPanel); 
	        	//frame.setContentPane(tabbedPane);
	        	
	        	//tabPan.add(tabbedPane,BorderLayout.CENTER);
	        	//frame.setContentPane(tabPan);
	        	cardLayout.show(mainPane,"AnalysisUI");
	            //frame.pack();
	            //frame.setVisible (true);

	        }
		});
		
		btnLeagueAnalysis.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            /*JFrame frame = new JFrame ("MyPanel");
	            frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	            frame.getContentPane().add(new PlayerAnalysis());
	        	JPanel lAnaPanel = new LeagueAnalysisView();
	        	
	        	JPanel pAnaPanel = new PlayerAnalysisView();	
	        	JTabbedPane tabbedPane = new JTabbedPane();
	        	JPanel tabPan = new JPanel();
	        	
	        	tabbedPane.addTab("Player Analysis", pAnaPanel);
	        	tabbedPane.addTab("League Analysis", lAnaPanel);*/
	        	
	        	tabbedPane.setSelectedIndex(1);
	        	
	        	//frame.removeAll();
	        	//frame.dispose();
	        	/*frame.invalidate();
	        	frame.validate();
	        	frame.repaint();*/

	        	//frame.setContentPane(lAnaPanel); 
	        	
	        	//tabPan.add(tabbedPane,BorderLayout.CENTER);
	        	//frame.setContentPane(tabPan);
	        	cardLayout.show(mainPane,"AnalysisUI");
	            //frame.pack();
	            //frame.setVisible (true);

	        }
		});
		btnLiveInput.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            /*JFrame frame = new JFrame ("MyPanel");
	            frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	            frame.getContentPane().add(new PlayerAnalysis());
	        	
	        	JPanel pAnaPanel = new PlayerAnalysisView();
	        	
	        	JPanel lAnaPanel = new LeagueAnalysisView(); 	
	        	JTabbedPane tabbedPane = new JTabbedPane();
	        	
	        	tabbedPane.addTab("Player Analysis", pAnaPanel);
		        tabbedPane.addTab("League Analysis", lAnaPanel);*/
	        	
	        	//tabbedPane.setSelectedIndex(0);
	        	
	        	//frame.removeAll();
	        	//frame.dispose();
	        	/*frame.invalidate();
	        	frame.validate();
	        	frame.repaint();*/
	        	mainPane.remove(livePanContainer);
	        	
	        	JPanel LivePanel = new LiveScoreView();
	        	LivePanel.updateUI();
	        	
	        	livePanContainer.removeAll();
	        	livePanContainer.updateUI();
	        	livePanContainer.add(LivePanel,BorderLayout.CENTER);
	        	livePanContainer.updateUI();
	        	
	        	mainPane.add(livePanContainer,"LiveUI");
	            //pAnaPanel.addComponentToPane(frame.getContentPane());
	        	
	        	//frame.setContentPane(pAnaPanel); 
	        	//frame.setContentPane(tabbedPane);
	        	
	        	//tabPan.add(tabbedPane,BorderLayout.CENTER);
	        	//frame.setContentPane(tabPan);
	        	cardLayout.show(mainPane,"LiveUI");
	            //frame.pack();
	            //frame.setVisible (true);

	        }
		});
		
		btnBatchInput.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
       
	        	
	        	mainPane.remove(batchPanContainer);
	        	
	        	JPanel BatchPanel = new BatchModeView();
	        	BatchPanel.updateUI();
	        	
	        	batchPanContainer.removeAll();
	        	batchPanContainer.updateUI();
	        	
	        	batchPanContainer.add(BatchPanel,BorderLayout.CENTER);
	        	
	        	batchPanContainer.updateUI();

	        	mainPane.add(batchPanContainer,"BatchUI");
	        	
	            //pAnaPanel.addComponentToPane(frame.getContentPane());
	        	
	        	//frame.setContentPane(pAnaPanel); 
	        	//frame.setContentPane(tabbedPane);
	        	
	        	//tabPan.add(tabbedPane,BorderLayout.CENTER);
	        	//frame.setContentPane(tabPan);
	        	cardLayout.show(mainPane,"BatchUI");
	        	
	            //frame.pack();
	            //frame.setVisible (true);

	        }
		});
		
		
    	//ADDING ALL PANES TO PARENT PANE
		outerPanCard.add(outerPan);
		mainPane.add(outerPanCard,"ScorekeeperUI");
		mainPane.add(tabPan,"AnalysisUI");
		/*mainPane.add(LivePanel,"LiveUI");
		mainPane.add(BatchPanel,"BatchUI");*/
		mainPane.add(livePanContainer,"LiveUI");
		mainPane.add(batchPanContainer,"BatchUI");
		//mainPane.add(buttonPanel);
		
		add(mainPane,BorderLayout.CENTER);
		add(buttonPanel,BorderLayout.SOUTH);
		
		setCardLayout(cardLayout);
		setmainPane(mainPane);
	}
	private void setCardLayout(CardLayout cLayout){
		this.cardLayout = cLayout;
	}
	static public CardLayout getCardLayout(){
		return cardLayout;
	}
	private void setmainPane(JPanel mPane){
		this.mainPane = mPane;
	}
	static public JPanel getMainPane(){
		return mainPane;
	}
}
