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
	
	<table border="1">
		<thead>
			<tr>
				<th>테이블 이름</th>
				<th>전체 행</th>
			</tr>
			<tr>
				<td>departments</td>
				<td>${departmentsRowCount}</td>
			</tr>
			<tr>
				<td>employees</td>
				<td>${employeesRowCount}</td>
			</tr>
			<tr>
				<td>dept_manager</td>
				<td>${deptManagerRowCount}</td>
			</tr>
			<tr>
				<td>dept_emp</td>
				<td>${empDeptRowCount}</td>
			</tr>
			<tr>
				<td>dept_title</td>
				<td>${titlesRowCount}</td>
			</tr>
			<tr>
				<td>dept_slaaries</td>
				<td>${salariesRowCount}</td>
			</tr>
		</thead>
	</table>
	<div>
		<ul>
			<li><a href="${pageContext.request.contextPath}/departments/getDepartmentsList">부서 목록</a></li>
			<li><a href="${pageContext.request.contextPath}/employees/getEmployeesList?limit=10">사원 목록</a></li>
			<lis>
				사원 목록 first_name
				<a href="${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=asc">오름차순</a>
				<a href="${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=desc">내림차순</a>
			</lis>
		</ul>
	</div>
	<div>
		employees table row count : <%=request.getAttribute("employeesRowCount") %>
		employees table row count : ${employeesRowCount}<!-- el -->
	</div>
</body>
</html>