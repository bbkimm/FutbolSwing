package futbolSwing;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.event.RowSorterEvent;
import javax.swing.event.RowSorterListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;







import com.fourpointzeroteam.nathan.fantasyfutbol.Futbol.soccer.Player;
//import com.fourpointzeroteam.nathan.fantasyfutbol.Futbol.soccer.Team;
import com.fourpointzeroteam.nathan.fantasyfutbol.Futbol.exception.IdLengthException;
import com.fourpointzeroteam.nathan.fantasyfutbol.Futbol.exception.InvalidInputException;
import com.fourpointzeroteam.nathan.fantasyfutbol.Futbol.exception.NameLengthException;
import com.fourpointzeroteam.nathan.fantasyfutbol.Futbol.exception.NumberLengthException;
import com.fourpointzeroteam.nathan.fantasyfutbol.Futbol.exception.PlayerNotFoundException;

public class PlayerAnalysisView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3744189497333993857L;
	private JTable table;
	
	/**
	 * Create the panel.
	 */
	//public static JPanel newJPanel(){
		
        //JPanel panel = new JPanel();
        //JPanel outerPan = new JPanel(new BorderLayout());
		//outerPan.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		
		/*JPanel topPan = new JPanel(new BorderLayout());
		topPan.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		
		String IMG_PATH = "src/futbol_logo.png";
		try{
			BufferedImage img = ImageIO.read(new File(IMG_PATH));
	         ImageIcon icon = new ImageIcon(img);
	         JLabel imgLabel = new JLabel(icon);
	         topPan.add(imgLabel);
			BufferedImage wPic = ImageIO.read(this.getClass().getResource("futbol_logo.png"));
			JLabel wIcon = new JLabel(new ImageIcon(wPic));
			topPan.add(wIcon);
		} 
		catch (Exception e){
			e.printStackTrace();
		}
		
		outerPan.add(topPan,BorderLayout.NORTH);*/
		
		/*JPanel ctrPan = new JPanel(new BorderLayout());
		ctrPan.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		
		JButton btnPlayerAnalysis = new JButton("Player Analysis");
		ctrPan.add(btnPlayerAnalysis);
		
		outerPan.add(ctrPan,BorderLayout.CENTER);
		*/
		
       // return outerPan;
    //}
	public PlayerAnalysisView() {
		
		/*Team Dragons = new Team(1);
        Team Pheonix = new Team(2);
        Team Triades = new Team(3);
        Team Redman = new Team(4);

        try {
            Dragons.setNumPoints(23);
            Pheonix.setNumPoints(17);
            Triades.setNumPoints(29);
            Redman.setNumPoints(25);

            Dragons.setName("Dragons");
            Pheonix.setName("Pheonix");
            Triades.setName("Triades");
            Redman.setName("Redman");
            
            Dragons.setNumGoals(52);
            Pheonix.setNumGoals(24);
            Triades.setNumGoals(61);
            Redman.setNumGoals(44);

            Dragons.setNumPenalties(16);
            Pheonix.setNumPenalties(28);
            Triades.setNumPenalties(13);
            Redman.setNumPenalties(9);
        } catch (InvalidInputException e) {
        }


        Player nathanlarue = null;
        Player briankimlim = null;
        Player kevinnam = null;
        Player alexanderwu = null;
        Player xavierfortin = null;
        Player charlesbedard = null;
        Player alexbirer = null;
        Player felixpoulin = null;
        try {
            nathanlarue = new Player(1, "Larue, Nathan", 12);
            briankimlim = new Player(2, "Kim Lim, Brian", 31);
            kevinnam = new Player(3, "Nam, Kevin", 21);
            alexanderwu = new Player(4, "Wu, Alexander", 40);
            felixpoulin = new Player(5, "Poulin, Felix", 31);
            xavierfortin = new Player(6, "Fortin, Xavier", 53);
            charlesbedard = new Player(7, "Bedard, Charles", 86);
            alexbirer = new Player(8, "Birer, Alex", 81);

            nathanlarue.addShot(true);
            nathanlarue.addShot(true);
            nathanlarue.addShot(false);
            nathanlarue.addShot(false);
            briankimlim.addShot(true);
            briankimlim.addShot(false);
            briankimlim.addShot(false);
            kevinnam.addShot(true);
            kevinnam.addShot(true);
            kevinnam.addShot(true);
            kevinnam.addShot(true);
            alexanderwu.addShot(true);
            alexanderwu.addShot(true);
            alexanderwu.addShot(true);
            alexanderwu.addShot(false);
            xavierfortin.addShot(true);
            xavierfortin.addShot(true);
            xavierfortin.addShot(true);
            xavierfortin.addShot(false);
            charlesbedard.addShot(true);
            charlesbedard.addShot(true);
            alexbirer.addShot(true);
            alexbirer.addShot(true);
            alexbirer.addShot(true);
            alexbirer.addShot(true);
            alexbirer.addShot(false);

            nathanlarue.addInfraction(1);
            nathanlarue.addInfraction(2);
            nathanlarue.addInfraction(3);
            nathanlarue.addInfraction(2);
            nathanlarue.addInfraction(3);
            briankimlim.addInfraction(1);
            briankimlim.addInfraction(2);
            briankimlim.addInfraction(1);
            kevinnam.addInfraction(3);
            kevinnam.addInfraction(3);
            alexanderwu.addInfraction(2);
            alexanderwu.addInfraction(2);
            alexanderwu.addInfraction(1);
            alexanderwu.addInfraction(3);
            alexanderwu.addInfraction(3);
            xavierfortin.addInfraction(1);
            xavierfortin.addInfraction(2);
            charlesbedard.addInfraction(2);
            charlesbedard.addInfraction(3);
            alexbirer.addInfraction(1);
            alexbirer.addInfraction(1);

        } catch (NameLengthException e) {
        } catch (NumberLengthException e) {
        } catch (IdLengthException e) {
        }
        
        ArrayList<Team> teamArrayList = new ArrayList<>();
        ArrayList<Player> playerArrayList = new ArrayList<>();
        
        teamArrayList.add(Dragons);
        teamArrayList.add(Pheonix);
        teamArrayList.add(Triades);
        teamArrayList.add(Redman);
        
        playerArrayList.add(nathanlarue);
        playerArrayList.add(briankimlim);
        playerArrayList.add(kevinnam);
        playerArrayList.add(alexanderwu);
        playerArrayList.add(xavierfortin);
        playerArrayList.add(charlesbedard);
        playerArrayList.add(alexbirer);
        playerArrayList.add(felixpoulin);*/

		//initiateData();
		
		JPanel outerPan = new JPanel(new BorderLayout());
		JPanel topPan = new JPanel(new BorderLayout());
		topPan.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		
		
		JPanel ctrPan = new JPanel(new BorderLayout());
		ctrPan.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
 
		
	     /*List<Player> listPlayers = createListPlayer();
	     TableModel tableModel = new PlayerAnalysisTableModel(listPlayers);
	     table = new JTable(tableModel);*/
		
	     TableModel tableModel = new PlayerAnalysisTableModel(DatabaseManager.listPlayers);
	     table = new JTable(tableModel);
		
	        // insert code for sorting here...
	         
	     //add(new JScrollPane(table), BorderLayout.CENTER);
	     JScrollPane pTable = new JScrollPane(table);
	     ctrPan.add(pTable,BorderLayout.CENTER);
	     //outerPan.add(ctrPan,BorderLayout.CENTER);
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
	     
	     JLabel lblPlayerAnalysis = new JLabel("Player Analysis",JLabel.CENTER);
	     lblPlayerAnalysis.setFont(new Font("Arial", Font.BOLD, 24));
	        topPan.add(lblPlayerAnalysis, BorderLayout.SOUTH);
	        outerPan.add(ctrPan, BorderLayout.CENTER);
	        outerPan.add(topPan,BorderLayout.NORTH);
	     
	     //table.setAutoCreateRowSorter(true);
	        
	        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
	        table.setRowSorter(sorter);
	        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
	        
	        int columnIndexToSort = 0;
	        sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));
	         
	        sorter.setSortKeys(sortKeys);
	        sorter.sort();
	        
	        sorter.addRowSorterListener(new RowSorterListener() {
	            @Override
	            public void sorterChanged(RowSorterEvent evt) {
	                int indexOfNoColumn = 0;
	                for (int i = 0; i < table.getRowCount(); i++) {
	                    table.setValueAt(i + 1, i, indexOfNoColumn);
	                }
	            }
	        });
	        sorter.setSortable(0, false);
	        sorter.setSortable(1, false);
	        sorter.setSortable(2, false);
	        
	        add(outerPan);
	        
	        // JLabel lblPlayerAnalysis = new JLabel("Player Analysis");
	        //topPan.add(lblPlayerAnalysis, BorderLayout.CENTER);
	        //outerPan.add(ctrPan, BorderLayout.CENTER);
	        //outerPan.add(topPan,BorderLayout.NORTH);
	        /*pack();
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);*/
	}    
	
	    /*public List<Player> createListPlayer() {
	        List<Player> listPlayers = new ArrayList<>();
	 
	        // code to add dummy data here...
	        Player nathanlarue = new Player( "Larue, Nathan", 12);
	        Player briankimlim = new Player( "Kim Lim, Brian", 31);
	        Player kevinnam = new Player( "Nam, Kevin", 21);
	        Player alexanderwu = new Player( "Wu, Alexander", 40);
	        Player felixpoulin = new Player( "Poulin, Felix", 31);
	        Player xavierfortin = new Player( "Fortin, Xavier", 53);
	        Player charlesbedard = new Player( "Bedard, Charles", 86);
	        Player alexbirer = new Player( "Birer, Alex", 81);
	        
	        nathanlarue.setShots(99);
	        briankimlim.setShots(10);
	        kevinnam.setShots(15);
	        alexanderwu.setShots(420);
	        
	        nathanlarue.setGoals(43);
	        briankimlim.setGoals(2);
	        kevinnam.setGoals(6);
	        alexanderwu.setGoals(5);
	        
	        nathanlarue.setInfractions(2);
	        briankimlim.setInfractions(1);
	        kevinnam.setInfractions(4);
	        alexanderwu.setInfractions(3);
	        
			
	        listPlayers.add(nathanlarue);
	        listPlayers.add(briankimlim);
	        listPlayers.add(kevinnam);
	        listPlayers.add(alexanderwu);
	        listPlayers.add(felixpoulin );
	        listPlayers.add(xavierfortin);
	        listPlayers.add(charlesbedard );
	        listPlayers.add(alexbirer);
	 
	        return listPlayers;
	    }*/
	 
	    /*public static void main(String[] args) {
	    	
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                new PlayerAnalysisView().setVisible(true);
	            }
	        });
		}*/
		
	    public void initiateData() {
	        //Team Dragons = new Team(1);
	        /*Team Dragons = new Team(1);
	        Team Pheonix = new Team(2);
	        Team Triades = new Team(3);
	        Team Redman = new Team(4);

	        try {
	            Dragons.setNumPoints(23);
	            Pheonix.setNumPoints(17);
	            Triades.setNumPoints(29);
	            Redman.setNumPoints(25);

	            Dragons.setNumGoals(52);
	            Pheonix.setNumGoals(24);
	            Triades.setNumGoals(61);
	            Redman.setNumGoals(44);

	            Dragons.setNumPenalties(16);
	            Pheonix.setNumPenalties(28);
	            Triades.setNumPenalties(13);
	            Redman.setNumPenalties(9);
	        } catch (InvalidInputException e) {
	        }


	        Player nathanlarue = null;
	        Player briankimlim = null;
	        Player kevinnam = null;
	        Player alexanderwu = null;
	        Player xavierfortin = null;
	        Player charlesbedard = null;
	        Player alexbirer = null;
	        Player felixpoulin = null;
	        try {
	            nathanlarue = new Player(1, "Larue, Nathan", 12);
	            briankimlim = new Player(2, "Kim Lim, Brian", 31);
	            kevinnam = new Player(3, "Nam, Kevin", 21);
	            alexanderwu = new Player(4, "Wu, Alexander", 40);
	            felixpoulin = new Player(5, "Poulin, Felix", 31);
	            xavierfortin = new Player(6, "Fortin, Xavier", 53);
	            charlesbedard = new Player(7, "Bedard, Charles", 86);
	            alexbirer = new Player(8, "Birer, Alex", 81);

	            nathanlarue.addShot(true);
	            nathanlarue.addShot(true);
	            nathanlarue.addShot(false);
	            nathanlarue.addShot(false);
	            briankimlim.addShot(true);
	            briankimlim.addShot(false);
	            briankimlim.addShot(false);
	            kevinnam.addShot(true);
	            kevinnam.addShot(true);
	            kevinnam.addShot(true);
	            kevinnam.addShot(true);
	            alexanderwu.addShot(true);
	            alexanderwu.addShot(true);
	            alexanderwu.addShot(true);
	            alexanderwu.addShot(false);
	            xavierfortin.addShot(true);
	            xavierfortin.addShot(true);
	            xavierfortin.addShot(true);
	            xavierfortin.addShot(false);
	            charlesbedard.addShot(true);
	            charlesbedard.addShot(true);
	            alexbirer.addShot(true);
	            alexbirer.addShot(true);
	            alexbirer.addShot(true);
	            alexbirer.addShot(true);
	            alexbirer.addShot(false);

	            nathanlarue.addInfraction(true);
	            nathanlarue.addInfraction(true);
	            nathanlarue.addInfraction(true);
	            nathanlarue.addInfraction(false);
	            nathanlarue.addInfraction(false);
	            briankimlim.addInfraction(true);
	            briankimlim.addInfraction(false);
	            briankimlim.addInfraction(false);
	            kevinnam.addInfraction(false);
	            kevinnam.addInfraction(false);
	            alexanderwu.addInfraction(true);
	            alexanderwu.addInfraction(true);
	            alexanderwu.addInfraction(true);
	            alexanderwu.addInfraction(true);
	            alexanderwu.addInfraction(true);
	            xavierfortin.addInfraction(false);
	            xavierfortin.addInfraction(false);
	            charlesbedard.addInfraction(false);
	            charlesbedard.addInfraction(true);
	            alexbirer.addInfraction(true);
	            alexbirer.addInfraction(true);

	        } catch (NameLengthException e) {
	        } catch (NumberLengthException e) {
	        } catch (IdLengthException e) {
	        }
	        
	        ArrayList<Team> teamArrayList = new ArrayList<>();
	        ArrayList<Player> playerArrayList = new ArrayList<>();
	        
	        teamArrayList.add(Dragons);
	        teamArrayList.add(Pheonix);
	        teamArrayList.add(Triades);
	        teamArrayList.add(Redman);
	        
	        playerArrayList.add(nathanlarue);
	        playerArrayList.add(briankimlim);
	        playerArrayList.add(kevinnam);
	        playerArrayList.add(alexanderwu);
	        playerArrayList.add(xavierfortin);
	        playerArrayList.add(charlesbedard);
	        playerArrayList.add(alexbirer);
	        playerArrayList.add(felixpoulin);
*/
	    }
}
