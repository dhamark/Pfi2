import java.util.Calendar;

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

public class ThreadJourney extends Thread {


	private Parser par;
	private GUI gui;

	public ThreadJourney (Parser p, GUI g){
		this.par = p;
		this.gui = g;
	}

	public void run(){
String searchURL = Constants.getURL(gui.textField_1.getText(),gui.textField_2.getText(),20);
		
		Journeys journeys = Parser.getJourneys(searchURL);
		for (Journey journey : journeys.getJourneys()){
			
		gui.textArea_1.append(journey.getStartStation()+" - ");
		gui.textArea_1.append(""+journey.getEndStation());
		String time = journey.getDepDateTime().get(Calendar.HOUR_OF_DAY)
				+ ":" + journey.getDepDateTime().get(Calendar.MINUTE);
			gui.textArea_1.append(" departs "  + time + " that is in "+journey.getTimeToDeparture()+ " minutes. And it is "
				+journey.getDepTimeDeviation()+" min late" +"\n");
		}
}		
}
