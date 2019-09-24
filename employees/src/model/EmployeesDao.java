  
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import vo.*;
import java.util.ArrayList;
import java.util.List;

import DB.DBHelper;
import DB.DBHelper;
import java.util.*;
public class EmployeesDao {
	
	public List<Map<String, Object>> selectEmployeesCountGroupByGender(){
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql ="SELECT gender, COUNT(gender) as cnt FROM employees GROUP BY gender";
		try {
			conn = DBHelper.getConnection();
			stmt=conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("gender" , rs.getString("gender"));
				map.put("cnt", rs.getInt("cnt"));
				list.add(map);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, stmt, conn);
		}
		return list;
	}
	
	public List<Employees> selectEmployeesListBetween(int begin, int end){
		List<Employees> list = new ArrayList<Employees>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql="SELECT emp_no,birth_date,first_name,last_name,gender,hire_date FROM employees WHERE emp_no BETWEEN ? AND ? ORDER BY emp_no ASC";
		
		
		try {
			conn = DBHelper.getConnection();
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1,begin);
			stmt.setInt(2,end);
			rs=stmt.executeQuery();
			
			while(rs.next()) {
				Employees employees = new Employees();
				 employees.setEmpNo(rs.getInt("emp_no"));
				 employees.setBirthDate(rs.getString("birth_date" ));
				 employees.setFirstName(rs.getString("first_name" ));
				 employees.setLastName(rs.getString("last_name" ));
				 employees.setGender(rs.getString("gender" ));
				 employees.setHireDate(rs.getString("hire_date"));
				list.add(employees);	
			}
			
		}catch(Exception e) {
			
		}finally {
			DBHelper.close(rs, stmt, conn);
		}
		
		
		return list;
	}
	
	
	public List<Employees> selectEmployeesListOrderBy(String order){
		System.out.println("selectEmployeesListOrderBy param order :" + order);
		List<Employees> list = new ArrayList<Employees>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = null;
		
		if(order.equals("asc")) {
			sql = "select emp_no, birth_date, first_name, last_name, gender, hire_date from employees order by first_name asc limit 50";
		} else if(order.equals("desc")) {
			sql = "select emp_no, birth_date, first_name, last_name, gender, hire_date from employees order by first_name desc limit 50";
		}
			try {
				conn = DBHelper.getConnection();
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery();
				while(rs.next()) {
					Employees employees = new Employees();
					employees.setEmpNo(rs.getInt("emp_no"));
					employees.setBirthDate(rs.getString("birth_date"));
					employees.setFirstName(rs.getString("first_name"));
					employees.setLastName(rs.getString("last_name"));
					employees.setGender(rs.getString("gender"));
					employees.setHireDate(rs.getString("hire_date"));
					list.add(employees);
				}
			} catch(Exception e) {
				e.printStackTrace();
			}finally {
				DBHelper.close(rs, stmt, conn);
			}
			return list;
	}
	
	public List<Employees> selectEmplyeesList(int limit) {
		System.out.println("EmployeesDao selectEmployeesListByLimit parama limit :"+limit);
		List<Employees> list = new ArrayList<Employees>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql="SELECT emp_no, birth_date, first_name, last_name, gender, hire_date FROM employees LIMIT ?";
		
		
		try {
			conn = DBHelper.getConnection();
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1,limit);
			rs=stmt.executeQuery();
			
			while(rs.next()) {
				Employees employees = new Employees();
				 employees.setEmpNo(rs.getInt("emp_no"));
				 employees.setBirthDate(rs.getString("birth_date" ));
				 employees.setFirstName(rs.getString("first_name" ));
				 employees.setLastName(rs.getString("last_name" ));
				 employees.setGender(rs.getString("gender" ));
				 employees.setHireDate(rs.getString("hire_date"));
				list.add(employees);	
			}
			
		}catch(Exception e) {
			
		}finally {
			DBHelper.close(rs, stmt, conn);
		}
		
		
		return list;
		}

	
	public int selectEmployeesRowCount() {
		int count = 0;
		final String sql="SELECT COUNT(*) FROM employees";
		Connection conn =null;
		PreparedStatement stmt=null;
		ResultSet rs = null;
		try {
			//드라이브 이름
			conn = DBHelper.getConnection();
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			if(rs.next()) {
				count=rs.getInt("COUNT(*)");
			}
			
		}catch(Exception e) { // 자바의 변수 생명주기는 {} 
			e.printStackTrace();
		}finally {
			DBHelper.close(rs, stmt, conn);
		}
	
		
		return  count;
	}
}
