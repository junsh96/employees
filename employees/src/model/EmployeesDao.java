  
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import vo.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDao {
	public List<Employees> selectEmplyeesList(int limit) {
		System.out.println("EmployeesDao selectEmployeesListByLimit parama limit :"+limit);
		List<Employees> list = new ArrayList<Employees>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql="SELECT emp_no, birth_date, first_name, last_name, gender, hire_date FROM employees LIMIT ?";
		
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mariadb://localhost:3306/employees","root","wkqk1234");
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
			try {
				rs.close();
				stmt.close();
				conn.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
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
			Class.forName("org.mariadb.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mariadb://localhost:3306/employees","root","wkqk1234");
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			if(rs.next()) {
				count=rs.getInt("COUNT(*)");
			}
			
		}catch(Exception e) { // 자바의 변수 생명주기는 {} 
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	
		
		return  count;
	}
}
