

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Scanner;

public class ReadAndWriteScanner {

	public static void main(String[] args) {
		ReadAndWriteScanner st = new ReadAndWriteScanner();  //Skapa instans av mig själv :) för att inte köra i statisk kontext
		st.readAndWriteExample();	
	}
	

	//Read from the net
	public void readAndWriteExample(){
		
		String wholeCode="";
	try {
			URL turing = new URL("https://gist.githubusercontent.com/k3larra/a0d5e6ff7622f5a78872/raw/7958992cebf92e76b07f8adac820107894447b6f/Turing");
			Scanner s = new Scanner(turing.openStream());
			while (s.hasNext()){
//				int j = 0;
//				j++;
//				
//				int letter = 0+j;
//				int letter2 = 0+j;
//				letter2=letter*letter;
				
				
				String string = s.nextLine();
				wholeCode=wholeCode+string;
		//		System.out.println(string);

			}
			for(int i = 0; i < wholeCode.length(); i++){
				//letter++;
				System.out.println(wholeCode.charAt(i*i));
			}
			
			
			s.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}


