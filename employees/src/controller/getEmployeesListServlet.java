package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeesDao;
import vo.Employees;


@WebServlet("/employees/getEmployeesList")
public class getEmployeesListServlet extends HttpServlet {
	private EmployeesDao employeesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int limit=10;
		if(request.getParameter("limit")!=null) {
			limit=Integer.parseInt(request.getParameter("limit"));
		}
		System.out.println("limit 확인: "+limit);
		
		
		employeesDao = new EmployeesDao();
		List<Employees>list= employeesDao.selectEmplyeesList(limit);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/employees/employeesList.jsp").forward(request,  response);
	}
}