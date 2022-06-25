package br.com.magnasistemas.dto;

import java.io.Serializable;

import br.com.magnasistemas.entity.AddressEntity;
import br.com.magnasistemas.entity.CompanyEntity;
import br.com.magnasistemas.entity.DepartmentEntity;

public class EmployeeDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private String email;

	private int age;

	private String sex;

	private CompanyEntity company;
	private AddressEntity address;
	private DepartmentEntity department;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public CompanyEntity getCompany() {
		return company;
	}

	public void setCompany(CompanyEntity company) {
		this.company = company;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	public DepartmentEntity getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}

}
