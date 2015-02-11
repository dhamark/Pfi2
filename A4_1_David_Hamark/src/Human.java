
public class Human {

public int info; 
public String humanName; 
private Dog dog; 

	
public Human (String humanName){
	this.humanName = humanName; 
}

	
	public String getName(){
		return this.humanName;
	}


	public void buyDog(Dog dogName) {
		this.dog = dogName;
	}
	
	
	public String getInfo(){
		String s =  ""; 
		if (dog != null){
			
			s = getName() +" " +"has a dog with the name of" + " "+ dog.getName() + ".";
			return s;

		}else{

			s = getName() + " " + "does not own a dog.";
			return s;
			
		}
	
	}
}
