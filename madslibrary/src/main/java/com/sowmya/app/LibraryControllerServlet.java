package com.sowmya.app;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sowmya.model.Book;
import com.sowmya.model.User;

@WebServlet(urlPatterns = "/home")
public class LibraryControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public LibraryControllerServlet() {
		super();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String choice = request.getParameter("id");
		LibraryService service = new LibraryService();
		String uname;
		String bname;
		long quantity;
		ArrayList<User> users = new ArrayList<>();
		ArrayList<Book> books = new ArrayList<>();
		

		switch (choice) {

		case "showBooks":
			books=service.showBooks();
			request.setAttribute("books", books);
			RequestDispatcher rd1 = request.getRequestDispatcher("displaybooks.jsp");
			rd1.forward(request, response);			
			break;
		case "addBook":
			bname = request.getParameter("bname");
			System.out.println(bname);
			quantity = Long.parseLong(request.getParameter("quantity"));
			service.addBook(bname,quantity);
			RequestDispatcher rd4 = request.getRequestDispatcher("welcome.jsp");
			rd4.forward(request, response);	
			break;
		case "addUser":
			uname = request.getParameter("uname");
			System.out.println(uname);
			service.addUser(uname);
			RequestDispatcher rd3 = request.getRequestDispatcher("welcome.jsp");
			rd3.forward(request, response);	
			break;
		case "users":
			users = service.showUsers();
			request.setAttribute("users", users);
			//System.out.println(users);
			RequestDispatcher rd = request.getRequestDispatcher("displayusers.jsp");
			rd.forward(request, response);			
			break;
		case "showUserBooks":
			System.out.println("showbooks");
			uname = request.getParameter("uname");
			ArrayList<String> u1 = service.showUserBooks(uname);
			System.out.println(u1);
			request.setAttribute("userbooks", u1);
			RequestDispatcher rd5 = request.getRequestDispatcher("displayuserbooksresult.jsp");
			rd5.forward(request, response);	
			break;
		case "checkOut":
			System.out.println("checkout");
			uname = request.getParameter("uname");
		    bname = request.getParameter("bname");
			String result = service.checkOut(bname,uname);
			System.out.println(result);
			RequestDispatcher rd2 = request.getRequestDispatcher("welcome.jsp");
			rd2.forward(request, response);	
			break;
			
		case "checkIn":
		    uname = request.getParameter("uname");
		    bname = request.getParameter("bname");
			service.checkIn(uname,bname);
			RequestDispatcher rd6 = request.getRequestDispatcher("welcome.jsp");
			rd6.forward(request, response);	
			break;

		}

	}

}
