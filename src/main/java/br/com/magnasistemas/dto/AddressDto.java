package br.com.magnasistemas.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class AddressDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotNull
	@Length(max = 35)
	private String road;

	@NotNull
	@Length(max = 35)
	private String district;

	@NotNull
	@Length(max = 35)
	private String city;

	@NotNull
	@Length(min = 2, max = 2)
	private String state;

	@NotNull
	@Length(min = 8, max = 8)
	private String cep;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoad() {
		return road;
	}

	public void setRoad(String road) {
		this.road = road;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
