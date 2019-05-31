package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/div")
public class DivServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; UTF-8");
		
		String x_ = request.getParameter("x");
		String y_ = request.getParameter("y");
		
		Float x = (float)0.0;
		Float y= (float)0.0;
		
		if(x_!=null)
			x = Float.parseFloat(x_);
		if(y_!=null)
			y = Float.parseFloat(y_);
		
		PrintWriter out = response.getWriter();
		out.println(x/y);
		
		
	}
	
	
}
