package com.practice.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModifyBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "datamaster";
		String pw = "1234";

		Connection con= null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);

			con = DriverManager.getConnection(url, id, pw);
			String sql = "UPDATE book SET book_loc = ? WHERE book_name = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "001-00055");
			pstmt.setString(2, "book44");
			
			int result = pstmt.executeUpdate();

			if (result == 1) {
				out.print("INSERT success");
			} else {
				out.print("INSERT fail");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(con != null) {
					con.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}