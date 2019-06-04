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
	
	<jsp:include page="../../inc/header.jsp"></jsp:include>

	<!-- --visual block------------------------------------------------------------------ -->

	<div id="visual">
		<div class="content-box" style="position: relative"></div>
	</div>

	<!-- --body block------------------------------------------------------------------ -->


	<div id="body">
		<!-- <div class="content-box clear-fix"> -->
		<div class="content-box">
		
			<jsp:include page="../../inc/aside.jsp"></jsp:include>
			
			<main>
			<section>
				<h1>공지사항</h1>
				<section id="breadcrumb">
					<h1 class="d-none">경로</h1>
					<ol>
						<li>home</li>
						<li>고객센터</li>
						<li>공지사항</li>
					</ol>
				</section>
				<section>
					<h1>공지사항 내용</h1>
					<table>
						<tbody>
							<tr>
								<th>제목</th>
								<td>${notice.title}</td>
							</tr>
							<tr>
								<th>작성일</th>
								<td>${notice.regDate}</td>
							</tr>
							<tr>
								<th>첨부파일</th>
								<td>
								<c:forEach var="file" items="${noticeFiles}">
									<a href="/upload/${file.name}" download>${file.name}</a>
								</c:forEach>
								</td>
							</tr>
							<tr>
								<th>내용</th>
								<td>${notice.content}</td>
							</tr>
						</tbody>
					</table>
					<div>
						<a href="edit?id=${notice.id }">수정</a>
						<a href="del?id=${notice.id }">삭제</a>
					</div>
				</section>
			</section>
			<section>
                   <h1></h1>
                   <ul>
                      <li><span>이전글</span><a href="detail?id=${prev.id}">${prev.title}</a></li>
                      <li><span>다음글</span><a href="detail?id=${next.id}">${next.title}</a></li>
                   </ul>
                </section>
			</main>
			<!-- <div style="clear:left;"></div>
            css hack // 그리고 이에대한 더 나은 방법을 만듦 -> clearfix -->
		</div>
	</div>

	<!-- --footer block------------------------------------------------------------------ -->

	<jsp:include page="../../inc/footer.jsp"></jsp:include>

</body>

</html>