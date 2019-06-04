<%@page import="com.newlecture.web.dao.NoticeDao"%>
<%@page import="com.newlecture.web.dao.file.FileNoticeDao"%>
<%@page import="java.util.Scanner"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<jsp:include page="../../inc/header.jsp"></jsp:include>

    <!-- --visual block------------------------------------------------------------------ -->

    <div id="visual">
        <div class="content-box" style="position : relative">
        </div>
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
                       <h1>공지사항 검색</h1>
                       <form>
                          <select>
                             <option>제목</option>
                             <option>작성자</option>
                             <option>내용</option>
                          </select>                           
                           <input type="text" >
                           <input type="submit" value="검색" >
                       </form>
                    </section>
                    <section id="notice">
                        <h1 class="d-none">공지사항 목록</h1>
                        <form method="post">
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
                            <c:forEach var="n" items="${list}">
                           <c:if test="${param.eid == n.id}">
                              <tr>
                                 <td class="num">${n.id}</td>
                                 <td class="title">
                                    <input type="text" name="title" value="${n.title}">
                                    <input type="hidden" name="id" value="${n.id }">
                                    <span><input type="submit" value="저장"></span>
                                 </td>
                                 <td class="writer">${n.writerId}</td>
                                 <td class="date">${n.regDate}</td>
                                 <td class="hit">${n.hit}</td>
                              </tr>
                           </c:if>
                           <c:if test="${param.eid != n.id}">
                              <tr>
                                 <td class="num">${n.id}</td>
                                 <td class="title"><a href="detail?id=${n.id}">
                                       ${n.title} </a> <span>[23]</span> <span><a
                                       href="list?eid=${n.id}">수정</a><a href="">삭제</a></span></td>
                                 <td class="writer">${n.writerId}</td>
                                 <td class="date">${n.regDate}</td>
                                 <td class="hit">${n.hit}</td>
                              </tr>
                           </c:if>
                        </c:forEach>
                            </tbody>
                        </table>
                        </form>
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

                    <section id="pager">
                        <h1 class="d-none">페이지</h1>
                        <div>
                            <div>이전</div>
                            <ul>
                                <li><a href="list?p=1">1</a></li>
                                <li><a href="list?p=2">2</a></li>
                                <li><a href="list?p=3">3</a></li>
                                <li><a href="list?p=4">4</a></li>
                                <li><a href="list?p=5">5</a></li>
                            </ul>
                            <div>다음</div>
                        </div>
                    </section>
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