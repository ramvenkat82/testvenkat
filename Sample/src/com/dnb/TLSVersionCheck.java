package com.dnb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class TLSVersionCheck {

	public static void main(String[] args) {
	      PrintStream out = System.out;

	      // Getting the default SSL socket factory
	      SSLSocketFactory f = 
	         (SSLSocketFactory) SSLSocketFactory.getDefault();
	      out.println("The default SSL socket factory class: "
	         +f.getClass());
	      try {
	      // Getting the default SSL socket factory
	         SSLSocket c =
	           (SSLSocket) f.createSocket("localhost", 9990);
	         printSocketInfo(c);
	         /*c.startHandshake();
	         BufferedWriter w = new BufferedWriter(new OutputStreamWriter(
	            c.getOutputStream()));
	         BufferedReader r = new BufferedReader(new InputStreamReader(
	            c.getInputStream()));
	         w.write("GET / HTTP/1.0");
	         w.newLine();
	         w.newLine(); // end of HTTP request
	         w.flush();
	         String m = null;
	         while ((m=r.readLine())!= null) {
	            out.println(m);
	         }
	         w.close();
	         r.close();
	         c.close();*/
	      } catch (IOException e) {
	         System.err.println(e.toString());
	      }
	   }
	   private static void printSocketInfo(SSLSocket s) {
	      System.out.println("Socket class: "+s.getClass());
	      System.out.println("   Remote address = "
	         +s.getInetAddress().toString());
	      System.out.println("   Remote port = "+s.getPort());
	      System.out.println("   Local socket address = "
	         +s.getLocalSocketAddress().toString());
	      System.out.println("   Local address = "
	         +s.getLocalAddress().toString());
	      System.out.println("   Local port = "+s.getLocalPort());
	      System.out.println("   Need client authentication = "
	         +s.getNeedClientAuth());
	      SSLSession ss = s.getSession();
	      System.out.println("   SessionID = "+ss.getId());
	     // System.out.println("   Cipher suite = "+ss.getCipherSuite());
	      System.out.println("   Protocol = "+ss.getProtocol());
	   }
	}