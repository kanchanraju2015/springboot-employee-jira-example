package com.briz.springboot_employee_jira_example;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	
	@Autowired
	EmployeeRepository erepo;
	@RequestMapping("/test")
	public String test()
	{
		return "this is jira testing";
	}
	@RequestMapping("/santosh")
	public String santosh()
	{
		return "this is jira testing by santosh";
	}
	
	@RequestMapping("/save")
	public String save(@RequestBody Employee employee)
	{
		erepo.save(employee);
		return "data saved into table";
	}
	@RequestMapping("/all")
	public List<Employee> alldata()
	{
		return erepo.findAll();
	}
	@RequestMapping("/by/{name}")
	public List<Employee> byname(@PathVariable String name)
	{
		return erepo.findByName(name);
	}
	
	@GetMapping("/by/{city}")
	public List<Employee> byCity(@PathVariable String city) {
		return erepo.findByCity(city);
	}
	
	
	@GetMapping("/by/id") //http://localhost:8080/by/id?id=205
	public Optional<Employee> byid(@RequestParam int id)
	{
		return erepo.findById(id);
	}
	
	@GetMapping("/multiple/id") //http://localhost:8080/multiple/id?lid=203,204,205
	public List<Employee> multiid(@RequestParam List<Integer> lid)
	{
		return erepo.findAllById(lid);
	}
	
	@PutMapping("/update/{id}")
	public Employee update(@RequestBody Employee employee,@PathVariable int id)
	{
		Employee emp=erepo.findById(id).get();
		emp.setAge(employee.getAge());
		emp.setCity(employee.getCity());
		emp.setCountry(employee.getCountry());
		emp.setName(employee.getName());
		erepo.save(emp);
		return emp;
	}
	@PatchMapping("/partial/{id}")
	public Employee partial(@RequestBody Employee employee,@PathVariable int id)
	{
		Employee emp=erepo.findById(id).get();
		emp.setName(employee.getName());
		emp.setAge(employee.getAge());
		emp.setCity(employee.getCity());
		emp.setCountry(employee.getCountry());
		erepo.save(emp);
		return emp;
	}
	@DeleteMapping("/del/{id}")
	public String delbyid(@PathVariable int id)
	{
		erepo.deleteById(id);
		return "data deleted";
	}
}


