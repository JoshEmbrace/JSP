<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header id="header">
	<!-- <div style="background:rgb(255, 172, 199); width:100px;">BBBB</div> -->
	<div class="content-box">
		<h1 id="logo">뉴렉처 온라인</h1>
		<section class="menu-box">
			<h1 class="d-none">머릿말</h1>

			<nav id="main-menu">
				<h1 class="d-none">메인메뉴</h1>
				<ul>
					<li><a href="">학습가이드</a></li>
					<li><a href="">강좌선택</a></li>
					<li><a href="">AnswerIs</a></li>
				</ul>
			</nav>

			<section id="lecture-search-form">
				<h1 class="d-none">강좌선택 폼</h1>
				<form>
					<label>과정검색</label> <input type="text"> <input
						type="submit" value="검색">
				</form>
			</section>

			<nav id="right-menu">
				<h1 class="d-none">우측회원관리메뉴</h1>
				<nav id="member-menu">
					<h1 class="d-none">회원 메뉴</h1>
					<ul>
						<li><a href="">HOME</a></li>
						<c:if test="${not empty id}">
							<li><a href="/member/logout">로그아웃</a></li>
						</c:if>
						<c:if test="${empty id}">
							<li><a href="/member/login">로그인</a></li>
						</c:if>
						<li><a href="">회원가입</a></li>
					</ul>
				</nav>
				<nav id="direct-menu">
					<h1 class="d-none">자주사용하는 메뉴</h1>
					<ul>
						<li>마이페이지</li>
						<li>고객센터</li>
					</ul>
				</nav>
			</nav>

		</section>
	</div>
</header>