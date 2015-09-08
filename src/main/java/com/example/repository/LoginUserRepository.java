package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.example.domain.User;

/**
 * ユーザーログイン用のレポジトリ
 * @author sho
 *
 */
public class LoginUserRepository {
	
	private static final RowMapper<User> USER_ROW_MAPPER = (rs, i) -> {
		Long id = rs.getLong("id");
		String name = rs.getString("name");
		String email = rs.getString("email");
		String password = rs.getString("password");
		String address = rs.getString("address");
		String telephone = rs.getString("telephone");
		
		return new User(id, name, email, password, address, telephone);
	};
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public User findByMailAddress(String email){
		User user = null;
		try{
			SqlParameterSource param = new MapSqlParameterSource().addValue("email", email);
			user = jdbcTemplate.queryForObject("select id, name,email, password, address, telephone from users where email = :email",
					param,
					USER_ROW_MAPPER);
			return user;	
		}catch(DataAccessException e){
			return null;
		}
	}
}
