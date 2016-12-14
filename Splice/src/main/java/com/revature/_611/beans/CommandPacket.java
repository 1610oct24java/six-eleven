package com.revature._611.beans;

public class CommandPacket {
	private String lobbyName;
	private String command;
	private String data;
	private String from;
	
	
	
	public CommandPacket(String lobbyName, String command, String data, String from) {
		super();
		this.lobbyName = lobbyName;
		this.command = command;
		this.data = data;
		this.from = from;
	}
	
	
	public CommandPacket() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "CommandPacket [lobbyName=" + lobbyName + ", command=" + command + ", data=" + data + ", from=" + from
				+ "]";
	}

	public String getLobbyName() {
		return lobbyName;
	}
	public void setLobbyName(String lobbyName) {
		this.lobbyName = lobbyName;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	
	
}
