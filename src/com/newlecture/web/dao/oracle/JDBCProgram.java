package com.newlecture.web.dao.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.newlecture.web.entity.Notice;

public class JDBCProgram {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
//		DriverManager;
//		Connection;
//		Statement;
//		ResultSet;
		Notice asdf = new Notice(0,"타이틀1","내용바꾸기","a",null,0);
		OracleNoticeDao qwe = new OracleNoticeDao();
		
//		qwe.insert(asdf);
//		qwe.update(asdf);
		qwe.delete(4444);
		
		/*
		 * Notice note; OracleNoticeDao ond = new OracleNoticeDao();
		 * 
		 * //ond.update(new Notice(12345,"진라면순한맛","농심",null,1000));
		 * 
		 * //note = ond.get(12345);
		 * 
		 * //ond.delete(41);
		 * 
		 * note = ond.getPrev(12345);
		 * 
		 * System.out.println(note.getId()); System.out.println(note.getTitle());
		 * System.out.println(note.getWriterId()); System.out.println(note.getHit());
		 * 
		 * System.out.println();
		 * 
		 * note = ond.getNext(12345);
		 * 
		 * System.out.println(note.getId()); System.out.println(note.getTitle());
		 * System.out.println(note.getWriterId()); System.out.println(note.getHit());
		 */
//		Scanner scan = new Scanner(System.in);
//		System.out.print("문자를 입력해주세요>");
//		String cha = scan.nextLine();
//		
//		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
//		//String sql = "SELECT * FROM MEMBER WHERE ID LIKE '%"+cha+"%'";
//		String sql = String.format("SELECT * FROM MEMBER WHERE ID LIKE \'%%%s%%\'", cha);
//		
//		Class.forName("oracle.jdbc.OracleDriver");
//		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");
//		Statement st = con.createStatement();
//		ResultSet rs = st.executeQuery(sql);
//
//		while(rs.next()) {
//			
//			String id = rs.getString("id");
//			String pwd = rs.getString("pwd");
//			String name = rs.getString("name");
//			
//			System.out.printf("id:%s, pwd:%s, name:%s\n", id, pwd, name);
//			
//		}
//		
//		rs.close();
//		st.close();
//		con.close();
		
	}

}
