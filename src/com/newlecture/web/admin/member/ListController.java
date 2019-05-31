package com.newlecture.web.admin.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/member/list")
public class ListController extends HttpServlet{ // http://server/admin/member/list
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Map<String,String>> members = new ArrayList<>();
		Map<String, String> member; //members��� �̸��� map ��ü �����
		
		member = new HashMap<>();
		member.put("id","dragon");
		member.put("name","�տ���");
		members.add(member);
		
		member = new HashMap<>();
		member.put("id","moon");
		member.put("name","������");
		members.add(member);
		
		//���� ���� ���� = ���� ���� ����
		// application, session, request, page
		request.setAttribute("members", members);
		request.setAttribute("x", 10);
		request.setAttribute("member", member);
		request.setAttribute("y", new int[] {3,6,9});
		request.getRequestDispatcher("list.jsp").forward(request, response);

	}

}
