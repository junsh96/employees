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
	<h1>사원 목록</h1>
	<form method="get" action="${pageContext.request.contextPath}/employees/getEmployeesList">
		<select name ="limit">
			<option value="10">10</option>
			<option value="20">20</option>
			<option value="30">30</option>
			<option value="40">40</option>
			
		</select>개씩 보기
		<button type = "submit">사원목록</button>
	</form>
	<table border="1">
		<thead>
			<tr>
				<th>사원번호</th>
				<th>사원생일</th>
				<th>사원이름</th>
				<th>사원성</th>
				<th>사원성별</th>
				<th>사원입사날짜</th>
			</tr>
		</thead>
		<c:forEach var="employees" items="${list}">
			<tr>
				<td>${employees.empNo}</td>
				<td>${employees.birthDate}</td>
				<td>${employees.firstName}</td>
				<td>${employees.lastName}</td>
				<td>${employees.gender}</td>
				<td>${employees.hireDate}</td>
			</tr>
		</c:forEach>
				
	</table>
</body>
</html>