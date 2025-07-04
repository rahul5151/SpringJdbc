package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entites.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {
	
    @Autowired
	private JdbcTemplate jdbcTemplate;
	
    public int insert(Student student) {
		
		 //insert query
        String qry="insert into student(id,name,city) values(?,?,?)";
       int update= this.jdbcTemplate.update(qry,student.getId(),student.getName(),student.getCity());
		return update;
	}
	public int change(Student student) {
	      	//update query
		String qry="update student set name=?, city=? where id=?";
		int update = this.jdbcTemplate.update(qry,student.getName(),student.getCity(),student.getId());
			return update;
		}
	public int delete(int studentId) {
		//delete operation
		String query="delete from student where id=?";
		int update = this.jdbcTemplate.update(query,studentId);
		return update;
	}
	public Student getStudent(int studentId) {
		
		String query="select * from student where id=?";
		RowMapper<Student> rowMapper=new RowMapperImpl();
		Student queryForObject = this.jdbcTemplate.queryForObject(query, rowMapper,studentId);
		return queryForObject;
	}
	public List<Student> getAllStudents() {
		String qry="select * from student";
		List<Student> query = this.jdbcTemplate.query(qry, new RowMapperImpl());
		return query;
	}
	
		
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	
	
	

}
