/**
	Class CD represents a CD for sale at a book store.
	This version of the class is a subclass of class BookStoreItem
	and inherits variables and methods from it. This class overrides
	the getSize() method that it inherits from BookStoreItem. This
	class also declares one variable named playingTime (declared here because
	other items, e.g., a Book, sold at a book store do not have a playing time.
	The getSize() method returns this variable's value, since the size of
	a CD is its playing time.
	Author: Corey Lucas
	E-mail address: clucas0044@kctcs.edu
	Last changed: 10/23/2015
	Lab 01
*/

public class CD extends BookStoreItem {
		
	/*
	* The constructor
	* Contains code that initially sets up each Book object when it is
	* first created. Always has the same name as the class.
	*/
	
	private int playingTime;
	
	public CD (String title, String author, double price, int playingTime) {
		super(title, author, price);
		if (playingTime >= 0) {
			this.playingTime = playingTime;
		}		
	}
	
	public CD () {
		//call the other constructor and pass it a generic  title, author, price and playingTime
		this("title", "author", 0.0, 0);
	}
	
	public int getSize(){
		
		return playingTime;
		
	}
		
	/*
	* method toString() returns a String representation of this object
	*/
	public String toString() {
		String cd = "CD:\n" + super.toString() +
						"\nPlaying time: " + this.playingTime;
		return cd;
	}
	
	public boolean equals(Object obj) {
		boolean equalCDs;
			
		equalCDs = super.equals(obj);
		
		if (equalCDs) {
			if (obj instanceof CD) {
				if (this.playingTime != ((CD)obj).playingTime) {
					equalCDs = false;
				}
			}
		}
		
		return equalCDs;
	}
		
}
