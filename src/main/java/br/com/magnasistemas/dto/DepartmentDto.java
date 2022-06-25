package br.com.magnasistemas.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class DepartmentDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;

	@NotNull
	@Length(max = 50)
	private String name;

	public DepartmentDto() {

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

}
