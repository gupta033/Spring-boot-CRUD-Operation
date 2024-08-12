package com.main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.main.entity.User;

@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean insertUser(User user) {
		boolean status=false;
		try {
			
		
		String INSERT_SQL_QUERY= "insert into users(name, email, gender, city) values(?,?,?,?)";
		
		int count=jdbcTemplate.update(INSERT_SQL_QUERY, user.getName(), user.getEmail(), user.getGender(), user.getCity());
		if(count > 0) {
			status =true;
		}
		}catch (Exception e) {
			status = false;
			e.printStackTrace();
		}
		return status;
		
	}
	public boolean updateUser(User user) {
	    boolean status = false;
	    try {
	        String updateQuery = "UPDATE users SET name=?, gender=?, city=? WHERE email=?";
	        int count = jdbcTemplate.update(updateQuery, user.getName(), user.getGender(), user.getCity(), user.getEmail());
	        status = (count > 0);
	    } catch (Exception e) {
	        status = false;
	        e.printStackTrace();
	    }
	    return status;
	}
	public boolean deleteByEmail(String email) {
	    boolean status = false;
	    try {
	        String deleteQuery = "delete from users WHERE email=?";
	        int count = jdbcTemplate.update(deleteQuery, email);
	        status = (count > 0);
	    } catch (Exception e) {
	        status = false;
	        e.printStackTrace();
	    }
	    return status;
	}
	
	public User getUserByEmail(String email) {
	    String selectQuery = "SELECT * FROM users WHERE email=?";
	    return jdbcTemplate.queryForObject(selectQuery, new UserRowMapper(), email);
	}
// allUsers data
	public List<User> getAllUsers(){
		String select_Query_all="select * from users";
		return jdbcTemplate.query(select_Query_all, new UserRowMapper());
	}
	
	public static final class UserRowMapper implements org.springframework.jdbc.core.RowMapper<User> {

	    @Override
	    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
	        User user = new User();
	        user.setName(rs.getString("name"));
	        user.setEmail(rs.getString("email"));
	        user.setGender(rs.getString("gender"));
	        user.setCity(rs.getString("city"));
	       
	        return user;
	    }
	

		
	}

}
