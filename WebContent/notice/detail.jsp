<%@page import="com.newlecture.web.dao.file.FileNoticeDao"%>
<%@page import="com.newlecture.web.dao.NoticeDao"%>
<%@page import="java.util.Scanner"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="com.jhtacybercampus.web.entity.Notice"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
   
	NoticeDao noticeDao = new FileNoticeDao();
	int id = Integer.parseInt(request.getParameter("id"));
	Notice n = noticeDao.get(id);

%>

<!DOCTYPE html>s
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Document</title>
</head>
<body>
	<h1>공지사항</h1>

	<table>
		<tr>
			<td>제목:</td>
			<td><%=n.getTitle() %></td>
		</tr>
		<tr>
			<td>작성자:</td>
			<td><%=n.getWriterId() %></td>
		</tr>
		<tr>
			<td>작성일</td>
			<td><%=n.getRegDate() %></td>
		</tr>
	</table>
</body>
</html>