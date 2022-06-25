package br.com.magnasistemas.dto;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class EmployeeDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotNull
	@Length(max = 80)
	private String name;

	@NotNull
	@Length(max = 25)
	@Email
	private String email;

	@NotNull
	@Length(max = 2)
	private int age;

	@NotNull
	@Length(max = 1, min = 1)
	private String sex;

	@Valid
	private CompanyDto company;

	@Valid
	private AddressDto address;

	@Valid
	private DepartmentDto department;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EmployeeDto() {
	}

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

	public CompanyDto getCompany() {
		return company;
	}

	public void setCompany(CompanyDto company) {
		this.company = company;
	}

	public AddressDto getAddress() {
		return address;
	}

	public void setAddress(AddressDto address) {
		this.address = address;
	}

	public DepartmentDto getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentDto department) {
		this.department = department;
	}

}
