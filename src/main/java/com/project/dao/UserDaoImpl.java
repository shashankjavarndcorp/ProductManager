package com.project.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.dao.UserDao;
import com.project.db.DBUtility;
import com.project.model.User;

public class UserDaoImpl  implements UserDao {

	DBUtility db = new DBUtility();
	PreparedStatement pst;
	ResultSet rs;

	@Override
	public int regUser(User user) throws SQLException {
		// TODO Auto-generated method stub

		String sql = "insert into user(loginName,password,mobile,email,firstName,lastName)values(?,?,?,?,?,?)";
		pst = db.createPST(sql);
		pst.setString(1, user.getLoginName());
		pst.setString(2, user.getPassword());
		pst.setLong(3, user.getMobile());
		pst.setString(4, user.getEmail());
		pst.setString(5, user.getFirstName());
		pst.setString(6, user.getLastName());
		return db.update(pst);
	}

	@Override
	public int updateUser(User user) throws SQLException {
		String sql = "update user set loginName=?,password=?,mobile=?,email=?,firstName=?,lastName=? where id=?";
		pst = db.createPST(sql);
		pst.setString(1, user.getLoginName());
		pst.setString(2, user.getPassword());
		pst.setLong(3, user.getMobile());
		pst.setString(4, user.getEmail());
		pst.setString(5, user.getFirstName());
		pst.setString(6, user.getLastName());
		pst.setInt(7, user.getId());
		return db.update(pst);
	}

	@Override
	public int deletUser(Integer userId) throws SQLException {
		String sql = "delete from user where id=?";
		pst = db.createPST(sql);
		pst.setInt(1, userId);
		return db.update(pst);

	}
	@Override
	public User authenticate(String loginName, String password) throws SQLException {
		String sql = "select * from user where loginName=? and password=?";
		pst = db.createPST(sql);
		pst.setString(1, loginName);
		pst.setString(2, password);
		rs = db.query(pst);
		if (rs.next()) {
			User u = new User();
			u.setId(rs.getInt("id"));
			u.setFirstName(rs.getString("firstName"));
			u.setLastName(rs.getString("lastName"));
			u.setLoginName(rs.getString("loginName"));
			u.setPassword(rs.getString("password"));
			u.setMobile(rs.getLong("mobile"));
			u.setEmail(rs.getString("email"));
			return u;
		} else
			return null;
	}
}
