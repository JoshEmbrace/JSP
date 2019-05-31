package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class SignUp extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; UTF-8");
		
		String name_ = request.getParameter("name");
		String id_ = request.getParameter("id");
		String email_ = request.getParameter("email");
		String psw_ = request.getParameter("psw");
		String mnum_ = request.getParameter("mnum");

		Integer mnum = 0;

		if (mnum_ != null)
			mnum = Integer.parseInt(mnum_);

		PrintWriter out = response.getWriter();

		out.printf("축하합니다."+name_+"님의 회원가입이 완료되었습니다.");
		out.printf("<br><br>이름 : "+name_);
		out.printf("<br>아이디 : "+id_);
		out.printf("<br>psw : "+psw_.substring(0, 2)+"***");
		out.printf("<br>E-mail : "+email_);
		out.printf("<br>핸드폰 번호 : "+mnum);
	}

}
