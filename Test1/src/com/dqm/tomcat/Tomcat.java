
package com.dqm.tomcat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.StringTokenizer;

interface Serlet {
	public String getContext();
}

class HelloSerlet implements Serlet {

	public String getContext() {
		// TODO Auto-generated method stub
		return "hello java";
	}
}

class DateSerlet implements Serlet {

	public String getContext() {
		// TODO Auto-generated method stub
		return "now time is"+new Date();
	}
	
}

public class Tomcat {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket server = new ServerSocket(8080);
			Socket client ;
			BufferedReader br = null;
			while(true){
				client = server.accept();
				br = new BufferedReader(
						new InputStreamReader(client.getInputStream()));
				String command = br.readLine();
				StringTokenizer stk = new StringTokenizer(command);
				System.out.println(stk.nextToken());
				String sStr = stk.nextToken().substring(1);
				sStr = "com.dqm.tomcat."+sStr;
				System.out.println(sStr);
				PrintStream ps = new PrintStream(client.getOutputStream());
				ps.println("<html>");
			
				ps.println("<body>");
				try {
					Serlet serlet = (Serlet)Class.forName(sStr).newInstance();
					ps.println(serlet.getContext());
					System.out.println(serlet.getContext());
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				ps.println("</body>");
				ps.println("</html>");
				System.out.println(ps.toString());
				ps.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
