package com.revature._611.springbeans;

public class GameState {
	// ROUND: A lap around each players. In round 1, not all players have had a turn
	// in round 2, each player has had at least 1 turn;
	private int round;
	// TURN: One set of player phases and actions. Makes up rounds. Is comprised of
	// a research and combat phase.
	private int turn;
	// PHASE: Research is represented by 1, Combat by two.
	private int phase;
	
	public String toJsonString() {
		StringBuilder json = new StringBuilder();
		
		json.append("{");
		json.append("\n");
		json.append("\"round\": \"" + this.round + "\",");
		json.append("\n");
		json.append("\"turn\": \"" + this.turn + "\",");
		json.append("\n");
		json.append("\"phase\": \"" + this.phase + "\"");
		json.append("\n");
		json.append("}");
		
		return json.toString();
	}
	
	public GameState() {
		/*
		 * Initializes a default fresh game, in round one, first player's turn, and
		 * starting with their research phase.
		 */
		super();
		this.round = 1;
		this.turn = 0;
		this.phase = 1;
	}

	public GameState(int round, int turn, int phase) {
		/*
		 * Should ONLY be used for TESTING
		 */
		super();
		this.round = round;
		this.turn = turn;
		this.phase = phase;
	}
	
	public boolean step(int numPlayers) {
		/*
		 * INPUT: Number of Players (int)
		 * OUTPUT: Research Start? (boolean)
		 * DESCRIPTION: Moves the game a step forward, taking the number of players
		 * remaining in the game into account.
		 */
		boolean output = false;
		
		System.out.println("\tPRE: " + round + ", " + turn + ", " + phase);
		if (++phase > 2){
			//System.out.println("\tIF ++Phase: " + round + ", " + turn + ", " + phase);
			if (++turn >= numPlayers) {
				//System.out.println("\tIf ++Turn: " + round + ", " + turn + ", " + phase);
				round++;
				turn = 0;
			}
			//System.out.println("\tPOST if ++Turn: " + round + ", " + turn + ", " + phase);
			phase = 1;
		}
		System.out.println("\tPOST: " + round + ", " + turn + ", " + phase);
		
		if(phase == 1){
			// If we just entered the research phase, let people know
			// so we can hand out some research counters
			return true;
		}
		return output;
	}
	
	public int getRound() {
		return round;
	}
	public void setRound(int round) {
		this.round = round;
	}
	public int getTurn() {
		return turn;
	}
	public void setTurn(int turn) {
		this.turn = turn;
	}
	public int getPhase() {
		return phase;
	}
	public void setPhase(int phase) {
		this.phase = phase;
	}

	@Override
	public String toString() {
		return "GameState [round=" + round + ", turn=" + turn + ", phase=" + phase + "]";
	}

	
}
