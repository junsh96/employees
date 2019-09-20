package controller;
import model.*;
import vo.*;

import java.util.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class getEmployeesListServlet
 */
@WebServlet("/employees/getEmployees")
public class getEmployeesListServlet extends HttpServlet {
	private EmployeesDao employeesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int limit = 10;
		if(request.getParameter("limit") !=null){
			limit = Integer.parseInt(request.getParameter("limit"));
		}
		System.out.println("GETEmployeesListServlet param limit :" + limit);
		
		employeesDao = new EmployeesDao();
		employeesDao.selectEmployeesListByLimit(limit);
		int list = employeesDao.selectEmployeesRowCount();
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/WEB-INF/views/employees/employeesList.jsp");
	}

}
