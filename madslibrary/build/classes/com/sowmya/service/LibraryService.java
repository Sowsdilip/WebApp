package com.sowmya.service;

import java.util.ArrayList;
import com.sowmya.dao.EntityDao;
import com.sowmya.model.Book;
import com.sowmya.model.Entity;
import com.sowmya.model.User;
import com.sowmya.model.UserBooks;

public class LibraryService {

	Entity e1;
	ArrayList<Book> books = new ArrayList<>();
	ArrayList<User> users = new ArrayList<>();
	EntityDao dao = new EntityDao();

	public boolean bookExists(String bname) {

		boolean result = false;
		if (dao.checkIfBookAvailable(bname) != null)
			result = true;
		return result;
	}

	public boolean userExists(String uname) {
		boolean result = false;
		if (dao.checkIfUserAvailable(uname) != null)
			result = true;		
		return result;
	}

	public void addBook(String name, long quantity) {
		e1 = new Book(name, quantity);
		books.add((Book) e1);
		dao.insertToDb(e1);

	}

	public void addUser(String name) {
		// TODO Auto-generated method stub
		e1 = new User(name);
		users.add((User) e1);
		dao.insertToDb(e1);

	}

	public ArrayList<Book> showBooks() {
		books = dao.loadBooksFromDb();
		return books;
	}

	public ArrayList<User> showUsers() {
		users = dao.loadUsersFromDb();
		return users;
	}

	public ArrayList<String> showUserBooks(String uname) {

		UserBooks u1 = new UserBooks(uname);
		u1 = dao.loadUserBooksFromDb(uname);
		return u1.getUserBooks();
	}

	public String checkOut(String bname, String uname) {
		ArrayList<String> books;
		String result =null;
		UserBooks u1;
		Book b1;
		System.out.println("checkout Service");
		if (userExists(uname)) {
			if (bookExists(bname)) {
				b1 = dao.checkIfBookAvailable(bname);
				System.out.println(b1.getName());
				u1 = dao.loadUserBooksFromDb(uname);
				System.out.println(u1.getName());
				books = u1.getUserBooks();
				if (books.size() < 4) {
					books.add(bname);
					u1.setUserBooks(books);
					b1.setQuantity(b1.getQuantity() - 1);
					dao.addUSerBook(uname, bname);
					dao.updateBookQuantity(b1);
					result =  bname + " issued to " + uname;
				}
			} else
				result = "Book not Added";
		} else
			result = "User not Added";
		return result;
	}

	public void checkIn(String uname, String bname) {
		boolean result = false;
		Book b1 = dao.checkIfBookAvailable(bname);
		b1.setQuantity(b1.getQuantity()+1);
		dao.updateBookQuantity(b1);
		result = dao.updateUserBooks(uname, bname);
		System.out.println(result);
		System.out.println("Book " + bname + " returned by" + uname);
		}

}

	

