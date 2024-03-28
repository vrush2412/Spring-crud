package com.example.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.Entity.Employee;

@Repository
public class EmployeeDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO employee (emi_id, name, salary) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, employee.getEmi_id(), employee.getName(), employee.getSalary());
    }

    public void updateEmployee(Employee employee) {
        String sql = "UPDATE employee SET name = ?, salary = ? WHERE emi_id = ?";
        jdbcTemplate.update(sql, employee.getName(), employee.getSalary(), employee.getEmi_id());
    }

    public void deleteEmployee(int emi_id) {
        String sql = "DELETE FROM employee WHERE emi_id = ?";
        jdbcTemplate.update(sql, emi_id);
    }

    // public Employee getEmployeeById(int emi_id) {
    //     String sql = "SELECT * FROM employee WHERE emi_id = ?";
    //     // return jdbcTemplate.queryForObject(sql, new Object[]{emi_id},
    //     //         (resultSet, i) -> new Employee(
    //     //                 resultSet.getLong("emi_id"),
    //     //                 resultSet.getString("name"),
    //     //                 resultSet.getDouble("salary")
    //     //         ));

        
    // }
}
