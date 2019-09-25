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
			<li><a href="${pageContext.request.contextPath}/titles/getTitlesListDistinct">업무목록</a></li>
			<li><a href="${pageContext.request.contextPath}/salaries/getSalariesStatistics">연봉 통계값(count,sum,avg,max,min,std)</a>
			<li><a href="${pageContext.request.contextPath}/employees/getEmployeesCountByGender">사원 수(성별group by gender)</a></li>
			<li><a href="${pageContext.request.contextPath}/departments/getDepartmentsCountByDeptNo">부서별 사원 수</a></li>
			<li><a href = "${pageContext.request.contextPath}/employees/getEmployeesListByPage">사원목록 페이징(10명씩)</a></li>
		</ul>
	</div>
	<div>
		employees table row count : <%=request.getAttribute("employeesRowCount") %>
		employees table row count : ${employeesRowCount}<!-- el -->
	</div>
	<div>
		<form method="post" action="${pageContext.request.contextPath}/employees/getEmployeesListBetween">
			<input type="number" name="begin">~<input type="number" name="end">
			<button type="submit">사원목록 between....and....</button>
			(${minEmpNo}~${maxEmpNo})
		</form>
	</div>
</body>
</html>