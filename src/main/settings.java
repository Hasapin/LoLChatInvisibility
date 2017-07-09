package main;

public class settings {
	
	public int Width = 340;
	public int Height = 340;
	
	public String NA = "192.64.174.69";
	public String EUW = "185.40.64.69";
	public String EUNE = "185.40.64.111";
	public String OCE = "192.64.169.22";
	
	private String naName = "nalolchat";
	private String euwName = "euwlolchat";
	private String euneName = "eunelolchat";
	private String oceName = "ocelolchat";
	
	public String naAction = "allow";
	public String euwAction = "allow";
	public String euneAction = "allow";
	public String oceAction = "allow";

	private String dir = "out";
	private String protocol = "TCP";
	public boolean haveRulesBeenCreated = false;
}
