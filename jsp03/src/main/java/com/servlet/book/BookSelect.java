package com.servlet.book;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dao.BookDao;
import com.servlet.vo.BookVo;

public class BookSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDao bookDao = new BookDao();
		ArrayList<BookVo> list = bookDao.select();
		PrintWriter out = response.getWriter();
		
		for (int i = 0; i < list.size(); i++) {
			BookVo bookVo = list.get(i);
			int bookId = bookVo.getBookId();
			String bookName = bookVo.getBookName();
			String bookLoc = bookVo.getBookLoc();
			
			out.print("bookId : " + bookId + ", ");
			out.print("bookName : " + bookName + ", ");
			out.print("bookLoc : " + bookLoc + " <br>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
