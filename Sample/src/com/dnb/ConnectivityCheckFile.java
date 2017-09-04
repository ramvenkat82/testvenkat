package com.dnb;

import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

//import org.apache.commons.net.telnet.TelnetClient;
public class ConnectivityCheckFile extends TimerTask {
	public static void main(String args[]) {
		try {
			FileInputStream fstream = new FileInputStream("IP_list.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(
					fstream));

			String strLine;
			Socket s1 = null;
			InputStream is = null;
			DataInputStream dis = null;
			 FileOutputStream outputStream = new FileOutputStream("reports.txt");
			 OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-16");
	         BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
			// Read File Line By Line
			while ((strLine = br.readLine()) != null) {
				// Print the content on the console
				String[] arr = strLine.split("[ \t]");
				String IP = arr[0];
				int port = Integer.parseInt(arr[1]);

				try {
					s1 = new Socket(IP, port);
					is = s1.getInputStream();
					dis = new DataInputStream(is);
					if (dis != null) {
						bufferedWriter.write(IP+"\t"+ port+ "\t" +"PASS");
					} else {
						System.out.println("Connection invalid");
					}

				} catch (Exception e) {
					bufferedWriter.write(IP+"\t"+ port+ "\t" +"FAIL");

				}
				 bufferedWriter.newLine();
			}
			// Close the input stream
			if(br != null)br.close();
			if(dis != null)dis.close();
			if(s1 != null)s1.close();
			if(bufferedWriter != null)bufferedWriter.close();
			if(outputStreamWriter != null)outputStreamWriter.close();
			if(outputStream != null)outputStream.close();
		} catch (Exception e) {
e.printStackTrace();
		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
}