/**
	Class Book represents a book for sale at a book store.
	This version of the class is a subclass of class BookStoreItem
	and inherits variables and methods from it. This class overrides
	the getSize() method that it inherits from BookStoreItem. This
	class also declares one variable named pages (declared here because
	other items sold at a book store (CDs and Tapes) do not contain pages.
	The getSize() method returns this variable's value, since the size of
	a book is how many pages are in it.
	Author: Corey Lucas
	E-mail address: clucas0044@kctcs.edu
	Last changed: 10/23/2015
	Lab 02
*/

public class Book extends BookStoreItem {
	
	/*
	* The constructor
	* Contains code that initially sets up each Book object when it is
	* first created. Always has the same name as the class.
	*/
	
	private int pages;
	
	public Book (String title, String author, double price, int pages) {
		super(title, author, price);
		if (pages >= 0) {
			this.pages = pages;
		}
	}
	
	public Book () {
		//call the other constructor and pass it a generic  title, author and price
		this("title", "author", 0.0,0);
	}
	
	public int getSize(){
		
		return pages;
		
	}
	
	/*
	* method toString() returns a String representation of this Book object
	* It calls the superclass's version of the toString() method to reuse
	* the code there, and only adds what details it needs to
	*/
	public String toString() {
		String book;
		book = "Book:\n" + super.toString() + 
				"\nPages: " + this.pages;
		return book;
	}
	
	public boolean equals(Object obj) {
		boolean equalBooks;
			
		equalBooks = super.equals(obj);
		
		if (equalBooks) {
			if (obj instanceof Book) {
				if (this.pages != ((Book)obj).pages) {
					equalBooks = false;
				}
			}
		}
		
		return equalBooks;
	}
		
}
