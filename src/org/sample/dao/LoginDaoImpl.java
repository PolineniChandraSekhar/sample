package org.sample.dao;

import java.util.List;

import org.sample.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sun.awt.SunHints.Value;

@Repository
public class LoginDaoImpl implements LoginDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public User getUser(String name) {
		System.out.println("Reached DAO");
		String sql="select * from user where username='"+name+"'";
		System.out.println("\nQuery"+sql);
		BeanPropertyRowMapper rm=new BeanPropertyRowMapper(User.class);
		List<User> value=jdbcTemplate.query(sql, rm);
		System.out.println(value.size());
		if (value != null && !value.isEmpty()) {
			
			return value.get(0);
		}
		else{
		return null;
		}
	}
		

}
