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
<meta name="viewport" content="width=device-width, initial-scale=1">
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
					<h1>공지사항 검색</h1>
					<form>
						<select>
							<option>제목</option>
							<option>작성자</option>
							<option>내용</option>
						</select> <input type="text"> <input type="submit" value="검색">
					</form>
				</section>
				<section id="notice">
					<h1 class="d-none">공지사항 목록</h1>
					<table>
						<thead>
							<tr>
								<td class="num">번호</td>
								<td class="title">제목</td>
								<td class="writer">작성자</td>
								<td class="date">작성일</td>
								<td class="hit">조회수</td>
							</tr>
						</thead>
						<tbody>
						
							<style>
								.even{
									background: beige;
								}
							
							</style>
							<c:forEach var="n" items="${list}" begin="0" end="9"
								varStatus="s">

								<c:if test="${s.count %2 == 0}">
									<tr class="even">
										<td class="num">${n.id}</td>
										<td class="title"><a href="detail?id=${n.id}">
												${s.count }/${s.current.title } : ${n.title} </a> <span>[23]</span>
										</td>
										<td class="writer">${n.writerId}</td>
										<td class="date">${n.regDate}</td>
										<td class="hit">${n.hit}</td>
									</tr>
								</c:if>
								<c:if test="${s.count %2 == 1}">
									<tr>
										<td class="num">${n.id}</td>
										<td class="title"><a href="detail?id=${n.id}">
												${s.count }/${s.current.title } : ${n.title} </a> <span>[23]</span>
										</td>
										<td class="writer">${n.writerId}</td>
										<td class="date">${n.regDate}</td>
										<td class="hit">${n.hit}</td>
									</tr>
								</c:if>

<%-- 								<tr class="even">
									<td class="num">${n.id}</td>
									<td class="title"><a href="detail?id=${n.id}">
											${s.index }/${s.current.title } : ${n.title} </a> <span>[23]</span>
									</td>
									<td class="writer">${n.writerId}</td>
									<td class="date">${n.regDate}</td>
									<td class="hit">${n.hit}</td>
								</tr> --%>
							</c:forEach>
						</tbody>
					</table>

					<div>
						<a href="reg">글쓰기</a>
					</div>
				</section>

				<section id="page-index">
					<h1 class="d-none">페이지 정보</h1>
					<div>
						<div>
							<span class="color-highight font-bold">1</span> / 1 pages
						</div>
					</div>
				</section>

				<!-- 1,6,11,16,21,....-> page + total 레코드 수 -> 마지막 번호 
               
	               page : 1     start ==> 1
	               page : 13     start ==> 11
	               page : 44     start ==> 41
	               page : 39     start ==> 36 
	               
	               page : 1~5    :=> 1
	               page : 6~10    :=> 6
	               
	               start =page - (page%5-1)
	               start = (page/5)*5+1
	               -->
				<c:set var="page" value="${ (empty param.p) ? 1 : param.p}" />

				<%-- <c:set var="start" value="${page%5 == 0 ? page-4 : page-(page%5-1)}"/> --%>
				<c:set var="start" value="${page-(page-1)%5}"/>
				<c:set var="last" value=""/>
				<section id="pager"> 
					<h1>페이지</h1>
					<div>
						<div><a href="list?p=${(start < 6) ? start : start-5}">이전</a></div>
						<ul>
							<c:forEach var="n" begin="${start}" end="${start+4}" varStatus="s">
								<li><a href="list?p=${n}">${n}</a></li>
							</c:forEach>
						</ul>
						<div><a href="list?p=${start+5 }">다음</a></div>
					</div>
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