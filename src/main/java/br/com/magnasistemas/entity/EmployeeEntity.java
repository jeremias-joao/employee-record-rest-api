package br.com.magnasistemas.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Table(name = "TB_EMPLOYEE", schema = "employee")
public class EmployeeEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME", nullable = false, length = 80)
	private String name;

	@Email
	@Column(name = "EMAIL", nullable = false, length = 30)
	private String email;

	@Column(name = "AGE", nullable = false, length = 3)
	private int age;

	@Column(name = "SEX", nullable = false, length = 1)
	private String sex;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_COMPANY", referencedColumnName = "ID")
	private CompanyEntity company;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_ADDRESS", referencedColumnName = "ID")
	private AddressEntity address;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_DEPARTMENT", referencedColumnName = "ID")
	private DepartmentEntity department;

	public EmployeeEntity() {
	}

	public EmployeeEntity(Long id, String name, @Email String email, int age, String sex, CompanyEntity company,
			AddressEntity address, DepartmentEntity department) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
		this.sex = sex;
		this.company = company;
		this.address = address;
		this.department = department;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		return Objects.hash(address, age, company, department, email, id, name, sex);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeEntity other = (EmployeeEntity) obj;
		return Objects.equals(address, other.address) && age == other.age && Objects.equals(company, other.company)
				&& Objects.equals(department, other.department) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(sex, other.sex);
	}

	@Override
	public String toString() {
		return "EmployeeEntity [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + ", sex=" + sex
				+ ", company=" + company + ", address=" + address + ", department=" + department + "]";
	}

	
	
}
