package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.BookVO;

public class BookDAO {

	Connection conn = null; // 데이터 베이스와 연결을 위한 객체
	PreparedStatement pstmt = null; // sql문 전송하는 객체인 PreparedStatement
	ResultSet rs = null; // SQL 질의에 의해 생성된 테이블을 저장하는 객체

	public void con() {
		try {
			// 1. JDBC 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. Connection 객체 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr"); // Connection 객체를 연결
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void discon() {
		try {
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void bookinsert(BookVO b) {
		con();
		String sql = "insert into BookVO values(?,?,?,?,?)"; // BookVO 안에 values 데이터를 집어넣는다는 뜻

		try {
			pstmt = conn.prepareStatement(sql); // 괄호 안에 실행시키고 싶은 sql문 넣기. 상기의 sql 문이 psmt 라는 객체로 만들어졌다.
			pstmt.setString(1, b.getId()); // 몇번째 물음표에 어떤 값을 넣을 것인지 쓰는 것이다.
			pstmt.setString(2, b.getTitle());
			pstmt.setString(3, b.getAuthor());
			pstmt.setString(4, b.getPublisher());
			pstmt.setInt(5, b.getPrice());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace(); // 예외정보 출력
		}
		discon();
	}

	public BookVO bookselect(String id) {
		con();

		BookVO m = null;
		String sql = "select * from BookVO where id=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				m = new BookVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
			}
			rs.close(); // rs 가 열려있다면 닫아라.
		} catch (Exception e) {
			System.out.println(e);
		}

		discon();
		return m;
	}

	public void bookupdate(BookVO b) {
		con();

		String sql = "update BookVO set title=?,author=?,publisher=?,price=? where id=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getId());
			pstmt.setString(2, b.getTitle());
			pstmt.setString(3, b.getAuthor());
			pstmt.setString(4, b.getPublisher());
			pstmt.setInt(5, b.getPrice());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace(); // 예외정보 출력
		}
		discon();

	}

	public void bookdelete() {
		con();

		String sql = "delete BookVO where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sql);
			pstmt.executeUpdate();
		} catch (SQLException e) { // 괄호에는 처리하고자하는 예외타입(SQLException), 참조변수(e)를 선언
			e.printStackTrace(); // 예외정보 출력
		}
		discon();

	}

	public ArrayList bookselectAll() {
		con();
		ArrayList<BookVO> m = new ArrayList<BookVO>();
		String sql = "select * from BookVO";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				m.add(new BookVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
			}
			rs.close(); // rs 가 열려있다면 닫아라.
		} catch (Exception e) {
			System.out.println(e);
		}
		discon();
		return m;
	}
}
