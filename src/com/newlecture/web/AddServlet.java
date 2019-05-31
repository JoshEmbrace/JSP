package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/add")
public class AddServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		String result_ = request.getParameter("result");
		int result = 0;

		if(result_ != null)
			result = Integer.parseInt(result_);
			
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset=\"UTF-8\">");
		out.print("<title>Insert title here</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("	<form action=\"add\" method=\"post\">");
		out.print("		<div>");
		out.print("			<label>x : </label> <input type=\"text\" name=\"x\" />");
		out.print("		</div>");
		out.print("		<div>");
		out.print("			<label>y : </label> <input type=\"text\" name=\"y\" />");
		out.print("		</div>");
		out.print("		<div>");
		out.print("			<input type=\"submit\" value=\"덧셈\" />");
		out.print("		</div>");
		out.print("	</form>");
		out.print("결과 :");
		out.printf("%d", result);
		out.print("</body>");
		out.print("</html>");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String x_ = request.getParameter("x"); //문자열값을 비교하는 함수
			String y_ = request.getParameter("y");
			
			Integer x = 0;
			Integer y = 0;
			
			if(x_ != null)
				x = Integer.parseInt(x_);
			if(y_ != null)
				y = Integer.parseInt(y_);
			
			int result = x + y;
		
			
			//서버에서 다른 서블릿을 요청하는 방법
			//1.redirect
			response.sendRedirect("add?result="+result);
			//2.포워드 forward
			//request.getRequestDispatcher("add").forward(request, response);
			//GET -> GET, POST -> POST
	}	
	
/*	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		int result = 0;
		
		if(request.getMethod().equals("POST")) { //참조주소를 비교하는것이 아닌
			String x_ = request.getParameter("x"); //문자열값을 비교하는 함수
			String y_ = request.getParameter("y");
			
			Integer x = 0;
			Integer y = 0;
			
			if(x_ != null)
				x = Integer.parseInt(x_);
			if(y_ != null)
				y = Integer.parseInt(y_);
			
			result = x + y;
		}
		
		PrintWriter out = response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset=\"UTF-8\">");
		out.print("<title>Insert title here</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("	<form action=\"add\" method=\"post\">");
		out.print("		<div>");
		out.print("			<label>x : </label> <input type=\"text\" name=\"x\" />");
		out.print("		</div>");
		out.print("		<div>");
		out.print("			<label>y : </label> <input type=\"text\" name=\"y\" />");
		out.print("		</div>");
		out.print("		<div>");
		out.print("			<input type=\"submit\" value=\"덧셈\" />");
		out.print("		</div>");
		out.print("	</form>");
		out.print("결과 :");
		out.printf("%d", result);
		out.print("</body>");
		out.print("</html>");
		
	}
*/	
}
