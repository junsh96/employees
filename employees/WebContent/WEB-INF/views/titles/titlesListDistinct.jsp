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
	<h1>�������(�ߺ����� distinct)</h1>
	<a href="${pageContext.request.contextPath}/">Ȩ����</a>
	<ol>
		<c:forEach var="row" items="${list}">
			<li>${row}</li>
		</c:forEach>
	</ol>
</body>
</html>