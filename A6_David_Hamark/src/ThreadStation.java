import java.util.ArrayList;

import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;


public class ThreadStation extends Thread{


	private Parser par;
	private GUI gui;

	public ThreadStation (Parser p, GUI g){
		this.par = p;
		this.gui = g;
	}

	public void run(){
		ArrayList<Station> searchStations = new ArrayList<Station>();
		
		searchStations.addAll(Parser.getStationsFromURL(gui.textField.getText())); // Lägger till stationer innehållandes malmö. 
		System.out.println(Parser.getStationsFromURL(gui.textField.getText()));
		for (Station s: searchStations){
			System.out.println("loopar");
	       gui.textArea.append(s.getStationName() + " number" + s.getStationNbr() + "\n");
		}
		
}
	}