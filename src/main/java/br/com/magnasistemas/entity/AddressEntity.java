package br.com.magnasistemas.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ADDRESS", schema = "employee")
public class AddressEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "ROAD", length = 35, nullable = false)
	private String road;

	@Column(name = "DISTRICT", length = 35, nullable = false)
	private String district;

	@Column(name = "CITY", length = 35, nullable = false)
	private String city;

	@Column(name = "STATE", length = 2, nullable = false)
	private String state;

	@Column(name = "CEP", length = 8, nullable = false)
	private String cep;

	public AddressEntity() {
	}

	public AddressEntity(Long id, String road, String district, String city, String state, String cep) {
		this.id = id;
		this.road = road;
		this.district = district;
		this.city = city;
		this.state = state;
		this.cep = cep;
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(cep, city, district, id, road, state);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddressEntity other = (AddressEntity) obj;
		return Objects.equals(cep, other.cep) && Objects.equals(city, other.city)
				&& Objects.equals(district, other.district) && Objects.equals(id, other.id)
				&& Objects.equals(road, other.road) && Objects.equals(state, other.state);
	}

	@Override
	public String toString() {
		return "AddressEntity [id=" + id + ", road=" + road + ", district=" + district + ", city=" + city + ", state="
				+ state + ", cep=" + cep + "]";
	}

	

}
