package br.com.magnasistemas.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class StatusDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotNull
	@Length(max = 8)
	private String status;

	public StatusDto() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
