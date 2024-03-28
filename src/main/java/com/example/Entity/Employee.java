package com.example.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


    @Entity
	@Table(name = "employee")
	public class Employee {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "emi_id")
	    private Long emi_id;
		@Column(name = "name")
	    private String name;
		@Column(name = "salary")
	    private Double salary;
		public Employee(Long emi_id, String name, Double salary) {
			super();
			this.emi_id = emi_id;
			this.name = name;
			this.salary = salary;
		}
		public Long getEmi_id() {
			return emi_id;
		}
		public void setEmi_id(Long emi_id) {
			this.emi_id = emi_id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Double getSalary() {
			return salary;
		}
		public void setSalary(Double salary) {
			this.salary = salary;
		}
		public Employee() {
		
		}
}
