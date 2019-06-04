package com.newlecture.web.controller.admin.notice;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.NoticeFileDao;
import com.newlecture.web.dao.oracle.OracleNoticeDao;
import com.newlecture.web.dao.oracle.OracleNoticeFileDao;

@WebServlet("/admin/notice/detail")
public class DetailController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		NoticeDao noticeDao = new OracleNoticeDao();
		NoticeFileDao noticeFileDao = new OracleNoticeFileDao();
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		try {
			request.setAttribute("notice", noticeDao.get(id));
			request.setAttribute("prev", noticeDao.getPrev(id));
			request.setAttribute("next", noticeDao.getNext(id));
			
			request.setAttribute("noticeFiles", noticeFileDao.getListByNoticeId(id));
			System.out.println(noticeFileDao.getListByNoticeId(id).get(0).getName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/WEB-INF/view/notice/detail.jsp").forward(request, response);
		
	}

}
