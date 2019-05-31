package com.newlecture.web.dao.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Notice;

public class OracleNoticeDao implements NoticeDao {

	@Override
	public List<NoticeView> getList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return getList(1,"title","");
	}

	@Override
	public List<NoticeView> getList(int page) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return getList(page,"title","");
	}

	@Override
	public List<NoticeView> getList(int page, String field, String query) throws ClassNotFoundException, SQLException {
		List<NoticeView> list = new ArrayList<>();

		int start = 1 + (page - 1) * 10; // 1, 11, 21, 31, 41...
		int end = page * 10; // 10, 20, 30, 40, ...

		String sql = "SELECT * FROM NOTICE_VIEW " + " WHERE " + field + "  LIKE ? AND NUM BETWEEN ? AND ?";

		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%" + query + "%"); // -> "%A%" -> '%A%'
		st.setInt(2, start);
		st.setInt(3, end);

		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			NoticeView notice = new NoticeView(
					rs.getInt("id"),
					rs.getString("title"), 
					"",
					rs.getString("writer_id"), 
					rs.getDate("regdate"), 
					rs.getInt("hit"), 
					rs.getInt("comment_Count")
					);
			list.add(notice);
		}

		rs.close();
		st.close();
		con.close();

		return list;
	}

	@Override
	public Notice get(int id) throws ClassNotFoundException, SQLException {

		Notice notice = null;

		// String sql = String.format("select *from notice where id=%d", id);
		String sql = "select * from notice where id=" + id;

		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);

		if (rs.next()) {
			notice = new Notice(
					rs.getInt("id"), 
					rs.getString("title"),
					rs.getString("content"),
					rs.getString("writer_id"), 
					rs.getDate("regdate"), 
					rs.getInt("hit")
					);
		}

		rs.close();
		st.close();
		con.close();

		return notice;

	}

	@Override
	public Notice getPrev(int id) throws ClassNotFoundException, SQLException {

		Notice notice = null;

		String sql = " select * from (select * from notice_view order by regdate desc) "
				+ " where regdate < (select regdate from notice where id = " + id + " ) and rownum = 1 ";
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);

		if (rs.next()) {
			notice = new Notice(
					rs.getInt("id"),
					rs.getString("title"), 
					"",
					rs.getString("writer_id"), 
					rs.getDate("regdate"), 
					rs.getInt("hit")
					);
		}

		rs.close();
		st.close();
		con.close();

		return notice;

	}

	@Override
	public Notice getNext(int id) throws ClassNotFoundException, SQLException {

		Notice notice = null;

		String sql = " select * from (select * from notice_view order by regdate) "
				+ " where regdate > (select regdate from notice where id = " + id + " ) and rownum = 1 ";

		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);

		if (rs.next()) {
			notice = new Notice(
					rs.getInt("id"),
					rs.getString("title"),
					"",
					rs.getString("writer_id"),
					rs.getDate("regdate"), 
					rs.getInt("hit")
					);
		}

		rs.close();
		st.close();
		con.close();

		return notice;

	}

	@Override
	public int insert(Notice notice) throws ClassNotFoundException, SQLException {

		int result = 0;
		/*
		 * String sql = String.format("insert into notice values(%d,'%s','%s',%s,%d)",
		 * notice.getId(), notice.getTitle(), notice.getWriterId(), null,
		 * notice.getHit());
		 */
		String sql = "INSERT INTO NOTICE(id, title, content, writer_id)" + "values(NOTICE_SEQ.NEXTVAL, ? ,? ,'bang')";
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");
		// Statement st = con.createStatement();
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, notice.getTitle());
		st.setString(2, notice.getContent());
		// st.setInt(3, notice.getId());
		/*
		 * ResultSet a = st.executeQuery(sql); //만들어진 테이블 조회해서 가져오기
		 */
		result = st.executeUpdate();// 연동된 DB에 입력하기

		st.close();
		con.close();

		return result;
	}

	@Override
	public int update(Notice notice) throws ClassNotFoundException, SQLException {
		
		int result = 0;

		/*
		 * String sql = String.
		 * format("update notice set id=%d, title='%s', writer_id = '%s' where id = 12345"
		 * , notice.getId(), notice.getTitle(), notice.getWriterId());
		 */
		int id = notice.getId();
		String sql = "update notice set title=?, content=? where id ="+id;

		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, notice.getTitle());
		st.setString(2, notice.getContent());
		/*
		 * ResultSet a = st.executeQuery(sql); //만들어진 테이블 조회해서 가져오기
		 */
		result = st.executeUpdate();// 연동된 DB에 입력하기

		st.close();
		con.close();

		return result;
	}

	@Override
	public int delete(int id) throws ClassNotFoundException, SQLException {
		int result = 0;

		String sql = "delete from notice where id=?";

		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);
		/*
		 * ResultSet a = st.executeQuery(sql); //만들어진 테이블 조회해서 가져오기
		 */
		result = st.executeUpdate();// 연동된 DB에 입력하기

		st.close();
		con.close();

		return result;
	}

}
