package com.dnb;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class WriteFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			FileOutputStream outputStream = new FileOutputStream("writetest.txt");
			 OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-16");
	         BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
	         bufferedWriter.write("test");
	         bufferedWriter.close();
	         outputStreamWriter.close();
	         outputStream.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
