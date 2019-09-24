package model;
import java.sql.*;
import java.util.*;
import vo.*;
import DB.DBHelper;
public class DepartmentsDao {
	public List <Departments> selectDepartmentsList(){
		List<Departments> list = new ArrayList<Departments>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT dept_no, dept_name FROM departments";
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Departments departments = new Departments();
				departments.setDeptNo(rs.getString("dept_no"));
				departments.setDeptName(rs.getString("dept_name"));
				list.add(departments);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(rs, stmt, conn);
		}
		return list;
	}
	
	public int selectDepartMentsRowCount() {
		int count = 0;
		final String sql="SELECT COUNT(*) FROM departments";
		Connection conn =null;
		PreparedStatement stmt=null;
		ResultSet rs = null;
		try {
			
			conn = DBHelper.getConnection();
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			if(rs.next()) {
				count=rs.getInt("COUNT(*)");
			}
			
		}catch(Exception e) { 
			e.printStackTrace();
		}finally {
			DBHelper.close(rs, stmt, conn);
		}
	
		
		return  count;
	}

}
