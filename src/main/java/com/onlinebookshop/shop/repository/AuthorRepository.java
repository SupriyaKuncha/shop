package com.onlinebookshop.shop.repository;


import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.onlinebookshop.shop.model.Author;

@Repository
public class AuthorRepository {
private final JdbcTemplate jdbctemplate;

public AuthorRepository(JdbcTemplate jdbctemplate) {
	super();
	this.jdbctemplate = jdbctemplate;
}
//rowMapper for author
//it is an functional interface
public RowMapper<Author> authorRowMapper=(rs, rowNum)->
           new Author(rs.getInt("id"),rs.getString("name"),rs.getString("country"));
           
public int save(Author author) {
	String sql="Insert into authors (name,country) VALUES (?,?)";
	return jdbctemplate.update(sql,author.getName(),author.getCountry());
}

public List<Author> findAll(){
	String sql="select * from authors";
	return jdbctemplate.query(sql,authorRowMapper);
}
public Author findById(int id) {
	String sql="select * from authors where id= ? ";
	return jdbctemplate.queryForObject(sql,authorRowMapper,id);
}
public int update(Author author) {
	String sql="Update authors set name=?,country=? where id= ?";
	return jdbctemplate.update(sql,author.getName(),author.getCountry(),author.getId());
}
public int delete(int id) {
	String sql="Delete from authors where id= ? ";
	return jdbctemplate.update(sql,id);
}

}
