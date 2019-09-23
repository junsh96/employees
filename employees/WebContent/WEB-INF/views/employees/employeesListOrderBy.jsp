<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>��� ���</h1>
	<div>
		<a href = "${pageContext.request.contextPath}/">Ȩ����</a>
	</div>
		<table border = "1">
		<thead>
			<tr>
				<th>��� ��ȣ</th>
				<th>��� ����</th>
				<th>��� ��</th>
				<th>��� �̸�</th>
				<th>��� ����</th>
				<th>�Ի� ��¥</th>
			</tr>
		</thead>
		<tbody>
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
		</tbody>
	</table>
</div>
</body>
</html>