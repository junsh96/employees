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
	<!-- WEB APP �׺���̼� -->
	
	<table border="1">
		<thead>
			<tr>
				<th>���̺� �̸�</th>
				<th>��ü ��</th>
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
			<li><a href="${pageContext.request.contextPath}/departments/getDepartmentsList">�μ� ���</a></li>
			<li><a href="${pageContext.request.contextPath}/employees/getEmployeesList?limit=10">��� ���</a></li>
			<lis>
				��� ��� first_name
				<a href="${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=asc">��������</a>
				<a href="${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=desc">��������</a>
			</lis>
			<li><a href="${pageContext.request.contextPath}/titles/getTitlesListDistinct">�������</a></li>
			<li><a href="${pageContext.request.contextPath}/salaries/getSalariesStatistics">���� ��谪(count,sum,avg,max,min,std)</a>
			<li><a href="${pageContext.request.contextPath}/employees/getEmployeesCountByGender">��� ��(����group by gender)</a></li>
			<li><a href="${pageContext.request.contextPath}/departments/getDepartmentsCountByDeptNo">�μ��� ��� ��</a></li>
			<li><a href = "${pageContext.request.contextPath}/employees/getEmployeesListByPage">������ ����¡(10��)</a></li>
		</ul>
	</div>
	<div>
		employees table row count : <%=request.getAttribute("employeesRowCount") %>
		employees table row count : ${employeesRowCount}<!-- el -->
	</div>
	<div>
		<form method="post" action="${pageContext.request.contextPath}/employees/getEmployeesListBetween">
			<input type="number" name="begin">~<input type="number" name="end">
			<button type="submit">������ between....and....</button>
			(${minEmpNo}~${maxEmpNo})
		</form>
	</div>
</body>
</html>