<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>ȸ�� ���(10�� ����¡)</h1>
	<!--���̺� -->
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
	
	<c:if test="${currentPage>1}">
		<a href="${pageContext.request.contextPath}/employees/getEmployeesListByPage?currentPage=${currentPage-1}">����</a>
	</c:if>
	
		<a href="${pageContext.request.contextPath}/employees/getEmployeesListByPage?currentPage=${currentPage+1}">����</a>

</body>
</html>