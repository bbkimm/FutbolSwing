package futbolSwing;

public class Player {
		
	private int index;
	private int id;
	    private int number;
	    private String name;
	    private int numShots;
	    private int numGoals;
	    private int numInfractions;
	 
	    public Player(String name, int number) {
	        this.name = name;
	        this.number = number;
	        
	        numShots = 0;
	        numGoals = 0;
			numInfractions = 0;
	    }
	     
	    public int getShots() {
			return this.numShots;
		}
	    public int getID() {
			return this.id;
		}
	    public int getIndex() {
			return this.index;
		}

		/**
		 * Getter method for player name
		 * @return name of player
		 */
		public String getName() {
			return this.name;
		}

		/**
		 * Getter method for player nb
		 * @return player's number
		 */
		public int getNumber() {
			return this.number;
		}

		/**
		 * Getter method for nb of goals
		 * @return nb of goals scored by player
		 */
		public int getNumGoals() {
			return this.numGoals;
		}
		public int getInfractions() {
			return this.numInfractions;
		}
		
		public void setName(String name){
				this.name = name;
		}
		public void setNumber(int number){
			this.number = number;
		}
		public void setShots(int shots){
			this.numShots = shots;
		}
		public void setGoals(int goals){
			this.numGoals = goals;
		}
		public void setInfractions(int infractions){
			this.numInfractions = infractions;
		}
		
		public void setIndex(int index){
			this.index = index;
		}
		
}
