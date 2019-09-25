package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;
import vo.Employees;

import java.util.*;
/**
 * Servlet implementation class getEmployeesListByPageServlet
 */
@WebServlet("/employees/getEmployeesListByPage")
public class getEmployeesListByPageServlet extends HttpServlet {
	private EmployeesDao employeesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		employeesDao = new EmployeesDao();
		//현재 페이지 
		int currentPage = 1;
		//게시물 갯수
		int rowPerPage = currentPage*10;
		if(request.getParameter("currentPage")!=null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		List<Employees> list = employeesDao.selectEmployeesListByPage(currentPage, rowPerPage);
		int lastPage = employeesDao.selectLastPage();
		
		request.setAttribute("list", list);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("lastPage", lastPage);
		request.getRequestDispatcher("/WEB-INF/views/employees/employeesListByPage.jsp").forward(request, response);
		System.out.println("currentPage : " +currentPage);
	}

}