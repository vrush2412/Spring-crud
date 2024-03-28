package com.example.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.Entity.Employee;
import com.example.Repository.EmployeeRepository;
//import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RestController
// @RequestMapping("home")
	public class EmployeeController {
	    @Autowired
	    private EmployeeRepository employeeRepository;
		List<Employee> empList=new ArrayList();

	    @GetMapping("/")
	    public String home(Model model) {
	        List<Employee> employee = employeeRepository.findAll();
	        model.addAttribute("employee", employee);
	        return "redirect:/home";
	   }
	    @RequestMapping(value="/home", method=RequestMethod.POST)
		public String myForm(@ModelAttribute Employee employee,Model model) {
			System.out.println(employee);
			return "home";
		}
		@PostMapping("/addEmployee")
public ResponseEntity<String> saveemployee(@RequestBody Employee employee){
    try{
    employeeRepository.save(employee);
    }
    catch(Exception e){
        return new ResponseEntity< >("not inserted",HttpStatus.INTERNAL_SERVER_ERROR);
    }
return new ResponseEntity<String>("successfully inserted", HttpStatus.OK);
}
	    @PostMapping("/addEmployee")
	    public String addEmployee(@RequestParam String name, @RequestParam Double salary) {
	        Employee employee = new Employee();
	        employee.setName(name);
	        employee.setSalary(salary);
	        employeeRepository.save(employee);
			System.out.println("hello");
			// RedirectView redirectView=new RedirectView();
			// redirectView.setUrl("http://www.google.com");
	        return "redirect:/addEmployee";
	    }

	    @GetMapping("getbyid/{emi_id}")
    public Employee getEmployeeById (@PathVariable int emi_id){
        for(Employee e:empList){
            if(e.getEmi_id()==emi_id){
            return e;
            }
        }
         return new Employee();
    }

		@GetMapping("getAll")
        public List<Employee>getAllEmployee(){
            return empList;
		}

	    @PutMapping("/update")
	    public String updateEmployee(@RequestParam Long emi_id, @RequestParam String name, @RequestParam Double salary) {
			Employee employee = employeeRepository.findById(emi_id).orElseThrow(null);
	        employee.setName(name);
	        employee.setSalary(salary);
	        employeeRepository.save(employee);
	        return "redirect:/home.html";
	    }
	    
	    @DeleteMapping("/delete")
	    public String deleteEmployee(@RequestParam Long emi_id) {
	        employeeRepository.deleteById(emi_id);
	        return "redirect:/home.html";
	    }
		@PutMapping("/updatebyid/{emi_id}")
        public Employee updatebyid(@PathVariable Long emi_id,@RequestBody String name){
            Employee temp=null;
            for(Employee employee:empList){
                if(emi_id==employee.getEmi_id()){
                employee.setName(name);
                temp=employee;
                 break;
                }
            }
            return temp;
        }
    
}
