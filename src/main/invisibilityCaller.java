package main;

import java.io.IOException;

public class invisibilityCaller {
	
	private static Window window;
	private static settings set;
	public static Runtime runtime;
	
	public static void main(String[] args) throws IOException{
		set = new settings();
		window = new Window();
		
		if(!set.haveRulesBeenCreated){
			runtime.exec("netsh advfirewall firewall add rule name=\"nalolchat\" dir=out remoteip=192.64.174.69 protoc=TCP action=allow");
			runtime.exec("netsh advfirewall firewall add rule name=\"euwlolchat\" dir=out remoteip=185.40.64.69 protoc=TCP action=allow");
			runtime.exec("netsh advfirewall firewall add rule name=\"eunelolchat\" dir=out remoteip=185.40.64.111 protoc=TCP action=allow");
			runtime.exec("netsh advfirewall firewall add rule name=\"ocelolchat\" dir=out remoteip=192.64.169.22 protoc=TCP action=allow");
			
			set.haveRulesBeenCreated = true;
		}
	}

	private void cmdCall(String name, String dir, String ip, String protocol, String action) throws IOException{
		runtime = Runtime.getRuntime();
		runtime.exec("netsh advfirewall firewall add rule name=\""+ name +"\" dir="+ dir +" remoteip="+ ip +" protocol="+ protocol +" action="+ action +"");
	}
}
