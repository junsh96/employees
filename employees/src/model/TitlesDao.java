package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import DB.DBHelper;
public class TitlesDao {
	public int selectTitlesRowCount() {
		int count = 0;
		final String sql="SELECT COUNT(*) FROM titles";
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
	public List<String> selectTitlesListDistinct() {
		List<String> list = new ArrayList<String>();
		String sql="SELECT DISTINCT title FROM titles";
		Connection conn =null;
		PreparedStatement stmt=null;
		ResultSet rs = null;
		try {
			//드라이브 이름
			conn = DBHelper.getConnection();
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString("title"));
			}
			
		}catch(Exception e) { // 자바의 변수 생명주기는 {} 
			e.printStackTrace();
		}finally {
			DBHelper.close(rs, stmt, conn);
		}
	
		
		return list;
	}
	
}


