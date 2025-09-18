package com.briz.springboot_employee_jira_example;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@DynamicInsert
@DynamicUpdate

@Entity(name="employee") // your table name decide this section 
public class Employee {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
int id;
@NotBlank(message = "Name is mandatory")
String name;

@NotBlank(message = "Name is mandatory")
int age;
String city;

@NotBlank(message = "Name is mandatory")
String country;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
}
