package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;

@WebServlet({"/","/index"})
public class IndexServlet extends HttpServlet {
	private EmployeesDao employeesDao;
	private DepartmentsDao departmentsDao;
	private DeptManagerDao deptManagerDao;
	private EmpDeptDao empDeptDao;
	private TitlesDao titlesDao;
	private SalariesDao salariesDao; 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		employeesDao = new EmployeesDao();
		departmentsDao = new DepartmentsDao();
		deptManagerDao = new DeptManagerDao();
		int deptManagerRowCount =deptManagerDao.selectDeptManagerRowCount(); 
		empDeptDao = new EmpDeptDao();
		int empDeptRowCount = empDeptDao.selectDeptRowCount(); 
		titlesDao = new TitlesDao();
		int titlesRowCount = titlesDao.selectTitlesRowCount(); 
		salariesDao = new SalariesDao();
		int salariesRowCount = salariesDao.selectSalariesRowCount();
		int departmentsRowCount = departmentsDao.selectDepartMentsRowCount(); 
		int employeesRowCount = employeesDao.selectEmployeesRowCount();
		
		request.setAttribute("deptManagerRowCount", deptManagerRowCount);
		request.setAttribute("empDeptRowCount", empDeptRowCount);
		request.setAttribute("salariesRowCount", salariesRowCount);
		request.setAttribute("titlesRowCount", titlesRowCount);
		request.setAttribute("employeesRowCount", employeesRowCount);
		request.setAttribute("departmentsRowCount", departmentsRowCount);
		
		request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
	}


}