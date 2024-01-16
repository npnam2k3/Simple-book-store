package vnua.fita.bookstore.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vnua.fita.bookstore.bean.Book;

public class BookDAO {
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;
	private Statement statement;
	private PreparedStatement preStatement;
	private ResultSet resultSet;

	public BookDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		super();
		this.jdbcURL = jdbcURL;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
	}

	public List<Book> listAllBooks() {
		// danh sach chua ket qua tra ve
		List<Book> listBook = new ArrayList<Book>();

		// cau lenh sql
		String sql = "SELECT * FROM	tblbook";

		// tao ket noi
		jdbcConnection = DBConnection.createConnection(jdbcURL, jdbcUsername,
				jdbcPassword);
		try {
			// tao doi tuong truy van CSDL
			statement = jdbcConnection.createStatement();

			// thuc hien truy van
			resultSet = statement.executeQuery(sql);

			// duyet qua danh sach ban ghi ket qua tra ve
			while (resultSet.next()) {
				int id = resultSet.getInt("book_id");
				String title = resultSet.getString("title");
				String author = resultSet.getString("author");
				int price = resultSet.getInt("price");
				int quantityInStock = resultSet.getInt("quantity_in_stock");
				String detail = resultSet.getString("detail");
				String imagePath = resultSet.getString("image_path");

				// đóng gói các giá trị thuộc tính vào đối tượng Bean(Book)
				Book book = new Book(id, title, author, price, quantityInStock);
				book.setDetail(detail);
				book.setImagePath(imagePath);

				// Thêm đối tượng Bean vào danh sách
				listBook.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(resultSet);
			DBConnection.closeStatement(statement);
			DBConnection.closeConnect(jdbcConnection);
		}
		return listBook;
	}

	public static void main(String[] args) {
		 BookDAO book = new BookDAO("jdbc:mysql://localhost:3306/bookstore", "root",
		 "123456");
		List<Book> listBook = book.listAllBooks();
		for (Book book2 : listBook) {
			System.out.println(book2);
		}
	}
}
