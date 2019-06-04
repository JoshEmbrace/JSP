<%@page import="com.newlecture.web.dao.NoticeDao"%>
<%@page import="com.newlecture.web.dao.file.FileNoticeDao"%>
<%@page import="java.util.Scanner"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" style="font-size: 10px">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Document</title>

<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<!-- //파일명/디렉토리 정하기(기준이 없다? 기준을 모른다?)->콘텐츠 선별->종류별 블록감싸기->아웃라인
->플랫폼API와 태그 그리고 시멘틱 태그-->

<body>
	<!-- --header block------------------------------------------------------------------ -->
	
	<jsp:include page="../inc/header.jsp"></jsp:include>

	<!-- --visual block------------------------------------------------------------------ -->

	<div id="visual">
		<div class="content-box" style="position: relative"></div>
	</div>

	<!-- --body block------------------------------------------------------------------ -->


	<div id="body">
		<!-- <div class="content-box clear-fix"> -->
		<div class="content-box">
		
			<jsp:include page="../inc/aside.jsp"></jsp:include>
			
			<main>
			<section>
				<h1>로그인</h1>
				<section id="breadcrumb">
					<h1 class="d-none">경로</h1>
					<ol>
						<li>home</li>
						<li>member</li>
						<li>login</li>
					</ol>
				</section>
				<section>
					<h1>로그인 폼</h1>
					<c:if test="${param.error==1}">
					<div style="color:red">
						아이디 또는 비밀번호가 유효하지 않습니다.
					</div>
					</c:if>
					<form method="post">
					<table>
						<tbody>
							<tr>
								<th>아이디</th>
								<td><input type="text" name ="id"></td>
							</tr>
							<tr>
								<th>비밀번호</th>
								<td><input type="password" name="pwd"></td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" name="로그인"></td>
							</tr>
						</tbody>
					</table>
					</form>
				</section>
			</section>
			</main>
			<!-- <div style="clear:left;"></div>
            css hack // 그리고 이에대한 더 나은 방법을 만듦 -> clearfix -->
		</div>
	</div>

	<!-- --footer block------------------------------------------------------------------ -->

	<jsp:include page="../inc/footer.jsp"></jsp:include>

</body>

</html>