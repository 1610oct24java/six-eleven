package com.revature._611.game;

public class GameState {
	// ROUND: A lap around each players. In round 1, not all players have had a turn
	// in round 2, each player has had at least 1 turn;
	private int round;
	// TURN: One set of player phases and actions. Makes up rounds. Is comprised of
	// a research and combat phase.
	private int turn;
	// PHASE: Research is represented by 1, Combat by two.
	private int phase;
	
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
	
	public void step(int numPlayers) {
		/*
		 * INPUT: Number of Players (int)
		 * OUTPUT: None
		 * DESCRIPTION: Moves the game a step forward, taking the number of players
		 * remaining in the game into account.
		 */
		if (++phase > 2){
			if (++turn > numPlayers) {
				round++;
				turn = 0;
			}
			phase = 1;
		}
		
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
