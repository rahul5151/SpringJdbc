package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entites.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "my program started!" );
        
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
       StudentDao s=context.getBean("studentDao",StudentDao.class);
       
		/*
		 * Student student = new Student(); student.setId(201);
		 * student.setName("Ambika sudarshan"); student.setCity("hazaribagh"); int
		 * insert= s.insert(student); System.out.println(insert);
		 */
		/*
		 * Student student = new Student(); student.setId(201);
		 * student.setName("Aarti Sudarshan"); student.setCity("bangalore"); int change
		 * = s.change(student); System.out.println(change);
		 */
		/*
		 * int delete = s.delete(201); System.out.println(delete);
		 */
       Student student = s.getStudent(200);
       System.out.println(student);
       List<Student> allStudents = s.getAllStudents();
       for (Student student2 : allStudents) {
    	   System.out.println(student2);
		
	}
    }
}
