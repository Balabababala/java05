package com.example.dao;
import java.sql.*;
import java.util.*;


import javax.swing.event.InternalFrameEvent;
import com.example.model.Employee;


public class EmployeeDAOJDBCImpl implements EmployeeDAO{
	
	private Connection con ;
	
	EmployeeDAOJDBCImpl() throws Exception{
		String url="jdbc:mysql://localhost:3306/EmployeeDB";
		String user="root";
		String password="abc123";
		try {
			con=DriverManager.getConnection(url, user, password);
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new Exception("資料庫連線失敗"+e);
		}
	}
	
	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		if(con!=null)
			con.close();
	}

	//INSERT INTO EMPLOYEE VALUES (id, firstName, lastName, birthDate, salary)
	@Override
	public void add(Employee emp) throws DAOException {
		// TODO Auto-generated method stub
		String sql ="INSERT INTO EMPLOYEE VALUES (?, ?, ?, ?, ?)";
		try (PreparedStatement pstmt=con.prepareStatement(sql)){
			
			pstmt.setInt(1,emp.getId());
			pstmt.setString(2,emp.getFirstName());
			pstmt.setString(3,emp.getLastName());
			pstmt.setDate(4,new java.sql.Date(emp.getBirthDate().getTime()));
			pstmt.setDouble(5,emp.getSalary());	
			if(pstmt.executeUpdate()!=1) {
				throw new DAOException("員工新增失敗");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			throw new DAOException("新增資料發生錯誤:"+e);
		}
	}

	//UPDATE EMPLOYEE SET FIRSTNAME=firstName, LASTNAME=lastName,BIRTHDATE=birthDate, SALARY=salary WHERE ID=id;
	@Override
	public void update(Employee emp) throws DAOException {
		// TODO Auto-generated method stub
		String sql ="UPDATE EMPLOYEE SET FIRSTNAME=?, LASTNAME=?,BIRTHDATE=?, SALARY=? WHERE ID=?";
		try (PreparedStatement pstmt=con.prepareStatement(sql);){
			pstmt.setString(1,emp.getFirstName());
			pstmt.setString(2,emp.getLastName());
			pstmt.setDate(3,new java.sql.Date(emp.getBirthDate().getTime()));
			pstmt.setDouble(4,emp.getSalary());	
			pstmt.setInt(5,emp.getId());
			if(pstmt.executeUpdate()!=1) {
				throw new DAOException("員工更新失敗");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			throw new DAOException("更新資料發生錯誤:"+e);
		}
		
	}
	//DELETE FROM EMPLOYEE WHERE ID=id
	@Override
	public void delete(int id) throws DAOException {
		// TODO Auto-generated method stub
		String sql ="DELETE FROM EMPLOYEE WHERE ID=?";
		try (PreparedStatement pstmt=con.prepareStatement(sql)){
			pstmt.setInt(1,id);
			pstmt.execute();
		} catch (SQLException e) {
			// TODO: handle exception
			throw new DAOException("新增資料發生錯誤:"+e);
		}
	}

	//SELECT * FROM EMPLOYEE WHERE ID=id
	@Override
	public Employee findByID(int id) throws DAOException {
		// TODO Auto-generated method stub
		String query="SELECT * FROM EMPLOYEE WHERE ID=?";
		Employee emp=null;
		try (PreparedStatement pstmt = con.prepareStatement(query)){
			pstmt.setInt(1, id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				emp= new Employee((rs.getInt("ID")),
						 rs.getString("FIRSTNAME"),rs.getString("LASTNAME"),
						 rs.getDate("BIRTHDATE"),rs.getFloat("SALARY"));
			}
			return emp;
		} catch (SQLException e) {
			// TODO: handle exception
			throw new DAOException("查詢資料發生錯誤:"+e) ;
		}
		
	}

	//SELECT * FROM EMPLOYEE
	@Override
	public Employee[] getAllEmployees() throws DAOException {
		// TODO Auto-generated method stub
		String query="SELECT * FROM EMPLOYEE ";
		List<Employee> output=new ArrayList<>();
		Employee emp=null;
		try (PreparedStatement pstmt = con.prepareStatement(query)){
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				emp= new Employee((rs.getInt("ID")),
						 rs.getString("FIRSTNAME"),rs.getString("LASTNAME"),
						 rs.getDate("BIRTHDATE"),rs.getFloat("SALARY"));
				output.add(emp);
			}
			return output.toArray(new Employee[0]);
		} catch (SQLException e) {
			// TODO: handle exception
			throw new DAOException("查詢資料發生錯誤:"+e) ;
		}
	} 

		
		
		
}
