package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.connectivity.ConnectionCon;
import com.studentmodel.LoginModel1;
import com.studentmodel.RegisterModel;

public class RegisterDAO implements RegisterInterface1 {
	Connection con = ConnectionCon.getConnectivity();
	String status = "Failed";
	boolean telIsExists;
	boolean unIsExists;
	boolean isUpdate;
	ResultSet rs;
	
	public String insert(RegisterModel m) {
		String sql = "insert into register(First_Name,Last_Name,Mobile_No,Username,Password_) values (?,?,?,?,?)";
		try {
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setString(1, m.getFirstName());
			pt.setString(2, m.getLastName());
			pt.setLong(3, m.getMobileno());
			pt.setString(4, m.getUserName());
			pt.setString(5, m.getPassword());
			int n = pt.executeUpdate();
			if (n > 0) {
				status = "Success";
			} else {
				status = "Failed";
			}
		} catch (Exception e) {

		}
		return status;
	}

	public boolean checkMobile(RegisterModel m) {
		String sql = "select count(*) from register where mobile_no=?";
		try {
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setLong(1, m.getMobileno());
			ResultSet rs = pt.executeQuery();
			int i = 0;
			while (rs.next()) {
				i = rs.getInt(1);
			}
			if (i == 1) {
				telIsExists = true;
			} else {
				telIsExists = false;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return telIsExists;
	}

	public boolean checkUserName(RegisterModel m) {
		String sql = "select count(*) from register where username=?";
		try {
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setString(1, m.getUserName());
			ResultSet rs = pt.executeQuery();
			int i = 0;
			while (rs.next()) {
				i = rs.getInt(1);
			}
			if (i == 1) {
				unIsExists = true;
			} else {
				unIsExists = false;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return unIsExists;
	}

	public String selectWithLogin(LoginModel1 m) {
		String sql = "select count(*) from register where username=? and password_=?";
		try {
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setString(1, m.getUserName());
			pt.setString(2, m.getPassword());
			ResultSet rs = pt.executeQuery();
			int i = 0;
			while (rs.next()) {
				i = rs.getInt(1);
			}
			if (i == 1) {
				status = "Success";
			} else {
				status = "Failed";
			}
		} catch (Exception e) {

			System.out.println(e);
		}
		return status;
	}

	public ResultSet selectProfile(LoginModel1 m) {
		String sql = "select * from register where username=? and password_=?";
		try {
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setString(1, m.getUserName());
			pt.setString(2, m.getPassword());
			rs = pt.executeQuery();

		} catch (Exception e) {
			System.out.println(e);
		}
		return rs;

	}

	public ResultSet selectProfile(RegisterModel m) {
		String sql = "select * from register where username=?";
		try {
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setString(1, m.getUserName());
			rs = pt.executeQuery();

		} catch (Exception e) {
			System.out.println(e);
		}
		return rs;
	}

	public boolean updateAll(RegisterModel m) {
		String sql = "update register set first_name=?, last_name=? , Mobile_No=?, Password_=? where username=?";
		try {
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setString(1, m.getFirstName());
			pt.setString(2, m.getLastName());
			pt.setLong(3, m.getMobileno());
			pt.setString(4, m.getPassword());
			pt.setString(5, m.getUserName());
			int n = pt.executeUpdate();
			if (n > 0) {
				isUpdate = true;
			} else {
				isUpdate = false;
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return isUpdate;
	}
	public boolean updateAllByAdmin(RegisterModel m) {
		String sql = "update register set first_name=?, last_name=? , Mobile_No=? where username=?";
		try {
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setString(1, m.getFirstName());
			pt.setString(2, m.getLastName());
			pt.setLong(3, m.getMobileno());
			pt.setString(4, m.getUserName());
			int n = pt.executeUpdate();
			if (n > 0) {
				isUpdate = true;
			} else {
				isUpdate = false;
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return isUpdate;
	}
	
	public String adminLogin(LoginModel1 m) {
		String sql = "select count(*) from AdminLogin where username=? and pasword=?";
		try {
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setString(1, m.getUserName());
			pt.setString(2, m.getPassword());
			ResultSet rs = pt.executeQuery();
			int i = 0;
			while (rs.next()) {
				i = rs.getInt(1);
			}
			if (i == 1) {
				status = "Success";
			} else {
				status = "Failed";
			}
		} catch (Exception e) {

			System.out.println(e);
		}
		return status;
	}
	
	public List<RegisterModel> getAll(){
		List<RegisterModel> list = new ArrayList<>();
		try {
			
			PreparedStatement ps = con.prepareStatement("select * from register");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				RegisterModel rm = new RegisterModel();
				rm.setFirstName(rs.getString(1));
				rm.setLastName(rs.getString(2));
				rm.setUserName(rs.getString(3));
				rm.setMobileno(rs.getLong(4));
				rm.setPassword(rs.getString(5));
				list.add(rm);
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	public String adminDelect(LoginModel1 m) {
		try {
			PreparedStatement ps = con.prepareStatement("delete from register where username=?");
			ps.setString(1, m.getUserName());
			int i = ps.executeUpdate();
			if (i > 0) {
				status = "Success";
			} else {
				status = "Failed";
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

}
