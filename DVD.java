/**
	Class DVD represents a DVD for sale at a book store.
	This version of the class is a subclass of class BookStoreItem
	and inherits variables and methods from it. This class overrides
	the getSize() method that it inherits from BookStoreItem. This
	class also declares one variable named playingTime (declared here because
	other items, e.g., a Book, sold at a book store do not have a playing time.
	The getSize() method returns this variable's value, since the size of
	a DVD is its playing time.
	Author: Corey Lucas
	E-mail address: clucas0044@kctcs.edu
	Last changed: 10/23/2015
	Lab 01
*/

public class DVD extends BookStoreItem {
	
	/*
	* The constructor
	* Contains code that initially sets up each Book object when it is
	* first created. Always has the same name as the class.
	*/
	
	private int playingTime;
	
	public DVD (String title, String author, double price, int playingTime) {
		super(title, author, price);
		if (playingTime >= 0) {
			this.playingTime = playingTime;
		}	
	}
	
	public DVD () {
		//call the other constructor and pass it a generic  title, author and price
		this("title", "author", 0.0, 0);
	}
	
	public int getSize(){
		
		return playingTime;
		
	}
	
	/*
	* method toString() returns a String representation of this object
	*/
	public String toString() {
		String DVD = "DVD:\n" + super.toString() +
						"\nPlaying time: " + this.playingTime;
		return DVD;
	}
	
	public boolean equals(Object obj) {
		boolean equalDVDs;
			
		equalDVDs = super.equals(obj);
		
		if (equalDVDs) {
			if (obj instanceof DVD) {
				if (this.playingTime != ((DVD)obj).playingTime) {
					equalDVDs = false;
				}
			}
		}
		
		return equalDVDs;
	}
		
}
