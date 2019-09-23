package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;
import vo.*;
import java.util.List;

/**
 * Servlet implementation class getEmployeesListOrderBy
 */
@WebServlet("/employees/getEmployeesListOrderBy")
public class getEmployeesListOrderBy extends HttpServlet {
	private EmployeesDao employeesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		employeesDao = new EmployeesDao();
		
		String order = request.getParameter("order");
		System.out.println(order);
		
		List<Employees>list= employeesDao.selectEmployeesListOrderBy(order);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/employees/employeesListOrderBy.jsp").forward(request,response);
	}

}
