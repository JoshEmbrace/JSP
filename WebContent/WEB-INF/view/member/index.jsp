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
			
			</main>
			<!-- <div style="clear:left;"></div>
            css hack // 그리고 이에대한 더 나은 방법을 만듦 -> clearfix -->
		</div>
	</div>

	<!-- --footer block------------------------------------------------------------------ -->

	<jsp:include page="../inc/footer.jsp"></jsp:include>

</body>

</html>