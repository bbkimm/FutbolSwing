package futbolSwing;
import java.util.ArrayList;
/*
import mysql.Connect;*/


import com.fourpointzeroteam.nathan.fantasyfutbol.Futbol.exception.EmptyListException;
import com.fourpointzeroteam.nathan.fantasyfutbol.Futbol.exception.IdLengthException;
import com.fourpointzeroteam.nathan.fantasyfutbol.Futbol.exception.InvalidInputException;
import com.fourpointzeroteam.nathan.fantasyfutbol.Futbol.exception.MatchNotFoundException;
import com.fourpointzeroteam.nathan.fantasyfutbol.Futbol.exception.NameLengthException;
import com.fourpointzeroteam.nathan.fantasyfutbol.Futbol.exception.NumberLengthException;
import com.fourpointzeroteam.nathan.fantasyfutbol.Futbol.exception.PlayerNotFoundException;
import com.fourpointzeroteam.nathan.fantasyfutbol.Futbol.exception.TeamNotFoundException;
import com.fourpointzeroteam.nathan.fantasyfutbol.Futbol.soccer.*;

/**
 * General container for the Match, Team and Player databases. Contains getter methods in order to access objects from database.
 */
public class DatabaseManager {
	
	/**
	 * List of the teams in the database
	 */
	public static ArrayList<Team>	listTeams = new ArrayList<Team>();
	
	/**
	 * List of the players in the database
	 */
	public static ArrayList<Player> listPlayers = new ArrayList<Player>();
	
	/**
	 * List of the matches in the database
	 */
	public static ArrayList<Match> listMatchs = new ArrayList<Match>();
	
	/**
	 * List of infractions in the database
	 */
	public static ArrayList<Infraction> listInfractions = new ArrayList<Infraction>();
	
	/**
	 * List of Shots in the database
	 */
	public static ArrayList<Shot> listShots = new ArrayList<Shot>();
	
	
	/**
	 * mySQL connection object
	 */
/*	private static Connect con;
	
	*//**
	 * Starts up DatabaseManager, connects to mySQL database, then starts DatabaseController
	 * @param connect connection class to mySQL database
	 *//*
	public static void start(){
		Connect con = new Connect();
		DatabaseController.start(con);
	}
	*/
	
	/**
	 * Getter method returns match that matches matchID
	 * @param matchID matchID of match
	 * @return match  match with matching MatchID
	 * @throws MatchNotFoundException  Match not found in database
	 */
	public static Match getMatch(int matchID) throws MatchNotFoundException {
		for (int i=0; i < listMatchs.size(); i++) {
			if (listMatchs.get(i).getID() == matchID) {
				return listMatchs.get(i);
			}
		}
		throw new MatchNotFoundException();
	}
	
	/**
	 * Getter method that returns a list of the matchs
	 * @return list of matchs
	 * @throws EmptyListException Exception caused by a database with an empty list of matchs
	 */
	public static ArrayList<Match> getMatchList() throws EmptyListException {
		if (listMatchs == null)
			throw new EmptyListException();
		else
			return listMatchs;	
	}
	
	/**
	 * Getter method returns team that matches teamID
	 * @param teamID teamID of team 
	 * @return team with matching TeamID
	 * @throws TeamNotFoundException Team not found in database
	 */
	public static Team getTeam(int teamID) throws TeamNotFoundException {
		for (int i=0; i < listTeams.size(); i++) {
			if (listTeams.get(i).getID() == teamID) {
				return listTeams.get(i);
			}
		}
		throw new TeamNotFoundException();
	}
	
	/**
	 * Getter method that returns a list of the teams
	 * @return list of teams
	 * @throws EmptyListException Exception caused by a database with an empty list of teams
	 */
	public static ArrayList<Team> getTeamList() throws EmptyListException {
		if (listTeams == null)
			throw new EmptyListException();
		else
			return listTeams;	
	}
	
	/**
	 * Getter method returns player that matches playerID
	 * @param playerID playerID of player
	 * @return player with matching PlayerID
	 * @throws PlayerNotFoundException Player not found in database
	 */
	public static Player getPlayer(int playerID) throws PlayerNotFoundException {
		for (int i=0; i < listPlayers.size(); i++) {
			if (listPlayers.get(i).getID() == playerID) {
				return listPlayers.get(i);
			}
		}
		throw new PlayerNotFoundException();
	}
	
	/**
	 * Getter method that returns a list of the players
	 * @return list of Players
	 * @throws EmptyListException Exception caused by a database with an empty list of players
	 */
	public static ArrayList<Player> getPlayerList() throws EmptyListException {
		if (listPlayers == null)
			throw new EmptyListException();
		else
			return listPlayers;	
	}
	
	/**
	 * Adds a player into the database
	 * @param player
	 * @param teamID
	 */
	public static void addPlayer(Player player, int teamID){
		//Add player
		listPlayers.add(player);
		
		//Add player to team
		for(int i = 0; i < listTeams.size(); i++){
			if(listTeams.get(i).getID() == teamID){
				listTeams.get(i).addPlayerToTeam(player);
				break;
			}
		}
	}
	
	/**
	 * Adds a team into the database
	 * @param team
	 */
	public static void addTeam(Team team){
		//Add team
		listTeams.add(team);
	}
	
	/**
	 * Adds a match into the database
	 * @param match
	 */
	public static void addMatch(Match match){
		//Add a match
		listMatchs.add(match);
	}
	
	/**
	 * Adds an infraction into the database
	 * @param match
	 */
	public static void addInfraction(Infraction infraction){
		//Add a match
		listInfractions.add(infraction);
	}
	
	/**
	 * Adds a shot into the database
	 * @param match
	 */
	public static void addShot(Shot shot){
		//Add a match
		listShots.add(shot);
	}

	//TEST "DATABASE"
	public static void initiateData(){
	Team Dragons = new Team(1);
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
    
    /*ArrayList<Team> listTeams = new ArrayList<>();
    ArrayList<Player> listPlayers = new ArrayList<>();*/
    
    listTeams.add(Dragons);
    listTeams.add(Pheonix);
    listTeams.add(Triades);
    listTeams.add(Redman);
    
    listPlayers.add(nathanlarue);
    listPlayers.add(briankimlim);
    listPlayers.add(kevinnam);
    listPlayers.add(alexanderwu);
    listPlayers.add(xavierfortin);
    listPlayers.add(charlesbedard);
    listPlayers.add(alexbirer);
    listPlayers.add(felixpoulin);
	
    Dragons.addPlayerToTeam(nathanlarue);
    Dragons.addPlayerToTeam(briankimlim);
    
    Pheonix.addPlayerToTeam(kevinnam);
    Pheonix.addPlayerToTeam(alexanderwu);
    
    Triades.addPlayerToTeam(xavierfortin);
    Triades.addPlayerToTeam(charlesbedard);
    
    Redman.addPlayerToTeam(alexbirer);
    Redman.addPlayerToTeam(felixpoulin);
	}
}