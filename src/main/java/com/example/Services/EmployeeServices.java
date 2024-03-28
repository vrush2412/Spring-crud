package com.example.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.Entity.Employee;
import com.example.Repository.EmployeeRepository;
import com.example.crud.CrudApplication;

@Service
public class EmployeeServices extends SpringBootServletInitializer {
    

        @Override
        protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
            return application.sources(CrudApplication.class);
        }
    
    // @Autowired
    // private JdbcTemplate jdbcTemplate;

    @Autowired
    private EmployeeRepository employeeRepository;

    // public void insertEmployeeUsingJdbcTemplate(Employee employee) {
    //     jdbcTemplate.update("INSERT INTO employee (name, salary) VALUES (?, ?)",
    //             employee.getName(), employee.getName());
    // }

    public void insertEmployeeUsingRepository(Employee employee) {
        employeeRepository.save(employee);
    }
}
