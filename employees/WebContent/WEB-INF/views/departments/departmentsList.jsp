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
	<h1>�μ����</h1>	
	<table border="1">
		<thead>
			<tr>
				<th>�μ� ��ȣ</th>
				<th>�μ� �̸�</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="departments" items="${list}">
				<tr>
					<td>${departments.deptNo()}</td>
					<td>${departments.deptName()}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>