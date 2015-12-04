package futbolSwing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Hashtable;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.fourpointzeroteam.nathan.fantasyfutbol.Futbol.exception.EmptyHashtableException;
import com.fourpointzeroteam.nathan.fantasyfutbol.Futbol.exception.InvalidInputException;
import com.fourpointzeroteam.nathan.fantasyfutbol.Futbol.exception.InvalidUsernameException;
import com.fourpointzeroteam.nathan.fantasyfutbol.Futbol.exception.PasswordLengthException;
import com.fourpointzeroteam.nathan.fantasyfutbol.Futbol.exception.UsernameLengthException;

public class AuthenticationView extends JPanel {
	
	/**
	 * Hashtable instance. Keys (String) -> Username. Values (String) -> Password.
	 */
	private static Hashtable<String, String> credentials = new Hashtable<String,String>();
	
	private static ScorekeeperView scorekeeperUI;
	/**
	 * Create the panel.
	 */
	public AuthenticationView() {
		
		//Hashtable<String, String> credentials = new Hashtable<String,String>();
	    credentials.put("a", "b");
		
		JPanel outerPan = new JPanel(new BorderLayout());
		JPanel ctrPan = new JPanel(new BorderLayout());
		
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
		
		JButton bLogin = new JButton("Login");
	    JPanel loginPanel = new JPanel();
	    //loginpanel.setLayout (null); 
	    JTextField loginField = new JTextField(15);
	    JPasswordField passField = new JPasswordField(15);
	    JLabel userLab = new JLabel("Username: ");
	    JLabel passLab = new JLabel("Password: ");
	    
	    JPanel uFieldPan = new JPanel(new BorderLayout());
	    uFieldPan.add(userLab,BorderLayout.WEST);
	    uFieldPan.add(loginField,BorderLayout.CENTER);
	    
	    JPanel pFieldPan = new JPanel(new BorderLayout());
	    pFieldPan.add(passLab,BorderLayout.WEST);
	    pFieldPan.add(passField,BorderLayout.CENTER);
	    
	    ctrPan.add(uFieldPan,BorderLayout.NORTH);
	    ctrPan.add(pFieldPan,BorderLayout.CENTER);
	    
	    loginPanel.add(ctrPan,BorderLayout.NORTH);
	    loginPanel.add(bLogin,BorderLayout.CENTER);
	    
	    outerPan.add(topPan,BorderLayout.NORTH);
	    outerPan.add(loginPanel,BorderLayout.CENTER);
	    add(outerPan);
	    
	    bLogin.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            try {
					if(authenticate(loginField.getText(),String.valueOf(passField.getPassword()))){
						removeAll();
						updateUI();
						add(scorekeeperUI);
						updateUI();
					}
					else{
						JOptionPane.showMessageDialog(null, "Incorrect Username/Password.",
		        	             "Error!",
		        	             JOptionPane.ERROR_MESSAGE);
					}
				} catch (EmptyHashtableException | InvalidUsernameException
						| InvalidInputException | UsernameLengthException
						| PasswordLengthException e1) {
					//e1.printStackTrace();
					JOptionPane.showMessageDialog(null,  "Invalid Username/Password Input.",
	        	             "Error!",
	        	             JOptionPane.ERROR_MESSAGE);
				}
	        }
		});
	}
	
	


	
	/**
	 * Check if username matches password and allow access to scorekeeper view
	 * @param username Username of scorekeeper. Max 20 digits.
	 * @param password Password of scorekeeper. Max 20 digits.
	 * @throws UsernameLengthException Username is over 20 digits
	 * @throws PasswordLengthException Password is over 20 digits
	 * @throws EmtpyHashtableException Hashtable is empty. No scorekeepers in database
	 * @throws InvalidUsernameException Username doesn't exist in database
	 * @throws InvalidInputException Empty string or null string entered 
	 */
	public static boolean authenticate(String username, String password) throws EmptyHashtableException, InvalidUsernameException, InvalidInputException, UsernameLengthException, PasswordLengthException{
		
		// Boolean regarding if username and password matches
		boolean isMatch = false;
		
		// Check for valid input
		if (username.equals("") || password.equals("") || username == null || password == null) {
			throw new InvalidInputException();
		}
		// Check for empty Hashtable
		else if (credentials.isEmpty()) {
			throw new EmptyHashtableException();
		}
		// Check if username is over 20 digits
		else if (username.length() > 20) {
			throw new UsernameLengthException();
		}
		// Check if password is over 20 digits
		else if (password.length() > 20) {
			throw new PasswordLengthException();
		}
		// Check for valid username
		else if (!credentials.containsKey(username)) {
			throw new InvalidUsernameException();
		}
		else {
			isMatch = (credentials.get(username).equals(password));
			if (isMatch){
				scorekeeperUI = new ScorekeeperView();
			}
				
		}
		
		return isMatch;
	}

}
