<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
						<td>${employees.getEmpNo()}</td>
						<td>${employees.getBirthDate()}</td>
						<td>${employees.getFirstName()}</td>
						<td>${employees.getLastName()}</td>
						<td>${employees.getGender()}</td>
						<td>${employees.getHireDate()}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>