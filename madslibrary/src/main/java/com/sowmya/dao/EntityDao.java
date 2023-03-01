package com.sowmya.dao;

import com.sowmya.db.DBManager;
import com.sowmya.model.Book;
import com.sowmya.model.Entity;
import com.sowmya.model.User;
import com.sowmya.model.UserBooks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EntityDao extends DBManager {

	public void insertToDb(Entity e1) {

		loadDriver();
		Connection con = getConnection();
		String sql;

		PreparedStatement ps = null;

		try {
			if (e1 instanceof Book) {
				sql = "insert into books(bname,quantity) values (?,?)";
				ps = getPreparedStatement(con, sql);
				ps.setString(1,((Book) e1).getName());
				ps.setLong(2,((Book) e1).getQuantity());
				ps.executeUpdate();
			} else if (e1 instanceof User) {
				sql = "insert into users(uname) value (?)";
				ps = getPreparedStatement(con, sql);
				ps.setString(1,((User) e1).getName());
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			System.out.println("!!! Sql Exception");
		} finally {
			closePreparedStatement(ps);
			closeConnection(con);
		}

	}

	public ArrayList<Book> loadBooksFromDb() {
		ArrayList<Book> book = new ArrayList<>();
		loadDriver();
		Connection con = getConnection();
		String sql = "select * from books";

		PreparedStatement ps = getPreparedStatement(con, sql);

		try {

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Book b1 = new Book(rs.getString("bname"), rs.getLong("quantity"));
				book.add(b1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeConnection(con);
		closePreparedStatement(ps);

		return book;

	}

	public Book checkIfBookAvailable(String bname) {
		Book b1 = new Book();
		loadDriver();
		Connection con = getConnection();
		String sql = "select * from books where bname=?";

		PreparedStatement ps = getPreparedStatement(con, sql);

		try {
			ps.setString(1,bname);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
			 b1 = new Book(rs.getString("bname"), rs.getLong("quantity"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeConnection(con);
		closePreparedStatement(ps);

		return b1;

	}
	
	public User checkIfUserAvailable(String uname) {
		User u1 = new User();
		loadDriver();
		Connection con = getConnection();
		String sql = "select * from users where uname=?";

		PreparedStatement ps = getPreparedStatement(con, sql);

		try {
			ps.setString(1,uname);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
			 u1 = new User(rs.getString("uname"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeConnection(con);
		closePreparedStatement(ps);

		return u1;

	}


	public void updateBookQuantity(Book b1) {

		loadDriver();
		Connection con = getConnection();
		String sql = "update books set quantity=? where bname=?";
		PreparedStatement ps = getPreparedStatement(con, sql);

		try {
			ps.setLong(1, b1.getQuantity());
			System.out.println(b1.getQuantity());
			ps.setString(2, b1.getName());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeConnection(con);
		closePreparedStatement(ps);

	}

	public void addUSerBook(String uname, String bname) {

		loadDriver();
		Connection con = getConnection();
		String sql = "insert into userbooks values (?,?)";

		PreparedStatement ps = getPreparedStatement(con, sql);
		try {
			ps.setString(1, uname);
			ps.setString(2, bname);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection(con);
		closePreparedStatement(ps);

	}

	public UserBooks loadUserBooksFromDb(String uname) {

		UserBooks u1 = new UserBooks(uname);
		ArrayList<String> books = new ArrayList<>();
		loadDriver();
		Connection con = getConnection();
		String sql = "select bname from userbooks where uname=?";

		PreparedStatement ps = getPreparedStatement(con, sql);

		try {
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				books.add(rs.getString("bname"));
				u1.setUserBooks(books);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeConnection(con);
		closePreparedStatement(ps);

		return u1;

	}

	public ArrayList<User> loadUsersFromDb() {
		ArrayList<User> users = new ArrayList<>();
		loadDriver();
		Connection con = getConnection();
		String sql = "select uname from users";

		PreparedStatement ps = getPreparedStatement(con, sql);

		try {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User u1 = new User(rs.getString("uname"));
				users.add(u1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeConnection(con);
		closePreparedStatement(ps);

		return users;

	}

	public boolean updateUserBooks(String uname, String bname) {
		boolean result = false;
		Connection con = getConnection();
		String sql = "delete from userbooks where uname=? && bname= ?";

		PreparedStatement ps = getPreparedStatement(con, sql);

		try {
			ps.setString(1, uname);
			ps.setString(2, bname);
			ps.executeUpdate();
			result = true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeConnection(con);
		closePreparedStatement(ps);

		return result;

	}

}
