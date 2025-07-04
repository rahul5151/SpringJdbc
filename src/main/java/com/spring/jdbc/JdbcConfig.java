package com.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.dao.StudentDaoImpl;

@Configuration
@ComponentScan(basePackages = {"com.spring.jdbc.dao"})
public class JdbcConfig {
    @Bean("ds")
	public DataSource getDataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("root");
		return driverManagerDataSource;
	}
    @Bean("jdbcTemplate")
    public JdbcTemplate getTemplate() {
    	JdbcTemplate jdbcTemplate = new JdbcTemplate();
    	jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
    	
    }
	/*
	 * @Bean("studentDao") public StudentDaoImpl getStudentDaoImpl() {
	 * StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
	 * studentDaoImpl.setJdbcTemplate(getTemplate()); return studentDaoImpl;
	 * 
	 * }
	 */
}
