<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h1>index</h1>
	<!-- WEB APP 네비게이션 -->
	<div>
		<ul>
			<li><a href="<%=request.getContextPath()%>/departments/getDepartmentsList">부서 목록</a></li>
			<li><a href="<%=request.getContextPath()%>/employees/getEmployeesList?limit=10">사원 목록</a></li>
			
		</ul>
	</div>
	<div>
		employees table row count : <%=request.getAttribute("employeesRowCount") %>
		employees table row count : ${employeesRowCount}<!-- el -->
	</div>
</body>
</html>