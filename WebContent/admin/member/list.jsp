<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%
	List<Map<String,String>> members = new ArrayList<>();
	Map<String, String> member; //members라는 이름의 map 객체 만들기
	
	member = new HashMap<>();
	member.put("id","dragon");
	member.put("name","손오공");
	members.add(member);
	
	member = new HashMap<>();
	member.put("id","moon");
	member.put("name","문재인");
	members.add(member);
%> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원목록</h1>
	<table border="1">
		<tr>
			<td>아이디</td>
			<td>이름</td>
		</tr>
		<%-- <%
		for(int i=0; i<2; i++){
		%>
		<tr>
			<td><%=members.get(i).get("id") %></td>
			<td><%=members.get(i).get("name") %></td>
		</tr>
		<% } %> --%>
		<c:forEach var="m" items="${members}">
			<tr>
				<td>${m.id }</td>
				<td>${m.name }</td>
			</tr>
		</c:forEach>
		<%
			int x = 30;
			pageContext.setAttribute("x", x);
		%>
		<div><%=request.getAttribute("x") %>, ${x}, ${requestScope.x}</div>
		<div><%=((Map<String, String>)request.getAttribute("member")).get("name")%>, ${member.name}</div>
		<%
		for(Map<String, String> a: ((List<Map<String, String>>)request.getAttribute("members"))){
		%>
		<tr>
			<td><%=a.get("id") %></td>
			<td><%=a.get("name") %></td>
		</tr>
		<% } %>
		
		
	</table>
</body>
</html>