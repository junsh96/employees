<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>업무목록(중복제거 distinct)</h1>
	<a href="${pageContext.request.contextPath}/">홈으로</a>
	<ol>
		<c:forEach var="row" items="${list}">
			<li>${row}</li>
		</c:forEach>
	</ol>
</body>
</html>